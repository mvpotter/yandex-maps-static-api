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
import io.github.mvpotter.model.polyline.Curve;
import org.junit.Assert;
import org.junit.Test;

public class YandexApiUrlBuilderTest {

    // Basic URL
    private static final String DEFAULT_API_URL = "http://static-maps.yandex.ru/1.x/?"
                                                  + "l=map&ll=83.098206,54.851704&lang=en-US";
    // API key
    private static final String API_KEY = "5kgRTG54gYB43g5HR4v2";
    private static final String API_URL_WITH_API_KEY = DEFAULT_API_URL + "&apiKey=5kgRTG54gYB43g5HR4v2";
    // Viewport
    private static final float VIEWPORT_LONGITUDE = 0.05f;
    private static final float VIEWPORT_LATITUDE = 0.05f;
    private static final String API_URL_WITH_VIEWPORT = DEFAULT_API_URL + "&spn=" + VIEWPORT_LONGITUDE + "," +
                                                                                    VIEWPORT_LATITUDE;
    // Scale
    private static final int SCALE = 1;
    private static final String API_URL_WITH_SCALE = DEFAULT_API_URL + "&z=" + SCALE;
    // Size
    private static final int WIDTH = 250;
    private static final int HEIGHT = 200;
    private static final String API_URL_WITH_SIZE = DEFAULT_API_URL + "&size=" + WIDTH + "," + HEIGHT;

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
    public void testBuildWithCurve() {
        YandexMap yandexMap = new YandexMap();
        Curve curve = new Curve();
        curve.addPoint(new Coordinate(37.656577f, 55.741176f));
        curve.addPoint(new Coordinate(37.656748f, 55.741419f));
        curve.addPoint(new Coordinate(37.655131f, 55.741814f));
        curve.addPoint(new Coordinate(37.658257f, 55.742524f));
        curve.addPoint(new Coordinate(37.659811f, 55.743066f));
        curve.addPoint(new Coordinate(37.659667f, 55.743233f));
        curve.addPoint(new Coordinate(37.659551f, 55.743603f));
        curve.addPoint(new Coordinate(37.659775f, 55.743928f));
        curve.addPoint(new Coordinate(37.662398f, 55.745281f));
        yandexMap.addPolyline(curve);
        System.out.println(YandexApiUrlBuilder.build(yandexMap));
        //Assert.assertEquals(API_URL_WITH_SIZE, YandexApiUrlBuilder.build(yandexMap));
    }

}
