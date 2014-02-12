/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:14
 */
package io.github.mvpotter.urlbuilder;

import io.github.mvpotter.model.Coordinate;
import io.github.mvpotter.model.polyline.Curve;
import io.github.mvpotter.model.polyline.Polygon;
import org.junit.Assert;
import org.junit.Test;

public class PolylinesUrlArgumentBuilderTest extends AbstaratUrlBuilderTest {

    private static final String API_URL_NOT_CLOSED = "pl=c:8822ddc0,f:00ff00a0,w:5,"
                                                   + "AAAAAAAAAACAlpgAQEtMAICWmADA4eQAANPO_gDTzv4=";

    private static final PolylinesUrlArgumentBuilder polylinesUrlArgumentBuilder = new PolylinesUrlArgumentBuilder();

    @Test
    public void testBuildNotClosed() {
        Polygon polygon = new Polygon();

        Curve curve = new Curve();
        curve.addPoint(new Coordinate("0", "0"));
        curve.addPoint(new Coordinate("10", "5"));
        curve.addPoint(new Coordinate("20", "20"));
        polygon.addCurve(curve);

        yandexMap.addPolyline(polygon);

        Assert.assertEquals(API_URL_NOT_CLOSED, polylinesUrlArgumentBuilder.build(yandexMap));
    }

}
