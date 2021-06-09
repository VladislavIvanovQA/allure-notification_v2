package com.github.ivanovvlad9626.message;

import com.github.ivanovvlad9626.utils.TemplateUtil;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Создаёт отформатированный текст сообщения.
 *
 * @author kadehar
 * @since 2.0.10
 */
public class Text {
    /** Возвращает отформатированное по шаблону сообщение в Markdown формате. */
    public static String formattedMarkdownMessage() {
        ResourceBundle message = ResourceBundle.getBundle("template/text");
        return template(message);
    }

    /** Возвращает отформатированное по шаблону сообщение в HTML формате. */
    public static String formattedHtmlMessage() {
        ResourceBundle message = ResourceBundle.getBundle("template/html");
        return template(message);
    }

    private static String template(ResourceBundle message) {
        MessageFormat formatter = new MessageFormat("");
        formatter.applyPattern(message.getString("template"));
        return formatter.format(TemplateUtil.templateData());
    }
}
