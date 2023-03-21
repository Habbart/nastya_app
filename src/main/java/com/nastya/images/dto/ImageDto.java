package com.nastya.images.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ImageDto {

    private String name;

    private byte[] content;

    private String frontId;

}