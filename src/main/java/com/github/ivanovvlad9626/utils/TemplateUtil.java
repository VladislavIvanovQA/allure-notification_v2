package com.github.ivanovvlad9626.utils;

import com.github.ivanovvlad9626.config.Phrases;
import com.github.ivanovvlad9626.model.Summary;
import org.aeonbits.owner.ConfigFactory;

import static com.github.ivanovvlad9626.utils.BuildInfoHelper.*;
import static com.github.ivanovvlad9626.utils.JsonSlurper.readSummaryJson;
import static com.github.ivanovvlad9626.utils.NumberUtils.percentage;
import static com.github.ivanovvlad9626.utils.TimeUtil.time;


public class TemplateUtil {
    private static final Phrases phrases = ConfigFactory.newInstance().create(Phrases.class);

    /** Возвращает данные для шаблона. */
    public static Object[] templateData() {
        Summary summary = readSummaryJson(SettingsHelper.allureReportFolder());
        return new Object[] {
                phrases.resultsLabel(),
                phrases.launchLabel(),
                buildLaunchName(),
                phrases.durationLabel(),
                time(summary.time().duration()),
                phrases.environmentLabel(),
                buildEnvironment(),
                phrases.totalScenariosLabel(),
                summary.statistic().total(),
                phrases.totalPassedLabel(),
                summary.statistic().passed(),
                phrases.totalFailedLabel(),
                summary.statistic().failed(),
                phrases.totalBrokenLabel(),
                summary.statistic().broken(),
                phrases.totalUnknownLabel(),
                summary.statistic().unknown(),
                phrases.totalSkippedLabel(),
                summary.statistic().skipped(),
                phrases.ofPassedTestsLabel(),
                percentage(summary.statistic().passed(), summary.statistic().total()),
                phrases.ofFailedTestsLabel(),
                percentage(summary.statistic().failed(), summary.statistic().total()),
                phrases.reportLinkLabel(),
                buildReportLink()
        };
    }
}
