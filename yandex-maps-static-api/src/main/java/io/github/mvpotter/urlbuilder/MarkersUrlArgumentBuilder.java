/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:14
 */
package io.github.mvpotter.urlbuilder;

import io.github.mvpotter.model.YandexMap;
import io.github.mvpotter.model.marker.Marker;
import io.github.mvpotter.model.marker.Size;
import io.github.mvpotter.model.marker.Style;
import io.github.mvpotter.model.marker.Type;

import java.util.Set;

/**
 * Generates URL argument that contains information about markers.
 */
public class MarkersUrlArgumentBuilder extends AbstractUrlArgumentBuilder {

    private static final String MARKER_KEY = "pt";

    @Override
    protected String buildUrlArgument(final YandexMap yandexMap) {
        final StringBuilder urlBuilder = new StringBuilder();
        final Set<Marker> markers = yandexMap.getMarkers();
        if (!markers.isEmpty()) {
            urlBuilder.append(MARKER_KEY).append(EQUALS);
            for (Marker marker: markers) {
                urlBuilder.append(marker.getLocation().getLongitude()).
                        append(COORDINATES_SEPARATOR).
                        append(marker.getLocation().getLatitude()).
                        append(COORDINATES_SEPARATOR).
                        append(marker.getStyle().getCode());
                if (processType(marker.getType(), marker.getStyle()) != null) {
                    urlBuilder.append(marker.getType().getCode());
                }
                if (correctSize(marker.getSize(), marker.getStyle(), marker.getType()) != null) {
                    urlBuilder.append(marker.getSize().getCode());
                }
                if (correctContent(marker.getContent(), marker.getStyle(), marker.getType()) != null) {
                    urlBuilder.append(marker.getContent());
                }
                urlBuilder.append(ENTITIES_SEPARATOR);
            }
            urlBuilder.deleteCharAt(urlBuilder.length() - 1);
        }

        return urlBuilder.length() != 0 ? urlBuilder.toString() : null;
    }

    /**
     * Corrects size value in accordance with marker properties.
     *
     * @param size marker size
     * @param style marker style
     * @param type marker type
     * @return corrected size
     */
    private Size correctSize(final Size size, final Style style, final Type type) {
        final boolean isSquareLetter = (style == Style.SQUARE && type == Type.A)
                                        || (style == Style.SQUARE && type == Type.B);
        if (style == Style.FLAG || isSquareLetter) {
            return null;
        }
        if (style == Style.PIN) {
            return Size.MEDIUM;
        }

        return size;
    }

    /**
     * Corrects content value in accordance with marker properties.
     *
     * @param content marker content
     * @param style marker style
     * @param type marker type
     * @return corrected content
     */
    private Integer correctContent(final Integer content, final Style style, final Type type) {
        final boolean isLetter = type == Type.A || type == Type.B;
        final boolean isEmpty = type == Type.EMPTY_BLUE || type == Type.EMPTY_PURPLE
                                || type == Type.EMPTY_BLUE_WITH_YELLOW;
        if (style == Style.FLAG || style == Style.PIN
                || isLetter || isEmpty) {
            return null;
        }

        return content;
    }

    /**
     * Corrects type value in accordance with marker style.
     *
     * @param type marker type
     * @param style marker style
     * @return corrected type
     */
    private Type processType(final Type type, final Style style) {
        if (style == Style.FLAG) {
            return null;
        }
        return type;
    }

}
