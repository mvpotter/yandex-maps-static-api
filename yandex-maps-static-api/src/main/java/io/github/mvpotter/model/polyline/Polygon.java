/**
 * Created with IntelliJ IDEA.
 * User: mpotter
 * Date: 04.02.14
 * Time: 15:54
 */
package io.github.mvpotter.model.polyline;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Polygon for representation on the map.<br />
 * <b>Description</b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/polylines.xml
 */
public class Polygon extends Polyline {

    private static final Color DEFAULT_FILLING_COLLOR = new Color(0, 255, 0, 160);

    private Color fillingColor = DEFAULT_FILLING_COLLOR;
    private java.util.List<Curve> curves = new LinkedList<Curve>();

    /**
     * Returns polygon filling color.
     *
     * @return color
     */
    public Color getFillingColor() {
        return fillingColor;
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

    /**
     * Returns list of curves that build the polygon.
     *
     * @return list of curves
     */
    public List<Curve> getCurves() {
        return Collections.unmodifiableList(curves);
    }

    /**
     * Adds curve to polygon.
     *
     * @param curve curve
     */
    public void addCurve(final Curve curve) {
        this.curves.add(curve);
    }

}
