package com.lbb.model;

import lombok.Data;

import java.util.Date;

@Data
public class TAixinqianbaoWhiteList {
    private  String id;
    private  String userName;
    private  String mobile;
    private  String timeoutDay;
    private  Date gmtCreate;
    private  String userLabel;
    private  String zhimaScore;
    private  Date gmtModify;
}
