package com.nastya.images.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Getter
@Setter
public class ImageType extends BaseEntity {


    @OneToMany

    private Set<Image> images;

}
