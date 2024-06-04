package com.vtorres.org.departamentofuncionario.entities;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker {

    private String name;
    private WorkerLevel level;
    private double baseSalary;

    @OneToOne
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker(Department department) {
        this.department = department;
    }

    public Worker(String workerName, WorkerLevel workerLevel, double baseSalary, Department department) {
    }

    public void addContract(HourContract contract){
        contracts.add(contract);
    }
    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }
    public double income(int year, int month) {
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for (HourContract c : contracts) {
            cal.setTime(c.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1 + cal.get(Calendar.MONTH);
            if (year == c_year && month == c_month) {
                sum += c.totalValue();
            }
        }

        return sum;
    }


}
