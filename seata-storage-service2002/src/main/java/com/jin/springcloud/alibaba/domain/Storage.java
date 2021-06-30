package com.jin.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Long id;
    private Long productId;
    private Integer total;
    /**
     * storage used
     */
    private Integer used;
    /**
     * balance
     */
    private Integer residue;
}
