package com.kw.beerchartapp.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kw.beerchartapp.domain.BeerItem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class JsonUtil {
    private static final String JSON_BEER_FILE = "beers.json";

    public static void addBeer(BeerItem beer) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String beerFileContent = Files.readString(Paths.get(JSON_BEER_FILE));
            List<BeerItem> beers = mapper.readValue(beerFileContent, new TypeReference<>(){});
            if (beers.isEmpty()) {
                mapper.writeValue(new File(JSON_BEER_FILE), List.of(beer));
            } else {
                beers.add(beer);
                mapper.writeValue(new File(JSON_BEER_FILE), beers);
            }
        } catch (IOException e) {
            throw new IOException("Unable to add to JSON.");
        }
    }

    public static List<BeerItem> getBeers() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String beerFileContent = Files.readString(Paths.get(JSON_BEER_FILE));
            if (beerFileContent.isEmpty()) {
                return Collections.emptyList();
            }
            return mapper.readValue(beerFileContent, new TypeReference<>(){});
        } catch (IOException e) {
            throw new IOException("Unable to read from JSON.");
        }
    }
}
