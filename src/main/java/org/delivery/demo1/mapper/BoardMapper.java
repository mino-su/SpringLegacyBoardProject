package org.delivery.demo1.mapper;

import org.apache.ibatis.annotations.Param;
import org.delivery.demo1.dto.BoardDTO;

import java.util.List;

public interface BoardMapper {
    int insert(BoardDTO dto);

    BoardDTO selectOne(Long bno);

    int remove(Long bno);

    int update(BoardDTO dto);

    List<BoardDTO> list();

    List<BoardDTO> list2(@Param("skip") int skip, @Param("count")int count);// 페이징 처리

    int listCount();
}
