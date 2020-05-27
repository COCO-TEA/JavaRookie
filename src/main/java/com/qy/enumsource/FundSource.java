package com.qy.enumsource;


/**
 * Created by dell on 2018/1/2.
 */
public enum FundSource {
    WITHHOLD(0, 2, "银行卡代扣", "com.dafy.trade.service.repay.task.CashRepayTaskWrapper", null),
    TRANFER_BAL(1, 0, "消费账户划拨-余额还款", "com.dafy.trade.service.repay.task.CashRepayTaskWrapper", null),
    SHORTCUT(2, 0, "快捷还款", "com.dafy.trade.service.repay.task.CashRepayTaskWrapper", null),
    TRANFER_REVERSE(3, 3, "达飞账户划拨-线下还款", "com.dafy.trade.service.repay.task.CashRepayTaskWrapper", null),
    WEIXIN(4, 3, "微信还款", "", null),
    WITHHOLD_DOCA1(5, 1, "银行卡代扣-人工代扣", "com.dafy.trade.service.repay.task.CashRepayTaskWrapper", null),
    TRANFER_DOCA2(7, 1, "银行卡代扣-人工代扣", "com.dafy.trade.service.repay.task.CashRepayTaskWrapper", null),
    TRANFER_DOCA3(8, 1, "银行卡代扣-人工代扣", "com.dafy.trade.service.repay.task.CashRepayTaskWrapper", null),
    TRANFER_DOCA4(11, 1, "银行卡代扣-人工代扣", "com.dafy.trade.service.repay.task.CashRepayTaskWrapper", null),
    TRANFER_DOCA5(65, 0, "上饶-大额还款", "com.dafy.trade.service.repay.task.CashRepayTaskWrapper", null),
    TRANFER_DOCA6(9, 1, "倒贷代扣自动平账", "com.dafy.trade.service.repay.task.CashRepayTaskWrapper", null),
    APPOINT_WITHHOLD(12, 1, "短信划扣", "com.dafy.trade.service.repay.task.CashRepayTaskWrapper", null);
    private int code;
    private String value;
    private int nByWayOf; //nByWayOf = 0 用户主动还款  nByWayOf =1 系统代扣还款
    private String taskWrapperClassFullName;

    private FundSource(int code, int nByWayOf, String value, String taskWrapperClassFullName, Object obj) {
        this.code = code;
        this.nByWayOf = nByWayOf;
        this.value = value;
        this.taskWrapperClassFullName = taskWrapperClassFullName;
    }

    public static FundSource valueOf(int code) {
        for (FundSource d : FundSource.values()) {
            if(code==d.code)
                return d;
        }
        throw new RuntimeException("不支持的还款方式");
    }

    public static int getByWayOf(int code) {
        for (FundSource d : FundSource.values()) {
            if(code==d.getCode())
                return d.nByWayOf;
        }
        return 0;
    }

    public static String getValue(int code) {
        for (FundSource d : FundSource.values()) {
            if(code==d.getCode())
                return d.value;
        }
        return "";
    }

    public static String getTaskWrapperClassFullName(int code) {
        for (FundSource d : FundSource.values()) {
            if(code==d.getCode())
                return d.taskWrapperClassFullName;
        }
        return "";
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public String getTaskWrapperClassFullName() { return taskWrapperClassFullName; }
}
