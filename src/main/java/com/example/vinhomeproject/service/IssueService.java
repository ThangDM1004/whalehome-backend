package com.example.vinhomeproject.service;

import com.example.vinhomeproject.mapper.IssueMapper;
import com.example.vinhomeproject.models.Issue;
import com.example.vinhomeproject.models.Zone;
import com.example.vinhomeproject.repositories.IssueRepository;
import com.example.vinhomeproject.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {
    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private IssueMapper issueMapper;

    public ResponseEntity<ResponseObject> getAll(){
        List<Issue> issues = issueRepository.findAll();
        if(!issues.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "Get all issues successfully",
                    issues
            ));
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "List issues null",
                    null
            ));
        }
    }
}
