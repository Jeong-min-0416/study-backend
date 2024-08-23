package com.example.demo.songbook.dto.request;

import com.example.demo.songbook.entity.Songbook;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateSongbookRequest {

    private Long songNumber;
    private String songName;
    private String songMemo;

    public Songbook ToEntity(){
        return Songbook.builder()
                .songNumber(this.songNumber)
                .songName(this.songName)
                .songMemo(this.songMemo)
                .build();
    }

}
