package com.example.demo.songbook.dto.response;

import com.example.demo.songbook.entity.Songbook;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class SongbookResponse {

    private Long id;
    private Long songNumber;
    private String songName;
    private String songMemo;

    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime createAt;

    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime modifyAt;

    public static SongbookResponse convertToResponse(Songbook songbook) {
        SongbookResponse response = new SongbookResponse();
        response.setId(songbook.getId());
        response.setSongNumber(songbook.getSongNumber());
        response.setSongName(songbook.getSongName());
        response.setSongMemo(songbook.getSongMemo());
        response.setCreateAt(songbook.getCreateAt());
        response.setModifyAt(songbook.getModifyAt());
        return response;
    }
}