/*
 * Created with IntelliJ IDEA.
 * User: mpotter
 * Date: 05.02.14
 * Time: 17:31
 */
package io.github.mvpotter.model.marker;

/**
 * Marker style.
 */
public enum Style {

    SQUARE("pm"),
    ROUND("pm2"),
    FLAG("flag"),
    PIN("vk");

    private String code;

    /**
     * Creates marker style.
     *
     * @param code style code
     */
    Style(final String code) {
        this.code = code;
    }

    /**
     * Returns marker style code.
     *
     * @return marker style code
     */
    public String getCode() {
        return code;
    }

}
