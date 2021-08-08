package com.tweebaa.apicustomeradmin.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageCustomers {
//    "totalCount":22,"pageSize":10,"totalPage":3,"currPage":2,"list":
//    @Getter
//    @Setter

    private Integer totalCount=0;
    private Integer pageSize=0;
    private Integer totalPage=0;
    private Integer currPage=0;
    private List list;

}
