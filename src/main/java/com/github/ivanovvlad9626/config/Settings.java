package com.github.ivanovvlad9626.config;

import com.github.ivanovvlad9626.config.enums.Messenger;
import org.aeonbits.owner.Config;

@Config.Sources({"system:properties"})
public interface Settings extends Config {
    @Key("enable.chart")
    @DefaultValue("false")
    Boolean enableChart();
    @Key("bot.token")
    String botToken();
    @Key("chat.id")
    String chatId();
    @Key("reply.to.message.id")
    String replyToMessageId();
    @Key("project.name")
    String projectName();
    @Key("allure.report.folder")
    String allureReportFolder();
    @Key("messenger")
    @DefaultValue("telegram")
    Messenger messenger();
    @Key("mattermost.api.url")
    String mattermostApiUrl();
}
