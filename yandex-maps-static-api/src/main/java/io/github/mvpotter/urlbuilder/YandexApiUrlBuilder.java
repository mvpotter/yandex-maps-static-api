/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 31/01/14
 * Time: 22:46
 */
package io.github.mvpotter.urlbuilder;

import io.github.mvpotter.model.YandexMap;

/**
 * Builds Yandex API URL for further displaying on web components.
 */
public class YandexApiUrlBuilder {

    private static final String YANDEX_API_BASE_URL = "http://static-maps.yandex.ru/1.x/?";

    private UrlArgumentBuilder urlArgumentsBuilder;

    /**
     * Creates YandexApiUrlBuilder.
     */
    public YandexApiUrlBuilder() {
        this.urlArgumentsBuilder = createChain();
    }

    /**
     * Creates chain for YandexMap processing.
     *
     * @return Yandex maps static API URL builder
     */
    private UrlArgumentBuilder createChain() {
        final UrlArgumentBuilder urlArgumentsBuilder = new MapTypeUrlArgumentBuilder();

        final UrlArgumentBuilder mapCenterUrlArgumentBuilder = new MapCenterUrlArgumentBuilder();
        final UrlArgumentBuilder mapLanguageUrlArgumentBuilder = new MapLanguageUrlArgumentBuilder();
        final UrlArgumentBuilder apiKeyUrlArgumentBuilder = new ApiKeyUrlArgumentBuilder();
        final UrlArgumentBuilder mapViewportUrlArgumentBuilder = new MapViewportUrlArgumentBuilder();
        final UrlArgumentBuilder mapScaleUrlArgumentBuilder = new MapScaleUrlArgumentBuilder();
        final UrlArgumentBuilder mapSizeUrlArgumentBuilder = new MapSizeUrlArgumentBuilder();
        final UrlArgumentBuilder markersUrlArgumentBuilder = new MarkersUrlArgumentBuilder();
        final UrlArgumentBuilder polylinesUrlArgumentBuilder = new PolylinesUrlArgumentBuilder();

        urlArgumentsBuilder.setNext(mapCenterUrlArgumentBuilder);
        mapCenterUrlArgumentBuilder.setNext(mapLanguageUrlArgumentBuilder);
        mapLanguageUrlArgumentBuilder.setNext(apiKeyUrlArgumentBuilder);
        apiKeyUrlArgumentBuilder.setNext(mapViewportUrlArgumentBuilder);
        mapViewportUrlArgumentBuilder.setNext(mapScaleUrlArgumentBuilder);
        mapScaleUrlArgumentBuilder.setNext(mapSizeUrlArgumentBuilder);
        mapSizeUrlArgumentBuilder.setNext(markersUrlArgumentBuilder);
        markersUrlArgumentBuilder.setNext(polylinesUrlArgumentBuilder);

        return urlArgumentsBuilder;
    }

    /**
     * Builds URL in accordance with YandexMap object.
     *
     * @param yandexMap yandex map object
     * @return Yandex maps static API URL
     */
    public String build(final YandexMap yandexMap) {
        if (yandexMap == null) {
            throw new IllegalArgumentException("YandexMap should be initialized");
        }
        return YANDEX_API_BASE_URL + urlArgumentsBuilder.build(yandexMap);
    }

}
