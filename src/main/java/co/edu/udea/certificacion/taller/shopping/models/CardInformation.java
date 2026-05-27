package co.edu.udea.certificacion.taller.shopping.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardInformation {
    private String NameOnCard;
    private String cardNumber;
    private String cvcCode;
    private String expirationMonth;
    private String expirationYear;
}
