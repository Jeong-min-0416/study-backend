package com.example.demo.songbook.dto.request;

import com.example.demo.songbook.entity.Songbook;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ModifySongbookRequest {

    private Long id;
    private Long songNumber;
    private String songName;
    private String songMemo;

}
