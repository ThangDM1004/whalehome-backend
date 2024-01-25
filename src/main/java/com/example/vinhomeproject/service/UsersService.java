package com.example.vinhomeproject.service;

import com.example.vinhomeproject.dto.UserDTO;
import com.example.vinhomeproject.mapper.UserMapper;
import com.example.vinhomeproject.models.Users;
import com.example.vinhomeproject.repositories.UsersRepository;
import com.example.vinhomeproject.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository repo;
    @Autowired
    private UserMapper mapper;

    public ResponseEntity<ResponseObject> getAllUser(){
        List<Users> users = repo.findAll();
        if(!users.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "Successfully",
                    users
            ));
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "List user null",
                    null
            ));
        }
    }

    public ResponseEntity<ResponseObject> createUser(UserDTO user){
        boolean exist = checkEmailDuplicate(user.getEmail());
        user.setStatus(true);
        repo.save(mapper.createClassDtoToClassSubject(user));
        if(exist == true){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject(
                    "Email have exist",
                    null
            ));
        }else {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject(
                    "Create user successfully",
                    user
            ));
        }
    }
    public ResponseEntity<ResponseObject>  deleteUser(Long id){
       Optional<Users> user = repo.findById(id);
       user.get().setStatus(false);
       repo.save(user.get());
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                "Delete user successfully",
                null
        ));
    }

    public ResponseEntity<ResponseObject>  updateUser(Long id,UserDTO userDTO){
        Optional<Users> user = repo.findById(id);
        mapper.updateUser(userDTO,user.get());
        repo.save(user.get());
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                "Delete user successfully",
                null
        ));
    }

    public boolean checkEmailDuplicate(String email){
        boolean isExist = false;
        Optional<Users> users = repo.getUsersByEmail(email);
        if(users.isPresent()){
            isExist = true;
        }else {
            isExist = false;
        }
        return isExist;
    }
    public ResponseEntity<ResponseObject> getById(Long id){
        Optional<Users> users = repo.findById(id);
        if(users.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "Successfully",
                    users.get()
            ));
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "List user null",
                    null
            ));
        }
    }

    public ResponseEntity<ResponseObject> getListUserSortByDate(){
        List<Users> users = repo.getUserSortByDate();
        if(!users.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "Get list user sort by date",
                    users
            ));
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "List user null",
                    null
            ));
        }
    }
}
