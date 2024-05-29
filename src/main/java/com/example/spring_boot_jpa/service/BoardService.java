package com.example.spring_boot_jpa.service;

import com.example.spring_boot_jpa.dto.BoardCreateDTO;
import com.example.spring_boot_jpa.entity.BoardEntity;
import com.example.spring_boot_jpa.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public List<BoardEntity> getBoards() {
        return boardRepository.findAll();
    }

    public BoardEntity insertBoard(BoardCreateDTO board) {
        BoardEntity newBoard = BoardEntity.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .build();
        return boardRepository.save(newBoard);
    }

    public BoardEntity updateBoard(int id, BoardCreateDTO board) {
        BoardEntity exist = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 게시판입니다."));

        BoardEntity update = BoardEntity.builder()
                .id(exist.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .build();

        return boardRepository.save(update);
    }

    public BoardEntity deleteBoard(int id) {
        BoardEntity exist = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 게시판입니다."));

        boardRepository.delete(exist);
        return exist;
    }
}//class
