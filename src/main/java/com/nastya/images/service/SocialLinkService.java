package com.nastya.images.service;

import com.nastya.images.dao.SocialLinksDao;
import com.nastya.images.entity.SocialNetwork;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SocialLinkService {


    //todo - придумать как искать социальные сети не вытаскивая id на фронт
    private SocialLinksDao socialLinksDao;


    public List<SocialNetwork> getSocialContacts() {
        return socialLinksDao.findAll();
    }

    public SocialNetwork changeSocialLink(SocialNetwork link) {

        socialLinksDao.findByUrl()
        return ;
    }

    public String deleteSocialLink(String socialLinkId) {
        //todo
        return null;
    }
}
