package com.example.demo.songbook.repository.jpa;

import com.example.demo.songbook.entity.Songbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongbookRepository extends JpaRepository<Songbook, Long> {

    void deleteByIdIn(List<Long> id);



}
