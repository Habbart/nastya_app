package com.nastya.images.service;


import com.nastya.images.dao.TopicDao;
import com.nastya.images.entity.Topic;
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

    private TopicDao topicDao;

    public List<Topic> getTopics() {
        List<Topic> result = new ArrayList<>();
        try {
            result = topicDao.findAll();
        } catch (Exception e) {
            log.error(WHOOPS + e);
        }
        return null;
    }

    public Topic changeTopicName(Topic topic) {
        //todo
        return null;
    }

    public String deleteTopic(String topicId) {
        //todo
        return null;
    }
}
