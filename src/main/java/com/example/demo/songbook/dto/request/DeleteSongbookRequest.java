package com.example.demo.songbook.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DeleteSongbookRequest {

    private List<Long> id;
}
