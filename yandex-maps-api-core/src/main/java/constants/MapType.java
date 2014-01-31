package main.java.constants;

/**
 * Created with IntelliJ IDEA.
 * User: mvpotter
 * Date: 31.01.14
 * Time: 15:45
 *
 * Defines a map's type (basic, satellite, hybrid and so on).
 */
public enum MapType {

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

    private MapType(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
