//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.funwx.mall.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 20180827 Created by chj
 */
public final class IpUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(IpUtils.class);
    private static final String REGEX = "((25[0-5]|2[0-4]\\d|1\\d{2}|0?[1-9]\\d|0?0?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|0?[1-9]\\d|0?0?\\d)";
    private static final Pattern PATTERN = Pattern.compile("((25[0-5]|2[0-4]\\d|1\\d{2}|0?[1-9]\\d|0?0?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|0?[1-9]\\d|0?0?\\d)");
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int ZERO = 0;
    private static final int ONE_BYTE_LENGTH = 8;
    private static final int TWO_BYTE_LENGTH = 16;
    private static final int THREE_BYTE_LENGTH = 24;
    private static final Long MAX_ADDRESS_NUM = 4294967295L;
    private static final int OX00FFFFFF = 16777215;
    private static final int OX0000FFFF = 65535;
    private static final int OX000000FF = 255;
    private static final Long A_LOCAL_START = 167772160L;
    private static final Long A_LOCAL_END = 184549375L;
    private static final Long B_LOCAL_START = 2886729728L;
    private static final Long B_LOCAL_END = 2887778303L;
    private static final Long C_LOCAL_START = 3232235520L;
    private static final Long C_LOCAL_END = 3232301055L;
    private static Pattern p = Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+");

    private IpUtils() {
    }

    public static String getClientIp(HttpServletRequest request) {
        String ipArray = request.getHeader("x-forwarded-for");
        if (ipArray == null || ipArray.length() == 0 || "unknown".equalsIgnoreCase(ipArray)) {
            ipArray = request.getHeader("Proxy-Client-IP");
        }

        if (ipArray == null || ipArray.length() == 0 || "unknown".equalsIgnoreCase(ipArray)) {
            ipArray = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ipArray == null || ipArray.length() == 0 || "unknown".equalsIgnoreCase(ipArray)) {
            ipArray = request.getRemoteAddr();
        }

        if (ipArray != null) {
            String browserIp = ipArray.split(",")[0];
            return checkIpStr(browserIp) ? browserIp : null;
        } else {
            return null;
        }
    }

    public static String getClientIpChain(HttpServletRequest request) {
        String ipArray = request.getHeader("x-forwarded-for");
        if (ipArray == null || ipArray.length() == 0 || "unknown".equalsIgnoreCase(ipArray)) {
            ipArray = request.getHeader("Proxy-Client-IP");
        }

        if (ipArray == null || ipArray.length() == 0 || "unknown".equalsIgnoreCase(ipArray)) {
            ipArray = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ipArray == null || ipArray.length() == 0 || "unknown".equalsIgnoreCase(ipArray)) {
            ipArray = request.getRemoteAddr();
        }

        return ipArray;
    }

    public static String getStrictClientIp(HttpServletRequest request) {
        String ipArray = request.getHeader("x-forwarded-for");
        if (ipArray == null || ipArray.length() == 0 || "unknown".equalsIgnoreCase(ipArray)) {
            ipArray = request.getHeader("Proxy-Client-IP");
        }

        if (ipArray == null || ipArray.length() == 0 || "unknown".equalsIgnoreCase(ipArray)) {
            ipArray = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ipArray != null) {
            String browserIp = ipArray.split(",")[0];
            return checkIpStr(browserIp) ? browserIp : null;
        } else {
            return null;
        }
    }

    public static long ipToLongNum(String ip) {
        if (!checkIpStr(ip)) {
            throw new IllegalArgumentException("���ʽIP��ַ��ʽ����");
        } else {
            String[] ipStrArray = ip.split("\\.");
            Long[] ipLongArray = new Long[4];

            for (int i = 0; i < ipStrArray.length; ++i) {
                ipLongArray[i] = Long.parseLong(ipStrArray[i]);
            }
            return (ipLongArray[0] << 24) + (ipLongArray[1] << 16) + (ipLongArray[2] << 8) + ipLongArray[3];
        }
    }

    public static String longNumToIp(Long addrNum) {
        if (addrNum >= 0L && addrNum <= MAX_ADDRESS_NUM) {
            Long[] ipLongArray = new Long[]{addrNum >> 24, (addrNum & 16777215L) >> 16, (addrNum & 65535L) >> 8, addrNum & 255L};
            return StringUtils.join(ipLongArray, '.');
        } else {
            throw new IllegalArgumentException("ʮ����IP��ֵ����IP��Χ��");
        }
    }

    public static String getLocalIp() {
        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            String ip = null;

            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
                Enumeration ips = ni.getInetAddresses();

                while (ips.hasMoreElements()) {
                    InetAddress ipObj = (InetAddress) ips.nextElement();
                    if (ipObj.isSiteLocalAddress()) {
                        ip = ipObj.getHostAddress();
                        return ip;
                    }
                }
            }
            return ip;
        } catch (Exception var5) {
            LOGGER.error("", var5);
            return null;
        }
    }

    public static boolean checkIpStr(String ipAddress) {
        Matcher m = PATTERN.matcher(ipAddress);
        return m.matches();
    }

    public static boolean isLocalIp(String ipAddress) {
        if (!checkIpStr(ipAddress)) {
            return false;
        } else {
            Long ip = ipToLongNum(ipAddress);
            boolean isLocalA = ip >= A_LOCAL_START && ip <= A_LOCAL_END;
            boolean isLocalB = ip >= B_LOCAL_START && ip <= B_LOCAL_END;
            boolean isLocalC = ip >= C_LOCAL_START && ip <= C_LOCAL_END;
            return isLocalA || isLocalB || isLocalC;
        }
    }

    public static String extractIp(String url) {
        if (StringUtils.isBlank(url)) {
            return null;
        } else {
            String remoteServiceIp = null;
            Matcher m = p.matcher(url.toString());
            if (m.find()) {
                remoteServiceIp = m.group();
            }
            return remoteServiceIp;
        }
    }
}
