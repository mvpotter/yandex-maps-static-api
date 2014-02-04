/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 31/01/14
 * Time: 20:26
 */

package io.github.mvpotter.model;

import io.github.mvpotter.model.marker.Marker;
import io.github.mvpotter.model.polyline.Polyline;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Represents Yandex YandexMap object.
 */
public class YandexMap {

    public static final BigDecimal DEFAULT_VIEWPORT_SIZE = new BigDecimal("0.01");
    public static final int DEFAULT_SCALE = 10;
    public static final int MIN_SCALE = 0;
    public static final int MAX_SCALE = 17;
    public static final int MAX_WIDTH = 650;
    public static final int MAX_HEIGHT = 450;
    public static final int DEFAULT_SIZE = 450;

    private static final String DEFAULT_LONGITUDE = "83.098206";
    private static final String DEFAULT_LATITUDE = "54.851702";

    /**
     * YandexMap type.<br />
     * <b>Description:</b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_type.xml
     */
    private MapType mapType = MapType.MAP;
    /**
     * YandexMap center coordinate in degrees.<br />
     * <b>Description:</b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_center.xml
     */
    private Coordinate center = new Coordinate(DEFAULT_LONGITUDE, DEFAULT_LATITUDE);
    /**
     * YandexMap viewport in degrees.<br />
     * <b>Description:</b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_viewport.xml
     */
    private Coordinate viewport = new Coordinate(DEFAULT_VIEWPORT_SIZE, DEFAULT_VIEWPORT_SIZE);
    /**
     * YandexMap scale.<br />
     * <b>Description:</b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_scale.xml
     */
    private int scale = DEFAULT_SCALE;
    /**
     * YandexMap size in pixels.<br />
     * <b>Description:</b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_size.xml
     */
    private Size size = new Size(DEFAULT_SIZE, DEFAULT_SIZE);
    /**
     * Markers on map.<br />
     * <b>Description:</b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/markers.xml
     */
    private Set<Marker> markers = new HashSet<Marker>();
    /**
     * Polylines for representation on the map.<br />
     * <b>Description: http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/polylines.xml</b>
     */
    private List<Polyline> polylines = new LinkedList<Polyline>();
    /**
     * YandexMap language.<br />
     * <b>Description: </b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/localization.xml
     */
    private Language language = Language.ENGLISH;

    /**
     * API key to access Yandex Maps services (not necessary, but advisable).<br />
     * <b>Description: </b> http://api.yandex.ru/maps/form.xml
     */
    private String apiKey;

    /**
     * Creates Yandex Map object.
     */
    public YandexMap() {

    }

    /**
     * Creates Yandex Maps object.
     *
     * @param mapType map type
     * @param center map center
     */
    public YandexMap(final MapType mapType, final Coordinate center) {
        this.mapType = mapType;
        this.center = center;
    }

    /**
     * Creates Yandex Maps object.
     *
     * @param apiKey Yandex API key
     * @param mapType map type
     * @param center map center
     */
    public YandexMap(final String apiKey, final MapType mapType, final Coordinate center) {
        this(mapType, center);
        this.apiKey = apiKey;
    }

    /**
     * Returns map type.
     *
     * @return map type
     */
    public MapType getMapType() {
        return mapType;
    }

    /**
     * Sets map type.
     *
     * @param mapType map type.
     */
    public void setMapType(final MapType mapType) {
        this.mapType = mapType;
    }

    /**
     * Returns map center.
     *
     * @return map center
     */
    public Coordinate getCenter() {
        return center;
    }

    /**
     * Sets map center.
     *
     * @param center map center.
     */
    public void setCenter(final Coordinate center) {
        this.center = center;
    }

    /**
     * Returns map viewport.
     *
     * @return map viewport
     */
    public Coordinate getViewport() {
        return viewport;
    }

    /**
     * Sets map viewport.
     *
     * @param viewport map viewport.
     */
    public void setViewport(final Coordinate viewport) {
        this.viewport = viewport;
    }

    /**
     * Returns map scale.
     *
     * @return map scale
     */
    public int getScale() {
        return scale;
    }

    /**
     * Sets map scale. Must be in range [0, 17], if scale is set to zero - the whole world is shown.
     *
     * @param scale map scale.
     */
    public void setScale(final int scale) {
        if (scale < MIN_SCALE) {
            this.scale = MIN_SCALE;
        } else if (scale > MAX_SCALE) {
            this.scale = MAX_SCALE;
        } else {
            this.scale = scale;
        }
    }

    /**
     * Returns map size.
     *
     * @return map size
     */
    public Size getSize() {
        return size;
    }

    /**
     * Sets map size.
     *
     * @param size map size.
     */
    public void setSize(final Size size) {
        this.size = size;
        if (this.size.getWidth() > MAX_WIDTH) {
            this.size.setWidth(MAX_WIDTH);
        }
        if (this.size.getHeight() > MAX_HEIGHT) {
            this.size.setHeight(MAX_HEIGHT);
        }
    }

    /**
     * Returns markers.
     *
     * @return markers
     */
    public Set<Marker> getMarkers() {
        return markers;
    }

    /**
     * Sets map markers.
     *
     * @param markers map markers.
     */
    public void setMarkers(final Set<Marker> markers) {
        this.markers = markers;
    }

    /**
     * Returns list of polylines.
     *
     * @return list of polylines
     */
    public List<Polyline> getPolylines() {
        return polylines;
    }

    /**
     * Adds polyline to map.
     *
     * @param polyline polyline.
     */
    public void addPolyline(final Polyline polyline) {
        this.polylines.add(polyline);
    }

    /**
     * Returns map language.
     *
     * @return map language
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * Sets map language.
     *
     * @param language map language.
     */
    public void setLanguage(final Language language) {
        this.language = language;
    }

    /**
     * Returns api key.
     *
     * @return api key
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Sets api key.
     *
     * @param apiKey api key.
     */
    public void setApiKey(final String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Defines a map's type (basic, satellite, hybrid and so on).<br />
     * <b>Description:</b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_type.xml
     */
    public static enum MapType {

        /**
         * Basic map.
         */
        MAP("map"),
        /**
         * National map (with corrections added by Yandex Maps users).
         */
        NATIONAL_MAP("pmap"),
        /**
         * Satelite view.
         */
        SATELLITE("sat"),
        /**
         * Includes names of geographical objects.
         */
        GEO_NAMES("skl"),
        /**
         * Includes names of geographical objects (with corrections added by Yandex Maps users).
         */
        NATIONAL_GEO_NAMES("pskl"),
        /**
         * Hybrid view: satellite view with the names of geographical objects.
         */
        HYBRID("sat,skl"),
        /**
         * Traffic jams layer.
         */
        TRAFFIC_JAMS("trf");

        private String code;

        /**
         * Creates map type.
         *
         * @param code type code.
         */
        private MapType(final String code) {
            this.code = code;
        }

        /**
         * Returns map type code that is used by Yandex Maps.
         *
         * @return map type code
         */
        public String getCode() {
            return code;
        }

    }

    /**
     * Yandex map language.
     */
    public static enum Language {
        ENGLISH("en-US"),
        TURKEY("tr-TR"),
        RUSSIAN("ru-RU");

        private String code;

        /**
         * Create map language.
         *
         * @param code language code
         */
        private Language(final String code) {
            this.code = code;
        }

        /**
         * Get language code that is used by Yandex Maps.
         *
         * @return map language
         */
        public String getCode() {
            return code;
        }

    }

}
