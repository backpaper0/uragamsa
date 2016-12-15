package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.BookmarkDao;
import com.example.dao.EntryDao;
import com.example.entity.Bookmark;

@RestController
@RequestMapping("entry")
public class EntryController {

    final BookmarkDao bookmarkDao;
    final EntryDao entryDao;

    public EntryController(BookmarkDao bookmarkDao, EntryDao entryDao) {
        this.bookmarkDao = bookmarkDao;
        this.entryDao = entryDao;
    }

    @GetMapping
    Map<String, Object> findByUrl(@RequestParam String url) {
        return entryDao.findByUrl(url)
                .map(x -> {
                    List<Bookmark> bookmarks = bookmarkDao.findByEntryId(x.id);
                    Map<String, Object> map = new HashMap<>();
                    map.put("entry", x);
                    map.put("bookmarks", bookmarks);
                    return map;
                }).orElse(null);
    }
}
