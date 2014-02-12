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

public class MapCenterUrlArgumentBuilderTest extends AbstaratUrlBuilderTest {

    private static final Coordinate MAP_CENTER = new Coordinate("5", "5");
    private static final String MAP_CENTER_ARGUMENT = "ll=" + MAP_CENTER.getLongitude()
                                                            + ApiKeyUrlArgumentBuilder.COORDINATES_SEPARATOR
                                                            + MAP_CENTER.getLatitude();

    private static final MapCenterUrlArgumentBuilder mapCenterUrlArgumentBuilder = new MapCenterUrlArgumentBuilder();

    @Test
    public void buildTest() {
        yandexMap.setCenter(MAP_CENTER);
        Assert.assertEquals(MAP_CENTER_ARGUMENT, mapCenterUrlArgumentBuilder.build(yandexMap));
    }

}
