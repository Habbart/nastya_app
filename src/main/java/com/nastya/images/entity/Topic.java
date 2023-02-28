package com.nastya.images.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "topic")
public class Topic extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false, columnDefinition = "VARCHAR(255)")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "work_topic",
            joinColumns = @JoinColumn(name = "topic_id"),
            inverseJoinColumns = @JoinColumn(name = "work_id"))
    private Set<Work> portfolioImages;
}