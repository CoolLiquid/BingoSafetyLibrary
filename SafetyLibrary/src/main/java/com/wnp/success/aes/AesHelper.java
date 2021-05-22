package com.wnp.success.aes;

import com.wnp.success.ISecurity;

import java.nio.charset.Charset;
import java.util.Base64;

public class AesHelper extends ISecurity {
    private AES aes;

    private static class Holder {
        static AesHelper INSTANT = new AesHelper();
    }

    public static AesHelper getInstance() {
        return Holder.INSTANT;
    }

    public synchronized static void init(byte[] key) {
        if (getInstance().aes == null) {
            AES aes = new AES();
            aes.initKey(key);
            getInstance().aes = aes;
        }
    }

    public synchronized static void init(String key) {
        init(key.getBytes(Charset.forName("utf-8")));
    }

    public String encrypt(String data) {
        byte[] aesData = aes.encrypt(data.getBytes(Charset.forName("utf-8")));
        return Base64.getEncoder().encodeToString(aesData).replace("\r\n","");
    }

    public String decrypt(String data){
        byte[] aesData = aes.decrypt(Base64.getDecoder().decode(data));
        return new String(aesData, Charset.forName("utf-8"));
    }

    @Override
    protected String FINALKEY() {
        return AES.KEY_ALGORITHM;
    }
}
