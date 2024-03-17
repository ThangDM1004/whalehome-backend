package com.example.vinhomeproject.service;


import com.example.vinhomeproject.dto.AreaDTO;
import com.example.vinhomeproject.dto.ContractDTO;
import com.example.vinhomeproject.dto.ContractDTO_2;
import com.example.vinhomeproject.models.*;
import com.example.vinhomeproject.repositories.AppointmentRepository;
import com.example.vinhomeproject.repositories.ContractHistoryRepository;
import com.example.vinhomeproject.repositories.ContractRepository;
import com.example.vinhomeproject.repositories.PaymentRepository;
import com.example.vinhomeproject.response.ResponseObject;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private ContractHistoryRepository contractHistoryRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private FileService fileService;
    public ResponseEntity<ResponseObject> getAll(){
        List<ContractDTO_2> contracts = contractRepository.getAll();
        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                contracts
        ));
    }

    public ResponseEntity<ResponseObject> getById(Long id){
        Optional<Contract> contract = contractRepository.findById(id);
        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                contract
        ));
    }

    public ResponseEntity<ResponseObject> create(ContractDTO contractDTO){
        Contract contract;
        contractDTO.setContractHistory(contractHistoryRepository.findById(contractDTO.getContractHistory().getId()).get());
        contract = Contract.builder()
                .dateSign(contractDTO.getDateSign())
                .description(contractDTO.getDescription())
                .dateStartRent(contractDTO.getDateStartRent())
                .contractHistory(contractDTO.getContractHistory())
                .appointment(appointmentRepository.findById(contractDTO.getAppointmentId()).get())
                .build();
        contractRepository.save(contract);
        Optional<Appointment> appointment = appointmentRepository.findById(contractDTO.getAppointmentId());
        appointment.get().setContract(contract);
        appointmentRepository.save(appointment.get());

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                "Create contract successfully",
                contractRepository.getByIdNew(contract.getId())
        ));
    }

    public ResponseEntity<ResponseObject> delete(Long id){
        Optional<Contract> contract = contractRepository.findById(id);
        if(contract.isPresent()){
            contract.get().setStatus(!contract.get().isStatus());
            contractRepository.save(contract.get());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "Delete contract successfully",
                    contract
            ));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(
                "Not found contract",
                ""
        ));
    }

    public ResponseEntity<ResponseObject> update(Long id, ContractDTO contractDTO){
        Optional<Contract> contract = contractRepository.findById(id);
        if(contract.isPresent()){
            if(contractDTO.getDateSign()!=null){contract.get().setDateSign(contractDTO.getDateSign());}
            if(contractDTO.getDescription()!=null){contract.get().setDescription(contractDTO.getDescription());}
            if(contractDTO.getDateStartRent()!=null){contract.get().setDateStartRent(contractDTO.getDateStartRent());}
            if(contractDTO.getContractHistory()!=null){contract.get().setContractHistory(contractHistoryRepository.findById(contractDTO.getContractHistory().getId()).get());}
            contractRepository.save(contract.get());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "Update contract successfully",
                    contract
            ));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(
                "Not found contract",
                ""
        ));
    }
    public ResponseEntity<ResponseObject> countAll(){
        List<Contract> contracts = contractRepository.findAll();
        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                contracts.size()
        ));
    }

    public ResponseEntity<ResponseObject> uploadFile(MultipartFile multipartFile,Long id) {
        Optional<Contract> contract = contractRepository.findById(id);
        if(contract.isPresent()){
            if (multipartFile != null) {
                String imageUrl = this.upload(multipartFile);
                contract.get().setUrlFile(imageUrl);
                contractRepository.save(contract.get());
                return ResponseEntity.status (HttpStatus.NOT_FOUND).body(new ResponseObject(
                        "File uploaded successfully. File URL: " + imageUrl,
                        ""
                ));
            } else {
                return ResponseEntity.status (HttpStatus.NOT_FOUND).body(new ResponseObject(
                        "File is null",
                        ""
                ));
            }
        }
        return ResponseEntity.status (HttpStatus.NOT_FOUND).body(new ResponseObject(
                "Contract is not exist",
                ""
        ));
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
            String fileExtension = getExtension(fileName);

            // Check if the file is a PDF
            if (!fileExtension.equalsIgnoreCase("pdf")) {
                return "Invalid file format. Only PDF files are allowed.";
            }

            fileName = UUID.randomUUID().toString().concat(fileExtension);
            File file = convertToFile(multipartFile, fileName);
            String URL = uploadFile(file, fileName);
            file.delete();
            return URL;
        } catch (Exception e) {
            e.printStackTrace();
            return "Something went wrong while uploading the file.";
        }
    }
    public ResponseEntity<ResponseObject> downloadFile(Long id) throws IOException {
        Optional<Contract> contract = contractRepository.findById(id);
        if(contract.isPresent()){
            byte[] fileBytes = fileService.downloadFile(contract.get().getUrlFile());

            ByteArrayResource resource = new ByteArrayResource(fileBytes);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=downloaded_file");

            ResponseObject responseObject = new ResponseObject();
            responseObject.setMessage("File downloaded successfully");
            responseObject.setData(fileBytes);

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(responseObject);

        }
        return ResponseEntity.status (HttpStatus.NOT_FOUND).body(new ResponseObject(
                "Contract is not exist",
                ""
        ));
    }
}
