/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 31/01/14
 * Time: 20:26
 */

package io.github.mvpotter.model;

import io.github.mvpotter.model.marker.Marker;
import io.github.mvpotter.model.polyline.Polyline;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Represents Yandex YandexMap object.
 */
public class YandexMap {

    public static final Coordinate DEFAULT_CENTER = new Coordinate("83.098206", "54.851702");
    public static final String VIEWPORT_SIZE = "0.01";
    public static final Coordinate DEFAULT_VIEWPORT = new Coordinate(VIEWPORT_SIZE, VIEWPORT_SIZE);
    public static final int DEFAULT_SCALE = 10;

    /**
     * YandexMap type.<br />
     * <b>Description:</b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_type.xml
     */
    private Set<MapType> mapTypes = new LinkedHashSet<MapType>();
    /**
     * YandexMap center coordinate in degrees.<br />
     * <b>Description:</b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_center.xml
     */
    private Coordinate center = DEFAULT_CENTER;
    /**
     * YandexMap viewport in degrees.<br />
     * <b>Description:</b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_viewport.xml
     */
    private Coordinate viewport = DEFAULT_VIEWPORT;
    /**
     * YandexMap scale.<br />
     * <b>Description:</b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_scale.xml
     */
    private int scale = DEFAULT_SCALE;
    /**
     * YandexMap size in pixels.<br />
     * <b>Description:</b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_size.xml
     */
    private Size size;
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
        setMapType(MapType.MAP);
    }

    /**
     * Creates Yandex Maps object.
     *
     * @param mapType map type
     * @param center map center
     */
    public YandexMap(final MapType mapType, final Coordinate center) {
        setMapType(mapType);
        setCenter(center);
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
        setApiKey(apiKey);
    }

    /**
     * Returns map type.
     *
     * @return map type
     */
    public Set<MapType> getMapTypes() {
        return Collections.unmodifiableSet(mapTypes);
    }

    /**
     * Sets map type.
     *
     * @param mapType map type.
     */
    public void setMapType(final MapType mapType) {
        mapTypes.clear();
        this.mapTypes.add(mapType);
    }

    /**
     * Sets complex map type.
     *
     * @param mapTypes map types.
     */
    public void setMapType(final MapType... mapTypes) {
        this.mapTypes.clear();
        Collections.addAll(this.mapTypes, mapTypes);
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
        this.scale = scale;
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
    }

    /**
     * Returns markers.
     *
     * @return markers
     */
    public Set<Marker> getMarkers() {
        return Collections.unmodifiableSet(markers);
    }

    /**
     * Adds marker to map.
     *
     * @param marker marker
     */
    public void addMarker(final Marker marker) {
        this.markers.add(marker);
    }

    /**
     * Returns list of polylines.
     *
     * @return list of polylines
     */
    public List<Polyline> getPolylines() {
        return Collections.unmodifiableList(polylines);
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
