package com.sparta.board.dto;

import lombok.Getter;


public class BoardRequestDto {
    @Getter
    public static class BoardResistDto {
        private String title;
        private String username;
        private String password;
        private String content;
    }
}
