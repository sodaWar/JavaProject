package com.lbb.model;

import lombok.Data;

import java.util.Date;
@Data
public class TGreyListModel {
    String id;
    String userName;//"姓名',
    String mobile; //手机号',
    String timeoutDay; // '-2:闪贷灰名单',
    Date gmtCreate; //入库时间',
    Date gmtModify;  //修改时间',
    int state;  //0(已剔除) 1(未剔除)",
    String orgId;//机构id,
    String orgName;  //  机构名称,
}
