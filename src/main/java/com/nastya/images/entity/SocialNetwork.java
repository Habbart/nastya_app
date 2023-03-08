package com.nastya.images.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "social_network")
public class SocialNetwork extends BaseEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "url")
    private String url;
}