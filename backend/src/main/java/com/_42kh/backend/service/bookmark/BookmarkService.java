package com._42kh.backend.service.bookmark;

import java.util.List;

import com._42kh.backend.web.bookmark.dto.BookmarkRequest;
import com._42kh.backend.web.bookmark.dto.BookmarkResponse;
import com._42kh.backend.web.bookmark.dto.BookmarkSaveResponse;

public interface BookmarkService {

    BookmarkSaveResponse save(BookmarkRequest bookmarkRequest);
    
    BookmarkResponse findById(Long id);

    List<BookmarkResponse> finAll(); 

    void delete(Long id);

}
