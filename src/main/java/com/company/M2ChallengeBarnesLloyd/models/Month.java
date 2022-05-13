package com.company.M2ChallengeBarnesLloyd.models;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class Month {

    @NotEmpty(message = "Please enter a number for the month.")
    private int monthNumber;
    @NotEmpty(message = "Please enter a month name.")
    private String month;

    public Month() {
    }

    public Month(int monthNumber, String month) {
        this.monthNumber = monthNumber;
        this.month = month;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month1 = (Month) o;
        return monthNumber == month1.monthNumber && Objects.equals(month, month1.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monthNumber, month);
    }

    @Override
    public String toString() {
        return "Month{" +
                "monthNumber=" + monthNumber +
                ", month='" + month + '\'' +
                '}';
    }
}
