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
public class Image extends BaseEntity {

    @Column(name = "path")
    private String path;
}