/**
 * Created with IntelliJ IDEA.
 * User: mpotter
 * Date: 04.02.14
 * Time: 15:54
 */
package io.github.mvpotter.model.polyline;

import io.github.mvpotter.utils.ColorUtils;

import java.awt.*;

/**
 * Polygon for representation on the map.<br />
 * <b>Description</b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/polylines.xml
 */
public class Polygon extends Polyline {

    private static final Color DEFAULT_FILLING_COLLOR = ColorUtils.toColor("00FF00A0");

    private Color fillingColor = DEFAULT_FILLING_COLLOR;

    /**
     * Returns polygon filling color.
     *
     * @return color
     */
    public Color getFillingColor() {
        return fillingColor;
    }

    /**
     * Returns polygon filling color in HEX representation.
     *
     * @return color in HEX representation
     */
    public String getHexFillingColor() {
        return ColorUtils.toHexColor(fillingColor);
    }

    /**
     * Sets polygon filling color.
     *
     * @param fillingColor filling color
     */
    public void setFillingColor(final Color fillingColor) {
        if (fillingColor == null) {
            this.fillingColor = DEFAULT_FILLING_COLLOR;
        } else {
            this.fillingColor = fillingColor;
        }
    }

}
