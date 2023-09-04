package com.tms.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class CreatingLogFile {

    @Autowired
    ReadFromFileService readFromFileService;
    @Autowired
    WriteInFileService writeInFileService;

    @Bean
    public void log() throws FileNotFoundException {
        Integer counter = readFromFileService.read();
        Boolean ready = writeInFileService.write(counter + 1);
        if (ready){
            System.out.println("ready");
        }
    }

}

