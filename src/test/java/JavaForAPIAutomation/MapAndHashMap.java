package JavaForAPIAutomation;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapAndHashMap {


    @Test
    public void hashmapTest(){

        Map<String, Integer> grades = new HashMap<>();
        grades.put("Tom grade", 1);
        grades.put("Johnny grade", 2);
        System.out.println(grades);
        System.out.println(grades.get("Johnny grade"));

        Map<String, String> fullNames = new HashMap<>();
        fullNames.put("First Name", "Tom");
        fullNames.put("Last Name", "Hanks");

        System.out.println("Printing all entrySet of the hashmap: "+fullNames);
        System.out.println("Printing the value of First Name Key: "+fullNames.get("First Name"));
        System.out.println("Printing all keys only: "+fullNames.keySet());
        System.out.println("Printing all values only: "+fullNames.values());
    }


    @Test
    public void string_integer_hashmap(){
        Integer[] hi = {1,2};
        Integer[] bye ={3,4};
        Integer[] hello={5,6};

        Map<String, Integer[]> siHashMap = new HashMap<>();
        siHashMap.put("firstKey", hi);
        siHashMap.put("secondKey", bye);
        siHashMap.put("thirdKey", hello);
        System.out.println(Arrays.stream(siHashMap.get("secondKey")).toList());
    }

    @Test
    public void string_string_hashmap(){
        String[] mazdaModels = {"Mazda 6","Mazda 3"};
        String[] toyotaModels ={"Corolla","Camry"};
        String[] mitsubishiModels={"Evolution x","Pajero"};

        Map<String, String[]> siHashMap = new HashMap<>();
        siHashMap.put("Mazda", mazdaModels);
        siHashMap.put("Toyota", toyotaModels);
        siHashMap.put("Mitsubishi", mitsubishiModels);
        System.out.println(Arrays.stream(siHashMap.get("Toyota")).toList());
        System.out.println((siHashMap.keySet()));

        // Traversing over HashMap and printing each key with its array of values
        for (Map.Entry<String, String[]> entry : siHashMap.entrySet()) {
            System.out.println(entry.getKey()+" => "+Arrays.stream(entry.getValue()).toList());
        }

    }

    @Test
    public void creatingAMapMoreConcisely(){

        // The following Map.of is used in Java 9:
        // Map<String, Integer> numberOfBallsByColor = Map.of("red", 3, "green", 6, "blue", 5);

        Map<String, Integer> numberOfBallsByColor = new HashMap<>();
        numberOfBallsByColor.put("red", 3);
        numberOfBallsByColor.put("green", 6);
        numberOfBallsByColor.put("blue", 5);

        int numberOfRedBalls = numberOfBallsByColor.get("red");
        System.out.println("number of red balls is: "+numberOfRedBalls);

        Map<String, Integer> moreColors = new HashMap<>();
        moreColors.put("yellow", 10);
        moreColors.put("white", 17);

        moreColors.putAll(numberOfBallsByColor);

        System.out.println("moreColors Map is: "+moreColors);
        // moreColors Map is: {red=3, green=6, blue=5, yellow=10, White=17} that will be printed

        System.out.println("Number of colors for purple balls is: "+ moreColors.get("purple"));
        //Number of colors for white balls is: null

        System.out.println("Number of colors for pink balls is: "+ moreColors.getOrDefault("pink", 0));
        //Number of colors for white balls is: 0

        System.out.println("beige tennis balls are present: "+moreColors.containsKey("beige"));
        //beige tennis balls are present: false

        // Replacing Values
        moreColors.put("yellow", 20);
        System.out.println("moreColors Map after updating yellow value using put: "+moreColors);

        moreColors.replace("yellow", 7);
        System.out.println("moreColors Map after updating yellow value using replace  "+moreColors);

        // It will get updated if only is already existed
        moreColors.replace("beige", 18);
        System.out.println("moreColors Map after updating beige value using replace  "+moreColors);

    }

    @Test
    public void iteratingOverMapKeys(){

        Map<String, Integer> numberOfBallsByColor = new HashMap<>();
        numberOfBallsByColor.put("red", 3);
        numberOfBallsByColor.put("green", 6);
        numberOfBallsByColor.put("blue", 5);

        System.out.println("Keys: "+numberOfBallsByColor.keySet());
        System.out.println("Values: "+numberOfBallsByColor.values());

        System.out.println("Value of green: "+ numberOfBallsByColor.get("green"));

        // Iterating (Traversing) over HashMap first way:
        for(String key : numberOfBallsByColor.keySet()){
            int numberOfTennisBalls = numberOfBallsByColor.get(key);
            System.out.println("Key is: "+ key + "  value is: "+ numberOfTennisBalls);
        }

        // Iterating (Traversing) over HashMap second way:
        for (Map.Entry<String, Integer> entry : numberOfBallsByColor.entrySet()) {
            System.out.println(entry.getKey()+" => "+entry.getValue());
        }

        // Another way using lambda expression
        numberOfBallsByColor.entrySet().forEach(this::printColorOf);
    }
    private void printColorOf(Map.Entry<String, Integer> entry) {
        System.out.println("lambda Color: "+ entry);
    }

}