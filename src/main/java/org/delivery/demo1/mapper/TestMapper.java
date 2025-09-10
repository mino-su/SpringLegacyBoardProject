package org.delivery.demo1.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface TestMapper {
    @Insert("insert into tb1_testA (col1) values (#{str})")
    int insertA(@Param("str") String str);

    @Insert("insert into tb1_testB (col2) values (#{str})")
    int insertB(@Param("str") String str);
}
