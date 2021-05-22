package com.wnp.success;

import java.math.BigInteger;
import java.util.Random;

public class DH {
    private int priKey;
    private static int dhP = 99991;
    private static int dhG = 5;

    public DH() {
        Random random = new Random();
        priKey = random.nextInt(10);
        System.out.println("DH 生成的私钥为 " + priKey);
    }

    public int getPubKey() {
        return startPow(dhG, priKey).divideAndRemainder(new BigInteger(String.valueOf(dhP)))[1].intValue();
    }


    public int getCommonKey(int pubKeyS) {
        return startPow(pubKeyS, priKey).divideAndRemainder(new BigInteger(String.valueOf(dhP)))[1].intValue();
    }

    private BigInteger startPow(int a, int b) {
        if (b == 0) {
            return new BigInteger(String.valueOf(1));
        } else {
            return pow(new BigInteger(String.valueOf(a)),b);
        }
    }

    private BigInteger pow(BigInteger a, int b) {
        if (b != 1)
            return a.multiply(pow(a, b - 1));
        else
            return a;
    }


}
