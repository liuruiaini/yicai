package com.javasm.company.mapper;

import com.javasm.company.bean.Vo.CompanyEmployeeInfoVo;
import com.javasm.util.PaginationHelper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyEmployeeInfoVoMapper {
    CompanyEmployeeInfoVo findById(Integer id);
    List<CompanyEmployeeInfoVo> findAll(Integer index,Integer size,Integer companyId);
}
