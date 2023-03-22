package com.javasm.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@Component
public class PaginationHelper {
    //1.总帖子数
    private int totalInfo;
    //2.每页帖子数
    private int prePageInfo;
    //3.当前在第几页
    private int page;
    //4.一共多少页
    public int getPageCount() {
        //当查询结果为0时，设置总页数为1，方便返回前段
        if(totalInfo==0){
            return 1;
        }
        return totalInfo % prePageInfo == 0 ? totalInfo / prePageInfo : totalInfo / prePageInfo + 1;
    }
    //5.起始索引
    public int getCurrentPageStart() {
        if (page < 1 || page > getPageCount()) {
            throw new RuntimeException("页数错误");
        }
        return (page - 1) * prePageInfo;
    }



}
