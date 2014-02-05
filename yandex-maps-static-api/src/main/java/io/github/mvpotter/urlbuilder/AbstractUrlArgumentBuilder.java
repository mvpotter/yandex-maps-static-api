/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:07
 */
package io.github.mvpotter.urlbuilder;

import io.github.mvpotter.model.YandexMap;

/**
 * Generates URL argument in accordance with YandexMap object entities.
 */
public abstract class AbstractUrlArgumentBuilder implements UrlArgumentBuilder {

    protected static final String ARGUMENTS_SEPARATOR = "&";
    protected static final String EQUALS = "=";
    protected static final String COORDINATES_SEPARATOR = ",";
    protected static final String ENTITIES_SEPARATOR = "~";


    protected UrlArgumentBuilder next;

    /**
     * Sets next element of a chain.
     *
     * @param next next element of a chain
     */
    @Override
    public void setNext(final UrlArgumentBuilder next) {
        this.next = next;
    }

    /**
     * Builds URL argument that is used by Yandex static API.
     *
     * @param yandexMap yandex map
     * @return URL part
     */
    @Override
    public String build(final YandexMap yandexMap) {
        String result = buildUrlArgument(yandexMap);
        if (next != null) {
            final String nextArgument = next.build(yandexMap);
            if (nextArgument != null) {
                if (result == null) {
                    result = nextArgument;
                } else {
                    result = result + ARGUMENTS_SEPARATOR + nextArgument;
                }
            }
        }
        return result;
    }

    /**
     * Builds a URL argument that is used by Yandex static API.
     *
     * @param yandexMap yandex map
     * @return URL part
     */
    protected abstract String buildUrlArgument(final YandexMap yandexMap);

}
