package pl.damian.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOfferResponseModel {
    private UUID id;
    private String title;
    private Double price;
    private String currency;
}
