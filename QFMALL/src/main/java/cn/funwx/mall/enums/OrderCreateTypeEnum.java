package cn.funwx.mall.enums;

/**
 * @author liu66
 * @description 订单生成方式
 * 
 */
public enum OrderCreateTypeEnum {

    ONLINE_PAID(1, "线上支付"),
    COUPON(2, "优惠券");

    private OrderCreateTypeEnum(Integer code, String str) {
        this.code = code;
        this.remark = str;
    }

    private Integer code;
    private String remark;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
