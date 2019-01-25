package com.lbb.model;
import lombok.Data;
import java.util.Date;

@Data
public class TBlacklistModel {
    String id;
    String userName;
    String mobile;
    String timeoutDay;
    Date gmtCreate;
    Date   gmtModify;
    String label;
    String status;
    String orgId;
    String orgName;
}
