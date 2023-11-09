package com.alten.util;

import com.alten.exception.EmptySpiecesException;
import com.alten.exception.TailedAnimalsNotFoundException;
import com.alten.exception.WingedAnimalsNotFoundException;
import com.alten.model.Animal;
import com.alten.model.TailedAnimal;
import com.alten.model.WingedAnimal;

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
            throw new EmptySpiecesException("There are no animals for the selected spieces");
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
            throw new EmptySpiecesException("There are no animals for the selected spieces");
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
            throw new EmptySpiecesException("There are no animals for the selected spieces");
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
            throw new EmptySpiecesException("There are no animals for the selected spieces");
        }
    }

    public Animal findLargestWingspanAnimal() throws WingedAnimalsNotFoundException {
        Animal largestWingspan = null;

        for (Animal animal : animals) {
            if (animal instanceof WingedAnimal wingedAnimal) { //verifico se animale deriva da Volatile
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



/*public static Volatile trovaAperturaAlareMaggiore(List<Volatile> volatili) {
        Volatile maxAperturaAlare = volatili.get(0);

        for (Volatile vol : volatili) {
            if (vol.getAperturaAlare() > maxAperturaAlare.getAperturaAlare()) {
                maxAperturaAlare = vol;
            }
        }
        return maxAperturaAlare;
    }*/