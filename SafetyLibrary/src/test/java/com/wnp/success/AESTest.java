package com.wnp.success;

import com.wnp.success.aes.AesHelper;
import org.junit.Test;

public class AESTest {

    @Test public void test(){
        AesHelper.init("abc");
        AesHelper helper = AesHelper.getInstance();
        String data = "我这辈子最大的错误就是让你们吃太饱了abc";
        String encryptData = helper.encrypt(data);
        String decryptData = helper.decrypt(encryptData);
        System.out.println(encryptData);
        System.out.println(decryptData);
        assert decryptData.equals(data);
    }
}
