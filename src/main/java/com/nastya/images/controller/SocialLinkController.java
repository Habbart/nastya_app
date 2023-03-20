package com.nastya.images.controller;


import com.nastya.images.entity.SocialNetwork;
import com.nastya.images.service.SocialLinkService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/social")
@RequiredArgsConstructor
public class SocialLinkController {

    private SocialLinkService socialLinkService;

    @GetMapping()
    public List<SocialNetwork> getSocialContacts() {
        return socialLinkService.getSocialContacts();
    }

    @PostMapping()
    public SocialNetwork changeSocialLink(@RequestBody SocialNetwork link){
        return socialLinkService.changeSocialLink(link);
    }

    @DeleteMapping()
    public String deleteSocialLink(@RequestParam @NotBlank String socialLinkId){
        return socialLinkService.deleteSocialLink(socialLinkId);
    }

}
