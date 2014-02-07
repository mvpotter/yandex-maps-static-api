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

    public static final int MIN_WIDTH = 1;
    public static final int MAX_WIDTH = 650;

    public static final int MIN_HEIGHT = 1;
    public static final int MAX_HEIGHT = 450;

    public static final String SIZE_KEY = "size";

    @Override
    protected String buildUrlArgument(final YandexMap yandexMap) {
        final Size size = yandexMap.getSize();
        if (size != null) {
            final int width = getWithinBounds(size.getWidth(), MIN_WIDTH, MAX_WIDTH);
            final int height = getWithinBounds(size.getHeight(), MIN_HEIGHT, MAX_HEIGHT);
            return SIZE_KEY + EQUALS + width + COORDINATES_SEPARATOR + height;
        }

        return null;
    }

    /**
     * Returns value withing bounds.
     *
     * @param value value to be processed
     * @param lowBound low bound
     * @param highBound high bound
     * @return value withing bounds
     */
    private int getWithinBounds(final int value, final int lowBound, final int highBound) {
        int valueInBounds = value;
        if (value < lowBound) {
            valueInBounds = lowBound;
        }
        if (value > highBound) {
            valueInBounds = highBound;
        }

        return valueInBounds;
    }

}
