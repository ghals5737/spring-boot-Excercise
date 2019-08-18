package com.web.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreeboardComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private Long comment_id;

    @Column(name = "content")
    private String content;

    @Column(name = "write_date")
    private LocalDateTime write_date;

    @Column(name = "writer")
    private String writer;

    @Column(name = "comment_origin_id")
    private Long comment_origin_id;

    @Column(name = "comment_level")
    private int comment_level;

    //@ManyToOne(targetEntity = Freeboard.class)
    //@JoinColumn(table =  )
    private Long freeId;

}
