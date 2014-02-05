/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:14
 */
package io.github.mvpotter.urlbuilder;

import io.github.mvpotter.model.Size;
import io.github.mvpotter.model.YandexMap;

/**
 * Generates URL argument that contains information about map size.
 */
public class MapSizeUrlArgumentBuilder extends AbstractUrlArgumentBuilder {

    private static final String SIZE_KEY = "size";

    @Override
    protected String buildUrlArgument(final YandexMap yandexMap) {
        final Size size = yandexMap.getSize();
        if (size != null
            && size.getWidth() != YandexMap.DEFAULT_SIZE
            && size.getHeight() != YandexMap.DEFAULT_SIZE) {
            return SIZE_KEY + EQUALS + size.getWidth() + COORDINATES_SEPARATOR + size.getHeight();
        }

        return null;
    }

}
