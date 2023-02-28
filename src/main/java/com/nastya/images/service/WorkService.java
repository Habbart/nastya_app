package com.nastya.images.service;

import com.nastya.images.dao.ImageDao;
import com.nastya.images.dao.ImageTypeDao;
import com.nastya.images.dao.SocialLinksDao;
import com.nastya.images.entity.Image;
import com.nastya.images.entity.ImageType;
import com.nastya.images.entity.SocialLinks;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkService {

    private ImageDao imageDao;
    private ImageTypeDao imageTypeDao;
    private SocialLinksDao socialLinksDao;

    public List<Image> getWorks(List<String> topicIds) {
        List<Image> result;
        if(topicIds.isEmpty()){
            result = imageDao.findAll();
        } else {
            result = imageDao.findByTopicIds(topicIds);
        }
        return result;
    }

    public Image changeWork(Image image) {
        return imageDao.save(image);
    }

    public String deleteWorkOrImage(String workId, String imageId) {
        if(imageId.isBlank()){
            imageDao.findById(workId);
        }
        return null;
    }

    public List<ImageType> getTopics() {
        return null;
    }

    public Image changeTopicName(ImageType imageType) {
        return null;
    }

    public String deleteTopic(String topicId) {
        return null;
    }

    public List<SocialLinks> getSocialContacts() {
        return null;
    }

    public SocialLinks changeSocialLink(SocialLinks link) {
        return null;
    }

    public String deleteSocialLink(String socialLinkId) {
        return null;
    }
}
