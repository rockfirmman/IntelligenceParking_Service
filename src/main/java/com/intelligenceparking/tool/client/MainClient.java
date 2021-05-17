package com.intelligenceparking.tool.client;

import com.intelligenceparking.tool.socket.SocketTransceiver;

public class MainClient {

    public static void main(String[] args) {
        TcpClient c1 = new TcpClient() {

            @Override
            public void onReceive(SocketTransceiver st, String s) {
                System.out.println("Client1 Receive: " + s);
            }

            @Override
            public void onDisconnect(SocketTransceiver st) {
                System.out.println("Client1 Disconnect");
            }

            @Override
            public void onConnect(SocketTransceiver transceiver) {
                System.out.println("Client1 Connect");
            }

            @Override
            public void onConnectFailed() {
                System.out.println("Client1 Connect Failed");
            }
        };
        TcpClient c2 = new TcpClient() {

            @Override
            public void onReceive(SocketTransceiver st, String s) {
                System.out.println("Client2 Receive: " + s);
            }

            @Override
            public void onDisconnect(SocketTransceiver st) {
                System.out.println("Client2 Disconnect");
            }

            @Override
            public void onConnect(SocketTransceiver transceiver) {
                System.out.println("Client2 Connect");
            }

            @Override
            public void onConnectFailed() {
                System.out.println("Client2 Connect Failed");
            }
        };
        c1.connect("116.63.40.220", 8088);
        c2.connect("116.63.40.220", 8088);
//        c1.connect("127.0.0.1", 8088);
//        c2.connect("127.0.0.1", 8088);
        delay();
        while (true) {
            if (c1.isConnected()) {
                c1.getTransceiver().send("123");
            } else {
                break;
            }
            delay();
            if (c2.isConnected()) {
                c2.getTransceiver().send("hello");
            } else {
                break;
            }
            delay();
        }
    }

    static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}