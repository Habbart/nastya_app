package com.nastya.images.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "work")
public class Work extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "url")
    private String url;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "title_image_id")
    private TitleImage titleImage;

    @ToString.Exclude
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "work_id")
    private Set<Image> portfolioImages;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "work_topic",
            joinColumns = @JoinColumn(name = "work_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id"))
    private Set<Topic> topics;
}