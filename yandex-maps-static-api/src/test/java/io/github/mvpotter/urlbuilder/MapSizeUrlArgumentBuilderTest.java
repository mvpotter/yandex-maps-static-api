/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:14
 */
package io.github.mvpotter.urlbuilder;

import io.github.mvpotter.model.Size;
import org.junit.Assert;
import org.junit.Test;

public class MapSizeUrlArgumentBuilderTest extends AbstaratUrlBuilderTest {

    private static final String MAP_SIZE_PREFIX = "size=";

    private static final String MAP_SIZE_WITH_LOW_BOUNDS_ARGUMENT = MAP_SIZE_PREFIX +
                                                                    MapSizeUrlArgumentBuilder.MIN_WIDTH +
                                                                    MapSizeUrlArgumentBuilder.COORDINATES_SEPARATOR +
                                                                    MapSizeUrlArgumentBuilder.MIN_HEIGHT;
    private static final String MAP_SIZE_WITH_HIGH_BOUNDS_ARGUMENT = MAP_SIZE_PREFIX +
                                                                     MapSizeUrlArgumentBuilder.MAX_WIDTH +
                                                                     MapSizeUrlArgumentBuilder.COORDINATES_SEPARATOR +
                                                                     MapSizeUrlArgumentBuilder.MAX_HEIGHT;

    private static final MapSizeUrlArgumentBuilder mapSizeUrlArgumentBuilder = new MapSizeUrlArgumentBuilder();

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
