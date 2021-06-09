package com.github.ivanovvlad9626.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.Properties;

import static com.github.ivanovvlad9626.utils.MailSettingsHelper.*;


public class MailUtils {
    private static final Logger LOG = LoggerFactory.getLogger(MailUtils.class);

    public static Session createSession() {
        Properties props = new Properties();
        props.put("mail.smtp.from", mailFrom());
        props.put("mail.smtp.host", mailHost());
        props.put("mail.smtp.ssl.enable", mailSslEnable());
        props.put("mail.smtp.port", mailPort());
        props.put("mail.smtp.auth", "true");
        props.putAll(System.getProperties());

        props.forEach((key, value) -> {
            if (key.toString().contains("mail")) {
                LOG.info(key + " " + value);
            }
        });

        return Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailUsername(), mailPassword());
            }
        });
    }

    public static InternetAddress[] parseRecipientsFromString(String addresses) throws AddressException {
        ArrayList<InternetAddress> addressList = new ArrayList<>();

        if (addresses == null) {
            throw new IllegalArgumentException("Email not specified");
        }

        String[] addressesArray = addresses.split(", ");

        for (String address : addressesArray) {
            addressList.add(new InternetAddress(address));
        }

        return addressList.toArray(new InternetAddress[0]);
    }
}
