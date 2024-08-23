package com.example.demo.songbook.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetSongbookListRequest {

    private String songName;
    private String songMemo;
}
