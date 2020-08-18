package com.deep.msscbeerservice.repositories;

import com.deep.msscbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRespository extends PagingAndSortingRepository<Beer, UUID> {
}
