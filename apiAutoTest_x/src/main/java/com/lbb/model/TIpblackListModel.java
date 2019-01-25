package com.lbb.model;

import lombok.Data;

import java.util.Date;

@Data
public class TIpblackListModel {
    private int id;
    private String IP;
    private Date gmtCreate;
    private String orgId;
    private String orgName;
}
