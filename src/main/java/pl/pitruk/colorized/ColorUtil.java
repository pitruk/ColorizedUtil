package pl.pitruk.colorized;

import net.md_5.bungee.api.ChatColor;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorUtil {

    private static final Pattern HEX_PATTERN = Pattern.compile("&#([A-Fa-f0-9]{6})");
    private static final Pattern COLOR_PATTERN = Pattern.compile("&([0-9A-Fa-fk-or])");
    private static final Pattern GRADIENT_PATTERN = Pattern.compile("<gradient:([A-Fa-f0-9]{6}):([A-Fa-f0-9]{6})>(.*?)</gradient>");

    public static String colorize(String text) {
        text = translateGradients(text);
        text = translateHexColors(text);
        text = translateColorCodes(text);
        return text;
    }

    private static String translateHexColors(String text) {
        Matcher matcher = HEX_PATTERN.matcher(text);
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            String hexCode = matcher.group(1);
            ChatColor hexColor = ChatColor.of("#" + hexCode);
            matcher.appendReplacement(buffer, hexColor.toString());
        }

        matcher.appendTail(buffer);
        return buffer.toString();
    }

    private static String translateColorCodes(String text) {
        Matcher matcher = COLOR_PATTERN.matcher(text);
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            char colorCode = matcher.group(1).charAt(0);
            ChatColor color = ChatColor.getByChar(colorCode);
            matcher.appendReplacement(buffer, color.toString());
        }

        matcher.appendTail(buffer);
        return buffer.toString();
    }

    private static String translateGradients(String text) {
        Matcher matcher = GRADIENT_PATTERN.matcher(text);
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            String startColor = matcher.group(1);
            String endColor = matcher.group(2);
            String gradientText = matcher.group(3);

            String translatedGradient = applyGradient(gradientText, startColor, endColor);
            matcher.appendReplacement(buffer, translatedGradient);
        }

        matcher.appendTail(buffer);
        return buffer.toString();
    }

    private static String applyGradient(String text, String startHex, String endHex) {
        Color startColor = Color.decode("#" + startHex);
        Color endColor = Color.decode("#" + endHex);

        int length = text.length();
        StringBuilder gradientText = new StringBuilder();

        for (int i = 0; i < length; i++) {
            double ratio = (double) i / (length - 1);
            int red = (int) (startColor.getRed() * (1 - ratio) + endColor.getRed() * ratio);
            int green = (int) (startColor.getGreen() * (1 - ratio) + endColor.getGreen() * ratio);
            int blue = (int) (startColor.getBlue() * (1 - ratio) + endColor.getBlue() * ratio);

            Color stepColor = new Color(red, green, blue);
            ChatColor chatColor = ChatColor.of(stepColor);

            gradientText.append(chatColor.toString()).append(text.charAt(i));
        }

        return gradientText.toString();
    }
}

