package com.example.cloudcomputingproject.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
public class FileReader {
    public Map<String, String> excelReader(String filePath)  {
        Map<String, String> imageToNames = new TreeMap<>();
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

        return imageToNames;
    }
}
