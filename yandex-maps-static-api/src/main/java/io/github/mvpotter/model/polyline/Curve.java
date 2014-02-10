/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 02/02/14
 * Time: 22:05
 */
package io.github.mvpotter.model.polyline;

import io.github.mvpotter.model.Coordinate;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Curve for representation on the map.<br />
 * <b>Description: http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/polylines.xml</b>
 */
public class Curve extends Polyline {

    protected List<Coordinate> points = new LinkedList<Coordinate>();

    /**
     * Adds point to polyline.
     *
     * @param point point
     */
    public void addPoint(final Coordinate point) {
        this.points.add(point);
    }


    /**
     * Returns polyline's points.
     *
     * @return list of points
     */
    public List<Coordinate> getPoints() {
        return Collections.unmodifiableList(points);
    }

}
