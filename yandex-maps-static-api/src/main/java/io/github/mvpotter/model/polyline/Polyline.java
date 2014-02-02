/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 31/01/14
 * Time: 21:28
 */
package io.github.mvpotter.model.polyline;

import io.github.mvpotter.model.Coordinate;

import java.awt.*;
import java.util.List;

/**
 * Polyline for representation on the map.<br />
 * <b>Description: http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/polylines.xml</b>
 */
public interface Polyline {

    Color getColor();
    int getWidth();
    List<Coordinate> getPoints();
    String getHexColor();

}
