package com.sparta.board.dto;

import lombok.Getter;

@Getter
public class BoardRequestDto {
    protected String title;
    protected String username;
    protected String password;
    protected String content;
}
