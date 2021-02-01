package com.intelligenceparking.tool.dynamicTable;


import java.util.HashMap;
import java.util.Iterator;

public class DynamicUserTable {
    //<User.id,ip>
    private static HashMap<Integer,String> onlineUserTable = new HashMap<Integer,String>();
    //<ip,User.id>
    private static HashMap<String,Integer> onlineUserTableReverse = new HashMap<String,Integer>();

    public static void OnlineUserTableDisplay() {
        int key = 0;
        String value = null;
        Iterator it = onlineUserTable.keySet().iterator();
        while (it.hasNext()) {
            key = (int)it.next();
            value = onlineUserTable.get(key);
            System.out.println("key:" + key + "---" + "value:" + value);
        }
    }

    public static void insert(int userId,String ip){
        onlineUserTable.put(userId,ip);
        onlineUserTableReverse.put(ip,userId);
    }

    public static void delete(String ip){
        int userId = onlineUserTableReverse.get(ip);
        onlineUserTable.remove(userId);
        onlineUserTableReverse.remove(ip);
    }

    public static boolean checkOnline(int userId,String ip){
        OnlineUserTableDisplay();
        if (onlineUserTable.get(userId) == null && onlineUserTableReverse.get(ip)==null)
            return false;
        return true;
    }
}
