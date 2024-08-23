package com.example.demo.songbook.controller;

import com.example.demo.songbook.dto.request.CreateSongbookRequest;
import com.example.demo.songbook.dto.request.DeleteSongbookRequest;
import com.example.demo.songbook.dto.request.GetSongbookListRequest;
import com.example.demo.songbook.dto.request.ModifySongbookRequest;
import com.example.demo.songbook.dto.response.GetSongbookListResponse;
import com.example.demo.songbook.dto.response.SongbookResponse;
import com.example.demo.songbook.service.SongbookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/songbook")
public class SongbookController {

    @Autowired
    private final SongbookService songbookService;

    @PostMapping("/createSongbook")
    public SongbookResponse createSongbook(@RequestBody CreateSongbookRequest request) {
        return songbookService.createSongbook(request);
    }

    @PostMapping("/modifySongbook")
    public SongbookResponse modifySongbook(@RequestBody ModifySongbookRequest request) {
        return songbookService.modifySongbook(request);
    }

    @PostMapping("/deleteSongbook")
    public void deleteSongbook(@RequestBody List<DeleteSongbookRequest> request) {

        List<Long> id = request.stream()
                .flatMap(deleteRequest -> deleteRequest.getId().stream())
                .collect(Collectors.toList());

        songbookService.deleteSongbook(id);
    }

    @PostMapping("/getSongbookList")
    public List<GetSongbookListResponse> getSongbookList(@RequestBody GetSongbookListRequest request) {

        return songbookService.getSongbookList(request);
    }

}
