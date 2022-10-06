package com.sparta.board.controller;

import com.sparta.board.dto.BoardRequestDto;
import com.sparta.board.dto.BoardResponseDto;
import com.sparta.board.entity.Board;
import com.sparta.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    // 전체 게시글 목록 조회 (GET)
    @GetMapping("/api/board")
    public Map<String, Object> getBoard(){
        return boardService.getBoards();
    }

    // 게시글 작성 (POST)
    @PostMapping("/api/board")
    // 타입 response로
    public BoardResponseDto.BoardInfoDto postBoard (@RequestBody BoardRequestDto.BoardResistDto boardResistDto){
        // response 반환
        return boardService.postBoard(boardResistDto);
    }

    // 게시글 조회 (GET)
    @GetMapping("/api/board/{id}")
    public BoardResponseDto.BoardInfoDto getBoardOne(@PathVariable Long id){
        return boardService.getBoardOne(id);
    }

    // 게시글 비밀번호 확인 (GET)
    @GetMapping("/api/board/{id}/{password}")
    public Boolean getBoardPassword(@PathVariable Long id, @PathVariable String password){
        return boardService.checkPassword(id, password);
    }

    // 게시글 수정 (PUT)
    @PutMapping("/api/board/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto.BoardResistDto boardResistDto){
        boardService.updateBoard(id, boardResistDto);
        return id;
    }

    // 게시글 삭제 (DELETE)
    @DeleteMapping("/api/board/{id}")
    public Long deleteBoard(@PathVariable Long id){
        return boardService.deleteBoard(id);
    }
}
