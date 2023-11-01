package org.example;

import javax.management.MBeanException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LocalDate dateNow = LocalDate.now();

        System.out.println("When is your birthday? (####-01-31)");
        String dateString = reader.readLine();

        try {
            LocalDate dateOfBirth = LocalDate.parse(dateString);
            Period betweenBirthday = Period.between(dateOfBirth, dateNow);
            int years = betweenBirthday.getYears();
            int months = betweenBirthday.getMonths();
            int days = betweenBirthday.getDays();
            LocalDate now = LocalDate.now();

            System.out.println("You are " + years + " years, " + months + " months " + days + " days.");

            } catch(DateTimeParseException e) {
            System.out.println("Wrong date format, try do it again.");
            }
    }
