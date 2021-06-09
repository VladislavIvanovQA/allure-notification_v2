package com.github.ivanovvlad9626.client.clients;

import com.github.ivanovvlad9626.chart.Chart;
import com.github.ivanovvlad9626.client.Notifier;
import com.github.ivanovvlad9626.client.clients.mail.Letter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.MessagingException;

import static com.github.ivanovvlad9626.message.Text.formattedHtmlMessage;
import static com.github.ivanovvlad9626.utils.MailSettingsHelper.mailFrom;
import static com.github.ivanovvlad9626.utils.MailSettingsHelper.mailTo;
import static com.github.ivanovvlad9626.utils.MailUtils.createSession;
import static com.github.ivanovvlad9626.utils.SettingsHelper.projectName;


public class EmailClient implements Notifier {
    private final Logger LOG = LoggerFactory.getLogger(EmailClient.class);

    @Override
    public void sendText() {
        try {
            Letter letter = new Letter(createSession());

            letter.from(mailFrom())
                    .to(mailTo())
                    .subject(projectName())
                    .text(formattedHtmlMessage())
                    .send();
        } catch (MessagingException e) {
            LOG.error("Can't send mail. Error: {}", e.getLocalizedMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void sendPhoto() {
        Chart.createChart();
        try {
            Letter letter = new Letter(createSession());
            String message = "<img src='cid:image'>" + formattedHtmlMessage();

            letter.from(mailFrom())
                    .to(mailTo())
                    .subject(projectName())
                    .text(message)
                    .image("./piechart.png")
                    .send();
        } catch (MessagingException e) {
            LOG.error("Can't send mail. Error: {}", e.getLocalizedMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
