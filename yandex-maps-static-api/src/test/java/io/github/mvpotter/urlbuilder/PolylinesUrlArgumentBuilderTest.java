/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:14
 */
package io.github.mvpotter.urlbuilder;

import io.github.mvpotter.model.Coordinate;
import io.github.mvpotter.model.YandexMap;
import io.github.mvpotter.model.polyline.Polygon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PolylinesUrlArgumentBuilderTest {

    private static final String API_URL_NOT_CLOSED = "pl=c:8822ddc0,f:00ff00a0,w:5,"
                                                   + "AAAAAAAAAACAlpgAQEtMAICWmADA4eQAANPO_gDTzv4=";

    private YandexMap yandexMap;
    private static final PolylinesUrlArgumentBuilder polylinesUrlArgumentBuilder = new PolylinesUrlArgumentBuilder();

    @Before
    public void before() {
        yandexMap = new YandexMap();
    }

    @Test
    public void testBuildNotClosed() {
        Polygon polygon = new Polygon();
        polygon.addPoint(new Coordinate("0", "0"));
        polygon.addPoint(new Coordinate("10", "5"));
        polygon.addPoint(new Coordinate("20", "20"));
        yandexMap.addPolyline(polygon);

        Assert.assertEquals(API_URL_NOT_CLOSED, polylinesUrlArgumentBuilder.build(yandexMap));
    }

}
