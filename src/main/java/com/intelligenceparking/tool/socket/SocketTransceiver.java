package com.intelligenceparking.tool.socket;


import com.intelligenceparking.controller.FileController;
import com.intelligenceparking.tool.PicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
public abstract  class SocketTransceiver implements Runnable{

    int count = 0;
    int totalCount = 0;

    protected Socket socket;
    protected InetAddress addr;
    protected DataInputStream in;
    protected DataOutputStream out;
    private boolean runFlag;
    @Autowired
    private FileController fileController;

    /**
     * 实例化
     *
     * @param socket
     *            已经建立连接的socket
     */
    public SocketTransceiver(Socket socket) {
        this.socket = socket;
        this.addr = socket.getInetAddress();
    }

    /**
     * 获取连接到的Socket地址
     *
     * @return InetAddress对象
     */
    public InetAddress getInetAddress() {
        return addr;
    }

    /**
     * 开启Socket收发
     * <p>
     * 如果开启失败，会断开连接并回调{@code onDisconnect()}
     */
    public void start() {
        runFlag = true;
        new Thread(this).start();
    }

    /**
     * 断开连接(主动)
     * <p>
     * 连接断开后，会回调{@code onDisconnect()}
     */
    public void stop() {
        runFlag = false;
        try {
            socket.shutdownInput();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送字符串
     *
     * @param s
     *            字符串
     * @return 发送成功返回true
     */
    public boolean send(String s) {
        if (out != null) {
            try {
                out.writeUTF(s);
                System.out.println(out.toString());
                out.flush();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 监听Socket接收的数据(新线程中运行)
     */
    @Override
    public void run() {
        try {
            in = new DataInputStream(this.socket.getInputStream());
            out = new DataOutputStream(this.socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            runFlag = false;
        }

        byte pic[] = new byte[640*240];
        int position = 0;
        byte b[];
        while (runFlag) {
            b = new byte[1460];
            try {
                in.read(b);
                System.out.println("length: "+in.available());
                System.out.println("count: " + count);
                count++;
                int result = 0;
                for(byte bb: b) {
//                    System.out.print((bb&0xff)+" ");
                    if((bb&0xff)!=0)
                        result++;
                }
                for (byte bb:b) {
                    if(position<640*240){
                        pic[position] = bb;
                        position++;
                    }
                }
                System.out.println("result: " + result);
                totalCount += result;
                System.out.println("totalCount: " + totalCount + "\n");
                if(position>=640*240){
                    for(byte bb:pic)
                        System.out.print((bb&0xff)+" ");
                    System.out.println("Start make picture: ");
                    String fileName = PicUtil.byte2image(pic);
                    fileController.uploadLicensePic(fileName,8);
                }
            } catch (IOException e) {
                runFlag = false;
            }
        }
        try {
            in.close();
            out.close();
            socket.close();
            in = null;
            out = null;
            socket = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.onDisconnect(addr);
    }

    /**
     * 接收到数据
     * <p>
     * 注意：此回调是在新线程中执行的
     *
     * @param addr
     *            连接到的Socket地址
     * @param s
     *            收到的字符串
     */
    public abstract void onReceive(InetAddress addr, String s);

    /**
     * 连接断开
     * <p>
     * 注意：此回调是在新线程中执行的
     *
     * @param addr
     *            连接到的Socket地址
     */
    public abstract void onDisconnect(InetAddress addr);


}
