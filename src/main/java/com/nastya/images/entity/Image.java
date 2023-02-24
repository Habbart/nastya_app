package com.nastya.images.entity;

import jakarta.persistence.ManyToOne;

public class Image extends BaseEntity {

        @ManyToOne
        private ImageType imageType;

}
