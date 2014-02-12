/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:14
 */
package io.github.mvpotter.urlbuilder;

import org.junit.Assert;
import org.junit.Test;

public class MapScaleUrlArgumentBuilderTest extends AbstaratUrlBuilderTest {

    private static final String MAP_SCALE_PREFIX = "z=";

    private static final String MAP_SCALE_ARGUMENT = MAP_SCALE_PREFIX + "1";
    private static final String LOWER_THAN_MIN_BOUND_SCALE_ARGUMENT =
            MAP_SCALE_PREFIX + MapScaleUrlArgumentBuilder.MIN_SCALE;
    private static final String HIGHER_THAN_MAN_BOUND_SCALE_ARGUMENT =
            MAP_SCALE_PREFIX + MapScaleUrlArgumentBuilder.MAX_SCALE;

    private static final MapScaleUrlArgumentBuilder mapScaleUrlArgumentBuilder = new MapScaleUrlArgumentBuilder();

    @Test
    public void testBuildDefault() {
        yandexMap.setScale(1);
        String argument = mapScaleUrlArgumentBuilder.build(yandexMap);
        Assert.assertEquals(MAP_SCALE_ARGUMENT, argument);
    }

    @Test
    public void testBuildLowerThanMinBound() {
        yandexMap.setScale(MapScaleUrlArgumentBuilder.MIN_SCALE - MapScaleUrlArgumentBuilder.MAX_SCALE);
        String argument = mapScaleUrlArgumentBuilder.build(yandexMap);
        Assert.assertEquals(LOWER_THAN_MIN_BOUND_SCALE_ARGUMENT, argument);
    }

    @Test
    public void testBuildHigherThanMaxBound() {
        yandexMap.setScale(MapScaleUrlArgumentBuilder.MAX_SCALE * 2);
        String argument = mapScaleUrlArgumentBuilder.build(yandexMap);
        Assert.assertEquals(HIGHER_THAN_MAN_BOUND_SCALE_ARGUMENT, argument);
    }

}
