/*
 * Created with IntelliJ IDEA.
 * User: mpotter
 * Date: 03.02.14
 * Time: 13:00
 */
package io.github.mvpotter.utils;

import io.github.mvpotter.model.Coordinate;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;


/**
 * Encodes coordinates for optimized representation.
 */
// optimize performance if necessary
public final class CoordinatesEncoder {

    private static final String ENCODING_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_=";
    private static final BigDecimal MULTIPLIER = new BigDecimal(1000000);
    private static final int BITS = 32;
    private static final int BYTE = 8;
    private static final int ENCODING_STEP = 6;
    private static final String ABSENT_HALF_BYTE_CODE = "=";
    private static final String ZERO_BIT = "0";

    /**
     * Creates encoder.
     */
    private CoordinatesEncoder() {

    }

    /**
     * Encodes coordinates for optimized representation.
     *
     * @param points list of coordinates
     * @return encoded representation
     */
    public static String encode(final List<Coordinate> points) {
        if (points == null || points.isEmpty()) {
            return null;
        }
        final List<String> binaryRepresentations = new LinkedList<String>();
        binaryRepresentations.add(to32Bits(points.get(0).getLongitude().multiply(MULTIPLIER)));
        binaryRepresentations.add(to32Bits(points.get(0).getLatitude().multiply(MULTIPLIER)));
        for (int i = 1; i < points.size(); i++) {
            final Coordinate firstPoint = points.get(i - 1);
            final Coordinate secondPoint = points.get(i);
            binaryRepresentations.add(to32Bits(secondPoint.getLongitude().multiply(MULTIPLIER).
                                               subtract(firstPoint.getLongitude().multiply(MULTIPLIER))));
            binaryRepresentations.add(to32Bits(secondPoint.getLatitude().multiply(MULTIPLIER).
                                               subtract(firstPoint.getLatitude().multiply(MULTIPLIER))));
        }

        return encodeBinaryStrings(binaryRepresentations);
    }

    /**
     * Converts decimal number to 32 bit binary representation.
     *
     * @param value decimal value
     * @return 32 bit binary string
     */
    private static String to32Bits(final BigDecimal value) {
        final String binaryString = Integer.toBinaryString(value.toBigInteger().intValue());
        final StringBuilder stringBuilder = new StringBuilder(binaryString);
        if (binaryString.length() < BITS) {
            for (int i = 0; i < BITS - binaryString.length(); i++) {
                stringBuilder.insert(0, ZERO_BIT);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Encodes binary strings with Base64 analogous algorithm.
     *
     * @param binaryStrings binary strings
     * @return encoded string
     */
    private static String encodeBinaryStrings(final List<String> binaryStrings) {
        final StringBuilder reversedBinaryStringsBuilder = new StringBuilder();
        for (String binaryString: binaryStrings) {
            reversedBinaryStringsBuilder.append(reverseBynaryString(binaryString));
        }
        return encodeBinaryString(reversedBinaryStringsBuilder.toString());
    }

    /**
     * Reverse byte blocks in 4 byte binary string.
     *
     * @param binaryString 4 byte binary string
     * @return reversed 4 byte binary string
     */
    private static String reverseBynaryString(final String binaryString) {
        final StringBuilder reversedBinaryStringBuilder = new StringBuilder();
        for (int i = BITS - BYTE; i >= 0; i -= BYTE) {
            reversedBinaryStringBuilder.append(binaryString.substring(i, i + BYTE));
        }
        return reversedBinaryStringBuilder.toString();
    }

    /**
     * Encodes binary string.
     *
     * @param binaryString binary string
     * @return encoded string
     */
    private static String encodeBinaryString(final String binaryString) {
        final StringBuilder encodedStringBuilder = new StringBuilder();
        for (int i = 0; i < binaryString.length() - (ENCODING_STEP - 1); i += ENCODING_STEP) {
            final int position = Integer.parseInt(binaryString.substring(i, i + ENCODING_STEP), 2);
            final char encoded = ENCODING_STRING.charAt(position);
            encodedStringBuilder.append(encoded);
        }

        final int reminder = binaryString.length() % ENCODING_STEP;
        if (reminder > 0) {
            String lastString = binaryString.substring(binaryString.length() - reminder);
            for (int i = 0; i < ENCODING_STEP - reminder; i++) {
                lastString += "0";
            }
            encodedStringBuilder.append(ENCODING_STRING.charAt(Integer.parseInt(lastString, 2)));
        }

        for (int i = 0; i < ENCODING_STEP - reminder; i += 2) {
            encodedStringBuilder.append(ABSENT_HALF_BYTE_CODE);
        }
        return encodedStringBuilder.toString();
    }

}
