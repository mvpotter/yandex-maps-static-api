/*
 * Created with IntelliJ IDEA.
 * User: mpotter
 * Date: 05.02.14
 * Time: 14:23
 */
package io.github.mvpotter.model.marker.square;

import io.github.mvpotter.model.Coordinate;
import io.github.mvpotter.model.marker.AbstractMarker;

/**
 * YandexMap square marker.<br />
 * <b>Description: </b> http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/markers.xml
 */
public class SquareMarkerWithContent extends AbstractMarker implements SquareMarker {

    private Type type;
    private Size size = Size.MEDIUM;
    private int content;

    /**
     * Creates marker.
     *
     * @param location marker location on map
     */

    /**
     * Creates marker.
     *
     * @param location marker location on map
     * @param type marker type
     * @param size marker size
     * @param content merker content
     */
    public SquareMarkerWithContent(final Coordinate location, final Type type, final Size size, final int content) {
        super(location);
        this.type = type;
        this.size = size;
        this.content = content;
    }

    /**
     * Returns square marker type.
     *
     * @return type
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets square marker type.
     *
     * @param type type
     */
    public void setType(final Type type) {
        this.type = type;
    }

    /**
     * Returns square marker size.
     *
     * @return size
     */
    public Size getSize() {
        return size;
    }

    /**
     * Sets square marker size.
     *
     * @param size size
     */
    public void setSize(final Size size) {
        this.size = size;
    }

    /**
     * Returns marker content.<br />
     * Content cannot exceed maximum value specified by marker size.
     *
     * @return marker content
     */
    public int getContent() {
        return content > size.getMaximumContentLength() ? size.getMaximumContentLength() : content;
    }

    /**
     * Sets marker content.
     *
     * @param content content
     */
    public void setContent(final int content) {
        this.content = content;
    }

    /**
     * Square marker size.
     */
    public static enum Size {

        SMALL("s", 99),
        MEDIUM("m", 99),
        LARGE("l", 100);

        private String code;
        private int maximumContentLength;

        /**
         * Creates square marker size.
         *
         * @param code size code
         */

        /**
         * Creates square marker size.
         *
         * @param code size code
         * @param maximumContentLength maximum content length for size
         */
        private Size(final String code, final int maximumContentLength) {
            this.code = code;
            this.maximumContentLength = maximumContentLength;
        }

        /**
         * Returns square marker size code.
         *
         * @return square marker size code
         */
        public String getCode() {
            return code;
        }

        /**
         * Returns maximum content length for marker size.
         *
         * @return maximum content length
         */
        public int getMaximumContentLength() {
            return maximumContentLength;
        }

    }

    /**
     * Square marker type.
     */
    public static enum Type {

        WHITE("wt"),
        DARK_ORANGE("do"),
        DARK_BLUE("db"),
        BLUE("bl"),
        GREEN("gn"),
        GRAY("gr"),
        LIGHT_BLUE("lb"),
        NIGHT("nt"),
        ORANGE("or"),
        PINK("pn"),
        RED("rd"),
        PURPLE("vv"),
        YELLOW("yw");

        private String code;

        /**
         * Creates square marker type.
         *
         * @param code type code
         */
        private Type(final String code) {
            this.code = code;
        }

        /**
         * Returns square marker type code.
         *
         * @return square marker type code
         */
        public String getCode() {
            return code;
        }

    }

}
