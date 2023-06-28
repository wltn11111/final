package com._42kh.backend.web.bookmark;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._42kh.backend.service.bookmark.BookmarkService;
import com._42kh.backend.web.bookmark.dto.BookmarkRequest;
import com._42kh.backend.web.bookmark.dto.BookmarkResponse;
import com._42kh.backend.web.bookmark.dto.BookmarkSaveResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/bookmark")
public class BookmarkController {
    
    private final BookmarkService bookmarkService; 

    @PostMapping
    public BookmarkSaveResponse save(@RequestBody BookmarkRequest bookmarkRequest) {
        return bookmarkService.save(bookmarkRequest);
    }
    
    @GetMapping("/{id}")
    public BookmarkResponse findById(@PathVariable("id") Long id) {
        return bookmarkService.findById(id);
    }
    
    @GetMapping
    public List<BookmarkResponse> findAll(){
        return bookmarkService.finAll();
    }
    
    @DeleteMapping
    public void delete(@PathVariable("id") Long id) {
        bookmarkService.delete(id);
    }
}
