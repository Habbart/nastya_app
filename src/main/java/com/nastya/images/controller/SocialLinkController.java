package com.nastya.images.controller;


import com.nastya.images.dto.SocialNetworkDto;
import com.nastya.images.service.SocialLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/social")
@RequiredArgsConstructor
public class SocialLinkController {

    private SocialLinkService socialLinkService;

    @GetMapping()
    public List<SocialNetworkDto> getSocialContacts() {
        return socialLinkService.getSocialContacts();
    }

    @PostMapping()
    public SocialNetworkDto changeSocialLink(@RequestBody SocialNetworkDto dto) {
        return socialLinkService.changeSocialLink(dto);
    }

    @DeleteMapping()
    public String deleteSocialLink(@RequestBody SocialNetworkDto dto) {
        return socialLinkService.deleteSocialLink(dto);
    }

}
