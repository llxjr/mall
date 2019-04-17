package cn.funwx.mall.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liu66
 * @description 业务编号生成器
 */
public final class BussinessNoUtils {
    /**
     * 订单编号
     **/
    private static final String ORDER_NO_PRE = "ONO";
    /**
     * 商品编号
     **/
    private static final String GOOD_NO_PRE = "GNO";
    /**
     * 课程编号
     **/
    private static final String COURSE_NO_PRE = "CNO";
    /**
     * 试卷编号
     **/
    private static final String PAPER_NO_PRE = "PNO";

    public static synchronized String nextOrderNo(int auth) {
        return ORDER_NO_PRE + suffixNo(auth);
    }

    public static synchronized String nextGoodNo(int auth) {
        return GOOD_NO_PRE + suffixNo(auth);
    }

    public static synchronized String nextCourseNo(int auth) {
        return COURSE_NO_PRE + suffixNo(auth);
    }

    public static synchronized String nextPaperNo(int auth) {
        return PAPER_NO_PRE + suffixNo(auth);
    }

    private static String suffixNo(int auth) {
        return getFmtDateStr(new Date()) + auth + RandomNumberUtil.getStringRandom(2);
    }

    private static String getFmtDateStr(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        return sdf.format(date);
    }

}
