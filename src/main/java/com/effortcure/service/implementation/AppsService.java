package com.effortcure.service.implementation;

import java.util.List;

import com.effortcure.dto.response.AppResponseDTO;
import com.effortcure.network.SocketClient;
import com.effortcure.service.interfaces.AppsServiceInterface;
import com.effortcure.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;

public class AppsService implements AppsServiceInterface {

        @Override
        public List<AppResponseDTO> getApps() throws Exception {
                String host = System.getenv("AGENT_HOST");
                String port = System.getenv("AGENT_PORT");
                SocketClient socketClient = new SocketClient();
                socketClient.setHost(host != null ? host : "127.0.0.1");
                socketClient.setPort((port != null && !port.isBlank()) ? Integer.parseInt(host) : 8080);
                String json = socketClient.send("get_apps");
                return JsonUtil.fromJson(json, new TypeReference<List<AppResponseDTO>>() {
                });
        }

}
