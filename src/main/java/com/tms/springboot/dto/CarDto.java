package com.tms.springboot.dto;

import com.tms.springboot.model.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

    private int number;
    private List<Region> regions;

}
