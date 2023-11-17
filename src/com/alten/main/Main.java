package com.alten.main;

import com.alten.exception.EmptySpeciesException;
import com.alten.exception.TailedAnimalsNotFoundException;
import com.alten.exception.WingedAnimalsNotFoundException;
import com.alten.model.Animal;
import com.alten.model.Eagle;
import com.alten.model.Lion;
import com.alten.model.Tiger;
import com.alten.util.Zoo;

public class Main {

    public static void main(String[] args) {

        try {
            Zoo zoo = new Zoo();
            zoo.populateZoo();

            Animal highestLion = zoo.findHighestAnimal(Lion.class);
            Animal shortestLion = zoo.findShortestAnimal(Lion.class);
            Animal heaviestLion = zoo.findHeaviestAnimal(Lion.class);
            Animal lighestLion = zoo.findLightestAnimal(Lion.class);

            Animal highestTiger = zoo.findHighestAnimal(Tiger.class);
            Animal shortestTiger = zoo.findShortestAnimal(Tiger.class);
            Animal heaviestTiger = zoo.findHeaviestAnimal(Tiger.class);
            Animal lighestTiger = zoo.findLightestAnimal(Tiger.class);

            Animal highestEagle = zoo.findHighestAnimal(Eagle.class);
            Animal shortestEagle = zoo.findShortestAnimal(Eagle.class);
            Animal heaviestEagle = zoo.findHeaviestAnimal(Eagle.class);
            Animal lighestEagle = zoo.findLightestAnimal(Eagle.class);

            Animal largestWingspan = zoo.findLargestWingspanAnimal();

            Animal longestTail = zoo.findLongestTailAnimal();


            System.out.println("The highest lion is " + highestLion.getName() + ", the shortest lion is "
                    + shortestLion.getName() + ", the heaviest lion is " + heaviestLion.getName()
                    + ", the lighest lion is " + lighestLion.getName());

            System.out.println("The highest tiger is " + highestTiger.getName() + ", the shortest tiger is "
                    + shortestTiger.getName() + ", the heaviest lion is " + heaviestTiger.getName()
                    + ", the lighest tiger is " + lighestTiger.getName());

            System.out.println("The highest eagle is " + highestEagle.getName() + ", the shortest eagle is "
                    + shortestEagle.getName() + ", the heaviest lion is " + heaviestEagle.getName()
                    + ", the lighest eagle is " + lighestEagle.getName());

            System.out.println("The animal with the largest wingspan is " + largestWingspan.getName());

            System.out.println("The animal with the longest tail is " + longestTail.getName());

        } catch (EmptySpeciesException | WingedAnimalsNotFoundException | TailedAnimalsNotFoundException e) {
            e.printStackTrace();
        }

    }
}