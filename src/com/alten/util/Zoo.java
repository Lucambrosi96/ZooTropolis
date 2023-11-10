package com.alten.util;

import com.alten.exception.EmptySpiecesException;
import com.alten.exception.TailedAnimalsNotFoundException;
import com.alten.exception.WingedAnimalsNotFoundException;
import com.alten.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private List<Animal> animals;

    public Zoo() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void populateZoo(){
        addAnimal(new Lion("Simba", "Zebra", 2, LocalDate.of(2023, 10, 9), 1.50f, 100f, 0.50f));
        addAnimal(new Lion("Mufasa", "Bufalo", 8, LocalDate.of(2019, 10, 10), 2.50f, 200f, 1.00f));
        addAnimal(new Lion("Nala", "Zebra", 4, LocalDate.of(2018, 10, 7), 1.70f, 155.5f, 0.75f));

        addAnimal(new Tiger("Diego", "Gazzella", 1, LocalDate.of(2023, 10, 10), 1.40f, 50f, 0.20f));
        addAnimal(new Tiger("Red", "Antilope", 5, LocalDate.of(2019, 10, 6), 1.80f, 150f, 0.50f));
        addAnimal(new Tiger("Black", "Gazzella", 7, LocalDate.of(2020, 10, 10), 2.00f, 270f, 0.80f));

        addAnimal(new Eagle("Olympia", "Coniglio", 3, LocalDate.of(2019, 10, 5), 0.75f, 3f, 1.80f));
        addAnimal(new Eagle("Sky", "Coniglio", 3, LocalDate.of(2018, 10, 3), 0.50f, 4f, 1.60f));
        addAnimal(new Eagle("Blue", "Trota", 4, LocalDate.of(2019, 10, 10), 0.60f, 2f, 2.15f));
    }

    public List<Animal> findSpecies(List<Animal> animals, Class<? extends Animal> animalType) {
        List<Animal> speciesList = new ArrayList<>();
        for (Animal animal : animals) {
            if (animalType.isInstance(animal)) {
                speciesList.add(animal);
            }
        }
        return speciesList;
    }

    public Animal findHighestAnimal(Class<? extends Animal> species) throws EmptySpiecesException {
        List<Animal> selectedSpecies = findSpecies(animals, species);

        if (!selectedSpecies.isEmpty()) {
            Animal highest = selectedSpecies.get(0);

            for (Animal animal : selectedSpecies) {
                if (animal.getHeight() > highest.getHeight()) {
                    highest = animal;
                }
            }
            return highest;
        } else {
            throw new EmptySpiecesException("There are no animals for the selected species");
        }
    }

    public Animal findLowestAnimal(Class<? extends Animal> species) throws EmptySpiecesException {
        List<Animal> selectedSpecies = findSpecies(animals, species);

        if (!selectedSpecies.isEmpty()) {
            Animal lowest = selectedSpecies.get(0);

            for (Animal animal : selectedSpecies) {
                if (animal.getHeight() < lowest.getHeight()) {
                    lowest = animal;
                }
            }
            return lowest;
        } else {
            throw new EmptySpiecesException("There are no animals for the selected species");
        }
    }

    public Animal findHeaviestAnimal(Class<? extends Animal> species) throws EmptySpiecesException {
        List<Animal> selectedSpecies = findSpecies(animals, species);

        if (!selectedSpecies.isEmpty()) {
            Animal heaviest = selectedSpecies.get(0);

            for (Animal animal : selectedSpecies) {
                if (animal.getWeight() > heaviest.getWeight()) {
                    heaviest = animal;
                }
            }
            return heaviest;
        } else {
            throw new EmptySpiecesException("There are no animals for the selected species");
        }
    }

    public Animal findLightestAnimal(Class<? extends Animal> species) throws EmptySpiecesException {
        List<Animal> selectedSpecies = findSpecies(animals, species);

        if (!selectedSpecies.isEmpty()) {
            Animal lightest = selectedSpecies.get(0);

            for (Animal animal : selectedSpecies) {
                if (animal.getWeight() < lightest.getWeight()) {
                    lightest = animal;
                }
            }
            return lightest;
        } else {
            throw new EmptySpiecesException("There are no animals for the selected species");
        }
    }

    public Animal findLargestWingspanAnimal() throws WingedAnimalsNotFoundException {
        Animal largestWingspan = null;

        for (Animal animal : animals) {
            if (animal instanceof WingedAnimal wingedAnimal) {
                if (largestWingspan == null || wingedAnimal.getWingspan() >
                        ((WingedAnimal) largestWingspan).getWingspan()) {
                    largestWingspan = animal;
                }
            }
        }
        if (largestWingspan != null) {
            return largestWingspan;
        } else {
            throw new WingedAnimalsNotFoundException("There are no animals with wings in the zoo");
        }
    }

    public Animal findLongestTailAnimal() throws TailedAnimalsNotFoundException {
        Animal longestTail = null;

        for (Animal animal : animals) {
            if (animal instanceof TailedAnimal tailedAnimal) {
                if (longestTail == null || tailedAnimal.getTailLenght() > ((TailedAnimal) longestTail).getTailLenght()) {
                    longestTail = animal;
                }
            }
        }
        if (longestTail != null) {
            return longestTail;
        } else {
            throw new TailedAnimalsNotFoundException("There are no animals with tails in the zoo");
        }
    }
}