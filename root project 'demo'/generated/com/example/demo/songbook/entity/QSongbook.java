package com.example.demo.songbook.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSongbook is a Querydsl query type for Songbook
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSongbook extends EntityPathBase<Songbook> {

    private static final long serialVersionUID = -1258013613L;

    public static final QSongbook songbook = new QSongbook("songbook");

    public final DateTimePath<java.time.LocalDateTime> createAt = createDateTime("createAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> modifyAt = createDateTime("modifyAt", java.time.LocalDateTime.class);

    public final StringPath songMemo = createString("songMemo");

    public final StringPath songName = createString("songName");

    public final NumberPath<Long> songNumber = createNumber("songNumber", Long.class);

    public QSongbook(String variable) {
        super(Songbook.class, forVariable(variable));
    }

    public QSongbook(Path<? extends Songbook> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSongbook(PathMetadata metadata) {
        super(Songbook.class, metadata);
    }

}

