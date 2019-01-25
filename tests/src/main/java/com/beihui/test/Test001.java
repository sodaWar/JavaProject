package com.beihui.test;

import com.beihui.domain.*;
import com.beihui.service.UserCenterService;
import com.beihui.service.UserCenterServiceImpl;

/**
 * 第一个测试类（测试用户绑定银行卡...）
 *
 * @author huangdy
 * @Date 2018/11/22
 */
public class Test001 extends BaseTest {

    public static void main(String[] args) {
        // 固定写法
        UserCenterService service = new UserCenterServiceImpl(privateKey, domain, appId);

//        //指定用户的银行卡信息查询接口
//        BankCardBindingQuery query = new BankCardBindingQuery();
//        query.setUserId("000831f004a7420c82cb0c6b6e2ab63a");
//        service.getBankcardBinding(query);
//
//        //修改银行卡绑定信息接口
//        BankCardBindingBO bo = new BankCardBindingBO();
//        bo.setIdCard("211848199902126542");
//        bo.setCardNumber("62284819903121322");
//        bo.setBankName("农业银行");
//        bo.setStatus(1);
//        bo.setUserId("000831f004a7420c82cb0c6b6e2ab63a");
//        bo.setOrgId("1");
//        service.storeBankCardBinding(bo);
//
//        //银行卡绑定信息接口
//        query.setIdCard("211848199902126542");
//        query.setUserId("000831f004a7420c82cb0c6b6e2ab63a");
//        query.setOrgId("1");
//        service.getBankcardBindingList(query);

        //借款记录查询接口
//        RealNameQuery rq = new RealNameQuery();
//        rq.setIdCard("211848199902126542");
//        service.getUserOrderStat(rq);

//        //通讯录信息接口
//        rq.setIdCard("211848199902126542");
//        service.getUserContacts(rq);
//
//        //运营商信息接口
//        OperatorQuery oq = new OperatorQuery();
//        oq.setUserId("73c9fae86f9144aebe4b4fd79cb93a50");
//        oq.setOrg("tianji");
//        service.getOperatorInfo(oq);
//
//        //证照信息查询接口
//        rq.setIdCard("211848199902126542");
//        service.getRealNameList(rq);
//
//        //借款人信息查询接口
//        rq.setIdCard("211848199902126542");
//        service.getBorrowerInfo(rq);
//
//        //新增实名用户接口
//        RealNameBO rb = new RealNameBO();
//        rb.setRealName("洪乃武功");
//        rb.setIdCard("211848199902126542");
//        rb.setUserId("000831f004a7420c82cb0c6b6e2ab63a");
//        rb.setPhone("17348518944");
//        rb.setOrgId("1");
//        service.saveRealName(rb);
//
//        //修改实名用户接口
//        rb.setRealName("洪乃武功");
//        rb.setIdCard("211848199902126542");
//        rb.setUserId("000831f004a7420c82cb0c6b6e2ab63a");
//        rb.setPhone("17348518942");
//        rb.setOrgId("1");
//        service.updateRealName(rb);

        //查询单个实名用户接口
//        rq.setUserId("000831f004a7420c82cb0c6b6e2ab63a");
//        service.getRealNameByUserId(rq);

        //用户设备查询接口
//        DeviceQuery dq = new DeviceQuery();
//        dq.setUserId("000831f004a7420c82cb0c6b6e2ab63a");
//        service.getDevice(dq);

        //用户基础信息查询接口
        RealNameBaseQuery rbq = new RealNameBaseQuery();
        rbq.setIdCard("211848199902126542");
        service.getRealNameBase(rbq);

    }

}
