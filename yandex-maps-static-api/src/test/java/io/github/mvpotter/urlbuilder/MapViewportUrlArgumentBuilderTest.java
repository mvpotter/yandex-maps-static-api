/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:14
 */
package io.github.mvpotter.urlbuilder;

import io.github.mvpotter.model.Coordinate;
import org.junit.Assert;
import org.junit.Test;

public class MapViewportUrlArgumentBuilderTest extends AbstaratUrlBuilderTest {

    private static final Coordinate MAP_VIEWPORT = new Coordinate("0.9", "0.9");
    private static final String MAP_VIEWPORT_ARGUMENT = "spn=" + MAP_VIEWPORT.getLongitude()
                                                               + AbstractUrlArgumentBuilder.COORDINATES_SEPARATOR
                                                               + MAP_VIEWPORT.getLatitude();

    private static final MapViewportUrlArgumentBuilder mapViewportUrlArgumentBuilder =
            new MapViewportUrlArgumentBuilder();

    @Test
    public void buildTest() {
        yandexMap.setViewport(MAP_VIEWPORT);
        Assert.assertEquals(MAP_VIEWPORT_ARGUMENT, mapViewportUrlArgumentBuilder.build(yandexMap));
    }

}
