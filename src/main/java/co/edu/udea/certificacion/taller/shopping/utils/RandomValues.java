package co.edu.udea.certificacion.taller.shopping.utils;

import co.edu.udea.certificacion.taller.shopping.models.enums.Gender;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomValues {
    public static final List<String> RANDOM_MALE_NAMES =  new ArrayList<>(Arrays.asList("Juan", "Pedro", "Lucas", "Ernesto", "Sergio", "Samuel"));
    public static final List<String> RANDOM_FEMALE_NAMES =  new ArrayList<>(Arrays.asList("Ana", "Maria", "Karen", "Luisa", "Camila", "Catalina"));
    public static final List<String> RANDOM_LAST_NAMES =  new ArrayList<>(Arrays.asList("Gomez", "Lopez", "Alvarez", "Perez", "Jimenez", "Castillo"));


    public static <T> T randomItem(List<T> list) {

        return list.get(
                ThreadLocalRandom.current()
                        .nextInt(list.size())
        );
    }

    public static boolean randomBooleanValue() {
        if (Math.random() < 0.5){
            return false;
        }
        return true;
    }


    public static String randomAddress() {
        return "Street " + new Random().nextInt(999);
    }

    public static String randomZipCode() {
        return String.valueOf(
                10000 + new Random().nextInt(89999)
        );
    }

    public static String randomCompany(){
        return "Company " + new Random().nextInt(999);
    }

    public static String randomMobilePhone() {

        return "3"
                + (100000000 + new Random().nextInt(899999999));
    }

    public static String randomName(Gender gender){
        if (gender == Gender.M){
            return randomItem(RANDOM_MALE_NAMES);
        }
        return randomItem(RANDOM_FEMALE_NAMES);
    }

    public static String randomLastName(){
        return randomItem(RANDOM_LAST_NAMES);
    }

    public static Gender randomGender(){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randInt = random.nextInt(2);
        if (randInt==0){
            return Gender.M;
        }
        return Gender.F;
    }

    public static LocalDate randomBirthDate(){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomYear = random.nextInt(1950,2007);
        int randomMonth = random.nextInt(1,13);
        int randomDay = random.nextInt(1,27);
        LocalDate randomDate = LocalDate.of(randomYear,randomMonth,randomDay);

        return randomDate;
    }

    public static String randomEmail(String name) {
        return name
                + UUID.randomUUID()
                    .toString()
                    .substring(0,8)
                + "@udea.edu.co";
    }

}
