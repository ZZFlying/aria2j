package xyz.sagrada.aria2j.client.impl;

import java.net.http.WebSocket;
import java.util.concurrent.CompletionStage;

public class Aria2ListenerDemo implements WebSocket.Listener {

    private StringBuffer buffer = new StringBuffer();

    @Override
    public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
        buffer.append(data);
        if (last) {
            System.out.println("ws received info:" + buffer);
            buffer = new StringBuffer();
        }
        return null;
    }


}
