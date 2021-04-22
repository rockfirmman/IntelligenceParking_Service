package com.intelligenceparking.tool.pythonRecognize;

import com.intelligenceparking.controller.BillController;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        BillController t = new BillController();
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.format(day);
        t.createBillByHardware(1,"xxxx");
    }
}
