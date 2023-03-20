package com.nastya.images.service;

import com.nastya.images.dao.ImageDao;
import com.nastya.images.dao.WorkDao;
import com.nastya.images.entity.SocialNetwork;
import com.nastya.images.entity.Work;
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
}
