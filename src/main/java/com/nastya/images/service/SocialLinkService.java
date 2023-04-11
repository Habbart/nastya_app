package com.nastya.images.service;

import com.nastya.images.repository.SocialNetworkRepository;
import com.nastya.images.dto.SocialNetworkDto;
import com.nastya.images.entity.SocialNetworkEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SocialLinkService {


    private SocialNetworkRepository socialNetworkRepository;


    public List<SocialNetworkDto> getSocialContacts() {
        List<SocialNetworkEntity> all = socialNetworkRepository.findAll();
        List<SocialNetworkDto> result = new ArrayList<>();
        for (SocialNetworkEntity entity : all) {
            SocialNetworkDto dto = SocialNetworkDto.builder()
                    .url(entity.getUrl())
                    .description(entity.getDescription())
                    .build();
            result.add(dto);
        }
        return result;
    }

    public SocialNetworkDto changeSocialLink(SocialNetworkDto dto) {
        String url = dto.getUrl();
        String description = dto.getDescription();
        String newUrl = dto.getNewUrl();
        String newDescription = dto.getNewDescription();
        SocialNetworkEntity entity = socialNetworkRepository.findByUrlAndDescription(url, description);
        if(entity == null){
            entity = new SocialNetworkEntity();
        }
        if(!newDescription.isBlank()) {
            entity.setDescription(newDescription);
        }
        if(!newUrl.isBlank()) {
            entity.setUrl(newUrl);
        }
        socialNetworkRepository.save(entity);
        //todo определить параметр ответа
        return null;
    }

    public String deleteSocialLink(SocialNetworkDto dto) {
        //todo добавить проверку, что все параметры ДТО заполнены
        String url = dto.getUrl();
        String description = dto.getDescription();
        socialNetworkRepository.deleteByUrlAndDescription(url, description);
        return "SocialNetwork was successfully deleted";
    }
}
