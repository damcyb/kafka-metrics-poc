package pl.damian.producer.domain;

import model.offer.OfferDto;

public interface MessageFacade {

    void sendEvent(final OfferDto offerDto);
}
