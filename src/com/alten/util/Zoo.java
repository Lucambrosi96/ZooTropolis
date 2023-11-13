package com.alten.util;

import com.alten.exception.EmptySpeciesException;
import com.alten.exception.TailedAnimalsNotFoundException;
import com.alten.exception.WingedAnimalsNotFoundException;
import com.alten.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Zoo {

    private List<Animal> animals;

    public Zoo() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void populateZoo() {
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


    private List<Animal> findAllAnimalsBySpecies(List<Animal> animals, Class<? extends Animal> animalType) {
        return animals.stream().filter(animalType::isInstance).collect(Collectors.toList());
    }

    public Animal findHighestAnimal(Class<? extends Animal> species) throws EmptySpeciesException {
        List<Animal> matchingAnimals = findAllAnimalsBySpecies(animals, species);

        return matchingAnimals.stream().max(Comparator.comparing(Animal::getHeight))
                .orElseThrow(() -> new EmptySpeciesException("There are no animals for the selected species"));
    }

    public Animal findShortestAnimal(Class<? extends Animal> species) throws EmptySpeciesException {
        List<Animal> matchingAnimals = findAllAnimalsBySpecies(animals, species);

        return matchingAnimals.stream().min(Comparator.comparing(Animal::getHeight))
                .orElseThrow(() -> new EmptySpeciesException("There are no animals for the selected species"));
    }

    public Animal findHeaviestAnimal(Class<? extends Animal> species) throws EmptySpeciesException {
        List<Animal> matchingAnimals = findAllAnimalsBySpecies(animals, species);

        return matchingAnimals.stream().max(Comparator.comparing(Animal::getWeight))
                .orElseThrow(() -> new EmptySpeciesException("There are no animals for the selected species"));
    }

    public Animal findLightestAnimal(Class<? extends Animal> species) throws EmptySpeciesException {
        List<Animal> matchingAnimals = findAllAnimalsBySpecies(animals, species);

        return matchingAnimals.stream().min(Comparator.comparing(Animal::getWeight))
                .orElseThrow(() -> new EmptySpeciesException("There are no animals for the selected species"));
    }

    public Animal findLargestWingspanAnimal() throws WingedAnimalsNotFoundException {
        return animals.stream().filter(animal -> animal instanceof WingedAnimal)
                .map(animal -> (WingedAnimal) animal)
                .max(Comparator.comparing(WingedAnimal::getWingspan))
                .orElseThrow(() -> new WingedAnimalsNotFoundException("There are no animals with wing in the zoo"));
    }

    public Animal findLongestTailAnimal() throws TailedAnimalsNotFoundException {
        return animals.stream().filter(animal -> animal instanceof TailedAnimal)
                .map(animal -> (TailedAnimal) animal)
                .max(Comparator.comparing(TailedAnimal::getTailLenght))
                .orElseThrow(() -> new TailedAnimalsNotFoundException("There are no animals with tail in the zoo"));
    }
}