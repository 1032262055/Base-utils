package encode;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by Roc on 2019/6/11
 */
public class EncodeUtil {

    private static final String DEFAULT_CHARSET = "UTF-8";

    /**
     * MD5加密转base64
     *
     * @param sign
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String md5EncryptBase64(String sign) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] encodedBytes = Base64.getEncoder().encode(md5.digest(sign.getBytes(DEFAULT_CHARSET)));
        return new String(encodedBytes, Charset.forName(DEFAULT_CHARSET));
    }

    /**
     * base64
     *
     * @param md5
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] md5) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(md5).trim();
    }

    /**
     * 解密
     * @param body
     * @return
     * @throws Exception
     */
    public static String decryptBASE64(String body) throws Exception {
        return new String((new BASE64Decoder()).decodeBuffer(body.trim()), DEFAULT_CHARSET);
    }

    /**
     * MD5
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptMD5(byte[] data) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(data);
        return md5.digest();
    }
}
