package com.xubo;

import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft_6455;

import java.net.URI;

/**
 * Created with IDEA
 *
 * @description: 原生ws协议测试
 * @author: xubo
 * @create: 2018-09-30 16:11
 */
public class ConnectionBenchmarkNetty {

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {

            new Thread(new Runnable() {
                public void run() {
                    try {
                        WSClient wsClient = new WSClient(new URI("ws://127.0.0.1"), new Draft_6455());
                        wsClient.connect();
                        while (!wsClient.getReadyState().equals(WebSocket.READYSTATE.OPEN)){
                            System.out.println("connecting...");
                            Thread.sleep(1000);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

}
