package com.kw.beerchartapp.service;

import com.kw.beerchartapp.domain.BeerItem;

import java.util.List;

public interface BeerService {
    void addBeer();

    List<BeerItem> getBeers();

    void deleteBeer(int id);

    void updateBeer(BeerItem beerItem);
}
