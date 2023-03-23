package com.nastya.images.dto;


import lombok.Data;

import java.util.List;

@Data
public class WorkDtoWithTags {

    private List<WorkDto> dtos;

    private List<String> tags;
}
