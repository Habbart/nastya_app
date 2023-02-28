package com.nastya.images.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "work")
public class Work extends BaseEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID id;

    @NotBlank
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "url")
    private String url;

    @OneToOne
    @JoinColumn(name="title_image_id", unique = true)
    private TitleImage titleImage;

    @OneToMany
    @JoinColumn(name="work_id")
    private Set<Image> portfolioImages;

    @OneToMany
    @JoinColumn(name="work_id")
    @NotEmpty
    private Set<Topic> topics;
}