package com.sparta.board.entity;

import com.sparta.board.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Board extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String content;

    public Board(BoardRequestDto.BoardResistDto boardResistDto){
        this.title = boardResistDto.getTitle();
        this.username = boardResistDto.getUsername();
        this.password = boardResistDto.getPassword();
        this.content = boardResistDto.getContent();
    }

    public void updateBoard(BoardRequestDto.BoardResistDto boardResistDto){
        this.title = boardResistDto.getTitle();
        this.username = boardResistDto.getUsername();
        this.password = boardResistDto.getPassword();
        this.content = boardResistDto.getContent();
    }
}
