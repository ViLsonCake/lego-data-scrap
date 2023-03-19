package com.scrap.jsoup;

import com.project.SpringBootLegoScrap.entity.LegoSetEntity;
import com.scrap.conts.ScrapConts;
import com.scrap.validate.Validate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class LegoParser {

    public static LegoSetEntity getData(Integer item) throws IOException {

        // Create output lego set entity
        LegoSetEntity legoSetEntity = new LegoSetEntity();

        // Create parser
        Document document = Jsoup.connect(ScrapConts.URL + item).get();

        // Document body
        String body = document.body().toString();

        // Title
        legoSetEntity.setTitle(document.getElementsByAttributeValue(ScrapConts.ATTRIBUTE,
                ScrapConts.TITLE_VALUE).text());

        // Availability
        legoSetEntity.setAvailability(document.getElementsByAttributeValue(ScrapConts.ATTRIBUTE,
                ScrapConts.AVAILABILITY_VALUE).text());

        // Price
        legoSetEntity.setPrice(Validate.validatePrice(body));

        // Ages
        legoSetEntity.setAges(Validate.validateAges(body));

        // Pieces
        legoSetEntity.setPieces(Validate.validatePieces(body));

        // Item
        legoSetEntity.setItem(item);

        return legoSetEntity;
    }
}
