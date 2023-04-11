package com.nastya.images.service;


import com.nastya.images.repository.TagRepository;
import com.nastya.images.repository.WorkTagRepository;
import com.nastya.images.dto.TagDto;
import com.nastya.images.entity.TagEntity;
import com.nastya.images.entity.WorkTagEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.nastya.images.Constants.WHOOPS;

@Service
@RequiredArgsConstructor
@Slf4j
public class TagService {

    private TagRepository tagRepository;

    private WorkTagRepository workTagRepository;

    //вернуть все теги в порядке убывания их упоминания в работах.
    // Т.е. самый популярный тэг должен быть первым
    //todo - дописать тест, что всё работает как надо
    public List<String> getAllTags() {
        List<WorkTagEntity> workTopicEntities = new ArrayList<>();
        try {
            workTopicEntities = workTagRepository.countByTopicPopularity();
        } catch (Exception e) {
            log.error(WHOOPS + e);
        }
        return workTopicEntities.stream().map(w -> w.getTopic().getName()).toList();
    }

    public String changeTagName(TagDto tagDto) {
        //todo добавить валидатор что поля имен не пустые
        String oldTopicName = tagDto.getOldTagName();
        String newTopicName = tagDto.getNewTagName();
        TagEntity entity = tagRepository.findByName(oldTopicName);
        entity.setName(newTopicName);
        tagRepository.save(entity);
        return String.format("Tag name was successfully changed form %s to %s", oldTopicName, newTopicName);
    }

    public String deleteTag(String tagName) {
        tagRepository.deleteByName(tagName);
        return String.format("Tag with name %s was successfully deleted", tagName);
    }
}
