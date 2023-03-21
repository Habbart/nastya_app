package com.nastya.images.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"portfolioImages", "workTopics"})
@Entity
@Table(name = "work")
public class WorkEntity extends BaseEntity {

    @Column(name = "title", nullable = false)
    //todo название должно быть уникальным
    private String title;

    @Column(name = "url")
    private String url;

    @Column(name = "front_id", nullable = false, unique = true)
    private String frontId;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "title_image_id")
    private TitleImageEntity titleImage;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "work_id")
    private Set<ImageEntity> portfolioImages;

    @OneToMany(mappedBy = "work")
    private Set<WorkTopicEntity> workTopics;
}