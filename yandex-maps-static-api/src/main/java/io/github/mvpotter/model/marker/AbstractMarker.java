/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 31/01/14
 * Time: 21:17
 */
package io.github.mvpotter.model.marker;

import io.github.mvpotter.model.Coordinate;

/**
 * YandexMap marker.<br />
 * <b>Description: </b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/markers.xml
 */
public abstract class AbstractMarker implements Marker{

    private Coordinate location;

    /**
     * Creates marker.
     *
     * @param location marker location on map
     */
    protected AbstractMarker(Coordinate location) {
        this.location = location;
    }

    /**
     * Sets marker location on map.
     *
     * @param location marker location
     */
    @Override
    public void setLocation(Coordinate location) {
        this.location = location;
    }

    /**
     * Returns marker location on map.
     *
     * @return marker location
     */
    @Override
    public Coordinate getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMarker that = (AbstractMarker) o;
        if (location != null ? !location.equals(that.location) : that.location != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return location != null ? location.hashCode() : 0;
    }
}
