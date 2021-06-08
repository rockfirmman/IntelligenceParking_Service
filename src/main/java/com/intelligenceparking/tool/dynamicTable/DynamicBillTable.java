package com.intelligenceparking.tool.dynamicTable;

import com.intelligenceparking.bean.BillModel;
import com.intelligenceparking.tool.BillUtil;

import java.util.HashMap;
import java.util.Iterator;

public class DynamicBillTable {
    /*
    <User Id,BillModel>
     */
    private static HashMap<Integer, BillModel> billList = new HashMap<Integer,BillModel>();

    public static void insert(int id, BillModel billModel){
        billList.put(id,billModel);
        billDisplay();
    }

    public static void billDisplay() {
        Integer key = null;
        BillModel value = null;
        Iterator it = billList.keySet().iterator();
        while (it.hasNext()) {
            key = (Integer) it.next();
            value = billList.get(key);
            System.out.println("Email Address:" + key + "---" + "Code:" + value);
        }
    }

    public static BillModel verifyBill(int id){
        BillModel res = billList.get(id);
        billList.remove(id);
        return res;
    }

    public static boolean check(int id){
        if(billList.get(id)==null)
            return false;
        return true;
    }
}
