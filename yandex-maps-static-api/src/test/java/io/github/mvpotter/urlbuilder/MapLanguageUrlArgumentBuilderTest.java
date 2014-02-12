/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:14
 */
package io.github.mvpotter.urlbuilder;

import io.github.mvpotter.model.YandexMap;
import org.junit.Assert;
import org.junit.Test;

public class MapLanguageUrlArgumentBuilderTest extends AbstaratUrlBuilderTest {

    private static final YandexMap.Language MAP_LANGUAGE = YandexMap.Language.TURKEY;
    private static final String MAP_LANGUAGE_ARGUMENT = "lang=" + MAP_LANGUAGE.getCode();

    private static final MapLanguageUrlArgumentBuilder mapLanguageUrlArgumentBuilder =
            new MapLanguageUrlArgumentBuilder();

    @Test
    public void buildTest() {
        yandexMap.setLanguage(MAP_LANGUAGE);
        Assert.assertEquals(MAP_LANGUAGE_ARGUMENT, mapLanguageUrlArgumentBuilder.build(yandexMap));
    }

}
