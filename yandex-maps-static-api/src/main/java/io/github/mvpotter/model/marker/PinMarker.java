/*
 * Created with IntelliJ IDEA.
 * User: mpotter
 * Date: 05.02.14
 * Time: 13:44
 */
package io.github.mvpotter.model.marker;

import io.github.mvpotter.model.Coordinate;

/**
 * YandexMap pin marker.<br />
 * <b>Description: </b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/markers.xml
 */
public class PinMarker extends AbstractMarker {

    private Type type;

    /**
     * Creates pin marker.
     *
     * @param location marker location
     * @param type marker type
     */
    public PinMarker(final Coordinate location, final Type type) {
        super(location);
        this.type = type;
    }

    /**
     * Returns pin type.
     *
     * @return pin type
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets pin type.
     *
     * @param type pin type
     */
    public void setType(final Type type) {
        this.type = type;
    }

    /**
     * Pin type.
     */
    public static enum Type {
        BLACK("bkm"),
        GRAY("grm");

        private String code;

        /**
         * Creates pin type.
         *
         * @param code type code
         */
        private Type(final String code) {
            this.code = code;
        }

        /**
         * Returns pin type code.
         *
         * @return pin type code
         */
        public String getCode() {
            return code;
        }

    }

}
