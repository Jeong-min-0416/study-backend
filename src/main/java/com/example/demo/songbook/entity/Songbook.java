package com.example.demo.songbook.entity;

import com.example.demo.songbook.dto.request.ModifySongbookRequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "songbook")
public class Songbook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "song_number", nullable = false)
    private Long songNumber;

    @Column(name = "song_name", nullable = false, length = 255)
    private String songName;

    @Column(name = "song_memo", length = 1000)
    private String songMemo;

    @CreatedDate
    @Column(name = "create_at", updatable = false)
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(name = "modify_at")
    private LocalDateTime modifyAt;

    @Builder
    public Songbook(Long songNumber, String songName, String songMemo) {
        this.songNumber = songNumber;
        this.songName = songName;
        this.songMemo = songMemo;
    }

    public Songbook modify(ModifySongbookRequest request) {
        this.songNumber = request.getSongNumber();
        this.songName = request.getSongName();
        this.songMemo = request.getSongMemo();

        return this;
    }

    @PrePersist
    protected void onCreate() {
        createAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        modifyAt = LocalDateTime.now();
    }
}
