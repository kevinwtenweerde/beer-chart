package com.kw.beerchartapp.repository;

import com.kw.beerchartapp.domain.BeerItem;

import java.util.List;

public interface BeerItemRepository {

    List<BeerItem> getBeers();

    void addBeer(BeerItem beer);

    void deleteById(int id);

    void update(BeerItem beerItem);
}
