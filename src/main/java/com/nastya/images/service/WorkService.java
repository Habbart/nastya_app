package com.nastya.images.service;

import com.nastya.images.dao.ImageDao;
import com.nastya.images.dao.WorkDao;
import com.nastya.images.entity.SocialNetworkEntity;
import com.nastya.images.entity.TopicEntity;
import com.nastya.images.entity.WorkEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.nastya.images.Constants.WHOOPS;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkService {

    private WorkDao workDao;
    private ImageDao imageDao;


    public List<WorkEntity> getWorks(List<String> topicIds) {
        List<WorkEntity> result = new ArrayList<>();
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

    public WorkEntity changeWork(WorkEntity work) {
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

    public List<TopicEntity> getTopics() {
        List<TopicEntity> result = new ArrayList<>();
        try {
//            result = topicDao.findAll();
        } catch (Exception e) {
            log.error(WHOOPS + e);
        }
        return null;
    }

    public TopicEntity changeTopicName(TopicEntity topic) {
        return null;
    }

    public String deleteTopic(String topicId) {
        return null;
    }

    public List<SocialNetworkEntity> getSocialContacts() {
        return null;
    }

    public SocialNetworkEntity changeSocialLink(SocialNetworkEntity link) {
        return null;
    }

    public String deleteSocialLink(String socialLinkId) {
        return null;
    }
}
