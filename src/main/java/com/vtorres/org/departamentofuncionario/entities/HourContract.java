package com.vtorres.org.departamentofuncionario.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HourContract {

    private Date date;
    private Double valuePerHour;
    private Integer hours;

    public HourContract(Date contractDate, int valuePerHour, int hours) {
    }

    public double totalValue(){
        return valuePerHour * hours;
    }
}
