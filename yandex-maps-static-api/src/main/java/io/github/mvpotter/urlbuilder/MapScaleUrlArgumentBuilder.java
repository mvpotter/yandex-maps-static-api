/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:14
 */
package io.github.mvpotter.urlbuilder;

import io.github.mvpotter.model.YandexMap;

/**
 * Generates URL argument that contains information about map scale.
 */
public class MapScaleUrlArgumentBuilder extends AbstractUrlArgumentBuilder {

    private static final String SCALE_KEY = "z";

    @Override
    protected String buildUrlArgument(final YandexMap yandexMap) {
        final int scale = yandexMap.getScale();
        if (scale != YandexMap.DEFAULT_SCALE) {
            return SCALE_KEY + EQUALS + scale;
        }

        return null;
    }

}
