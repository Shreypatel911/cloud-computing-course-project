package com.example.cloudcomputingproject.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class FileReader {
    private final String filePath = "/home/ec2-user/Classification Results on Face Dataset (1000 images).csv";
    private final Map<String, String> imageToNames = new TreeMap<>();

    @PostConstruct
    public void init(){
        try (CSVReader reader = new CSVReader(new java.io.FileReader(filePath))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // Assuming each row has at least two cells
                String cell1 = nextLine[0];
                String cell2 = nextLine[1];

                imageToNames.put(cell1, cell2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
    public Map<String, String> excelReader()  {
        return imageToNames;
    }
}