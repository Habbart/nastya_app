package com.nastya.images.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "title_image")
public class TitleImageEntity extends BaseEntity {

    @Column(name = "path", nullable = false)
    private String path;
}