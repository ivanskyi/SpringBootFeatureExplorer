package com.ivanskyi.sbfe.service;

import com.ivanskyi.sbfe.exception.api.InvalidPageNumberException;
import org.springframework.stereotype.Service;

@Service
public class PageService {

    private static final String PAGE_NAME_PREFIX = "Page name:";

    public String getPageName(Integer pageNumber) {
        if (pageNumber == 5) {
            throw new InvalidPageNumberException(String.valueOf(pageNumber));
        }
        return PAGE_NAME_PREFIX + pageNumber;
    }
}
