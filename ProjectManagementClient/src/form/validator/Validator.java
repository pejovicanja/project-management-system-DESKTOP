/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.validator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Validator {

    private static Validator instance;

    private Validator() {

    }

    public static Validator getInstance() {
        if (instance == null) {
            instance = new Validator();
        }
        return instance;
    }

    public boolean isNull(Object object) {
        if (object == null) {
            return true;
        }
        return false;
    }

    public boolean isEmpty(String string) {
        if (string.isEmpty() || string.isBlank()) {
            return true;
        }
        return false;
    }

    public boolean isDouble(Object object) {
        try {
            Double.parseDouble(object.toString());
        } catch (NumberFormatException ex) {
            return true;
        }
        return false;
    }

    public boolean isInteger(Object object) {
        try {
            Integer.parseInt(object.toString());
        } catch (NumberFormatException ex) {
            return true;
        }
        return false;
    }

    public boolean isValidEmail(String string) {
        if (!string.contains("@") || !string.contains(".")) {
            return true;
        }

        if (string.indexOf('@') > string.indexOf('.')) {
            return true;
        }

        if (string.indexOf('@') == 0 || string.indexOf('.') == string.length() - 1 || string.indexOf('@') - string.indexOf('.') == 1) {
            return true;
        }

        return false;
    }

    public boolean isDateInOrder(LocalDate dateFrom, LocalDate dateTo) {
        if (dateFrom.isAfter(dateTo)) {
            return true;
        }
        return false;
    }

    public boolean isDateInFuture(LocalDate date) {
        if (date.isBefore(LocalDate.now())) {
            return true;
        }
        return false;
    }

    public boolean isLowerThanZero(double value) {
        if (value <= 0) {
            return true;
        }
        return false;
    }

    public boolean isInBound(int value, int boundStart, int boundEnd) {
        if (value >= boundStart && value <= boundEnd) {
            return true;
        }
        return false;
    }

}
