package co.edu.udea.certificacion.taller.shopping.utils;

import java.time.LocalDate;
import java.util.Map;

import co.edu.udea.certificacion.taller.shopping.models.User;
import co.edu.udea.certificacion.taller.shopping.models.UserBuilder;
import co.edu.udea.certificacion.taller.shopping.models.enums.Gender;
import io.cucumber.datatable.DataTable;

public class UserFromDataTable {

    public static User createUser(DataTable signupInformation){
        Map<String, String> data = signupInformation.asMap();

        LocalDate birthDate = null;
        if(data.get("dateOfBirth") != null){
            birthDate = LocalDate.parse(data.get("dateOfBirth"));
        }

        UserBuilder builder = UserBuilder.defaultUser();

        builder.withFirstName(data.get("firstName"));
        if(data.containsKey("email")){
            String email = data.get("email");
            if(email==null) email="";

            builder.withEmail(email);
        }

        return  builder.withLastName(data.get("lastName"))
                .withPassword(data.get("password"))
                .withGender(Gender.valueOf(data.get("gender")))
                .withDateOfBirth(birthDate)
                .build();
    }

}
