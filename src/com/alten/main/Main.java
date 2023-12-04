package com.alten.main;

import com.alten.model.Animal;
import com.alten.model.Eagle;
import com.alten.model.Lion;
import com.alten.model.Tiger;
import com.alten.util.Zoo;

public class Main {

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.populateZoo();
        processZooQueries(zoo);

    }
    //test git
    public static void processZooQueries(Zoo zoo) {

        Lion highestLion = zoo.findHighestAnimal(Lion.class);
        System.out.println("The highest lion is " + highestLion.getName());

        Lion shortestLion = zoo.findShortestAnimal(Lion.class);
        System.out.println("The shortest lion is " + shortestLion.getName());

        Lion heaviestLion = zoo.findHeaviestAnimal(Lion.class);
        System.out.println("The heaviest lion is " + heaviestLion.getName());

        Lion lightestLion = zoo.findLightestAnimal(Lion.class);
        System.out.println("The lightest lion is " + lightestLion.getName());

        Tiger highestTiger = zoo.findHighestAnimal(Tiger.class);
        System.out.println("The highest tiger is " + highestTiger.getName());

        Tiger shortestTiger = zoo.findShortestAnimal(Tiger.class);
        System.out.println("The shortest tiger is " + shortestTiger.getName());

        Tiger heaviestTiger = zoo.findHeaviestAnimal(Tiger.class);
        System.out.println("The heaviest tiger is " + heaviestTiger.getName());

        Tiger lightestTiger = zoo.findLightestAnimal(Tiger.class);
        System.out.println("The lightest tiger is " + lightestTiger.getName());

        Eagle highestEagle = zoo.findHighestAnimal(Eagle.class);
        System.out.println("The highest eagle is " + highestEagle.getName());

        Eagle shortestEagle = zoo.findShortestAnimal(Eagle.class);
        System.out.println("The shortest eagle is " + shortestEagle.getName());

        Eagle heaviestEagle = zoo.findHeaviestAnimal(Eagle.class);
        System.out.println("The heaviest eagle is " + heaviestEagle.getName());

        Eagle lightestEagle = zoo.findLightestAnimal(Eagle.class);
        System.out.println("The lightest eagle is " + lightestEagle.getName());

        Animal largestWingspan = zoo.findLargestWingspanAnimal();
        System.out.println("The animal with the largest wingspan is " + largestWingspan.getName());

        Animal longestTail = zoo.findLongestTailAnimal();
        System.out.println("The animal with the longest tail is " + longestTail.getName());

    }
}