/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 02/02/14
 * Time: 22:06
 */
package io.github.mvpotter.model.polyline;

import java.awt.*;

/**
 * Polyline for representation on the map.<br />
 * <b>Description: http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/polylines.xml</b>
 */
public class Polyline {

    private static final Color DEFAULT_COLOR = new Color(136, 34, 221, 192);
    private static final int DEFAULT_WIDTH = 5;

    protected Color color = DEFAULT_COLOR;
    protected int width = DEFAULT_WIDTH;

    /**
     * Sets polyline color.
     *
     * @param color color
     */
    public void setColor(final Color color) {
        if (color == null) {
            this.color = DEFAULT_COLOR;
        } else {
            this.color = color;
        }
    }

    /**
     * Sets polyline width.
     *
     * @param width width
     */
    public void setWidth(final int width) {
        if (width < 0) {
            this.width = DEFAULT_WIDTH;
        }
        this.width = width;
    }

    /**
     * Returns polyline color.
     *
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns polyline width.
     *
     * @return width
     */
    public int getWidth() {
        return width;
    }

}
