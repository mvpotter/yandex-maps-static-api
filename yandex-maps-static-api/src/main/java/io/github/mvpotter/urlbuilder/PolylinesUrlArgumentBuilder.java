/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:14
 */
package io.github.mvpotter.urlbuilder;

import io.github.mvpotter.model.Coordinate;
import io.github.mvpotter.model.YandexMap;
import io.github.mvpotter.model.polyline.Polygon;
import io.github.mvpotter.model.polyline.Polyline;
import io.github.mvpotter.utils.ColorUtils;
import io.github.mvpotter.utils.CoordinatesEncoder;

import java.util.LinkedList;
import java.util.List;

/**
 * Generates URL argument that contains information about polylines.
 */
public class PolylinesUrlArgumentBuilder extends AbstractUrlArgumentBuilder {

    private static final String POLYLINE_KEY = "pl";
    private static final String COLOR_KEY = "c";
    private static final String FILLING_COLOR_KEY = "f";
    private static final String WIDTH_KEY = "w";
    private static final String COLON = ":";

    @Override
    protected String buildUrlArgument(final YandexMap yandexMap) {
        final StringBuilder urlBuilder = new StringBuilder();
        final List<Polyline> polylines = yandexMap.getPolylines();
        if (!polylines.isEmpty()) {
            urlBuilder.append(POLYLINE_KEY).append(EQUALS);
            for (Polyline polyline : yandexMap.getPolylines()) {
                final List<Coordinate> points = new LinkedList<Coordinate>(polyline.getPoints());
                if (!points.isEmpty()) {
                    urlBuilder.append(renderPolylineColor(ColorUtils.toHexColor(polyline.getColor())));
                    if (polyline instanceof Polygon) {
                        final Polygon polygon = (Polygon) polyline;
                        if (!points.get(0).equals(points.get(points.size() - 1))) {
                            points.add(points.get(0));
                        }
                        urlBuilder.append(COORDINATES_SEPARATOR).
                                append(renderPolygonFillingColor(ColorUtils.toHexColor(polygon.getFillingColor())));
                    }
                    urlBuilder.append(COORDINATES_SEPARATOR).
                            append(renderPolylineWidth(polyline.getWidth())).
                            append(COORDINATES_SEPARATOR).
                            append(CoordinatesEncoder.encode(points)).
                            append(ENTITIES_SEPARATOR);
                }
            }
            urlBuilder.deleteCharAt(urlBuilder.length() - 1);
        }

        return urlBuilder.length() != 0 ? urlBuilder.toString() : null;
    }

    /**
     * Returns string that represents polyline color.
     *
     * @param color polyline color
     * @return string that represents polyline color
     */
    private String renderPolylineColor(final String color) {
        return COLOR_KEY + COLON + color;
    }

    /**
     * Returns string that represents polygon filling color.
     *
     * @param fillingColor polygon filling color
     * @return string that represents polygon filling color
     */
    private String renderPolygonFillingColor(final String fillingColor) {
        return FILLING_COLOR_KEY + COLON + fillingColor;
    }

    /**
     * Returns string that represents polyline width.
     *
     * @param width polyline width
     * @return string that represents polyline width
     */
    private String renderPolylineWidth(final int width) {
        return WIDTH_KEY + COLON + width;
    }

}
