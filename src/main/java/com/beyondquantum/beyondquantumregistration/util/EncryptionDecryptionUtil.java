package com.beyondquantum.beyondquantumregistration.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EncryptionDecryptionUtil {
    private static final Logger LOGGER = Logger.getLogger(EncryptionDecryptionUtil.class.getName());
    private static final String ALGORITHM = "AES";
    private static final String MODE_PADDING = "AES/ECB/PKCS5Padding";
    private static final String SECRET_KEY = "BPe71hOVy+37QgGwv/YyBizng1Q7npd1GryjXwqo++I=";
    private static final Key SECRET = new SecretKeySpec(Base64.getDecoder().decode(SECRET_KEY), ALGORITHM);

    public static String encrypt(String value) {
        try {
            Cipher cipher = Cipher.getInstance(MODE_PADDING);
            cipher.init(Cipher.ENCRYPT_MODE, SECRET);
            byte[] encryptedBytes = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error in encryption", e);
            return null;
        }
    }

//    public static String decrypt(String encryptedValue) {
//        try {
//            Cipher cipher = Cipher.getInstance(MODE_PADDING);
//            cipher.init(Cipher.DECRYPT_MODE, SECRET);
//            byte[] decodedBytes = Base64.getDecoder().decode(encryptedValue);
//            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
//            return new String(decryptedBytes);
//        } catch (Exception e) {
//            LOGGER.log(Level.SEVERE, "Error in decryption", e);
//            return null;
//        }
//    }
}
