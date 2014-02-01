/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 31/01/14
 * Time: 21:57
 */
package io.github.mvpotter.model.marker;

/**
 * YandexMap marker with content.<br />
 * <b>Description: </b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/markers.xml
 */
public interface MarkerWithContent {

    /**
     * Returns marker content (integer from 1 to 100).
     *
     * @return marker content
     */
    int getContent();

}
