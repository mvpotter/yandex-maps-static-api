/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 31/01/14
 * Time: 21:17
 */
package ru.mvpotter.model.marker;

/**
 * YandexMap marker.<br />
 * <b>Description: </b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/markers.xml
 */
public interface Marker {

    /**
     * Returns marker's code in accordance with its style.
     *
     * @return marker's code
     */
    String getCode();

}
