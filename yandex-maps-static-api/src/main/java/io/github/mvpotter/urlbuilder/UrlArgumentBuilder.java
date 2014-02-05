/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:25
 */
package io.github.mvpotter.urlbuilder;

import io.github.mvpotter.model.YandexMap;

/**
 * Generates URL argument in accordance with YandexMap object entities.
 */
public interface UrlArgumentBuilder {

    /**
     * Sets next element of a chain.
     *
     * @param next next element of a chain
     */
    void setNext(final UrlArgumentBuilder next);

    /**
     * Builds URL argument that is used by Yandex static API.
     *
     * @param yandexMap yandex map
     * @return URL part
     */
    String build(final YandexMap yandexMap);

}
