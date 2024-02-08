package com.example.cloudcomputingproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class InputController {
    @PostMapping("/")
    public ResponseEntity<String> handleFileUpload(@RequestParam("inputFile") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please upload a file");
        }

        System.out.println("Received file: " + file.getOriginalFilename());

        return ResponseEntity.ok("File uploaded successfully");
    }
}
