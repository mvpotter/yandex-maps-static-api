/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 31/01/14
 * Time: 20:58
 */
package ru.mvpotter.model;

/**
 * Represents map size.
 */
public class Size {

    /**
     * Width.
     */
    private int width;
    /**
     * Height.
     */
    private int height;

    /**
     * Creates size object.
     *
     * @param width width
     * @param height height
     */
    public Size(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Returns width.
     *
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets width.
     *
     * @param width width
     */
    public void setWidth(final int width) {
        this.width = width;
    }

    /**
     * Returns height.
     *
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets height.
     *
     * @param height height
     */
    public void setHeight(final int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", width, height);
    }
}
