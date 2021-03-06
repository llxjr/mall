package cn.funwx.mall.utils;

import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.codehaus.xfire.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class AesCbcUtil {
	
	private static Logger log = LoggerFactory.getLogger(AesCbcUtil.class);
    /**
     * AES解密
     *
     * @param data           //密文，被加密的数据
     * @param key            //秘钥
     * @param iv             //偏移量
     * @param encodingFormat //解密后的结果需要进行的编码
     * @return
     * @throws Exception
     */
    public static JSONObject decrypt(String data, String key, String iv) throws Exception {
    	// 被加密的数据  
        byte[] dataByte = Base64.decode(data);  
        // 加密秘钥  
        byte[] keyByte = Base64.decode(key);  
        // 偏移量  
        byte[] ivByte = Base64.decode(iv);  
        try {  
               // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要  
            int base = 16;  
            if (keyByte.length % base != 0) {  
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);  
                byte[] temp = new byte[groups * base];  
                Arrays.fill(temp, (byte) 0);  
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);  
                keyByte = temp;  
            }  
            // 初始化  
            Security.addProvider(new BouncyCastleProvider());  
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");  
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");  
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");  
            parameters.init(new IvParameterSpec(ivByte));  
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化  
            byte[] resultByte = cipher.doFinal(dataByte);  
            if (null != resultByte && resultByte.length > 0) {  
                String result = new String(resultByte, "UTF-8");  
                return JSON.parseObject(result);  
            }  
        } catch (NoSuchAlgorithmException e) {  
            log.error(e.getMessage(), e);  
        } catch (NoSuchPaddingException e) {  
            log.error(e.getMessage(), e);  
        } catch (InvalidParameterSpecException e) {  
            log.error(e.getMessage(), e);  
        } catch (IllegalBlockSizeException e) {  
            log.error(e.getMessage(), e);  
        } catch (BadPaddingException e) {  
            log.error(e.getMessage(), e);  
        } catch (UnsupportedEncodingException e) {  
            log.error(e.getMessage(), e);  
        } catch (InvalidKeyException e) {  
            log.error(e.getMessage(), e);  
        } catch (InvalidAlgorithmParameterException e) {  
            log.error(e.getMessage(), e);  
        } catch (NoSuchProviderException e) {  
            log.error(e.getMessage(), e);  
        }  
        return null;  
    }
}
