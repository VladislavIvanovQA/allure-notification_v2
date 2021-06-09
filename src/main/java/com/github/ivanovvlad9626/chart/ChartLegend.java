package com.github.ivanovvlad9626.chart;

import org.knowm.xchart.PieChart;

import static java.awt.Color.WHITE;
import static org.knowm.xchart.style.Styler.LegendLayout.Vertical;
import static org.knowm.xchart.style.Styler.LegendPosition.OutsideE;

public class ChartLegend {
    public static void addLegendTo(PieChart chart) {
        chart.getStyler()
                .setLegendVisible(true)
                .setLegendPosition(OutsideE)
                .setLegendPadding(4)
                .setLegendBorderColor(WHITE)
                .setLegendLayout(Vertical);
    }
}
