package com.wnp.success;

import com.wnp.success.aes.AesHelper;
import com.wnp.success.rsa.IKeyEngine;
import com.wnp.success.rsa.RsaHelper;

public class Test {

    @org.junit.Test
    public void test() {
        //客户端
        DH dhClient = new DH();
        RsaHelper rsaClientHelper = new RsaHelper(new IKeyEngine() {
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
            public String priKey() {return null;}
        });
        String pubKeyClient = rsaClientHelper.encrypt(String.valueOf(dhClient.getPubKey()));
        //服务器
        DH dhServer = new DH();
        RsaHelper rsaServerHelper = new RsaHelper(new IKeyEngine() {
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
        int pubKeyServer = dhServer.getPubKey();

        //客户端 与 服务器 双方交换密钥
        int commonClientKey = dhClient.getCommonKey(pubKeyServer);
        int commonServerKey = dhServer.getCommonKey(Integer.parseInt(rsaServerHelper.decrypt(pubKeyClient)));
        //重点。语言两个端交换的密钥是否一致
        assert commonClientKey == commonServerKey;

        //客户端
        AesHelper.init(String.valueOf(commonClientKey));
        AesHelper helper = AesHelper.getInstance();
        long time = System.currentTimeMillis();
        String encryContent = helper.encrypt("我这辈子做的唯一一件错误事就是让你们吃太饱了");
        helper.encrypt("我这辈子做的唯一一件错误事就是让你们吃太饱了");
        helper.decrypt(encryContent);
        helper.encrypt("我这辈子做的唯一一件错误事就是让你们吃太饱了");
        helper.decrypt(encryContent);
        helper.encrypt("我这辈子做的唯一一件错误事就是让你们吃太饱了");
        helper.decrypt(encryContent);
        helper.encrypt("我这辈子做的唯一一件错误事就是让你们吃太饱了");
        helper.decrypt(encryContent);
        helper.encrypt("我这辈子做的唯一一件错误事就是让你们吃太饱了");
        helper.decrypt(encryContent);
        //服务器
        String content = helper.decrypt(encryContent);
        System.out.println(System.currentTimeMillis() - time);
        System.out.println(content);

    }
}
