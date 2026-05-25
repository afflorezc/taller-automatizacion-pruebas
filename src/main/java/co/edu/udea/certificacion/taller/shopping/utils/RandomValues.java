package co.edu.udea.certificacion.taller.shopping.utils;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RandomValues {

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

    public static String randomEmail(String name) {
        return name
                + UUID.randomUUID()
                    .toString()
                    .substring(0,8)
                + "@udea.edu.co";
    }

}
