/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 31/01/14
 * Time: 23:03
 */
package io.github.mvpotter;

import org.junit.Assert;
import org.junit.Test;
import io.github.mvpotter.model.YandexMap;

public class YandexApiUrlBuilderTest {

    private static final String DEFAULT_API_URL = "http://static-maps.yandex.ru/1.x/?l=map&ll=83.098206,54.851704";

    @Test
    public void basicTestBuild() {
        YandexMap yandexMap = new YandexMap();
        Assert.assertEquals(DEFAULT_API_URL, YandexApiUrlBuilder.build(yandexMap));
    }

}
