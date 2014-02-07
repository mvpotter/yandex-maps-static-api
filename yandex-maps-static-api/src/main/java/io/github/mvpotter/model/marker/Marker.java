/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 31/01/14
 * Time: 21:17
 */
package io.github.mvpotter.model.marker;

import io.github.mvpotter.model.Coordinate;

/**
 * YandexMap marker.<br />
 * <b>Description: </b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/markers.xml
 */
public class Marker {

    private Coordinate location;
    private Style style = Style.SQUARE;
    private Type type = Type.WHITE;
    private Size size = Size.MEDIUM;
    private Integer content;

    /**
     * Creates marker.
     *
     * @param location marker location on map
     */
    public Marker(final Coordinate location) {
        this.location = location;
    }

    /**
     * Creates marker.
     *
     * @param location marker location on map
     * @param style marker style
     */
    public Marker(final Coordinate location, final Style style) {
        this(location);
        this.style = style;
    }

    /**
     * Creates marker.
     *
     * @param location marker location on map
     * @param style marker style
     * @param type marker type
     */
    public Marker(final Coordinate location, final Style style, final Type type) {
        this(location, style);
        this.type = type;
    }

    /**
     * Creates marker.
     *
     * @param location marker location on map
     * @param style marker style
     * @param type marker type
     * @param size marker size
     */
    public Marker(final Coordinate location, final Style style, final Type type, final Size size) {
        this(location, style, type);
        this.size = size;
    }

    /**
     * Creates marker.
     *
     * @param location marker location on map
     * @param style marker style
     * @param type marker type
     * @param size marker size
     * @param content marker content
     */
    public Marker(final Coordinate location, final Style style, final Type type, final Size size, final int content) {
        this(location, style, type, size);
        this.content = content;
    }

    /**
     * Sets marker location on map.
     *
     * @param location marker location
     */
    public void setLocation(final Coordinate location) {
        this.location = location;
    }

    /**
     * Returns marker location on map.
     *
     * @return marker location
     */
    public Coordinate getLocation() {
        return location;
    }

    /**
     * Returns marker size.
     *
     * @return marker size
     */
    public Style getStyle() {
        return style;
    }

    /**
     * Sets marker style.
     *
     * @param style marker style
     */
    public void setStyle(final Style style) {
        this.style = style;
    }

    /**
     * Returns marker type.
     *
     * @return maker type
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets marker type.
     *
     * @param type marker type
     */
    public void setType(final Type type) {
        this.type = type;
    }

    /**
     * Returns marker size.
     *
     * @return marker size
     */
    public Size getSize() {
        return size;
    }

    /**
     * Sets marker size.
     *
     * @param size marker size
     */
    public void setSize(final Size size) {
        this.size = size;
    }

    /**
     * Returns marker content.
     *
     * @return marker content
     */
    public Integer getContent() {
        return content;
    }

    /**
     * Sets marker content.
     *
     * @param content marker content
     */
    public void setContent(final Integer content) {
        this.content = content;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Marker that = (Marker) o;
        if (location != null ? !location.equals(that.getLocation()) : that.getLocation() != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return location != null ? location.hashCode() : 0;
    }

}
