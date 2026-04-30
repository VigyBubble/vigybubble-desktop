package com.effortcure.service.implementation;

import java.util.List;

import com.effortcure.dto.response.AppResponseDTO;
import com.effortcure.service.interfaces.AppsServiceInterface;
import com.effortcure.util.JsonUtil;
import com.effortcure.util.SocketClientUtil;
import com.fasterxml.jackson.core.type.TypeReference;

public class AppsService implements AppsServiceInterface {

    @Override
    public List<AppResponseDTO> getApps() throws Exception {
        SocketClientUtil.host = "127.0.0.1";
        SocketClientUtil.port = 8080;
        String json = SocketClientUtil.send("get_apps");
        System.out.println();
        return JsonUtil.fromJson(json, new TypeReference<List<AppResponseDTO>>() {
        });
    }

}
