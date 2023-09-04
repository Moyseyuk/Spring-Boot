package com.tms.springboot.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

@Service
public class WriteInFileService {

    @Value("${app.classPath}")
    String classPath;

    @Bean
    public boolean write(Integer counter) throws FileNotFoundException {
        File file = new File(classPath);
        PrintWriter pw = new PrintWriter(file);
        pw.println(counter);
        pw.close();
        return true;
    }

}