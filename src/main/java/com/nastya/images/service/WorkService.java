package com.nastya.images.service;

import com.nastya.images.dao.ImageDao;
import com.nastya.images.dao.TopicDao;
import com.nastya.images.dao.WorkDao;
import com.nastya.images.entity.SocialNetwork;
import com.nastya.images.entity.Topic;
import com.nastya.images.entity.Work;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkService {

    private static final String WHOOPS = "Что-то пошло не так!";
    private WorkDao workDao;
    private ImageDao imageDao;
    private TopicDao topicDao;


    public List<Work> getWorks(List<String> topicIds) {
        List<Work> result = new ArrayList<>();
        try {
            if (topicIds.isEmpty()) {
                result = workDao.findAll();
            } else {
                result = workDao.findByWorkTopicsIn(topicIds);
            }
        } catch (Exception e) {
            log.error(WHOOPS + e);
        }
        return result;
    }

    public Work changeWork(Work work) {
        return workDao.save(work);
    }

    public Boolean deleteWorkOrImage(String workId, String imageId) {
        try {
            if (imageId.isBlank()) {
                workDao.deleteById(UUID.fromString(workId));
            } else {
                imageDao.deleteById(UUID.fromString(imageId));
            }
        } catch (Exception e) {
            log.error(WHOOPS + e);
        }
        return Boolean.TRUE;
    }

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
        return null;
    }

    public String deleteTopic(String topicId) {
        return null;
    }

    public List<SocialNetwork> getSocialContacts() {
        return null;
    }

    public SocialNetwork changeSocialLink(SocialNetwork link) {
        return null;
    }

    public String deleteSocialLink(String socialLinkId) {
        return null;
    }
}
