package com.deep.msscbeerservice.web.controller;

import com.deep.msscbeerservice.domain.Beer;
import com.deep.msscbeerservice.web.model.BeerDto;
import com.deep.msscbeerservice.web.model.BeerStyleEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.print.attribute.standard.Media;
import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {

        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void handlePost() throws  Exception{
        //BeerDto beerDto = BeerDto.builder().build();
        BeerDto beerDto = getValidBeerDto();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void handleUpdate() throws  Exception{
       //BeerDto beerDto = BeerDto.builder().build();
        BeerDto beerDto = getValidBeerDto();
       String beerDtoJson = objectMapper.writeValueAsString(beerDto);

       mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
       .contentType(MediaType.APPLICATION_JSON)
       .content(beerDtoJson))
        .andExpect(status().isNoContent());
    }

    BeerDto getValidBeerDto(){
        return BeerDto.builder()
                .beerName("")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal("35.20"))
                .upc(87458547968652L)
                .build();
    }
}