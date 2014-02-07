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
    private static final String MAP_TYPES_SEPARATOR = ",";

    @Override
    protected String buildUrlArgument(final YandexMap yandexMap) {
        final StringBuilder mapTypesBuilder = new StringBuilder(MAP_TYPE_KEY + EQUALS);
        for (YandexMap.MapType mapType: yandexMap.getMapTypes()) {
            mapTypesBuilder.append(mapType.getCode()).append(MAP_TYPES_SEPARATOR);
        }
        mapTypesBuilder.deleteCharAt(mapTypesBuilder.length() - 1);
        return  mapTypesBuilder.toString();
    }

}
