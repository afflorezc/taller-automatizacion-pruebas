package co.edu.udea.certificacion.taller.shopping.utils;

import java.time.LocalDate;
import java.util.Map;
import java.util.function.Consumer;

import co.edu.udea.certificacion.taller.shopping.models.User;
import co.edu.udea.certificacion.taller.shopping.models.UserBuilder;
import co.edu.udea.certificacion.taller.shopping.models.enums.Gender;
import io.cucumber.datatable.DataTable;

public class UserFromDataTable {

    public static User createUser(DataTable signupInformation){
        
        Map<String, String> data = signupInformation.asMap();

        UserBuilder builder = UserBuilder.defaultUser();

        Map<String, Consumer<String>> actions = Map.of(
            "firstName", builder::withFirstName,
            "lastName", builder::withLastName,
            "password", builder::withPassword
        );

        data.forEach((key, value) ->{
            if(actions.containsKey(key)){
                actions.get(key).accept(value);
            }
        });

        LocalDate birthDate = null;
        if(data.get("dateOfBirth") != null){
            birthDate = LocalDate.parse(data.get("dateOfBirth"));
        }

        builder.withDateOfBirth(birthDate);
        if(data.containsKey("gender")){
            builder.withGender(Gender.valueOf(data.get("gender")));
        }
        
        if(data.containsKey("email")){
            String email = data.get("email");
            if(email==null) email="";

            builder.withEmail(email);
        }

        return  builder.build();
    }

}
