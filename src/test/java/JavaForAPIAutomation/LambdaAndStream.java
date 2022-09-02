package JavaForAPIAutomation;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LambdaAndStream {

    @Test
    public void printingOutColors(){
        List<String> colors = Arrays.asList("red", "green", "blue");

        // This is the normal foreach, for your comparison with other ones using Lambda
        for (String color: colors){
            printColorOf(color);
        }

        // foreach using Lambda without calling print function, we print directly here
        colors.forEach(color -> System.out.println("Color: "+color));

        // foreach using Lambda and calling a printing function
        colors.forEach(color -> printColorOf(color));

        // Another way of using Lambda with foreach and calling printing function
        colors.forEach(this:: printColorOf);

        // Here's the the same thing foreach using Lambda but with a condition if
        colors.forEach(
                color -> {
                    if(color.equals("red"))
                        System.out.println("It's RED!");
                    else
                        System.out.println(color);
                }
        );

    }

    // This is the function of printing which gets called within the above foreachs
    public void printColorOf(String color){
        System.out.println("Color: "+color);
    }


    // Using Lambda Expressions with Java stream to filtering array
    @Test
    public void filteringColors(){
        List<String> colors = Arrays.asList("red", "blue", "grey-blue", "grey", "green", "gritty white");

        // Here the list will be filtered to keep the values starting with g letter and then these values will be iterated over and printed out
        colors.stream()
                .filter(color -> color.startsWith("g"))
                .forEach(color ->  System.out.println("Color: "+color));

        // Here another list will be created from the values of the previous one with filtering the values to ones starting with g letter then convert them to uppercase then sorting them and finally gather them to a list them print the new list out
        List<String> filteredColors = colors.stream()
                .filter(color -> color.startsWith("g"))
                .map(color -> color.toUpperCase())
                .sorted()
                .collect(Collectors.toList());
        System.out.println(filteredColors);

    }

    // Using Lambda Expressions to traversing over a list and finding the minimum values' length and print the length as an integer
    @Test
    public void findingMinLength(){
        List<String> colors = Arrays.asList("red", "blue", "grey-blue", "grey", "green", "gritty white");

        Optional<Integer> minLength = colors.stream()
                .filter(color -> color.startsWith("g"))
                .map(String::length) // it's the same as this one:  map(color -> color.length())
                .sorted()
                .findFirst();

        System.out.println(minLength);

        // OR I can say
        minLength.ifPresent(
                length -> System.out.println(length)
        );

    }

    // Another way of doing the same as the previous method
    @Test
    public void filndingMinLengthAnotherWay(){
        List<String> colors = Arrays.asList("red", "blue", "grey-blue", "grey", "green", "gritty white");

        Integer minLength = colors.stream()
                .filter(color -> color.startsWith("g"))
                .map(String::length) // map(color -> color.length())
                .sorted()
                .findFirst()
                .orElse(0);

        System.out.println(minLength);
    }

    // Using Lambda Expressions to traversing over a list to find the shortest value and print it out
    @Test
    public void findingShortestColor(){
        List<String> colors = Arrays.asList("red", "blue", "grey-blue", "grey", "green", "gritty white");

        String shortesColor = colors.stream()
                .filter(color -> color.startsWith("g"))
                .map(String::toUpperCase) // .map(color -> color.toUpperCase())
                .sorted()
                .findFirst()
                .orElse("unknown");

        System.out.println(shortesColor);
    }
}
