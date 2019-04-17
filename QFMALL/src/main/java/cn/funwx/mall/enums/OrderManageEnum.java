package cn.funwx.mall.enums;

/**
 * @author liu66
 * @description 订单管理状态
 * 
 */
public enum OrderManageEnum {

    /**
     * 已生成 未支付
     **/
    NOT_PAID(0, "未支付"),
    /**
     * 已支付
     **/
    PAID(1, "已支付"),
    /**
     * 过期或者某种原因导致无效
     **/
    INVALID(2, "无效");

    private OrderManageEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
