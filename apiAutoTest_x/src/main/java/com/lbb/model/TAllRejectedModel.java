package com.lbb.model;

import lombok.Data;

import java.util.Date;

@Data
public class TAllRejectedModel {
    private int id;
    private String userName;
    private String mobile;
    private String idCard;
    private String rejectN;
    private Date gmtCreate;
    private  String orgId;
    private String orgName;


}
