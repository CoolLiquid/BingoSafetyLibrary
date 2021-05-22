package com.wnp.success.rsa;

import com.wnp.success.ISecurity;

import java.nio.charset.Charset;
import java.util.Base64;

public class RsaHelper extends ISecurity {
    private final Rsa rsa;

    public RsaHelper(IKeyEngine keyEngine){
        Rsa rsa = new Rsa(keyEngine);
        this.rsa = rsa;
    }

    public String encrypt(String data){
        byte[] rsaData = rsa.encrypt(data.getBytes(Charset.forName("utf-8")));
        return Base64.getEncoder().encodeToString(rsaData);
    }

    public String decrypt(String data) {
        byte[] baseData = Base64.getDecoder().decode(data);
        byte[] rsaData = rsa.decrypt(baseData);
        return new String(rsaData, Charset.forName("utf-8"));
    }

    @Override
    protected String FINALKEY() {
        return Rsa.RSA_ALGORITHM;
    }
}
