package com._42kh.backend.service.bookmark;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com._42kh.backend.domain.Bookmark.Bookmark;
import com._42kh.backend.domain.Bookmark.BookmarkRepository;
import com._42kh.backend.web.bookmark.dto.BookmarkRequest;
import com._42kh.backend.web.bookmark.dto.BookmarkResponse;
import com._42kh.backend.web.bookmark.dto.BookmarkSaveResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookmarkServiceImpl implements BookmarkService{
   
    private final BookmarkRepository bookmarkRepository;
    
    @Override
    @Transactional
    public BookmarkSaveResponse save(BookmarkRequest bookmarkRequest) {
        Bookmark bookmark = bookmarkRepository.save(bookmarkRequest.toEntity());
        return new BookmarkSaveResponse(bookmark);
    }

    @Override
    @Transactional (readOnly = true)
    public BookmarkResponse findById(Long id) {
        Bookmark bookmark = bookmarkRepository.findById(id).orElseThrow();
        return new BookmarkResponse(bookmark);
    }

    @Override
    @Transactional (readOnly = true)
    public List<BookmarkResponse> finAll() {
        List<Bookmark> bookmark = bookmarkRepository.findAll();
        return bookmark.stream()
                .map(BookmarkResponse::new)
                .toList();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Bookmark bookmark = bookmarkRepository.findById(id).orElseThrow();
        bookmarkRepository.delete(bookmark);
    }
}
