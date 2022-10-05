package com.sparta.board.service;

import com.sparta.board.dto.BoardRequestDto;
import com.sparta.board.dto.BoardResponseDto;
import com.sparta.board.entity.Board;
import com.sparta.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
        // 전체 게시글 목록 조회 (GET)
        @Transactional
        public List<BoardResponseDto.BoardInfoDto> getBoards(){
            List<Board> boards = boardRepository.findAllByOrderByModifiedAtDesc();
            List<BoardResponseDto.BoardInfoDto> lists = new ArrayList<>();

            // 생성자
            // setter (권장 x)
            // builder
            // 생성자가 아닌 생성메서드

            for (Board board : boards) {
                lists.add(new BoardResponseDto.BoardInfoDto(board));
            }
            return lists;
        }

        // 게시글 작성 (POST)
        @Transactional
        public BoardResponseDto.BoardInfoDto postBoard(BoardRequestDto.BoardResistDto boardResistDto){
            // 완전한 데이터 저장후
            Board savedBoard = boardRepository.save(new Board(boardResistDto));

            // response 반환
            return new BoardResponseDto.BoardInfoDto(savedBoard);
        }

        // 게시글 조회 (GET)
        @Transactional
        public BoardResponseDto.BoardInfoDto getBoardOne(Long id){
            Board board = boardRepository.findById(id).get();
            return new BoardResponseDto.BoardInfoDto(board);
        }

        // 게시글 비밀번호 확인 (GET)
        @Transactional
        public boolean checkPassword(Long id, String password){
            Board board = boardRepository.findById(id).get();
            if (!board.getPassword().equals(password)) {
                return false;
            }
            return true;
        }

        // 트랜잭셔널 어노테이션 넣으면 save() 안해도됨
        // 게시글 수정 (PUT)
        @Transactional
        public Long updateBoard(Long id, BoardRequestDto.BoardResistDto boardResistDto){
            Board board = boardRepository.findById(id).orElseThrow(
                    () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
            );
            board.updateBoard(boardResistDto);
            boardRepository.save(board);
            return board.getId();
        }

        // 게시글 삭제 (DELETE)
        @Transactional
        public Long deleteBoard(Long id){
            boardRepository.deleteById(id);
            return id;
        }
}
