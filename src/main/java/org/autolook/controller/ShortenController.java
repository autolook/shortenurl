package org.autolook.controller;


import org.autolook.service.ShortenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by raoshaoquan on 16/5/27.
 */
@RestController
@RequestMapping(value = "/api")
@EnableAutoConfiguration
public class ShortenController {

    @Autowired
    private ShortenService shortenService;

    @RequestMapping("/shorten")
    public String shorten(@RequestParam("url") String url ) {
        String shortUrl = "localhost:8081/".concat(shortenService.shorten(url));
        return shortUrl;
    }
}
