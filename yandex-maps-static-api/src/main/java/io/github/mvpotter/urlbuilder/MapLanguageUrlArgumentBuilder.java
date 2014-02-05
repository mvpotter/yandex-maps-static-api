/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:14
 */
package io.github.mvpotter.urlbuilder;

import io.github.mvpotter.model.YandexMap;

/**
 * Generates URL argument that contains information about map language.
 */
public class MapLanguageUrlArgumentBuilder extends AbstractUrlArgumentBuilder {

    private static final String LANGUAGE_KEY = "lang";

    @Override
    protected String buildUrlArgument(final YandexMap yandexMap) {
        return LANGUAGE_KEY + EQUALS + yandexMap.getLanguage().getCode();
    }

}
