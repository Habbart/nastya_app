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
public class Work extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "url")
    private String url;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "title_image_id")
    private TitleImage titleImage;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "work_id")
    private Set<Image> portfolioImages;

    @OneToMany(mappedBy = "work")
    private Set<WorkTopic> workTopics;
}