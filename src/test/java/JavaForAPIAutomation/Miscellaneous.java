package JavaForAPIAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Miscellaneous {


    @Test
    public void regex(){
        String balanceText = "JOD 500.5";
        System.out.println("balanceText as it is: "+balanceText);


        String numericValue = balanceText.replaceAll("[^\\d.]","");
        System.out.println("Keep Num only: "+numericValue);

       String charsValye =balanceText.replaceAll("[?:^\\d.]","");
       System.out.println("Keep chars only: "+charsValye);

       // Parsing the num value to double and make a simple calculation with it (divide it by 2)
        double amount = Double.parseDouble(numericValue);
        System.out.println("amount as a double type: "+amount);

        // Here's how to divide it by 2 after parsing it to double
        double dividedAmount = amount/2;
        System.out.println("dividedAmount as a double type: "+dividedAmount);

    }

    @Test
    public void regex2(){
        String values = "0|1|2|3|4|5";
        int length = values.split("|").length;
        System.out.println("length with considering '|': "+length);

        int length2 = values.split("\\W").length;
        System.out.println("length with excluding '|' symbol: "+length2);
    }

    @Test
    public void sizeOfNum() {
        String value = "0|1|2|3|4|5";

        String[] valueString = value.split("\\W");

        // Printing the numbers as a string array
        System.out.println(Arrays.stream(valueString).toList());

        // Iterating (Traversing) over the array of numbers with parsing them to integer
        for (String desiredValue : valueString) {
            int parsingDesiredValue = Integer.parseInt(desiredValue);
            System.out.println(parsingDesiredValue);
        }

        // Checking if a specific number exists
        boolean desiredNumberExists = false;
        for (String desiredValue : valueString) {
            int parsingDesiredValue = Integer.parseInt(desiredValue);
            if (parsingDesiredValue == 9) {
                desiredNumberExists = true;
                break;
            }
        }
        System.out.println("desiredNumberExists 9: "+desiredNumberExists);


        boolean desiredNumberDoesExist = false;
        for (String desiredValue : valueString) {
            int parsingDesiredValue = Integer.parseInt(desiredValue);
            if (parsingDesiredValue == 0) {
                desiredNumberDoesExist = true;
                break;
            }
        }
        System.out.println("desiredNumberDoesExist 0: "+desiredNumberDoesExist);
    }

}
