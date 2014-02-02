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

    /**
     * Creates YandexApiUrlBuilder.
     */
    private YandexApiUrlBuilder() {

    }

    /**
     * Build URL in accordance with YandexMap object.
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
        addApiKey(yandexMap, urlBuilder);
        addViewport(yandexMap, urlBuilder);
        addScale(yandexMap, urlBuilder);
        addSize(yandexMap, urlBuilder);
        addLanguage(yandexMap, urlBuilder);

        final String url = urlBuilder.toString();
        return url.substring(0, url.length() - 1);
    }

    /**
     * Add api key.
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
     * Add map type.
     *
     * @param yandexMap yandex map
     * @param urlBuilder api url builder
     */
    private static void addMapType(final YandexMap yandexMap, final StringBuilder urlBuilder) {
        urlBuilder.append(MAP_TYPE_KEY).append(EQUALS).
                   append(yandexMap.getMapType().getCode()).append(ARGUMENTS_SEPARATOR);
    }

    /**
     * Add map center.
     *
     * @param yandexMap yandex map
     * @param urlBuilder api url builder
     */
    private static void addMapCenter(final YandexMap yandexMap, final StringBuilder urlBuilder) {
        final Coordinate center = yandexMap.getCenter();
        urlBuilder.append(MAP_CENTER_KEY).append(EQUALS).
                   append(center.getLongitude()).append(COORDINATES_SEPARATOR).
                   append(center.getLatitude()).append(ARGUMENTS_SEPARATOR);
    }

    /**
     * Add map viewport.
     *
     * @param yandexMap yandex map
     * @param urlBuilder api url builder
     */
    private static void addViewport(final YandexMap yandexMap, final StringBuilder urlBuilder) {
        // add map viewport
        final Coordinate viewport = yandexMap.getViewport();
        if (viewport != null
            && viewport.getLongitude() != YandexMap.DEFAULT_VIEWPORT_SIZE
            && viewport.getLatitude() != YandexMap.DEFAULT_VIEWPORT_SIZE) {
            urlBuilder.append(VIEWPORT_KEY).append(EQUALS).
                    append(viewport.getLongitude()).append(COORDINATES_SEPARATOR).
                    append(viewport.getLatitude()).append(ARGUMENTS_SEPARATOR);
        }
    }

    /**
     * Add map scale.
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
     * Add map size.
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
     * Add map language.
     *
     * @param yandexMap yandex map
     * @param urlBuilder api url builder
     */
    private static void addLanguage(final YandexMap yandexMap, final StringBuilder urlBuilder) {
        // add map viewport
        final YandexMap.Language language = yandexMap.getLanguage();
        urlBuilder.append(LANGUAGE_KEY).append(EQUALS).append(language.getCode()).append(ARGUMENTS_SEPARATOR);
    }

}
