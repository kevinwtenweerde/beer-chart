package com.kw.beerchartapp.service;

import com.kw.beerchartapp.EbcColorCode;
import com.kw.beerchartapp.domain.BeerItem;
import com.kw.beerchartapp.repository.BeerItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeerServiceImpl implements BeerService {

    private final BeerItemRepository beerItemRepository;

    @Autowired
    public BeerServiceImpl(BeerItemRepository beerItemRepository) {
        this.beerItemRepository = beerItemRepository;
    }

    @Override
    public void addBeer() {
        beerItemRepository.addBeer(BeerItem.builder().bottlingDate(LocalDate.now()).build());
    }

    @Override
    public List<BeerItem> getBeers() {
        return  beerItemRepository.getBeers()
                .stream()
                .sorted(Comparator.comparing(BeerItem::getBottlingDate))
                .map(BeerItem::withColorCode)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBeer(int id) {
        beerItemRepository.deleteById(id);
    }

    @Override
    public void updateBeer(BeerItem beerItem) {
        beerItemRepository.update(beerItem);
    }
}
