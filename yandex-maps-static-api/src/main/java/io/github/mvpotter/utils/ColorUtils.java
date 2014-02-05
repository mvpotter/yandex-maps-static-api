/*
 * Created with IntelliJ IDEA.
 * User: mpotter
 * Date: 03.02.14
 * Time: 9:58
 */
package io.github.mvpotter.utils;

import java.awt.Color;

/**
 * Utils class for processing color.
 */
public final class ColorUtils {

    private static final int RED_BEGIN_INDEX = 0;
    private static final int RED_END_INDEX = 2;
    private static final int GREEN_BEGIN_INDEX = 2;
    private static final int GREEN_END_INDEX = 4;
    private static final int BLUE_BEGIN_INDEX = 4;
    private static final int BLUE_END_INDEX = 6;
    private static final int ALPHA_BEGIN_INDEX = 6;
    private static final int ALPHA_END_INDEX = 8;

    private static final int HEX_RADIX = 16;

    /**
     * Creates object.
     */
    private ColorUtils() {

    }

    /**
     * Converts hex color representation to java.awt.Color object.
     *
     * @param hexColor hex color representation (ex. "8822DDC0", where 88 - red, 22 - green, DD - blue, C0 - alpha).
     * @return java.awt.Color object
     */
    public static Color toColor(final String hexColor) {
        Color color = null;
        if (hexColor.length() == ALPHA_END_INDEX) {
            final String red = hexColor.substring(RED_BEGIN_INDEX, RED_END_INDEX);
            final String green = hexColor.substring(GREEN_BEGIN_INDEX, GREEN_END_INDEX);
            final String blue = hexColor.substring(BLUE_BEGIN_INDEX, BLUE_END_INDEX);
            final String alpha = hexColor.substring(ALPHA_BEGIN_INDEX, ALPHA_END_INDEX);

            color = new Color(Integer.parseInt(red, HEX_RADIX),
                              Integer.parseInt(green, HEX_RADIX),
                              Integer.parseInt(blue, HEX_RADIX),
                              Integer.parseInt(alpha, HEX_RADIX));

        }

        return color;
    }

    /**
     * Converts java.awt.Color object to hex string.
     *
     * @param color java.awt.Color object
     * @return hex color representation (ex. "8822DDC0", where 88 - red, 22 - green, DD - blue, C0 - alpha).
     */
    public static String toHexColor(final Color color) {
        final String red = pad(Integer.toHexString(color.getRed()));
        final String green = pad(Integer.toHexString(color.getGreen()));
        final String blue = pad(Integer.toHexString(color.getBlue()));
        final String alpha = pad(Integer.toHexString(color.getAlpha()));
        return red + green + blue + alpha;
    }

    /**
     * Adds zero to the beginning if hexadecimal representation contains only one symbol.
     *
     * @param hex hexadecimal number
     * @return hexadecimal number represented with two symbols
     */
    private static String pad(final String hex) {
        return (hex.length() == 1) ? "0" + hex : hex;
    }

}
