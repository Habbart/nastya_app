package com.nastya.images.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "image")
public class ImageEntity extends BaseEntity {

    @Column(name = "path", nullable = false)
    private String path;

    @Column(name = "front_id", nullable = false, unique = true)
    private String frontId;

    private boolean isCoverArt;
}