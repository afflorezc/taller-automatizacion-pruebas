package co.edu.udea.certificacion.taller.shopping.models;

import java.time.LocalDate;

import co.edu.udea.certificacion.taller.shopping.models.enums.Gender;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@NoArgsConstructor
@Getter
@Setter
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Gender gender;
    private LocalDate dateOfBirth;
    private boolean signUpForNewsLetter;
    private boolean specialOffers;
    private String companyName;
    private String address;
    private String address2;
    private LocationData locationData;
    private String zipCode;
    private String mobileNumber;


}
