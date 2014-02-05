/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:14
 */
package io.github.mvpotter.urlbuilder;

import io.github.mvpotter.model.YandexMap;

/**
 * Generates URL argument that contains information about API key.
 */
public class ApiKeyUrlArgumentBuilder extends AbstractUrlArgumentBuilder {

    private static final String API_KEY_KEY = "apiKey";

    @Override
    protected String buildUrlArgument(final YandexMap yandexMap) {
        final String apiKey = yandexMap.getApiKey();
        if (apiKey != null) {
            return API_KEY_KEY + EQUALS + yandexMap.getApiKey();
        }
        return null;
    }

}
