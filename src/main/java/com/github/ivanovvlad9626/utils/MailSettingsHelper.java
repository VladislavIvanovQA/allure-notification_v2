package com.github.ivanovvlad9626.utils;

import com.github.ivanovvlad9626.config.MailSettings;
import com.github.ivanovvlad9626.exceptions.ArgumentNotProvidedException;
import org.aeonbits.owner.ConfigFactory;

import java.util.Optional;

public class MailSettingsHelper {
    public static String mailFrom() {
        return Optional
                .ofNullable(readSettings().mailFrom())
                .orElseThrow(() ->
                        new ArgumentNotProvidedException("mail.from"));
    }

    public static String mailHost() {
        return Optional
                .ofNullable(readSettings().mailHost())
                .orElseThrow(() ->
                        new ArgumentNotProvidedException("mail.host"));
    }

    public static String mailSslEnable() {
        return Optional
                .ofNullable(readSettings().mailSslEnable())
                .orElseThrow(() ->
                        new ArgumentNotProvidedException("mail.ssl.enable"));
    }

    public static String mailPort() {
        return Optional
                .ofNullable(readSettings().mailPort())
                .orElseThrow(() ->
                        new ArgumentNotProvidedException("mail.port"));
    }

    public static String mailUsername() {
        return Optional
                .ofNullable(readSettings().mailUsername())
                .orElseThrow(() ->
                        new ArgumentNotProvidedException("mail.username"));
    }

    public static String mailPassword() {
        return Optional
                .ofNullable(readSettings().mailPassword())
                .orElseThrow(() ->
                        new ArgumentNotProvidedException("mail.password"));
    }

    public static String mailTo() {
        return Optional
                .ofNullable(readSettings().mailTo())
                .orElseThrow(() ->
                        new ArgumentNotProvidedException("mail.to"));
    }

    private static MailSettings readSettings() {
        return ConfigFactory.newInstance().create(MailSettings.class, System.getProperties());
    }
}
