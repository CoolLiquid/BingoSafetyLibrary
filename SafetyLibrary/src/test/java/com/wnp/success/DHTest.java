package com.wnp.success;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public final class DHTest {

 @Test public void dh(){
     List<Integer> list = new ArrayList<>();
     List<String> list1 = new ArrayList<>();
     assert  list.getClass() == list1.getClass();

     DH dhClient = new DH();
     DH dhServer = new DH();
     int pubKeyClient = dhClient.getPubKey();
     int pubKeyServer = dhServer.getPubKey();
     System.out.println("pubKeyClient = "+ pubKeyClient);
     System.out.println("pubKeyServer = "+ pubKeyServer);

     int commonClientKey = dhClient.getCommonKey(pubKeyServer);
     int commonServerKey = dhServer.getCommonKey(pubKeyClient);

     System.out.println(commonClientKey);
     System.out.println(commonServerKey);
     assert commonClientKey == commonServerKey;
 }

}
