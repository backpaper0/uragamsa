package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.BookmarkDao;
import com.example.dao.BookmarkDao.BookmarkView;
import com.example.dao.EntryDao;
import com.example.entity.Bookmark;
import com.example.entity.Entry;

@RestController
public class BookmarkController {

    final BookmarkDao bookmarkDao;
    final EntryDao entryDao;

    public BookmarkController(BookmarkDao bookmarkDao, EntryDao entryDao) {
        this.bookmarkDao = bookmarkDao;
        this.entryDao = entryDao;
    }

    @GetMapping("{username}")
    List<BookmarkView> findAll(@PathVariable String username) {
        return bookmarkDao.findByUsername(username);
    }

    @PostMapping
    Bookmark post(@RequestParam String username,
            @RequestParam String url,
            @RequestParam String title,
            @RequestParam(required = false) String comment) {

        Optional<Entry> entryOpt = entryDao.findByUrl(url);
        Entry entry = entryOpt.orElseGet(Entry::new);
        if (entryOpt.isPresent() == false) {
            entry.url = url;
            entry.title = title;
            entryDao.insert(entry);
        }

        Long entryId = entry.id;

        Optional<Bookmark> bookmarkOpt = bookmarkDao.findByUsernameAndEntryId(username, entryId);
        Bookmark bookmark = bookmarkOpt.orElseGet(Bookmark::new);
        if (bookmarkOpt.isPresent()) {
            bookmark.comment = comment;
            bookmarkDao.update(bookmark);
        } else {
            bookmark.username = username;
            bookmark.comment = comment;
            bookmark.entryId = entryId;
            bookmarkDao.insert(bookmark);
        }

        return bookmark;
    }
}
