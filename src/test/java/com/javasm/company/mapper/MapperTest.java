package com.javasm.company.mapper;

import com.javasm.company.bean.Vo.CompanyEmployeeInfoVo;
import com.javasm.util.PaginationHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class MapperTest {
    @Resource
    private CompanyEmployeeInfoVoMapper mapper;
    @Resource
    private PaginationHelper helper;
    @Test
    public void test1(){
        CompanyEmployeeInfoVo vo = mapper.findById(1);
        log.info("{}",vo);
        log.info("{}",vo.getEmployeeName());
    }
    @Test
    public void test2(){
        helper.setTotalInfo(9);
        helper.setPage(1);
        helper.setPrePageInfo(3);
        List<CompanyEmployeeInfoVo> all = mapper.findAll(0, 3,39671);
        log.info("{}",all);

    }
}
