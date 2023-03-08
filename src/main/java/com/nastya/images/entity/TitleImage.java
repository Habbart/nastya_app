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
public class TitleImage extends BaseEntity {

    @Column(name = "path")
    private String path;
}