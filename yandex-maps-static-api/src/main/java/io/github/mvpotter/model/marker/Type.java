/*
 * Created with IntelliJ IDEA.
 * User: mpotter
 * Date: 05.02.14
 * Time: 17:31
 */
package io.github.mvpotter.model.marker;

/**
 * Marker type.
 */
public enum Type {

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
    YELLOW("yw"),
    A("a"),
    B("b"),

    DARK_GREEN("dg"),
    EMPTY_BLUE("org"),
    EMPTY_PURPLE("dir"),
    EMPTY_BLUE_WITH_YELLOW("blyw"),

    BLACK("bk");

    private String code;

    /**
     * Creates marker type.
     *
     * @param code type code
     */
    Type(final String code) {
        this.code = code;
    }

    /**
     * Returns marker type code.
     *
     * @return marker type code
     */
    public String getCode() {
        return code;
    }

}
