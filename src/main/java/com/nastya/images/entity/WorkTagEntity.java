package com.nastya.images.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "work_tag")
public class WorkTagEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "work_id")
    private WorkEntity work;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private TagEntity tag;
}