package com.xubo;

import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft_6455;

import java.net.URI;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IDEA
 *
 * @description: STOMP协议测试
 * @author: xubo
 * @create: 2018-09-30 16:11
 */
public class ConnectionBenchmark {

    private static final AtomicInteger add = new AtomicInteger(1);

    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {

            new Thread(new Runnable() {
                public void run() {
                    final int current = add.getAndAdd(1);
                    System.out.println("======>"+current);
                    try {
                        String username = UUID.randomUUID().toString();
                        WSClient wsClient = new WSClient(new URI("ws://127.0.0.1/test-broker/message/"+current+"/"+RandomStringUtil.getRandomString(8)+"/websocket"), new Draft_6455());
                        wsClient.connect();
                        while (!wsClient.getReadyState().equals(WebSocket.READYSTATE.OPEN)){
                            System.out.println("connecting...");
                            Thread.sleep(1000);
                        }
                        wsClient.send("[\"CONNECT\\nlogin:"+username+"\\naccept-version:1.1,1.0\\nheart-beat:10000,10000\\n\\n\\u0000\"]");
                        wsClient.send("[\"SUBSCRIBE\\nid:sub-0\\ndestination:/user/topic/test-topic\\n\\n\\u0000\"]");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }
        

    }


}
