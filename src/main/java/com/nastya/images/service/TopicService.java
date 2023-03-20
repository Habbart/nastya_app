package com.nastya.images.service;


import com.nastya.images.dao.TopicDao;
import com.nastya.images.entity.TopicEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.nastya.images.Constants.WHOOPS;

@Service
@RequiredArgsConstructor
@Slf4j
public class TopicService {

    private TopicDao TopicEntityDao;

    public List<TopicEntity> getTopics() {
        List<TopicEntity> result = new ArrayList<>();
        try {
            result = TopicEntityDao.findAll();
        } catch (Exception e) {
            log.error(WHOOPS + e);
        }
        return null;
    }

    public TopicEntity changeTopicName(TopicEntity TopicEntity) {
        //todo
        return null;
    }

    public String deleteTopic(String TopicEntityId) {
        //todo
        return null;
    }
}
