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

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Generates URL argument that contains information about markers.
 */
public class MarkersUrlArgumentBuilder extends AbstractUrlArgumentBuilder {

    private static final String MARKER_KEY = "pt";

    private static final int MAX_ROUND_MARKER_CONTENT_VALUE = 99;
    private static final int MAX_SQUARE_MARKER_CONTENT_VALUE = 100;

    private static final Map<Style, Set<Type>> AVAILABLE_TYPES = new HashMap<Style, Set<Type>>();
    private static final Map<Style, Set<Size>> AVAILABLE_SIZES = new HashMap<Style, Set<Size>>();

    private static final Type[] SQUARE_MARKER_TYPES = new Type[] {Type.WHITE, Type.DARK_ORANGE, Type.DARK_BLUE,
                                                                  Type.BLUE, Type.GREEN, Type.GRAY, Type.LIGHT_BLUE,
                                                                  Type.NIGHT, Type.ORANGE, Type.PINK, Type.RED,
                                                                  Type.PURPLE, Type.YELLOW, Type.A, Type.B, };

    private static final Type[] ROUND_MARKER_TYPES = new Type[] {Type.WHITE, Type.DARK_ORANGE, Type.DARK_BLUE,
                                                                 Type.BLUE, Type.GREEN, Type.DARK_GREEN, Type.GRAY,
                                                                 Type.LIGHT_BLUE, Type.NIGHT, Type.ORANGE, Type.PINK,
                                                                 Type.RED, Type.PURPLE, Type.YELLOW, Type.A, Type.B,
                                                                 Type.EMPTY_BLUE, Type.EMPTY_PURPLE,
                                                                 Type.EMPTY_BLUE_WITH_YELLOW, };

    private static final Type[] PIN_MARKER_TYPES = new Type[]{Type.BLACK, Type.GRAY, };

    private static final Size[] SQUARE_MARKER_SIZES = new Size[]{Size.SMALL, Size.MEDIUM, Size.LARGE, };
    private static final Size[] ROUND_MARKER_SIZES = new Size[]{Size.MEDIUM, Size.LARGE, };
    private static final Size[] PIN_MARKER_SIZES = new Size[]{Size.MEDIUM, };

    /**
     * Creates marker url argument biolder.
     */
    public MarkersUrlArgumentBuilder() {
        AVAILABLE_TYPES.put(Style.SQUARE, new HashSet<Type>(Arrays.asList(SQUARE_MARKER_TYPES)));
        AVAILABLE_TYPES.put(Style.ROUND, new HashSet<Type>(Arrays.asList(ROUND_MARKER_TYPES)));
        AVAILABLE_TYPES.put(Style.PIN, new HashSet<Type>(Arrays.asList(PIN_MARKER_TYPES)));

        AVAILABLE_SIZES.put(Style.SQUARE, new HashSet<Size>(Arrays.asList(SQUARE_MARKER_SIZES)));
        AVAILABLE_SIZES.put(Style.ROUND, new HashSet<Size>(Arrays.asList(ROUND_MARKER_SIZES)));
        AVAILABLE_SIZES.put(Style.PIN, new HashSet<Size>(Arrays.asList(PIN_MARKER_SIZES)));
    }

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
                if (correctType(marker.getType(), marker.getStyle()) != null) {
                    urlBuilder.append(marker.getType().getCode());
                }
                if (correctSize(marker.getSize(), marker.getStyle(), marker.getType()) != null) {
                    urlBuilder.append(marker.getSize().getCode());
                }
                if (correctContent(marker.getContent(), marker.getStyle(),
                                   marker.getType(), marker.getSize()) != null) {
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
        Size correctedSize = size;
        final Set<Size> avalibleSizes = AVAILABLE_SIZES.get(style);
        final boolean isSquareLetter = (style == Style.SQUARE && type == Type.A)
                                        || (style == Style.SQUARE && type == Type.B);
        if (avalibleSizes == null || isSquareLetter) {
            correctedSize = null;
        } else if (!avalibleSizes.contains(size)) {
            correctedSize = avalibleSizes.iterator().next();
        }

        return correctedSize;
    }

    /**
     * Corrects content value in accordance with marker properties.
     *
     * @param content marker content
     * @param style marker style
     * @param type marker type
     * @param size marker size
     * @return corrected content
     */
    private Integer correctContent(final Integer content, final Style style, final Type type, final Size size) {
        Integer correctedContent = content;
        if (content == null || checkWithoutContent(style, type)) {
            correctedContent = null;
        } else if (style == Style.SQUARE && size == Size.LARGE && content > MAX_SQUARE_MARKER_CONTENT_VALUE) {
            correctedContent = MAX_SQUARE_MARKER_CONTENT_VALUE;
        } else if ((style == Style.SQUARE || style == Style.ROUND) && content > MAX_ROUND_MARKER_CONTENT_VALUE) {
            correctedContent = MAX_ROUND_MARKER_CONTENT_VALUE;
        }

        return correctedContent;
    }

    /**
     * Checks if marker should be without content.
     *
     * @param style marker style
     * @param type marker type
     * @return true if marker should be without content
     */
    private boolean checkWithoutContent(final Style style, final Type type) {
        final boolean isLetter = type == Type.A || type == Type.B;
        final boolean isEmpty = type == Type.EMPTY_BLUE || type == Type.EMPTY_PURPLE
                                || type == Type.EMPTY_BLUE_WITH_YELLOW;
        final boolean styleWithoutContent = style == Style.FLAG || style == Style.PIN;

        return styleWithoutContent || isLetter || isEmpty;
    }

    /**
     * Corrects type value in accordance with marker style.
     *
     * @param type marker type
     * @param style marker style
     * @return corrected type
     */
    private Type correctType(final Type type, final Style style) {
        final Set<Type> availableTypes = AVAILABLE_TYPES.get(style);
        Type correctedType = type;
        if (availableTypes == null) {
            correctedType = null;
        } else if (!availableTypes.contains(type)) {
            correctedType = availableTypes.iterator().next();
        }

        return correctedType;
    }

}
