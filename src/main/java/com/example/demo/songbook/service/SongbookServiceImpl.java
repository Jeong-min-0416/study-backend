package com.example.demo.songbook.service;

import com.example.demo.songbook.dto.request.CreateSongbookRequest;
import com.example.demo.songbook.dto.request.GetSongbookListRequest;
import com.example.demo.songbook.dto.request.ModifySongbookRequest;
import com.example.demo.songbook.dto.response.GetSongbookListResponse;
import com.example.demo.songbook.dto.response.SongbookResponse;
import com.example.demo.songbook.entity.Songbook;
import com.example.demo.songbook.repository.jpa.SongbookRepository;
import com.example.demo.songbook.repository.querydsl.SongbookRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongbookServiceImpl implements SongbookService {

    private final SongbookRepository songbookRepository;
    private final SongbookRepositoryCustom songbookRepositoryCustom;

    @Override
    public SongbookResponse createSongbook(CreateSongbookRequest request) {
        Songbook songbook = request.ToEntity();

        Songbook savedSongbook = songbookRepository.save(songbook);

        return SongbookResponse.convertToResponse(savedSongbook);
    }

    @Override
    @Transactional
    public SongbookResponse modifySongbook(ModifySongbookRequest request) {
        Songbook songbook = songbookRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalArgumentException("일치하는 데이터가 없습니다."));

        songbook.modify(request);

        // 엔티티를 저장하여 `@PreUpdate`가 호출되도록 함
        Songbook savedSongbook = songbookRepository.save(songbook);

        return SongbookResponse.convertToResponse(savedSongbook);
    }

    @Override
    @Transactional
    public void deleteSongbook(List<Long> id) {
        songbookRepository.deleteByIdIn(id);
    }

    @Override
    public List<GetSongbookListResponse> getSongbookList(GetSongbookListRequest request) {
        return songbookRepositoryCustom.getSongbookList(request);
    }

}
