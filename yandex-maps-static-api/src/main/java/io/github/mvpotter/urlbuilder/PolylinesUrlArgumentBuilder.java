/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:14
 */
package io.github.mvpotter.urlbuilder;

import io.github.mvpotter.model.Coordinate;
import io.github.mvpotter.model.YandexMap;
import io.github.mvpotter.model.polyline.Curve;
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
    private static final String POLYGON_CURVES_SEPARATOR = ";";

    @Override
    protected String buildUrlArgument(final YandexMap yandexMap) {
        final StringBuilder urlBuilder = new StringBuilder();
        final List<Polyline> polylines = yandexMap.getPolylines();
        if (!polylines.isEmpty()) {
            urlBuilder.append(POLYLINE_KEY).append(EQUALS);
            for (Polyline polyline : yandexMap.getPolylines()) {
                if (polyline instanceof Curve) {
                    urlBuilder.append(buildCurveArgument((Curve) polyline));
                } else if (polyline instanceof Polygon) {
                    urlBuilder.append(buildPolygonArgument((Polygon) polyline));
                }
            }
            urlBuilder.deleteCharAt(urlBuilder.length() - 1);
        }

        return urlBuilder.length() != 0 ? urlBuilder.toString() : null;
    }

    /**
     * Builds curve url argument.
     *
     * @param curve curve description
     * @return curve url representation
     */
    private String buildCurveArgument(final Curve curve) {
        final StringBuilder urlBuilder = new StringBuilder();
        final List<Coordinate> points = curve.getPoints();
        if (!points.isEmpty()) {
            urlBuilder.append(renderPolylineColor(ColorUtils.toHexColor(curve.getColor())));
            urlBuilder.append(COORDINATES_SEPARATOR).
                       append(renderPolylineWidth(curve.getWidth())).
                       append(COORDINATES_SEPARATOR).
                       append(CoordinatesEncoder.encode(points)).
                       append(ENTITIES_SEPARATOR);
        }
        return urlBuilder.toString();
    }

    /**
     * Builds polygon url argument.
     *
     * @param polygon polygon description
     * @return polygon url representation
     */
    private String buildPolygonArgument(final Polygon polygon) {
        final StringBuilder urlBuilder = new StringBuilder();
        final List<Curve> curves = polygon.getCurves();
        if (!curves.isEmpty()) {
            urlBuilder.append(renderPolylineColor(ColorUtils.toHexColor(polygon.getColor())));
            urlBuilder.append(COORDINATES_SEPARATOR).
                       append(renderPolygonFillingColor(ColorUtils.toHexColor(polygon.getFillingColor()))).
                       append(COORDINATES_SEPARATOR).
                       append(renderPolylineWidth(polygon.getWidth()));
            for (Curve curve: curves) {
                final List<Coordinate> points = new LinkedList<Coordinate>(curve.getPoints());
                if (!points.isEmpty()) {
                    if (!points.get(0).equals(points.get(points.size() - 1))) {
                        points.add(points.get(0));
                    }
                    final String separator = Character.toString(urlBuilder.charAt(urlBuilder.length() - 1));
                    if (!POLYGON_CURVES_SEPARATOR.equals(separator)) {
                        urlBuilder.append(COORDINATES_SEPARATOR);
                    }
                    urlBuilder.append(CoordinatesEncoder.encode(points));
                }
                urlBuilder.append(POLYGON_CURVES_SEPARATOR);
            }
            urlBuilder.deleteCharAt(urlBuilder.length() - 1);
            urlBuilder.append(ENTITIES_SEPARATOR);
        }
        return urlBuilder.toString();
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
