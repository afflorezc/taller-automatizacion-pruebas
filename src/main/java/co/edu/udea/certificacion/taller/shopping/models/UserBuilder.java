package co.edu.udea.certificacion.taller.shopping.models;

import java.time.LocalDate;

import co.edu.udea.certificacion.taller.shopping.models.enums.Gender;
import co.edu.udea.certificacion.taller.shopping.utils.RandomValues;

public class UserBuilder {

    private User user;

    private UserBuilder() {
        user = new User();
        // Set up basic information
        user.setAddress(RandomValues.randomAddress());
        if (Math.random() < 0.5){
            user.setAddress2(RandomValues.randomAddress());
        }

        user.setCompanyName(RandomValues.randomCompany());
        user.setMobileNumber(RandomValues.randomMobilePhone());
        user.setLocationData(Location.randomLocation());
        user.setSignUpForNewsLetter(RandomValues.randomBooleanValue());
        user.setSpecialOffers(RandomValues.randomBooleanValue());
        user.setZipCode(RandomValues.randomZipCode());

    }

    public static UserBuilder defaultUser() {
        return new UserBuilder();
    }

    public UserBuilder withFirstName(String firstName){
        user.setFirstName(firstName);
        user.setEmail(RandomValues.randomEmail(firstName));
        return this;
    }

    public UserBuilder withLastName(String lastName){
        user.setLastName(lastName);
        return this;
    }

    public UserBuilder withPassword(String password) {
        user.setPassword(password);
        return this;
    }

    public UserBuilder withGender(Gender gender){
        user.setGender(gender);
        return this;
    }

    public UserBuilder withDateOfBirth(LocalDate dateOfBirth){
        user.setDateOfBirth(dateOfBirth);
        return this;
    }

    public User build() {
        return user;
    }

}
