/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 31/01/14
 * Time: 23:03
 */
package io.github.mvpotter;

import io.github.mvpotter.model.Coordinate;
import io.github.mvpotter.model.Size;
import io.github.mvpotter.model.YandexMap;
import io.github.mvpotter.model.marker.Marker;
import io.github.mvpotter.model.marker.Style;
import io.github.mvpotter.model.marker.Type;
import io.github.mvpotter.model.polyline.Curve;
import io.github.mvpotter.model.polyline.Polygon;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.math.BigDecimal;

public class YandexApiUrlBuilderTest {

    // Basic URL
    private static final String DEFAULT_API_URL = "http://static-maps.yandex.ru/1.x/?"
                                                  + "l=map&ll=83.098206,54.851702&lang=en-US";
    // API key
    private static final String API_KEY = "5kgRTG54gYB43g5HR4v2";
    private static final String API_URL_WITH_API_KEY = DEFAULT_API_URL + "&apiKey=5kgRTG54gYB43g5HR4v2";
    // Viewport
    private static final BigDecimal VIEWPORT_LONGITUDE = new BigDecimal("0.05");
    private static final BigDecimal VIEWPORT_LATITUDE = VIEWPORT_LONGITUDE;
    private static final String API_URL_WITH_VIEWPORT = DEFAULT_API_URL + "&spn=" + VIEWPORT_LONGITUDE + "," +
                                                                                    VIEWPORT_LATITUDE;
    // Scale
    private static final int SCALE = 1;
    private static final String API_URL_WITH_SCALE = DEFAULT_API_URL + "&z=" + SCALE;
    // Size
    private static final int WIDTH = 250;
    private static final int HEIGHT = 200;
    private static final String API_URL_WITH_SIZE = DEFAULT_API_URL + "&size=" + WIDTH + "," + HEIGHT;
    // Curve
    private static final String API_URL_WITH_CURVES = "http://static-maps.yandex.ru/1.x/?l=map&lang=en-US&"
                                                    + "pl=c:000000ff,w:5,AZg-AviKUgOrAAAA8wAAAK_5__-LAQAANgwAAMYCAAA=~"
                                                    + "c:ffc800ff,w:5,o6Q-AlqSUgNw____pwAAAIz___9yAQAA4AAAAEUBAAA_"
                                                    + "CgAASQUAAA==";
    // Polygon
    private static final String API_URL_WITH_POLYGONS = "http://static-maps.yandex.ru/1.x/?l=map&lang=en-US&"
                                                      + "pl=c:000000ff,f:00ff00a0,w:5,gZg-AqSKUgOu8___DwUAAA4oAACLBwAA"
                                                      + "ROT__2bz__8=~c:ffffffff,f:00ff00a0,w:5,fqY-AkWTUgMJBgAASAcAAF"
                                                      + "wEAAD39___m_X__8EAAAA=";
    // Markers
    public static final String API_URL_WITH_MARKERS = "http://static-maps.yandex.ru/1.x/?l=map&lang=en-US&"
                                                    + "pt=37,37,pmwtm~37.1,37,flag~37.3,37.2,pmblm15~"
                                                    + "37.3,37.1,pm2blywm~37.1,37.2,pm2dgl90~37.2,37.1,pm2bm~"
                                                    + "37.2,37.2,pmgnl100~37.3,37,vkgrm~37,37.2,pm2orgl~37,37.1,pma~"
                                                    + "37.1,37.1,pmb~37.2,37,vkbkm";

    @Test
    public void basicTestBuild() {
        YandexMap yandexMap = new YandexMap();
        Assert.assertEquals(DEFAULT_API_URL, YandexApiUrlBuilder.build(yandexMap));
    }

    @Test
    public void testBuildWithApiKey() {
        YandexMap yandexMap = new YandexMap();
        yandexMap.setApiKey(API_KEY);
        Assert.assertEquals(API_URL_WITH_API_KEY, YandexApiUrlBuilder.build(yandexMap));
    }

    @Test
    public void testBuildWithViewport() {
        YandexMap yandexMap = new YandexMap();
        yandexMap.setViewport(new Coordinate(VIEWPORT_LONGITUDE, VIEWPORT_LATITUDE));
        Assert.assertEquals(API_URL_WITH_VIEWPORT, YandexApiUrlBuilder.build(yandexMap));
    }

    @Test
    public void testBuildWithScale() {
        YandexMap yandexMap = new YandexMap();
        yandexMap.setScale(SCALE);
        Assert.assertEquals(API_URL_WITH_SCALE, YandexApiUrlBuilder.build(yandexMap));
    }

    @Test
    public void testBuildWithSize() {
        YandexMap yandexMap = new YandexMap();
        yandexMap.setSize(new Size(WIDTH, HEIGHT));
        Assert.assertEquals(API_URL_WITH_SIZE, YandexApiUrlBuilder.build(yandexMap));
    }

    @Test
    public void testBuildWithCurves() {
        YandexMap yandexMap = new YandexMap();
        Curve curve = new Curve();
        curve.setColor(Color.BLACK);
        curve.addPoint(new Coordinate("37.656577", "55.741176"));
        curve.addPoint(new Coordinate("37.656748", "55.741419"));
        curve.addPoint(new Coordinate("37.655131", "55.741814"));
        curve.addPoint(new Coordinate("37.658257", "55.742524"));
        yandexMap.addPolyline(curve);

        curve = new Curve();
        curve.setColor(Color.ORANGE);
        curve.addPoint(new Coordinate("37.659811", "55.743066"));
        curve.addPoint(new Coordinate("37.659667", "55.743233"));
        curve.addPoint(new Coordinate("37.659551", "55.743603"));
        curve.addPoint(new Coordinate("37.659775", "55.743928"));
        curve.addPoint(new Coordinate("37.662398", "55.745281"));
        yandexMap.addPolyline(curve);

        Assert.assertEquals(API_URL_WITH_CURVES, YandexApiUrlBuilder.build(yandexMap));
    }

    @Test
    public void testBuildWithPolygons() {
        YandexMap yandexMap = new YandexMap();
        Polygon polygon = new Polygon();
        polygon.setColor(Color.BLACK);
        polygon.addPoint(new Coordinate("37.656705", "55.741092"));
        polygon.addPoint(new Coordinate("37.653551", "55.742387"));
        polygon.addPoint(new Coordinate("37.663805", "55.744318"));
        polygon.addPoint(new Coordinate("37.656705", "55.741092"));
        yandexMap.addPolyline(polygon);

        polygon = new Polygon();
        polygon.setColor(Color.WHITE);
        polygon.addPoint(new Coordinate("37.660286", "55.743301"));
        polygon.addPoint(new Coordinate("37.661831", "55.745165"));
        polygon.addPoint(new Coordinate("37.662947", "55.743108"));
        polygon.addPoint(new Coordinate("37.660286", "55.743301"));
        yandexMap.addPolyline(polygon);

        Assert.assertEquals(API_URL_WITH_POLYGONS, YandexApiUrlBuilder.build(yandexMap));
    }

    @Test
    public void testMarkers() {
        YandexMap yandexMap = new YandexMap();
        yandexMap.addMarker(new Marker(new Coordinate("37", "37")));
        yandexMap.addMarker(new Marker(new Coordinate("37.1", "37"), Style.FLAG));
        yandexMap.addMarker(new Marker(new Coordinate("37.2", "37"), Style.PIN, Type.BLACK));
        yandexMap.addMarker(new Marker(new Coordinate("37.3", "37"), Style.PIN, Type.GRAY));
        yandexMap.addMarker(new Marker(new Coordinate("37", "37.1"), Style.SQUARE, Type.A));
        yandexMap.addMarker(new Marker(new Coordinate("37.1", "37.1"), Style.SQUARE, Type.B));
        yandexMap.addMarker(new Marker(new Coordinate("37.2", "37.1"), Style.ROUND, Type.B));
        yandexMap.addMarker(new Marker(new Coordinate("37.3", "37.1"), Style.ROUND, Type.EMPTY_BLUE_WITH_YELLOW));
        yandexMap.addMarker(new Marker(new Coordinate("37.", "37.2"), Style.ROUND, Type.EMPTY_BLUE,
                                       io.github.mvpotter.model.marker.Size.LARGE));
        yandexMap.addMarker(new Marker(new Coordinate("37.1", "37.2"), Style.ROUND, Type.DARK_GREEN,
                                       io.github.mvpotter.model.marker.Size.LARGE, 90));
        yandexMap.addMarker(new Marker(new Coordinate("37.2", "37.2"), Style.SQUARE, Type.GREEN,
                                       io.github.mvpotter.model.marker.Size.LARGE, 100));
        yandexMap.addMarker(new Marker(new Coordinate("37.3", "37.2"), Style.SQUARE, Type.BLUE,
                            io.github.mvpotter.model.marker.Size.MEDIUM, 15));

        Assert.assertEquals(API_URL_WITH_MARKERS, YandexApiUrlBuilder.build(yandexMap));
    }

}
