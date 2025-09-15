package org.delivery.demo1.mapper;

import org.delivery.demo1.dto.BoardDTO;

import java.util.List;

public interface BoardMapper {
    int insert(BoardDTO dto);

    BoardDTO selectOne(Long bno);

    int remove(Long bno);

    int update(BoardDTO dto);

    List<BoardDTO> list();
}
