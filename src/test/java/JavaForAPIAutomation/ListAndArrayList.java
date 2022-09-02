package JavaForAPIAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListAndArrayList {



    @Test
    public void arrayListTest(){

        List<Integer> numbers = new ArrayList<>();

        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        numbers.add(2);
        numbers.add(4);
        numbers.add(6);
        numbers.add(7);
        System.out.println("Max Value: "+Collections.min(numbers));

    }


    @Test
    public void sortingStringArrayList(){
        List<String> text = new ArrayList<>();
        text.add("Zaid");
        text.add("Bela");
        text.add("Ahmad");
        text.add("Muhammad");

        System.out.println("Name before sorting: "+text);
        Collections.sort(text);
        System.out.println("Name after sorting: "+text);
    }


    @Test
    public void listOfColors(){

        List<String> myColors = new ArrayList<>();

        myColors.add("Red");
        myColors.add("Blue");
        myColors.add("Black");
        myColors.add("Red");

        // Traversing over the ArrayList using foreach
        for (String color : myColors) {
            System.out.println(color);
        }

        // foreach with condition to not print a specific value (skipping a specific value)
        for (String color:myColors) {
            if(color.equals("Red")){
                // Do not print
            }else {
                System.out.println(color);
            }
        }

        // Traversing over the ArrayList using for
        for(int i=0; i<myColors.size(); i++){
           System.out.println(myColors.get(i));
        }

        int indexOfBlackColor = myColors.indexOf("Black");
        System.out.println("indexOfBlackColor is: "+indexOfBlackColor);

        int indexOfRedColor = myColors.indexOf("Red");
        System.out.println("indexOfRedColor is: "+indexOfRedColor);

        int indexOfSecondRedColor = myColors.lastIndexOf("Red");
        System.out.println("indexOfSecondRedColor is: "+indexOfSecondRedColor);

        Collections.sort(myColors);
        System.out.println("Sorting goes here"+myColors);

        //Assert if Black color exist within the ArrayList (in this case it does exist so it will simply pass)
        Assert.assertTrue(myColors.contains("Black"), "myColors does not contain Black");

        // Assert if Crimson color exist within the ArrayList (in this case it does not so the message will appear indicating that)
        Assert.assertTrue(myColors.contains("Crimson"), "mycolors doesn't contain Crimson");
    }

    @Test // It shows how simple sorting works with strings ans ints
    public void sortingAList(){

        List<String> names = Arrays.asList("Paul", "Anne", "Bell", "Mira", "Anne");
        Collections.sort(names);
        System.out.println(names);

        List<Integer> numbers = Arrays.asList(4,9,5,7,1,3,2);
        Collections.sort(numbers);
        System.out.println(numbers);
    }

    @Test // This is to show how we can get the max value and the min from array consists of numbers
    public void findingMaxAndMin(){
        List<Integer> ages = Arrays.asList(10, 30, 50, 20, 15);
        System.out.println(Collections.max(ages));
        System.out.println(Collections.min(ages));

        List<Integer> agesArrayList = new ArrayList<>();
        agesArrayList.add(10);
        agesArrayList.add(30);
        agesArrayList.add(50);
        agesArrayList.add(20);
        agesArrayList.add(15);

        System.out.println(Collections.max(agesArrayList));
        System.out.println(Collections.min(agesArrayList));

    }


    @Test // This is to show how we can combine two ArrayLists with each other (How to add ArrayList values to another one)
    public void combiningLists(){
        List<String> names = new ArrayList<>();
        names.add("joe");
        names.add("sally");
        names.add("pete");

        System.out.println(names);

        List<String> moreNames = new ArrayList<>();
        moreNames.add("paul");
        moreNames.add("petra");


        System.out.println(moreNames);

        // Here's how we combine them with each other
        names.addAll(moreNames);
        System.out.println(names);

        // Here's how we remove a specific value from them
        names.remove("sally");
        System.out.println(names);

        // Here's how we can get a value by its index within the ArrayList
        System.out.println(names.get(1));

        // Here's how we sort the combined ArrayLists
        System.out.println("names before sorting: "+names);
        Collections.sort(names);
        System.out.println("names after sorting: "+names);

        // Here's how we detach the combined ArrayLists by removing tha added one (moreNames)
        names.removeAll(moreNames);
        System.out.println("names after detaching moreNames : "+names);

    }

}
