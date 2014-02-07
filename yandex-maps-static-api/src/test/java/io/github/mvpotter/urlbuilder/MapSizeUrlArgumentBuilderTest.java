/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:14
 */
package io.github.mvpotter.urlbuilder;

import io.github.mvpotter.model.Size;
import io.github.mvpotter.model.YandexMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MapSizeUrlArgumentBuilderTest {

    private static final String MAP_SIZE_PREFIX = "size=";

    private static final String MAP_SIZE_WITH_LOW_BOUNDS_ARGUMENT = MAP_SIZE_PREFIX +
                                                                    MapSizeUrlArgumentBuilder.MIN_WIDTH +
                                                                    MapSizeUrlArgumentBuilder.COORDINATES_SEPARATOR +
                                                                    MapSizeUrlArgumentBuilder.MIN_HEIGHT;
    private static final String MAP_SIZE_WITH_HIGH_BOUNDS_ARGUMENT = MAP_SIZE_PREFIX +
                                                                     MapSizeUrlArgumentBuilder.MAX_WIDTH +
                                                                     MapSizeUrlArgumentBuilder.COORDINATES_SEPARATOR +
                                                                     MapSizeUrlArgumentBuilder.MAX_HEIGHT;

    private YandexMap yandexMap;
    private static final MapSizeUrlArgumentBuilder mapSizeUrlArgumentBuilder = new MapSizeUrlArgumentBuilder();

    @Before
    public void before() {
        yandexMap = new YandexMap();
    }

    @Test
    public void testBuildWithLowBounds() {
        yandexMap.setSize(new Size(MapSizeUrlArgumentBuilder.MIN_WIDTH - MapSizeUrlArgumentBuilder.MAX_WIDTH,
                                   MapSizeUrlArgumentBuilder.MIN_HEIGHT - MapSizeUrlArgumentBuilder.MAX_HEIGHT));
        String argument = mapSizeUrlArgumentBuilder.build(yandexMap);
        Assert.assertEquals(MAP_SIZE_WITH_LOW_BOUNDS_ARGUMENT, argument);
    }

    @Test
    public void testBuildWithHighBounds() {
        yandexMap.setSize(new Size(MapSizeUrlArgumentBuilder.MAX_WIDTH * 2, MapSizeUrlArgumentBuilder.MAX_HEIGHT * 2));
        String argument = mapSizeUrlArgumentBuilder.build(yandexMap);
        Assert.assertEquals(MAP_SIZE_WITH_HIGH_BOUNDS_ARGUMENT, argument);
    }

}
