package com.lbb.model;

import lombok.Data;

import java.util.Date;
@Data
public class TWhiteListModel {
    String id;//id',
    String userName; //'姓名',
    String mobile;//手机号',
    int timeoutDay; //'-2:爱信测试',
    Date gmtCreate;  //'入库时间',
    Date gmtModify; //'修改时间',
    int userLabel;//'用户标签: 1:体验很好,2:马上借款,3:提出意见,4:忘记注册过,5:申请未通过,6:暂无需求,7:不接受回访,8:退订用户,9:不希望被骚扰,10:电话关机,11:电话空号\r\n12:电话停机,13:直接挂断,14:无人接听',
    int state;  //(已剔除)1(未剔除)',
    String orgId;//'机构id',
    String orgName;  //'机构名称',
}
