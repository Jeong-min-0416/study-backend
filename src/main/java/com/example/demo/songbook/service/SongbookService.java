package com.example.demo.songbook.service;

import com.example.demo.songbook.dto.request.CreateSongbookRequest;
import com.example.demo.songbook.dto.request.DeleteSongbookRequest;
import com.example.demo.songbook.dto.request.GetSongbookListRequest;
import com.example.demo.songbook.dto.request.ModifySongbookRequest;
import com.example.demo.songbook.dto.response.GetSongbookListResponse;
import com.example.demo.songbook.dto.response.SongbookResponse;

import java.util.List;

public interface SongbookService {

    SongbookResponse createSongbook(CreateSongbookRequest request);

    SongbookResponse modifySongbook(ModifySongbookRequest request);

    void deleteSongbook(List<Long> id);

    List<GetSongbookListResponse> getSongbookList(GetSongbookListRequest request);
}
