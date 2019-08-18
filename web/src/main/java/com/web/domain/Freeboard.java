package com.web.domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Freeboard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "freeId")
    private Long freeId;

    @Column(name = "content")
    private String content;

    @Column(name = "title")
    private String title;

    @Column(name = "writer")
    private String writer;

}