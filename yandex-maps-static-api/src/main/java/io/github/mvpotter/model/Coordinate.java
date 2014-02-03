/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 31/01/14
 * Time: 20:47
 */
package io.github.mvpotter.model;

import java.math.BigDecimal;

/**
 * Represents geographical coordinate.
 */
public class Coordinate implements Cloneable {

    /**
     * Longitude.
     */
    private BigDecimal longitude;
    /**
     * Latitude.
     */
    private BigDecimal latitude;

    /**
     * Creates coordinate object.
     *
     * @param longitude longitude
     * @param latitude latitude
     */
    public Coordinate(final String longitude, final String latitude) {
        setLongitude(longitude);
        setLatitude(latitude);
    }

    /**
     * Creates coordinate object.
     *
     * @param longitude longitude
     * @param latitude latitude
     */
    public Coordinate(final BigDecimal longitude, final BigDecimal latitude) {
        setLongitude(longitude);
        setLatitude(latitude);
    }

    /**
     * Returns longitude.
     *
     * @return longitude
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * Sets longitude.
     *
     * @param longitude longitude
     */
    public void setLongitude(final String longitude) {
        this.longitude = new BigDecimal(longitude);
    }

    /**
     * Sets longitude.
     *
     * @param longitude longitude
     */
    public void setLongitude(final BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * Returns latitude.
     *
     * @return latitude
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * Sets latitude.
     *
     * @param latitude latitude
     */
    public void setLatitude(final String latitude) {
        this.latitude = new BigDecimal(latitude);
    }

    /**
     * Sets latitude.
     *
     * @param latitude latitude
     */
    public void setLatitude(final BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return String.format("(%f, %f)", longitude, latitude);
    }

}
