package com.alten.main;

import com.alten.exception.CaudatiNonTrovatiException;
import com.alten.exception.VolatiliNonTrovatiException;
import com.alten.model.*;
import com.alten.util.Zoo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws VolatiliNonTrovatiException, CaudatiNonTrovatiException {

        List<Lion> lions = new ArrayList<>();
        List<Tiger> tigers = new ArrayList<>();
        List<Eagle> eagles = new ArrayList<>();
        List<Animal> animals = new ArrayList<>();



        lions.add(new Lion("Simba", "Zebra", 2, LocalDate.of(2023,10,9), 1.50f, 100f, 0.50f));
        lions.add(new Lion("Mufasa", "Bufalo", 8, LocalDate.of(2019,10,10), 2.50f, 200f, 1.00f));
        lions.add(new Lion("Nala", "Zebra", 4, LocalDate.of(2018,10,7), 1.70f, 155.5f, 0.75f));

        tigers.add(new Tiger("Diego", "Gazzella", 1, LocalDate.of(2023,10,10), 1.40f, 50f, 0.20f));
        tigers.add(new Tiger("Red", "Antilope", 5, LocalDate.of(2019,10,6), 1.80f, 150f, 0.50f));
        tigers.add(new Tiger("Black", "Gazzella", 7, LocalDate.of(2020,10,10), 2.00f, 270f, 0.80f));


        eagles.add(new Eagle("Olympia", "Coniglio", 3, LocalDate.of(2019,10,5), 0.75f, 3f, 1.80f));
        eagles.add(new Eagle("Sky", "Coniglio", 3, LocalDate.of(2018,10,3), 0.50f, 4f, 1.60f));
        eagles.add(new Eagle("Blue", "Trota", 4, LocalDate.of(2019,10,10), 0.60f, 2f, 2.15f));

        animals.addAll(lions);
        animals.addAll(tigers);
        animals.addAll(eagles);


        Animal highestLion = Zoo.findHighestAnimal(lions);
        Animal lowestLion = Zoo.findLowestAnimal(lions);
        Animal heaviestLion = Zoo.findHeaviestAnimal(lions);
        Animal lighestLion = Zoo.findLightestAnimal(lions);

        Animal highestTiger = Zoo.findHighestAnimal(tigers);
        Animal lowestTiger = Zoo.findLowestAnimal(tigers);
        Animal heaviestTiger = Zoo.findHeaviestAnimal(tigers);
        Animal lighestTiger = Zoo.findLightestAnimal(tigers);

        Animal highestEagle = Zoo.findHighestAnimal(eagles);
        Animal lowestEagle = Zoo.findLowestAnimal(eagles);
        Animal heaviestEagle = Zoo.findHeaviestAnimal(eagles);
        Animal lighestEagle = Zoo.findLightestAnimal(eagles);

        Animal largestWingspan = Zoo.findLargestWingspanAnimal(animals);

        Animal longestTail = Zoo.findLongestTailAnimal(animals);


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