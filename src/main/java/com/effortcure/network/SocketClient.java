package com.effortcure.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketClient {
    private String host;
    private int port;

    public String send(String message) throws IOException {

        try (Socket socket = new Socket(host, port)) {

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            byte[] request = message.getBytes(StandardCharsets.UTF_8);

            out.writeInt(request.length);
            out.write(request);
            out.flush();

            int length = in.readInt();
            byte[] response = new byte[length];

            in.readFully(response);

            return new String(response, StandardCharsets.UTF_8);
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
