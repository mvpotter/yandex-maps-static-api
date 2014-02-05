/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:14
 */
package io.github.mvpotter.urlbuilder;

import io.github.mvpotter.model.YandexMap;

/**
 * Generates URL argument that contains information about map type.
 */
public class MapTypeUrlArgumentBuilder extends AbstractUrlArgumentBuilder {

    private static final String MAP_TYPE_KEY = "l";

    @Override
    protected String buildUrlArgument(final YandexMap yandexMap) {
        return MAP_TYPE_KEY + EQUALS + yandexMap.getMapType().getCode();
    }

}
