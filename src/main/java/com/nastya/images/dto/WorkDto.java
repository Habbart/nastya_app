package com.nastya.images.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WorkDto {


    private String frontId;
    private String description;
    private String title;

    private List<ImageDto> imageDtos;
    private List<String> imagesIds;
}
