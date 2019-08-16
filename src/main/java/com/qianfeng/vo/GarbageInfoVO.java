package com.qianfeng.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GarbageInfoVO {
    long log_id;
    int result_num;
    List<ItemInfoVO> result = new ArrayList<ItemInfoVO>();
}
