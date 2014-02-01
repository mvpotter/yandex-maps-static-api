/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 31/01/14
 * Time: 22:46
 */
package io.github.mvpotter;

import io.github.mvpotter.model.Coordinate;
import io.github.mvpotter.model.YandexMap;

/**
 * Builds Yandex API URL for further displaying on web components.
 */
public final class YandexApiUrlBuilder {

    private static final String YANDEX_API_BASE_URL = "http://static-maps.yandex.ru/1.x/?";

    private static final String ARGUMENTS_SEPARATOR = "&";
    private static final String EQUALS = "=";

    private static final String API_KEY_KEY = "apiKey";
    private static final String MAP_TYPE_KEY = "l";
    private static final String MAP_CENTER_KEY = "ll";

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

        final String apiKey = yandexMap.getApiKey();
        if (apiKey != null) {
            urlBuilder.append(API_KEY_KEY).append(EQUALS).append(yandexMap.getApiKey()).append(ARGUMENTS_SEPARATOR);
        }
        // add map type
        urlBuilder.append(MAP_TYPE_KEY).append(EQUALS).
                   append(yandexMap.getMapType().getCode()).append(ARGUMENTS_SEPARATOR);
        // add map center information
        final Coordinate center = yandexMap.getCenter();
        urlBuilder.append(MAP_CENTER_KEY).append(EQUALS).
                   append(center.getLongitude()).append(",").append(center.getLatitude()).append(ARGUMENTS_SEPARATOR);

        final String url = urlBuilder.toString();
        return url.substring(0, url.length() - 1);
    }

}
