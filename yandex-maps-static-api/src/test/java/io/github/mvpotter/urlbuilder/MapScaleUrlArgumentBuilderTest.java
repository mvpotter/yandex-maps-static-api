/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:14
 */
package io.github.mvpotter.urlbuilder;

import io.github.mvpotter.model.YandexMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MapScaleUrlArgumentBuilderTest {

    private static final String MAP_SCALE_PREFIX = "z=";

    private static final String MAP_SCALE_ARGUMENT = MAP_SCALE_PREFIX + "1";

    private YandexMap yandexMap;
    private static final MapScaleUrlArgumentBuilder mapScaleUrlArgumentBuilder = new MapScaleUrlArgumentBuilder();

    @Before
    public void before() {
        yandexMap = new YandexMap();
    }

    @Test
    public void testBuildDefault() {
        yandexMap.setScale(1);
        String argument = mapScaleUrlArgumentBuilder.build(yandexMap);
        Assert.assertEquals(MAP_SCALE_ARGUMENT, argument);
    }

}
