package com.example.controller;

import java.util.List;
import java.util.Map;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
                .exchange("http://bookmark-api/" + user, HttpMethod.GET, null, responseType)
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
                .exchange("http://bookmark-api/entry?url=" + url, HttpMethod.GET, null,
                        responseType)
                .getBody();
        model.addAttribute("bookmarks", respomse.get("bookmarks"));
        model.addAttribute("entry", respomse.get("entry"));
        return "entry";
    }

    @GetMapping("/add")
    String add() {
        return "add";
    }

    @PostMapping("/add")
    String add(Model model, @RequestParam String url, @RequestParam String title,
            @RequestParam(required = false) String comment) {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("url", url);
        form.add("title", title);
        form.add("comment", comment);
        restTemplate.postForObject("http://bookmark-api/add", form, String.class);
        return "redirect:/entry?url=" + url;
    }
}
