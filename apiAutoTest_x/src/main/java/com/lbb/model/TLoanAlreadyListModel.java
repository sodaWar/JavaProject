package com.lbb.model;

import lombok.Data;

import java.util.Date;
@Data
public class TLoanAlreadyListModel {
    private int id;
    private String phone;
    private String idNumber;
    private String name;
    private String moneyAmount;
    private String loanTerm;
    private Date orderTime;
    private int isBlack;
    private Date gmtCreate;
    private String orgId;
    private String orgName;
}
