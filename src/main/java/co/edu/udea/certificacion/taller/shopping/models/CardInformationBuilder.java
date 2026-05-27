package co.edu.udea.certificacion.taller.shopping.models;

public class CardInformationBuilder {

    private CardInformation cardInformation;

    private CardInformationBuilder() {
        cardInformation = new CardInformation();
        cardInformation.setCardNumber("");
        cardInformation.setNameOnCard("");
        cardInformation.setCvcCode("");
        cardInformation.setExpirationMonth("");
        cardInformation.setExpirationYear("");
    }

    public static CardInformationBuilder defaultCardInformation(){
        return new CardInformationBuilder();
    }

    public CardInformationBuilder withCardNumber(String cardNumer){
        cardInformation.setCardNumber(cardNumer);
        return this;
    }

    public CardInformationBuilder withNameOnCard(String nameOnCard){
        cardInformation.setNameOnCard(nameOnCard);
        return this;
    }

    public CardInformationBuilder withCvcCode(String cvcCode){
        cardInformation.setCvcCode(cvcCode);
        return this;
    }

    public CardInformationBuilder withExpirationMonth(String expirationMonth){
        cardInformation.setExpirationMonth(expirationMonth);
        return this;
    }

    public CardInformationBuilder withExpirationYear(String expirationYear){
        cardInformation.setExpirationYear(expirationYear);
        return this;
    }

    public CardInformation build(){
        return cardInformation;
    }

}
