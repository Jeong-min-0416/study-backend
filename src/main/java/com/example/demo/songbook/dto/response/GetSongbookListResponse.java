package com.example.demo.songbook.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class GetSongbookListResponse {

    private Long songNumber;
    private String songName;
    private String songMemo;
    private LocalDateTime createAt;
    private LocalDateTime modifyAt;

    public GetSongbookListResponse(
            Long songNumber,
            String songName,
            String songMemo,
            LocalDateTime createAt,
            LocalDateTime modifyAt) {

        this.songNumber = songNumber;
        this.songName = songName;
        this.songMemo = songMemo;
        this.createAt = createAt;
        this.modifyAt = modifyAt;
    }
}
