package co.edu.udea.certificacion.taller.shopping.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InputDate {
    private int monthDay;
    private String monthName;
    private int year;

}
