package org.autolook.controller;

import org.autolook.service.ShortenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by raoshaoquan on 16/5/27.
 */
@RestController
@EnableAutoConfiguration
public class HomeController {

    public final static String HTTP_PREFIX = "http://";
    public final static String HTTPS_PREFIX = "http://";

    @Autowired
    private ShortenService shortenService;

    @RequestMapping("/{shorturl}")
    public ModelAndView home(HttpServletResponse response,
                             @PathVariable("shorturl") String shorturl) throws IOException {
        String url = shortenService.getUrl(shorturl);
        if (url.indexOf(HTTP_PREFIX) != 0 || url.indexOf(HTTPS_PREFIX) != 0) {
            url = HTTP_PREFIX.concat(url);
        }
        response.sendRedirect(url);
        return null;
    }

}
