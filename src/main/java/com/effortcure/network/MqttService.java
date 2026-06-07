package com.effortcure.network;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttService {

    private MqttClient client;

    private final String broker = "tcp://broker.hivemq.com:1883";
    private final String topic = "mostafa/environment";

    public interface OnMessageReceived {
        void onMessage(String json);
    }

    private OnMessageReceived listener;

    public MqttService(OnMessageReceived listener) {
        this.listener = listener;
    }

    public void connect() {
        try {
            String clientId = MqttClient.generateClientId();

            client = new MqttClient(broker, clientId, new MemoryPersistence());

            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);

            client.connect(options);

            System.out.println("Connected to MQTT broker");

            client.subscribe(topic, (t, msg) -> {
                String payload = new String(msg.getPayload());

                System.out.println("Received: " + payload);

                // send to JavaFX UI
                if (listener != null) {
                    listener.onMessage(payload);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (client != null)
                client.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}