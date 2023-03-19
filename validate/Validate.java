package com.scrap.validate;

import com.scrap.conts.ScrapConts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public static String validatePrice(String body) {
        Pattern pricePattern = Pattern.compile(ScrapConts.REGEX_PRICE_PATTERN);
        Matcher priceMatcher = pricePattern.matcher(body);

        StringBuilder priceBuilder = new StringBuilder();

        if (priceMatcher.find()) {
            priceBuilder.append(body.substring(priceMatcher.start(), priceMatcher.end()));

            // Delete "formattedAmount":"
            priceBuilder.delete(0, 19);
            // Delete last character
            priceBuilder.deleteCharAt(priceBuilder.length() - 1);
        }

        return priceBuilder.toString();
    }

    public static String validateAges(String body) {
        Pattern agePattern = Pattern.compile(ScrapConts.REGEX_AGE_PATTERN);
        Matcher ageMatcher = agePattern.matcher(body);

        StringBuilder agesBuilder = new StringBuilder();

        if (ageMatcher.find()) {
            agesBuilder.append(body.substring(ageMatcher.start(), ageMatcher.end()));

            // Delete "ageRange":"
            agesBuilder.delete(0, 12);
            // Delete last character
            agesBuilder.deleteCharAt(agesBuilder.length() - 1);
        }

        return agesBuilder.toString();
    }

    public static String validatePieces(String body) {
        Pattern piecesPattern = Pattern.compile(ScrapConts.REGEX_PIECES_PATTERN);
        Matcher piecesMatcher = piecesPattern.matcher(body);

        StringBuilder piecesBuilder = new StringBuilder();

        if (piecesMatcher.find()) {
            piecesBuilder.append(body.substring(piecesMatcher.start(), piecesMatcher.end()));

            // Delete "pieceCount":
            piecesBuilder.delete(0, 13);
            // Delete last character
            piecesBuilder.deleteCharAt(piecesBuilder.length() - 1);
        }

        return piecesBuilder.toString();
    }

}
