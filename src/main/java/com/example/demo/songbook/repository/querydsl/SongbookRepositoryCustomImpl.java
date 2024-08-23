package com.example.demo.songbook.repository.querydsl;

import com.example.demo.songbook.dto.request.GetSongbookListRequest;
import com.example.demo.songbook.dto.response.GetSongbookListResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static generated.com.example.demo.songbook.entity.QSongbook.songbook;

@Repository
@RequiredArgsConstructor
public class SongbookRepositoryCustomImpl implements SongbookRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<GetSongbookListResponse> getSongbookList(GetSongbookListRequest request) {
        // 기본 Querydsl 쿼리 생성
        var query = queryFactory.selectFrom(songbook);

        // 조건을 추가할 때 null 또는 빈 문자열인지 확인
        if (request.getSongName() != null && !request.getSongName().trim().isEmpty()) {
            query.where(songbook.songName.eq(request.getSongName()));
        }

        if (request.getSongMemo() != null && !request.getSongMemo().trim().isEmpty()) {
            query.where(songbook.songMemo.eq(request.getSongMemo()));
        }

        return query.fetch()
                .stream()
                .map(songbook -> new GetSongbookListResponse(
                        songbook.getSongNumber(),
                        songbook.getSongName(),
                        songbook.getSongMemo(),
                        songbook.getCreateAt(),
                        songbook.getModifyAt()
                ))
                .toList();
    }

//    @Override
//    public List<GetSongbookListResponse> getSongbookList(GetSongbookListRequest request) {
////        return null;
//        return queryFactory
//                .selectFrom(songbook) // QSongbook 인스턴스 사용
//                .where(
//                        songbook.songName.eq(request.getSongName()), // 엔티티 필드에 접근
//                        songbook.songName.eq(request.getSongMemo()) // 엔티티 필드에 접근
//                )
//                .fetch()
//                .stream()
//                .map(songbook -> new GetSongbookListResponse(
//                        songbook.getSongNumber(),
//                        songbook.getSongName(),
//                        songbook.getSongMemo(),
//                        songbook.getCreateAt(),
//                        songbook.getModifyAt()
//                ))
//                .toList();

//    }

}
