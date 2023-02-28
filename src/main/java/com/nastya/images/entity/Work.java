package com.nastya.images.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "work")
public class Work extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false, columnDefinition = "VARCHAR(255)")
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "url")
    private String url;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "title_image_id", unique = true)
    private TitleImage titleImage;

    @ToString.Exclude
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "work_id")
    private Set<Image> portfolioImages;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "work_topic",
            joinColumns = @JoinColumn(name = "work_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id"))
    private Set<Topic> topics;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Work work = (Work) o;
        return Objects.equals(id, work.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}