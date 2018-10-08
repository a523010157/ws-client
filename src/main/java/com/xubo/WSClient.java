package com.xubo;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.Date;
import java.util.Map;

/**
 * Created with IDEA
 *
 * @description: 自定义websocket客户端
 * @author: xubo
 * @create: 2018-10-08 16:56
 */
public class WSClient extends WebSocketClient{

    public WSClient(URI serverUri) {
        super(serverUri);
    }

    public WSClient(URI serverUri, Draft protocolDraft) {
        super(serverUri, protocolDraft);
    }

    public WSClient(URI serverUri, Map<String, String> httpHeaders) {
        super(serverUri, httpHeaders);
    }

    public WSClient(URI serverUri, Draft protocolDraft, Map<String, String> httpHeaders) {
        super(serverUri, protocolDraft, httpHeaders);
    }

    public WSClient(URI serverUri, Draft protocolDraft, Map<String, String> httpHeaders, int connectTimeout) {
        super(serverUri, protocolDraft, httpHeaders, connectTimeout);
    }

    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println(new Date().toString() + " ===> handshake success !");
    }

    public void onMessage(String msg) {
        System.out.println(new Date().toString() + "===> receive : "+msg);
/*        String username;
        if (msg.contains("user-name")){
            username = msg.substring(msg.indexOf("user-name:")+10,msg.indexOf("user-name:")+46);
            this.send("[\"SEND\\ndestination:/app/configure\\ncontent-length:94\\n\\n{\\\"condition\\\":{},\\\"is_push\\\":true,\\\"tradeid\\\":\\\"\\\",\\\"username\\\":\\\""+username+"\\\"}\\u0000\"]");
        }*/
        if(msg.equals("over")){
            this.close();
        }
    }

    public void onClose(int i, String s, boolean b) {
        System.out.println(new Date().toString() + "===> connection closed !");
    }

    public void onError(Exception e) {
        e.printStackTrace();
        System.out.println(new Date().toString() + "===> something error !");
    }

}
