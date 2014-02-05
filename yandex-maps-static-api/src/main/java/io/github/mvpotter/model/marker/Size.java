/*
 * Created with IntelliJ IDEA.
 * User: mpotter
 * Date: 05.02.14
 * Time: 17:31
 */
package io.github.mvpotter.model.marker;

/**
 * Square marker size.
 */
public enum Size {

    SMALL("s"),
    MEDIUM("m"),
    LARGE("l");

    private String code;

    /**
     * Creates marker size.
     *
     * @param code size code
     */
    Size(final String code) {
        this.code = code;
    }

    /**
     * Returns square marker size code.
     *
     * @return square marker size code
     */
    public String getCode() {
        return code;
    }

}
