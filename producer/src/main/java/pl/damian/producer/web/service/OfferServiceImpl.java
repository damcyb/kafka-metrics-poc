package pl.damian.producer.web.service;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import model.offer.OfferDto;
import org.springframework.stereotype.Service;
import pl.damian.producer.domain.MessageFacade;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class OfferServiceImpl implements OfferService{

    MessageFacade messageFacade;

    @Override
    public void createOfferAsync(final OfferDto offerDto) {
        messageFacade.sendEvent(offerDto);
    }
}
