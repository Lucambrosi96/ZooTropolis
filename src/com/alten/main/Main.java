package com.alten.main;

import com.alten.exception.EmptySpiecesException;
import com.alten.exception.TailedAnimalsNotFoundException;
import com.alten.exception.WingedAnimalsNotFoundException;
import com.alten.model.Animal;
import com.alten.model.Eagle;
import com.alten.model.Lion;
import com.alten.model.Tiger;
import com.alten.util.Zoo;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws WingedAnimalsNotFoundException, TailedAnimalsNotFoundException, EmptySpiecesException {

        Zoo zoo = new Zoo();

        zoo.addAnimal(new Lion("Simba", "Zebra", 2, LocalDate.of(2023, 10, 9), 1.50f, 100f, 0.50f));
        zoo.addAnimal(new Lion("Mufasa", "Bufalo", 8, LocalDate.of(2019, 10, 10), 2.50f, 200f, 1.00f));
        zoo.addAnimal(new Lion("Nala", "Zebra", 4, LocalDate.of(2018, 10, 7), 1.70f, 155.5f, 0.75f));

        zoo.addAnimal(new Tiger("Diego", "Gazzella", 1, LocalDate.of(2023, 10, 10), 1.40f, 50f, 0.20f));
        zoo.addAnimal(new Tiger("Red", "Antilope", 5, LocalDate.of(2019, 10, 6), 1.80f, 150f, 0.50f));
        zoo.addAnimal(new Tiger("Black", "Gazzella", 7, LocalDate.of(2020, 10, 10), 2.00f, 270f, 0.80f));

        zoo.addAnimal(new Eagle("Olympia", "Coniglio", 3, LocalDate.of(2019, 10, 5), 0.75f, 3f, 1.80f));
        zoo.addAnimal(new Eagle("Sky", "Coniglio", 3, LocalDate.of(2018, 10, 3), 0.50f, 4f, 1.60f));
        zoo.addAnimal(new Eagle("Blue", "Trota", 4, LocalDate.of(2019, 10, 10), 0.60f, 2f, 2.15f));

        Animal highestLion = zoo.findHighestAnimal(Lion.class);
        Animal lowestLion = zoo.findLowestAnimal(Lion.class);
        Animal heaviestLion = zoo.findHeaviestAnimal(Lion.class);
        Animal lighestLion = zoo.findLightestAnimal(Lion.class);

        Animal highestTiger = zoo.findHighestAnimal(Tiger.class);
        Animal lowestTiger = zoo.findLowestAnimal(Tiger.class);
        Animal heaviestTiger = zoo.findHeaviestAnimal(Tiger.class);
        Animal lighestTiger = zoo.findLightestAnimal(Tiger.class);

        Animal highestEagle = zoo.findHighestAnimal(Eagle.class);
        Animal lowestEagle = zoo.findLowestAnimal(Eagle.class);
        Animal heaviestEagle = zoo.findHeaviestAnimal(Eagle.class);
        Animal lighestEagle = zoo.findLightestAnimal(Eagle.class);

        Animal largestWingspan = zoo.findLargestWingspanAnimal();

        Animal longestTail = zoo.findLongestTailAnimal();


        System.out.println("Il leone più alto è " + highestLion.getName() + ", il leone più basso è "
                + lowestLion.getName() + ", il leone più pesante è " + heaviestLion.getName()
                + ", il leone più leggero è " + lighestLion.getName());

        System.out.println("La tigre più alta è " + highestTiger.getName() + ", la tigre più bassa è "
                + lowestTiger.getName() + ", la tigre più pesante è " + heaviestTiger.getName()
                + ", la tigre più leggera è " + lighestTiger.getName());

        System.out.println("L'aquila più alta è " + highestEagle.getName() + ", l'aquila più bassa è "
                + lowestEagle.getName() + ", l'aquila più pesante è " + heaviestEagle.getName()
                + ", l'aquila più leggera è " + lighestEagle.getName());

        System.out.println("L'animale con l'apertura alare maggiore è " + largestWingspan.getName());

        System.out.println("L'animale con la coda più lunga è " + longestTail.getName());

    }
}