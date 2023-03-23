package com.nastya.images.dto;

import lombok.Data;

@Data
public class ImageDto {

    private String name;

    private byte[] content;

    private String frontId;

}