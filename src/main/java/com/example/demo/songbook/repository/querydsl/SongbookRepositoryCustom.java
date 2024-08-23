package com.example.demo.songbook.repository.querydsl;

import com.example.demo.songbook.dto.request.GetSongbookListRequest;
import com.example.demo.songbook.dto.response.GetSongbookListResponse;

import java.util.List;

public interface SongbookRepositoryCustom {
    List<GetSongbookListResponse> getSongbookList(GetSongbookListRequest request);
}
