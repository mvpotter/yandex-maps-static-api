/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 31/01/14
 * Time: 20:47
 */
package io.github.mvpotter.model;

/**
 * Represents geographical coordinate.
 */
public class Coordinate {

    /**
     * Longitude.
     */
    private float longitude;
    /**
     * Latitude.
     */
    private float latitude;

    /**
     * Creates coordinate object.
     *
     * @param longitude longitude
     * @param latitude latitude
     */
    public Coordinate(final float longitude, final float latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * Returns longitude.
     *
     * @return longitude
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * Sets longitude.
     *
     * @param longitude longitude
     */
    public void setLongitude(final float longitude) {
        this.longitude = longitude;
    }

    /**
     * Returns latitude.
     *
     * @return latitude
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * Sets latitude.
     *
     * @param latitude latitude
     */
    public void setLatitude(final float latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return String.format("(%f, %f)", longitude, latitude);
    }
}
