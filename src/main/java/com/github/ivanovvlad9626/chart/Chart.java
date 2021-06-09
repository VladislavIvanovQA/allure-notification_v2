package com.github.ivanovvlad9626.chart;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.PieChart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

import static com.github.ivanovvlad9626.utils.SettingsHelper.projectName;
import static org.knowm.xchart.BitmapEncoder.BitmapFormat.PNG;

public class Chart {
    private static final Logger LOG = LoggerFactory.getLogger(Chart.class);
    private final static String FILE_NAME = "piechart";

    public static void createChart() {
        final String title = projectName();
        LOG.info("Create chart with title {}", title);
        PieChart chart = new org.knowm.xchart.PieChartBuilder()
                .title(title)
                .width(500)
                .height(250)
                .build();

        LOG.info("Add legend to chart");
        ChartLegend.addLegendTo(chart);
        LOG.info("Add view to chart");
        ChartView.addViewTo(chart);
        LOG.info("Add series to chart");
        List<int[]> colors = ChartSeries.addSeriesTo(chart);
        LOG.info("Add colors to series");
        ChartColors.addColorsTo(chart, colors);

        try {
            LOG.info("Try to save chart as {}.png", FILE_NAME);
            BitmapEncoder.saveBitmap(chart, FILE_NAME, PNG);
            LOG.info("Chart is created successfully");
        } catch (IOException e) {
            LOG.error("Error {} \n Reason {}", e.getLocalizedMessage(), e.getStackTrace());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
