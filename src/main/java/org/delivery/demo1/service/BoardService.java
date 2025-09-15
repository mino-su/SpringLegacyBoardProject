package org.delivery.demo1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.delivery.demo1.dto.BoardDTO;
import org.delivery.demo1.dto.BoardListPagingDTO;
import org.delivery.demo1.mapper.BoardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class BoardService {
    private final BoardMapper boardMapper;

    public List<BoardDTO> getList() {
        return boardMapper.list();
    }

    public Long register(BoardDTO dto) {
        int insertCount = boardMapper.insert(dto);
        log.info("insertCount: " + insertCount);
        return dto.getBno();
    }

    public BoardDTO read(Long bno) {
        return boardMapper.selectOne(bno);
    }

    public void remove(Long bno) {
        boardMapper.remove(bno);
    }

    public void modify(BoardDTO dto) {
        boardMapper.update(dto);
    }

    public BoardListPagingDTO getList(int page, int size) {
        // 페이지 번호가 0보다 작으면 무조건 1 페이지
        page = page <= 0 ? 1: page;
        // 사이즈가 10보다 작거나 100보다 크면 10
        size = (size <= 10 || page > 100) ? 10 : size;

        int skip = (page - 1) * size; // 2페이지 라면 (2-1)*10 이 되어야 함

        List<BoardDTO> list = boardMapper.list2(skip, size);

        int total = boardMapper.listCount();

        return new BoardListPagingDTO(list, total, page, size);
    }
}
