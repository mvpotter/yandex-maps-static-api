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
 * Generates URL argument that contains information about map viewport.
 */
public class MapViewportUrlArgumentBuilder extends AbstractUrlArgumentBuilder {

    private static final String VIEWPORT_KEY = "spn";

    @Override
    protected String buildUrlArgument(final YandexMap yandexMap) {
        final Coordinate viewport = yandexMap.getViewport();
        if (viewport != null && !viewport.equals(YandexMap.DEFAULT_VIEWPORT)) {
            return VIEWPORT_KEY + EQUALS + viewport.getLongitude() + COORDINATES_SEPARATOR + viewport.getLatitude();
        }

        return null;
    }

}
