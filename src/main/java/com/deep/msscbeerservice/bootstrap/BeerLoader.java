package com.deep.msscbeerservice.bootstrap;

import com.deep.msscbeerservice.domain.Beer;
import com.deep.msscbeerservice.repositories.BeerRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader  implements CommandLineRunner {

    private final BeerRespository beerRespository;

    public BeerLoader(BeerRespository beerRespository) {
        this.beerRespository = beerRespository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRespository.count() == 0 ){

            beerRespository.save(Beer.builder()
            .beerName("King")
            .beerStyle("IPA")
            .quantityToBrew(200)
            .minOnHold(12)
            .upc(36255555554L)
            .price(new BigDecimal(12.95))
            .build());

            beerRespository.save(Beer.builder()
            .beerName("Bud")
            .beerStyle("Pre")
            .quantityToBrew(100)
            .minOnHold(12)
            .upc(36555555555L)
            .price(new BigDecimal(54))
            .build());

        }
        System.out.println("Loaded Beers :"+ beerRespository.count());
    }
}
