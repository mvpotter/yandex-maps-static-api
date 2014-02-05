/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:14
 */
package io.github.mvpotter.urlbuilder;

import io.github.mvpotter.model.YandexMap;
import io.github.mvpotter.model.marker.Marker;

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
                if (marker.getType() != null) {
                    urlBuilder.append(marker.getType().getCode());
                }
                if (marker.getSize() != null) {
                    urlBuilder.append(marker.getSize().getCode());
                }
                if (marker.getContent() != null) {
                    urlBuilder.append(marker.getContent());
                }
                urlBuilder.append(ENTITIES_SEPARATOR);
            }
            urlBuilder.deleteCharAt(urlBuilder.length() - 1);
        }

        return urlBuilder.length() != 0 ? urlBuilder.toString() : null;
    }

}
