package com.nastya.images.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Image extends BaseEntity {

        @ManyToOne
        private ImageType imageType;

}
