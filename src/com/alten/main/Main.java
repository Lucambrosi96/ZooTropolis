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

    public static void main(String[] args) throws WingedAnimalsNotFoundException, TailedAnimalsNotFoundException, EmptySpeciesException {

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


        System.out.println("Il leone più alto è " + highestLion.getName() + ", il leone più basso è "
                + shortestLion.getName() + ", il leone più pesante è " + heaviestLion.getName()
                + ", il leone più leggero è " + lighestLion.getName());

        System.out.println("La tigre più alta è " + highestTiger.getName() + ", la tigre più bassa è "
                + shortestTiger.getName() + ", la tigre più pesante è " + heaviestTiger.getName()
                + ", la tigre più leggera è " + lighestTiger.getName());

        System.out.println("L'aquila più alta è " + highestEagle.getName() + ", l'aquila più bassa è "
                + shortestEagle.getName() + ", l'aquila più pesante è " + heaviestEagle.getName()
                + ", l'aquila più leggera è " + lighestEagle.getName());

        System.out.println("L'animale con l'apertura alare maggiore è " + largestWingspan.getName());

        System.out.println("L'animale con la coda più lunga è " + longestTail.getName());

    }
}