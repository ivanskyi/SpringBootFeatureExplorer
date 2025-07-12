package com.ivanskyi.sbfe.controller;

import com.ivanskyi.sbfe.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/random")
    public String getRandomAuthor() {
        return authorService.generateRandomAuthorName();
    }
}
