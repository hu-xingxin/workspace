package com.springmvc.app05.websocket;



import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
/**
 * @author huxingxin
 * @createTime 2021年08月20日 16:41:55
 * @Description
 */
/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@ServerEndpoint("/ws/bitCoinServer")
public class BitCoinServer {
    private Session session;

    /**
     * 表示有浏览器链接过来的时候被调用
     * @param session
     */
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        ServerManager.add(this);
        ServerManager.broadCast(ServerManager.getTotal()+"");
    }

    /**
     * 表示浏览器发出关闭请求的时候被调用
     */
    @OnClose
    public void onClose(){
        ServerManager.remove(this);
        ServerManager.broadCast(ServerManager.getTotal()+"");
    }

    /**
     * 表示浏览器发消息的时候被调用
     */
    @OnMessage
    public void onMessage(String message,Session session){
        System.out.println("来自客户端的消息:" + message);
    }

    /**
     * 表示有错误发生，比如网络断开了等等
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 用于向浏览器回发消息
     * @param msg
     * @throws IOException
     */
    public void sendMessage(String msg) throws IOException {
        session.getBasicRemote().sendText(msg);
    }
}
