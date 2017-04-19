package com.soom.utils;

import javax.crypto.Mac;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-04-19 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class CipherUtil {
    private static final int HASH_BYTES = 24;
    private static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";
    private static final String HASH_ALGORITHM = "HmacSHA256";
    private static final String TOKEN_TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static final String TOKEN_ALGORITHM = "AES";
    private static final byte[] salt = {0x79, 0x05, 0x16, 0x06, 0x48, 0x07, 0x27, 0x11};
    private static final int HASH_ITERATION = 1453;

    /**
     * keyed hash 함수
     * <li>PBKDF2를 사용하여 key를 생성한 후에 HMAC으로 hash한다.
     * <li>알고리즘은 위에 static멤버상수 참조
     *
     * @param plainText
     * @return String
     */
    public static String hash(String plainText) {
        try {
            if (plainText != null && !"".equals(plainText)) {
                char[] password = plainText.toCharArray();
                PBEKeySpec spec = new PBEKeySpec(password, salt, HASH_ITERATION,
                        HASH_BYTES * 8); // bit 단위
                SecretKeyFactory skf = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);

                Mac mac = Mac.getInstance(HASH_ALGORITHM);
                mac.init(skf.generateSecret(spec));
                return Base64.getEncoder().encodeToString(mac.doFinal(plainText.getBytes()));
            } else {
                return "";
            }
        } catch (Exception e) {
            throw new RuntimeException("9999", e);
        }
    }
}
