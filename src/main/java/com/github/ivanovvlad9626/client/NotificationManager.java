package com.github.ivanovvlad9626.client;

import com.github.ivanovvlad9626.client.clients.ClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.ivanovvlad9626.utils.SettingsHelper.enableChart;
import static com.github.ivanovvlad9626.utils.SettingsHelper.messenger;


public class NotificationManager {
    private static final Logger LOG = LoggerFactory.getLogger(NotificationManager.class);

    public static void sendMessage() {
        Notifier notifier = ClientFactory.create(messenger());
        if (enableChart()) {
            LOG.info("Sending text message with photo attachment.");
            notifier.sendPhoto();
        } else {
            LOG.info("Sending text message.");
            notifier.sendText();
        }
        LOG.info("Finish.");
    }
}
