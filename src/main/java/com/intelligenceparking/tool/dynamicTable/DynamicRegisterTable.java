package com.intelligenceparking.tool.dynamicTable;

import java.util.HashMap;
import java.util.Iterator;

public class DynamicRegisterTable {
    /*
    <emailAddress,Verification code>
     */
    private static HashMap<String,String> verificationList = new HashMap<String,String>();

    public static void insert(String emailAddress,String code){
        verificationList.put(emailAddress,code);
        verificationListDisplay();
    }

    public static boolean verify(String emailAddress,String code){
        if(verificationList.get(emailAddress)==null)
            return false;
        if(verificationList.get(emailAddress).equals(code)){
            verificationList.remove(emailAddress);
            System.out.print("Email Address "+emailAddress+"success");
            return true;
        }
        return false;
    }

    public static void verificationListDisplay() {
        String key = null;
        String value = null;
        Iterator it = verificationList.keySet().iterator();
        while (it.hasNext()) {
            key = (String) it.next();
            value = verificationList.get(key);
            System.out.println("Email Address:" + key + "---" + "Code:" + value);
        }
    }
}
