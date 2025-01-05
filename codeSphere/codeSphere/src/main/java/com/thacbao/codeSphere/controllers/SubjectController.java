package com.thacbao.codeSphere.controllers;

import com.thacbao.codeSphere.dto.response.ApiResponse;
import com.thacbao.codeSphere.dto.response.CodeSphereResponse;
import com.thacbao.codeSphere.services.serviceImpl.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/insert")
    public ResponseEntity<ApiResponse> insert(@RequestBody Map<String, String> request) {
        try {
            return subjectService.insertNewSubject(request);
        }
        catch (Exception e) {
            return CodeSphereResponse.generateResponse(new ApiResponse("error", e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllSubjects() {
        try {
            return subjectService.getAll();
        }
        catch (Exception e) {
            return CodeSphereResponse.generateResponse(new ApiResponse("error", e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}