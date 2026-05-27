package co.edu.udea.certificacion.taller.shopping.utils;

import java.util.Map;
import java.util.function.Consumer;

import co.edu.udea.certificacion.taller.shopping.models.CardInformation;
import co.edu.udea.certificacion.taller.shopping.models.CardInformationBuilder;
import io.cucumber.datatable.DataTable;

public class CardInformationFromDataTable {

    public static CardInformation getCardInformation(DataTable cardInformation){
        CardInformationBuilder builder = CardInformationBuilder.defaultCardInformation();

        Map<String, String> data = cardInformation.asMap();

        Map<String, Consumer<String>> actions = Map.of(
            "nameOnCard", builder::withNameOnCard,
            "cardNumber", builder::withCardNumber,
            "cvcCode", builder::withCvcCode,
            "expirationMonth", builder::withExpirationMonth,
            "expirationYear", builder::withExpirationYear
        );

        data.forEach((key, value) -> {
            if (value != null && actions.containsKey(key)){
                actions.get(key).accept(value);
            }
        });

        CardInformation cardInfo = builder.build();
        return cardInfo;
    }
}
