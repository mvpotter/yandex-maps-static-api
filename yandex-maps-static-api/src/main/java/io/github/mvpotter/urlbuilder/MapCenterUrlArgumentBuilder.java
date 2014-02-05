/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:14
 */
package io.github.mvpotter.urlbuilder;

import io.github.mvpotter.model.Coordinate;
import io.github.mvpotter.model.YandexMap;

/**
 * Generates URL argument that contains information about map center.
 */
public class MapCenterUrlArgumentBuilder extends AbstractUrlArgumentBuilder {

    private static final String MAP_CENTER_KEY = "ll";

    @Override
    protected String buildUrlArgument(final YandexMap yandexMap) {
        final Coordinate center = yandexMap.getCenter();
        if (center.equals(YandexMap.DEFAULT_CENTER)
            && (!yandexMap.getPolylines().isEmpty() || !yandexMap.getMarkers().isEmpty())) {
            return null;
        }
        return MAP_CENTER_KEY + EQUALS + center.getLongitude() + COORDINATES_SEPARATOR + center.getLatitude();
    }

}
