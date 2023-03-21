package com.nastya.images.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
public class WorkDto {

    private Set<ImageDto> imageDtoSet;

    private String frontId;

    private String description;
    //todo это поле можно передавать с аватаркой работы
}
