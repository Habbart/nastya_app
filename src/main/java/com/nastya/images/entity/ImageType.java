package com.nastya.images.entity;

import jakarta.persistence.OneToMany;

import java.util.Set;

public class ImageType extends BaseEntity {


    @OneToMany

    private Set<Image> images;

}
