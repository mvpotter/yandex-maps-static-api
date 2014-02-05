/*
 * Created with IntelliJ IDEA.
 * User: mpotter
 * Date: 05.02.14
 * Time: 12:38
 */
package io.github.mvpotter.model.marker;

import io.github.mvpotter.model.Coordinate;

/**
 * YandexMap marker.<br />
 * <b>Description: </b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/markers.xml
 */
public interface Marker {

    /**
     * Sets marker location on map.
     *
     * @param location marker location
     */
    void setLocation(Coordinate location);

    /**
     * Returns marker location on map.
     *
     * @return marker location
     */
    public Coordinate getLocation();

}
