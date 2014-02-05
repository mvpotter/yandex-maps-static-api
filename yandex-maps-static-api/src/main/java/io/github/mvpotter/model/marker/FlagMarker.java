/*
 * Created with IntelliJ IDEA.
 * User: mpotter
 * Date: 05.02.14
 * Time: 12:37
 */
package io.github.mvpotter.model.marker;

import io.github.mvpotter.model.Coordinate;

/**
 * YandexMap flag marker.<br />
 * <b>Description: </b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/markers.xml
 */
public class FlagMarker extends AbstractMarker {

    /**
     * Creates marker.
     *
     * @param location marker location on map
     */
    public FlagMarker(Coordinate location) {
        super(location);
    }

}
