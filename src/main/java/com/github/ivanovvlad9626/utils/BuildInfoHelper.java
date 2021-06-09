package com.github.ivanovvlad9626.utils;

import com.github.ivanovvlad9626.config.BuildInfo;
import com.github.ivanovvlad9626.exceptions.ArgumentNotProvidedException;
import org.aeonbits.owner.ConfigFactory;

import java.util.Optional;

public class BuildInfoHelper {
    public static String buildLaunchName() {
        return Optional
                .ofNullable(readBuildInfo().buildLaunchName())
                .orElseThrow(() ->
                        new ArgumentNotProvidedException("build.launch.name"));
    }

    public static String buildEnvironment() {
        return Optional
                .ofNullable(readBuildInfo().buildEnvironment())
                .orElseThrow(() ->
                        new ArgumentNotProvidedException("build.env"));
    }

    public static String buildReportLink() {
        String report = Optional
                .ofNullable(readBuildInfo().buildReportLink())
                .orElseThrow(() ->
                        new ArgumentNotProvidedException("build.report.link"));
        return report;
    }

    private static BuildInfo readBuildInfo() {
        return ConfigFactory.newInstance().create(BuildInfo.class, System.getProperties());
    }
}
