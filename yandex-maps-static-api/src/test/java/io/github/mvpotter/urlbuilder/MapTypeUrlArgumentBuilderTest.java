/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:14
 */
package io.github.mvpotter.urlbuilder;

import io.github.mvpotter.model.YandexMap;
import org.junit.Assert;
import org.junit.Test;

public class MapTypeUrlArgumentBuilderTest extends AbstaratUrlBuilderTest {

    private static final String MAP_TYPE_PREFIX = "l=";

    private static final String MAP_TYPE_ARGUMENT = MAP_TYPE_PREFIX + "map";
    private static final String NATIONAL_MAP_TYPE_ARGUMENT = MAP_TYPE_PREFIX + "pmap";
    private static final String SATELLITE_MAP_TYPE_ARGUMENT = MAP_TYPE_PREFIX + "sat";
    private static final String GEO_NAMES_MAP_TYPE_ARGUMENT = MAP_TYPE_PREFIX + "skl";
    private static final String NATIONAL_GEO_NAMES_MAP_TYPE_ARGUMENT = MAP_TYPE_PREFIX + "pskl";
    private static final String TRAFFIC_MAP_TYPE_ARGUMENT = MAP_TYPE_PREFIX + "trf";
    private static final String HYBRID_MAP_TYPE_ARGUMENT = MAP_TYPE_PREFIX + "sat,skl";
    private static final String COMPLEX_MAP_TYPE_ARGUMENT = MAP_TYPE_PREFIX + "sat,skl,trf";

    private static final MapTypeUrlArgumentBuilder mapTypeUrlArgumentBuilder = new MapTypeUrlArgumentBuilder();

    @Test
    public void testBuildDefault() {
        String argumet = mapTypeUrlArgumentBuilder.build(yandexMap);
        Assert.assertEquals(MAP_TYPE_ARGUMENT, argumet);
    }

    @Test
    public void testBuildNationalMap() {
        yandexMap.setMapType(YandexMap.MapType.NATIONAL_MAP);
        String argumet = mapTypeUrlArgumentBuilder.build(yandexMap);
        Assert.assertEquals(NATIONAL_MAP_TYPE_ARGUMENT, argumet);
    }

    @Test
    public void testBuildSatelliteMap() {
        yandexMap.setMapType(YandexMap.MapType.SATELLITE);
        String argumet = mapTypeUrlArgumentBuilder.build(yandexMap);
        Assert.assertEquals(SATELLITE_MAP_TYPE_ARGUMENT, argumet);
    }

    @Test
    public void testBuildGeoNamesMap() {
        yandexMap.setMapType(YandexMap.MapType.GEO_NAMES);
        String argumet = mapTypeUrlArgumentBuilder.build(yandexMap);
        Assert.assertEquals(GEO_NAMES_MAP_TYPE_ARGUMENT, argumet);
    }

    @Test
    public void testBuildNationalGeoNamesMap() {
        yandexMap.setMapType(YandexMap.MapType.NATIONAL_GEO_NAMES);
        String argumet = mapTypeUrlArgumentBuilder.build(yandexMap);
        Assert.assertEquals(NATIONAL_GEO_NAMES_MAP_TYPE_ARGUMENT, argumet);
    }

    @Test
    public void testBuildTrafficMap() {
        yandexMap.setMapType(YandexMap.MapType.TRAFFIC_JAMS);
        String argumet = mapTypeUrlArgumentBuilder.build(yandexMap);
        Assert.assertEquals(TRAFFIC_MAP_TYPE_ARGUMENT, argumet);
    }

    @Test
      public void testBuildHybridMap() {
        yandexMap.setMapType(YandexMap.MapType.HYBRID);
        String argumet = mapTypeUrlArgumentBuilder.build(yandexMap);
        Assert.assertEquals(HYBRID_MAP_TYPE_ARGUMENT, argumet);
    }

    @Test
    public void testBuildComplexMap() {
        yandexMap.setMapType(YandexMap.MapType.HYBRID, YandexMap.MapType.TRAFFIC_JAMS);
        String argumet = mapTypeUrlArgumentBuilder.build(yandexMap);
        Assert.assertEquals(COMPLEX_MAP_TYPE_ARGUMENT, argumet);
    }

}
