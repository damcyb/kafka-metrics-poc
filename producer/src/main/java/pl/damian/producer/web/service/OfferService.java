package pl.damian.producer.web.service;

import model.offer.OfferDto;
import org.springframework.stereotype.Service;

@Service
public interface OfferService {

    void createOfferAsync(OfferDto offerDto);
}
