package pl.damian.producer.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import model.offer.OfferDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.damian.data.model.CreateOfferRequestModel;
import pl.damian.data.model.CreateOfferResponseModel;
import pl.damian.producer.web.service.OfferService;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/producer")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class OfferController {

    OfferService offerService;

    @GetMapping

    @PostMapping
    @RequestMapping("/offer")
    public ResponseEntity<CreateOfferResponseModel> createOffer(
            @RequestBody CreateOfferRequestModel requestModel)
    {
        OfferDto offerDto = fromCreateOfferRequestToDto(requestModel);
        offerService.createOfferAsync(offerDto);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    private OfferDto fromCreateOfferRequestToDto(CreateOfferRequestModel requestModel) {
        return OfferDto.builder()
                .id(UUID.randomUUID())
                .price(requestModel.getPrice())
                .title(requestModel.getTitle())
                .currency(requestModel.getCurrency())
                .build();
    }
}
