package org.delivery.demo1.mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.delivery.demo1.dto.BoardDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;



    @Test
    public void testInsert() {
        BoardDTO boardDto = BoardDTO.builder()
                .title("title")
                .content("content")
                .writer("user00")
                .build();

        int insertCount = boardMapper.insert(boardDto);
        log.info("--------------------");
        log.info("insertCount: " + insertCount);
        log.info("=========================");
        log.info("BNO: " + boardDto.getBno());
    }

    @Test
    public void testSelectOne() {
        Long bno = 2L;
        BoardDTO board = boardMapper.selectOne(bno);
        log.info("board: " + board);
    }

    @Test
    public void testRemove() {
        Long bno = 2L;
        int removeCount = boardMapper.remove(bno);
        log.info("-------------------");
        log.info("removeCount: " + removeCount);
    }

    @Test
    public void testUpdate() {
        BoardDTO board = BoardDTO.builder()
                .bno(2L)
                .title("Update title")
                .content("Update content")
                .delFlag(false)
                .build();

        int updateCount = boardMapper.update(board);

        log.info("----------------------");
        log.info("updateCount: " + updateCount);

    }

    @Test
    public void testList() {
        List<BoardDTO> dtoList = boardMapper.list();
        log.info("dtoList");
        log.info(dtoList);

        dtoList.stream().forEach(log::info);
    }

    @Test
    public void testList2() {
        int page = 2;

        // 계산
        int skip = (page - 1) * 10;
        int count = 10;

        List<BoardDTO> dtoList = boardMapper.list2(skip, count);

        dtoList.stream().forEach(log::info);
    }
}
