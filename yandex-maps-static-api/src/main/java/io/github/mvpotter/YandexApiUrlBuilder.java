/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 31/01/14
 * Time: 22:46
 */
package io.github.mvpotter;

import io.github.mvpotter.model.Coordinate;
import io.github.mvpotter.model.Size;
import io.github.mvpotter.model.YandexMap;
import io.github.mvpotter.model.marker.FlagMarker;
import io.github.mvpotter.model.marker.Marker;
import io.github.mvpotter.model.marker.PinMarker;
import io.github.mvpotter.model.polyline.Polygon;
import io.github.mvpotter.model.polyline.Polyline;
import io.github.mvpotter.utils.CoordinatesEncoder;

import java.util.List;
import java.util.Set;

/**
 * Builds Yandex API URL for further displaying on web components.
 */
public final class YandexApiUrlBuilder {

    private static final String YANDEX_API_BASE_URL = "http://static-maps.yandex.ru/1.x/?";

    private static final String ARGUMENTS_SEPARATOR = "&";
    private static final String EQUALS = "=";
    private static final String COORDINATES_SEPARATOR = ",";

    private static final String API_KEY_KEY = "apiKey";
    private static final String MAP_TYPE_KEY = "l";
    private static final String MAP_CENTER_KEY = "ll";
    private static final String VIEWPORT_KEY = "spn";
    private static final String SCALE_KEY = "z";
    private static final String SIZE_KEY = "size";
    private static final String LANGUAGE_KEY = "lang";
    private static final String POLYLINE_KEY = "pl";
    private static final String MARKER_KEY = "pt";

    private static final String COLOR_KEY = "c";
    private static final String FILLING_COLOR_KEY = "f";
    private static final String WIDTH_KEY = "w";
    private static final String ENTITIES_SEPARATOR = "~";
    private static final String COLON = ":";

    private static final String FLAG_MARKER_CODE = "flag";
    private static final String PIN_MARKER_CODE = "vk";

    /**
     * Creates YandexApiUrlBuilder.
     */
    private YandexApiUrlBuilder() {

    }

    /**
     * Builds URL in accordance with YandexMap object.
     *
     * @param yandexMap yandex map object
     * @return url
     */
    public static String build(final YandexMap yandexMap) {
        if (yandexMap == null) {
            throw new IllegalArgumentException("YandexMap shou" + MAP_TYPE_KEY + "d be initialized");
        }

        final StringBuilder urlBuilder = new StringBuilder(YANDEX_API_BASE_URL);

        addMapType(yandexMap, urlBuilder);
        addMapCenter(yandexMap, urlBuilder);
        addLanguage(yandexMap, urlBuilder);
        addApiKey(yandexMap, urlBuilder);
        addViewport(yandexMap, urlBuilder);
        addScale(yandexMap, urlBuilder);
        addSize(yandexMap, urlBuilder);
        addMarkers(yandexMap, urlBuilder);
        addPolylines(yandexMap, urlBuilder);

        urlBuilder.deleteCharAt(urlBuilder.length() - 1);
        return urlBuilder.toString();
    }

    /**
     * Adds api key.
     *
     * @param yandexMap yandex map
     * @param urlBuilder api url builder
     */
    private static void addApiKey(final YandexMap yandexMap, final StringBuilder urlBuilder) {
        final String apiKey = yandexMap.getApiKey();
        if (apiKey != null) {
            urlBuilder.append(API_KEY_KEY).append(EQUALS).append(yandexMap.getApiKey()).append(ARGUMENTS_SEPARATOR);
        }
    }

    /**
     * Adds map type.
     *
     * @param yandexMap yandex map
     * @param urlBuilder api url builder
     */
    private static void addMapType(final YandexMap yandexMap, final StringBuilder urlBuilder) {
        urlBuilder.append(MAP_TYPE_KEY).append(EQUALS).
                   append(yandexMap.getMapType().getCode()).append(ARGUMENTS_SEPARATOR);
    }

    /**
     * Adds map center.
     *
     * @param yandexMap yandex map
     * @param urlBuilder api url builder
     */
    private static void addMapCenter(final YandexMap yandexMap, final StringBuilder urlBuilder) {
        final Coordinate center = yandexMap.getCenter();
        if (center.equals(YandexMap.DEFAULT_CENTER)
            && (!yandexMap.getPolylines().isEmpty() || !yandexMap.getMarkers().isEmpty())) {
            return;
        }
        urlBuilder.append(MAP_CENTER_KEY).append(EQUALS).
                append(center.getLongitude()).append(COORDINATES_SEPARATOR).
                append(center.getLatitude()).append(ARGUMENTS_SEPARATOR);
    }

    /**
     * Adds map viewport.
     *
     * @param yandexMap yandex map
     * @param urlBuilder api url builder
     */
    private static void addViewport(final YandexMap yandexMap, final StringBuilder urlBuilder) {
        // add map viewport
        final Coordinate viewport = yandexMap.getViewport();
        if (viewport != null && !viewport.equals(YandexMap.DEFAULT_VIEWPORT)) {
            urlBuilder.append(VIEWPORT_KEY).append(EQUALS).
                       append(viewport.getLongitude()).append(COORDINATES_SEPARATOR).
                       append(viewport.getLatitude()).append(ARGUMENTS_SEPARATOR);
        }
    }

    /**
     * Adds map scale.
     *
     * @param yandexMap yandex map
     * @param urlBuilder api url builder
     */
    private static void addScale(final YandexMap yandexMap, final StringBuilder urlBuilder) {
        // add map viewport
        final int scale = yandexMap.getScale();
        if (scale != YandexMap.DEFAULT_SCALE) {
            urlBuilder.append(SCALE_KEY).append(EQUALS).append(scale).append(ARGUMENTS_SEPARATOR);
        }
    }

    /**
     * Adds map size.
     *
     * @param yandexMap yandex map
     * @param urlBuilder api url builder
     */
    private static void addSize(final YandexMap yandexMap, final StringBuilder urlBuilder) {
        // add map viewport
        final Size size = yandexMap.getSize();
        if (size != null
            && size.getWidth() != YandexMap.DEFAULT_SIZE
            && size.getHeight() != YandexMap.DEFAULT_SIZE) {
            urlBuilder.append(SIZE_KEY).append(EQUALS).
                    append(size.getWidth()).append(COORDINATES_SEPARATOR).
                    append(size.getHeight()).append(ARGUMENTS_SEPARATOR);
        }
    }

    /**
     * Adds map language.
     *
     * @param yandexMap yandex map
     * @param urlBuilder api url builder
     */
    private static void addLanguage(final YandexMap yandexMap, final StringBuilder urlBuilder) {
        // add map viewport
        final YandexMap.Language language = yandexMap.getLanguage();
        urlBuilder.append(LANGUAGE_KEY).append(EQUALS).append(language.getCode()).append(ARGUMENTS_SEPARATOR);
    }

    /**
     * Adds polylines to map.
     *
     * @param yandexMap yandex map
     * @param urlBuilder api url builder
     */
    private static void addPolylines(final YandexMap yandexMap, final StringBuilder urlBuilder) {
        final List<Polyline> polylines = yandexMap.getPolylines();
        if (!polylines.isEmpty()) {
            urlBuilder.append(POLYLINE_KEY).append(EQUALS);
            for (Polyline polyline: yandexMap.getPolylines()) {
                final List<Coordinate> points = polyline.getPoints();
                if (!points.isEmpty()) {
                    urlBuilder.append(renderPolylineColor(polyline.getHexColor()));
                    if (polyline instanceof Polygon) {
                        urlBuilder.append(COORDINATES_SEPARATOR).
                                   append(renderPolygonFillingColor(((Polygon) polyline).getHexFillingColor()));
                    }
                    urlBuilder.append(COORDINATES_SEPARATOR).
                               append(renderPolylineWidth(polyline.getWidth())).
                               append(COORDINATES_SEPARATOR).
                               append(CoordinatesEncoder.encode(polyline.getPoints())).
                               append(ENTITIES_SEPARATOR);
                }
            }
            urlBuilder.deleteCharAt(urlBuilder.length() - 1);
            urlBuilder.append(ARGUMENTS_SEPARATOR);
        }
    }

    /**
     * Adds markers to map.
     *
     * @param yandexMap yandex map
     * @param urlBuilder api url builder
     */
    private static void addMarkers(final YandexMap yandexMap, final StringBuilder urlBuilder) {
        final Set<Marker> markers = yandexMap.getMarkers();
        if (!markers.isEmpty()) {
            urlBuilder.append(MARKER_KEY).append(EQUALS);
            for (Marker marker: markers) {
                urlBuilder.append(marker.getLocation().getLongitude()).
                           append(COORDINATES_SEPARATOR).
                           append(marker.getLocation().getLatitude()).
                           append(COORDINATES_SEPARATOR);
                if (marker instanceof FlagMarker) {
                    urlBuilder.append(FLAG_MARKER_CODE);
                } else if (marker instanceof PinMarker) {
                    urlBuilder.append(PIN_MARKER_CODE).append(((PinMarker) marker).getType().getCode());
                }
                urlBuilder.append(ENTITIES_SEPARATOR);
            }
        }
        urlBuilder.deleteCharAt(urlBuilder.length() - 1);
        urlBuilder.append(ARGUMENTS_SEPARATOR);
    }

    /**
     * Returns string that represents polyline color.
     *
     * @param color polyline color
     * @return string that represents polyline color
     */
    private static String renderPolylineColor(final String color) {
        return COLOR_KEY + COLON + color;
    }

    /**
     * Returns string that represents polygon filling color.
     *
     * @param fillingColor polygon filling color
     * @return string that represents polygon filling color
     */
    private static String renderPolygonFillingColor(final String fillingColor) {
        return FILLING_COLOR_KEY + COLON + fillingColor;
    }

    /**
     * Returns string that represents polyline width.
     *
     * @param width polyline width
     * @return string that represents polyline width
     */
    private static String renderPolylineWidth(final int width) {
        return WIDTH_KEY + COLON + width;
    }

}
