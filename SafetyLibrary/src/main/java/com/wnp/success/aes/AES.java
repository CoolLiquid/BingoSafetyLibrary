package com.wnp.success.aes;

import com.wnp.success.ISecurity;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Objects;

public class AES extends ISecurity {
    public static final String KEY_ALGORITHM = "AES";
    private SecretKey mkey;

    public synchronized void initKey(byte[] key) {
        if (mkey != null) {
            return;
        }
        try {
            KeyGenerator generator = KeyGenerator.getInstance(KEY_ALGORITHM);
            generator.init(128, new SecureRandom(key));
            SecretKey realKey = generator.generateKey();
            mkey = realKey;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public synchronized SecretKey getKey() {
        Objects.requireNonNull(mkey, "need invoke initKey Methods");
        return mkey;
    }

    public byte[] decrypt(byte[] data){
        try {
            return super.decrypt(mkey, data);
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] encrypt(byte[] data) {
        try {
            return super.encrypt(mkey, data);
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected String FINALKEY() {
        return KEY_ALGORITHM;
    }
}
