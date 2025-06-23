package com.ivanskyi.sbfe.controller;

import com.ivanskyi.sbfe.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pages")
@RequiredArgsConstructor
public class PageController {

    private final PageService pageService;

    @GetMapping("/{pageNumber}/name")
    public String getPageName(@PathVariable("pageNumber") Integer pageNumber) {
        return pageService.getPageName(pageNumber);
    }
}
