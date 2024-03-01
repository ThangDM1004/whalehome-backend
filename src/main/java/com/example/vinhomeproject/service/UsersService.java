package com.example.vinhomeproject.service;

import com.example.vinhomeproject.dto.UserDTO;
import com.example.vinhomeproject.mapper.UserMapper;
import com.example.vinhomeproject.models.Post;
import com.example.vinhomeproject.models.Users;
import com.example.vinhomeproject.repositories.UsersRepository;
import com.example.vinhomeproject.request.ChangePasswordRequest;
import com.example.vinhomeproject.response.ResponseObject;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsersService {

    @Autowired
    private UsersRepository repo;
    @Autowired
    private UserMapper mapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<ResponseObject> getAllUser() {
        List<Users> users = repo.findAll();
        if (!users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "Get all user successfully",
                    users
            ));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(
                    "List user null",
                    null
            ));
        }
    }

    public ResponseEntity<ResponseObject> createUser(UserDTO user) {
        boolean exist = checkEmailDuplicate(user.getEmail());
        user.setStatus(true);
        repo.save(mapper.createClassDtoToClassSubject(user));
        if (exist == true) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject(
                    "Email have exist",
                    null
            ));
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject(
                    "Create user successfully",
                    user
            ));
        }
    }

    public ResponseEntity<ResponseObject> deleteUser(Long id) {
        Optional<Users> user = repo.findById(id);
        if (user.isPresent()) {
            user.get().setStatus(false);
            repo.save(user.get());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "Delete user successfully",
                    null
            ));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(
                "Not found user",
                null
        ));
    }

    public ResponseEntity<ResponseObject> updateImageUser(Long id, MultipartFile multipartFile) {
        Optional<Users> user = repo.findById(id);
        if (user.isPresent()) {
            if (multipartFile != null) {
                String imageUrl = this.upload(multipartFile);
                user.get().setImage(imageUrl);
            }
            repo.save(user.get());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "Update image user successfully",
                    null
            ));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(
                "Not found user",
                null
        ));
    }

    public ResponseEntity<ResponseObject> updateUser(Long id, UserDTO userDTO) {
        Optional<Users> user = repo.findById(id);
        if (user.isPresent()) {
            userDTO.setImage(user.get().getImage());
            mapper.updateUser(userDTO,user.get());
            repo.save(user.get());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "Update user successfully",
                    null
            ));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(
                "Not found user",
                null
        ));
    }

    public boolean checkEmailDuplicate(String email) {
        boolean isExist = false;

        Optional<Users> users = repo.findByEmail(email);
        if(users.isPresent()){
            isExist = true;
        } else {
            isExist = false;
        }
        return isExist;
    }

    public ResponseEntity<ResponseObject> getById(Long id) {
        Optional<Users> users = repo.findById(id);
        if (users.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "Get user by id " + id + " successfully",
                    users.get()
            ));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(
                    "Not found user by id " + id,
                    null
            ));
        }
    }
    public ResponseEntity<ResponseObject> countAllUser() {
        List<Users> users = repo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                "Get all user successfully",
                users.size()
        ));
    }
    public ResponseEntity<ResponseObject> changePassword(ChangePasswordRequest request, Principal connectUser) {
        String message = "";
        var user = (Users) ((UsernamePasswordAuthenticationToken) connectUser).getPrincipal();
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            message = "Wrong password";
        }
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            message = "Password are not the same";
        }
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        repo.save(user);
        if (message.equals("Wrong password")) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject(
                            "Wrong password",
                            null
                    )
            );
        } else if (message.equals("Password are not the same")) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject(
                            "Password are not the same",
                            null
                    )
            );
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                            "Change password successfully",
                            null
                    )
            );
        }
    }
    public Page<Users> getPage(int currentPage, int pageSize, String field) {
        return repo.findAll(PageRequest.of(currentPage, pageSize, Sort.by(Sort.Direction.ASC, field)));
    }

    public int count() {
        return repo.findAll().size();
    }

    private File convertToFile(MultipartFile multipartFile, String fileName) throws IOException {
        File tempFile = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartFile.getBytes());
        }
        return tempFile;
    }

    private String uploadFile(File file, String fileName) throws IOException {
        BlobId blobId = BlobId.of("whalehome-project.appspot.com", fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        InputStream inputStream = PostImageService.class.getClassLoader().getResourceAsStream("firebase.json");
        Credentials credentials = GoogleCredentials.fromStream(inputStream);
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));
        String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/whalehome-project.appspot.com/o/%s?alt=media";
        return String.format(DOWNLOAD_URL, URLEncoder.encode(fileName, StandardCharsets.UTF_8));
    }
    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    private String upload(MultipartFile multipartFile) {
        try {
            String fileName = multipartFile.getOriginalFilename();
            fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));

            File file = this.convertToFile(multipartFile, fileName);
            String URL = this.uploadFile(file, fileName);
            file.delete();
            return URL;
        } catch (Exception e) {
            e.printStackTrace();
            return "Image couldn't upload, Something went wrong";
        }
    }
}
