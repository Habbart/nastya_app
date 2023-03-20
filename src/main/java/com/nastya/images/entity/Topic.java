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
public class Topic extends BaseEntity {

    //todo имя топика должно быть уникальным, по нему будем искать
    @Column(name = "name")
    private String name;

    @OneToMany (mappedBy = "topic")
    private Set<WorkTopic> workTopics;
}