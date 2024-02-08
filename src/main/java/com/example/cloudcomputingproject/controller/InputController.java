package com.example.cloudcomputingproject.controller;

import com.example.cloudcomputingproject.service.FileReader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
public class InputController {
    private final FileReader fileReader;

    public InputController(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @PostMapping("/")
    public ResponseEntity<String> handleFileUpload(@RequestParam("inputFile") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please upload a file");
        }

        String fileName = file.getOriginalFilename();
        fileName = fileName.substring(0, fileName.length() - 4);
        String filePath100 = "src/main/resources/static/Classification Results on Face Dataset (100 images).csv";
        String filePath1000 = "src/main/resources/static/Classification Results on Face Dataset (1000 images).csv";

        Map<String, String> imageToNames100 = fileReader.excelReader(filePath100);
//        Map<String, String> imageToNames1000 = fileReader.excelReader(filePath1000);

        return ResponseEntity.ok(fileName + ":" + imageToNames100.get(fileName));
    }
}
