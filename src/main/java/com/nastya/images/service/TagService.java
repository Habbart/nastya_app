package com.nastya.images.service;


import com.nastya.images.dao.TopicDao;
import com.nastya.images.dao.WorkTopicDao;
import com.nastya.images.dto.TopicDto;
import com.nastya.images.entity.TopicEntity;
import com.nastya.images.entity.WorkTopicEntity;
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

    private TopicDao topicDao;

    private WorkTopicDao workTopicDao;

    //вернуть все теги в порядке убывания их упоминания в работах.
    // Т.е. самый популярный тэг должен быть первым
    //todo - дописать тест, что всё работает как надо
    public List<String> getAllTags() {
        List<WorkTopicEntity> workTopicEntities = new ArrayList<>();
        try {
            workTopicEntities = workTopicDao.countByTopicPopularity();
        } catch (Exception e) {
            log.error(WHOOPS + e);
        }
        return workTopicEntities.stream().map(w -> w.getTopic().getName()).toList();
    }

    public String changeTagName(TopicDto tagDto) {
        //todo добавить валидатор что поля имен не пустые
        String oldTopicName = tagDto.getOldTopicName();
        String newTopicName = tagDto.getNewTopicName();
        TopicEntity entity = topicDao.findByName(oldTopicName);
        entity.setName(newTopicName);
        topicDao.save(entity);
        return String.format("Tag name was successfully changed form %s to %s", oldTopicName, newTopicName);
    }

    public String deleteTag(String tagName) {
        topicDao.deleteByName(tagName);
        return String.format("Tag with name %s was successfully deleted", tagName);
    }
}
