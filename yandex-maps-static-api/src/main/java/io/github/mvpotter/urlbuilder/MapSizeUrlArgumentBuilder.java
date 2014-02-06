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

    public static final int MAX_WIDTH = 650;
    public static final int MAX_HEIGHT = 450;
    private static final String SIZE_KEY = "size";

    @Override
    protected String buildUrlArgument(final YandexMap yandexMap) {
        final Size size = yandexMap.getSize();
        if (size != null
            && size.getWidth() != YandexMap.DEFAULT_SIZE
            && size.getHeight() != YandexMap.DEFAULT_SIZE) {
            int width = size.getWidth();
            int height = size.getHeight();
            if (width > MAX_WIDTH) {
                width = MAX_WIDTH;
            }
            if (height > MAX_HEIGHT) {
                height = MAX_HEIGHT;
            }
            return SIZE_KEY + EQUALS + width + COORDINATES_SEPARATOR + height;
        }

        return null;
    }

}
