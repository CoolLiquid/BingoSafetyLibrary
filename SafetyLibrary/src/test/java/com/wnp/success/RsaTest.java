package com.wnp.success;

import com.wnp.success.rsa.IKeyEngine;
import com.wnp.success.rsa.RsaHelper;
import org.junit.Test;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class RsaTest {

    @Test public void test() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(1024,new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
        RsaHelper helper = new RsaHelper(new IKeyEngine() {
            @Override
            public String pubKey() {
                return "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqJjyX6gAVuJLZuOaL1yA" +
                        "TYkWtLmtMvMtkDaice8siR89fa58ecqQ1WvW3cmTV6fHkSHG+3HVo+YpFI3uRBYU" +
                        "pEjUB4t8lEAjax2Hs2IXvMP80Iaxcii5ClV+DddCCoSMsMdWTQJyoh8UgsXc+IhY" +
                        "pTGGhCs9Yp2j1cY9N7xphJF7GvXyZnfdOHulhUM4QYu6xU8npc+BI28EX5p8Payh" +
                        "RtGwpElGf+oUcCcvQNiWRUnDQ30e1Hbb9o2oYUvKXr+WZ6KZCtlwFEIcod5VAmbJ" +
                        "ztwGJKTfqu3ZQWsaJqwOUr+UrBnHptWGADebcVFSmW3Sws2X76NS1nRu3GAYj5ZV" +
                        "mQIDAQAB";
            }

            @Override
            public String priKey() {
                return "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQComPJfqABW4ktm" +
                        "45ovXIBNiRa0ua0y8y2QNqJx7yyJHz19rnx5ypDVa9bdyZNXp8eRIcb7cdWj5ikU" +
                        "je5EFhSkSNQHi3yUQCNrHYezYhe8w/zQhrFyKLkKVX4N10IKhIywx1ZNAnKiHxSC" +
                        "xdz4iFilMYaEKz1inaPVxj03vGmEkXsa9fJmd904e6WFQzhBi7rFTyelz4EjbwRf" +
                        "mnw9rKFG0bCkSUZ/6hRwJy9A2JZFScNDfR7Udtv2jahhS8pev5ZnopkK2XAUQhyh" +
                        "3lUCZsnO3AYkpN+q7dlBaxomrA5Sv5SsGcem1YYAN5txUVKZbdLCzZfvo1LWdG7c" +
                        "YBiPllWZAgMBAAECggEAalTUABpf5GwibAi99ILddIkyZdb48jpGkT6z4zGaH/0w" +
                        "9fQ3E0T7ZW72+7gnElCB3/mymmDoAc+mNw1wqUZXzGkWOI/ziTiOXf8o16zVFbtx" +
                        "1j4s6bffRDI5JxeM0j9Y0CFYP4d8rtz1Paj2vVSYu87pbLAsreaILsoxT9anofBs" +
                        "6jjfthDSgHPX9KQdVNHBDmTHsvlI8/K+fhNELzM8hMqaiVv9R0EtAJEu8jxbwMCk" +
                        "70mmUuFJUX3x+beaA4rYVacrxa/TvEelHChdcEPW4X0ra2WtJmycqVJdsSFOWpuv" +
                        "03BrHL5/t65UZC83Jim5NiwBMd3B2xhYQThleuy5UQKBgQDQi6vDaeQ35pMHFFB+" +
                        "QttfaHiYQdA/5wdqUQDcdqIKlelX8FT5EuJownrpD0x7hubzSX0WJ1mxKotp28Uu" +
                        "F4Dkg8jMQQ2shJNxKtDEij3b1PuB8nDjR6z5Yvy28t9hEruc1SqcIJi+AGKRkI+k" +
                        "8o/76kJiPJXRgw37JOe6KFqNZQKBgQDO9jEIINyaVK/9Ahz/fmAmivAmyEJYJpx+" +
                        "DPqW6V0Z+5bZXnX3uTux/C6NqKxOGBkJRIyB0dm/pibgX/IYiIt9dUklVTQ1y5pe" +
                        "9oOpASeEPKf0/yFL4cWChos7I5pv/vOVV44hqcQtOF+NQN10XWlJKWmKAeqIGjz9" +
                        "alsZhBzuJQKBgEnu2kwDBHeU9Nbzqr24chFW9jn0SyH8g7J7WTTPkg7yqrEUcOuE" +
                        "eGPvXqe1VsYMQ2BI02HBPZkDnj0/Pp5ikr1wwwU2ouRgc+0Q4sZqxBdlYGznSIIq" +
                        "7PXU1Ab//5VokL6/C8YiAESL2mYEvAgcPlNu723oUKzgK1q38Lcci03JAoGBAI8d" +
                        "UYSkbMhP/a7Aslq/AjBE7ZJz8uTQNnE3+mU3FIluH79Kgdr+/Vez4mFVHWmXYmC1" +
                        "RVBUU/YiKEoKLvhmG8dyvlURmVwF4kb+wsawpKnd4+sYLecyRYlgDpGjqhz+OWSx" +
                        "OfjvU1hN3k1oaHsaST8tYuzrLEpXkotO65Y2dGb9AoGBAIXH2f325Hf3oFw9ZqNT" +
                        "9NFiUYanO5L6vfLkm0woV2+c9aw9MKsnW2vb+PyAsBrt8/CAb/Sb176Ib+AWeKn0" +
                        "I+f3NgdWNjJjfuWM0klPQX26WeFhRaqJdmJj8YFC/k8lov0/TGlZ1oth9UjqS2zi" +
                        "TY3QKi+Na1VuK3IFXNf43vVD";
            }
        });

        String content = "我这辈子最大的错误就是让你们吃太饱了";
        String enContent = helper.encrypt(content);
        String deContent = helper.decrypt(enContent);

        assert deContent.equals(content);
    }
}
