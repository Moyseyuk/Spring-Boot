package com.tms.springboot.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Service
public class ReadFromFileService {

    @Value("${app.classPath}")
    String classPath;

    @Bean
    public Integer read() throws FileNotFoundException {
        Integer text = null;
        File file = new File(classPath);
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()){
            text = Integer.valueOf(reader.nextLine());
        }
        return text;
    }

}
