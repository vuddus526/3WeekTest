package com.sparta.board.service;

import com.sparta.board.dto.BoardRequestDto;
import com.sparta.board.entity.Board;
import com.sparta.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
        // 전체 게시글 목록 조회 (GET)
        @Transactional
        public List<Board> getBoards(){
            return boardRepository.findAllByOrderByModifiedAtDesc();
        }

        // 게시글 작성 (POST)
        @Transactional
        public Board postBoard(Board board){
            return boardRepository.save(board);
        }

        // 게시글 조회 (GET)
        @Transactional
        public Board getBoardOne(Long id){
            Board board = boardRepository.findById(id).get();
            return board;
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
        public Long updateBoard(Long id, BoardRequestDto boardRequestDto){
            Board board = boardRepository.findById(id).orElseThrow(
                    () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
            );
            board.updateBoard(boardRequestDto);
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
