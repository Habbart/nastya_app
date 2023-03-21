package com.nastya.images.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SocialNetworkDto {

    private String description;

    private String url;

    private String newDescription;

    private String newUrl;
}
