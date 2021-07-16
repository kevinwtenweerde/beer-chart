package com.kw.beerchartapp.api;

import com.kw.beerchartapp.domain.BeerItem;
import com.kw.beerchartapp.service.BeerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/beer")
public class BeerResource {

    private final BeerService beerService;

    public BeerResource(BeerService beerService) {
        this.beerService = beerService;
    }

    @PutMapping(path = "/update")
    public void updateBeerItem(@RequestBody BeerItem beerItem) {
        beerService.updateBeer(beerItem);
    }

    @PostMapping(path = "/delete/{id}")
    public void deleteBeerItem(@PathVariable("id") int id) {
        beerService.deleteBeer(id);
    }

    @PostMapping(path = "/add")
    public void addBeerItem() {
        beerService.addBeer();
    }

    @GetMapping(path = "/get")
    public List<BeerItem> getBeers() {
        return beerService.getBeers();
    }
}
