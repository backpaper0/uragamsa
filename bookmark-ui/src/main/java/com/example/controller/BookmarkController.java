package com.example.controller;

import java.util.List;
import java.util.Map;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class BookmarkController {

    final RestTemplate restTemplate;

    public BookmarkController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    String home() {
        return "home";
    }

    @GetMapping("/{user}")
    String user(
            Model model, @PathVariable String user) {
        ParameterizedTypeReference<List<Map<String, Object>>> responseType = new ParameterizedTypeReference<List<Map<String, Object>>>() {
        };
        List<Map<String, Object>> bookmarks = restTemplate
                .exchange("http://localhost:8000/" + user, HttpMethod.GET, null, responseType)
                .getBody();
        model.addAttribute("bookmarks", bookmarks);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/entry")
    String entry(Model model, @RequestParam String url) {
        ParameterizedTypeReference<Map<String, Object>> responseType = new ParameterizedTypeReference<Map<String, Object>>() {
        };
        Map<String, Object> respomse = restTemplate
                .exchange("http://localhost:8000/entry?url=" + url, HttpMethod.GET, null,
                        responseType)
                .getBody();
        model.addAttribute("bookmarks", respomse.get("bookmarks"));
        model.addAttribute("entry", respomse.get("entry"));
        return "entry";
    }
}
