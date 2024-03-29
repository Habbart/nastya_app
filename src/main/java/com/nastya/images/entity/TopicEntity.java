package com.nastya.images.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "workTopics")
@Entity
@Table(name = "topic")
public class TopicEntity extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany (mappedBy = "topic")
    private Set<WorkTopicEntity> workTopics;
}