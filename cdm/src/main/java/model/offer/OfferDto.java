package model.offer;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Builder
@Data
public class OfferDto implements Serializable {
    private UUID id;
    private String title;
    private Double price;
    private String currency;

}
