package com.nastya.images.service;

import com.nastya.images.dao.SocialNetworkDao;
import com.nastya.images.entity.SocialNetworkEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SocialLinkService {


    //todo - придумать как искать социальные сети не вытаскивая id на фронт
    private SocialNetworkDao socialNetworkDao;


    public List<SocialNetworkEntity> getSocialContacts() {
        return socialNetworkDao.findAll();
    }

    public SocialNetworkEntity changeSocialLink(SocialNetworkEntity link) {
        return null;
    }

    public String deleteSocialLink(String socialLinkId) {
        //todo
        return null;
    }
}
