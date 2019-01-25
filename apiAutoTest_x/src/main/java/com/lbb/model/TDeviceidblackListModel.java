package com.lbb.model;

import lombok.Data;

import java.util.Date;
@Data
public class TDeviceidblackListModel {
    private String id;
    private String deviceID;
    private int cntN;
    private int label;
    private Date gmtCreate;
    private String orgId;
    private String orgName;
}
