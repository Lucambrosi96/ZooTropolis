package com.alten.util;

import com.alten.exception.CaudatiNonTrovatiException;
import com.alten.exception.VolatiliNonTrovatiException;
import com.alten.model.Animal;
import com.alten.model.TailedAnimal;
import com.alten.model.WingedAnimal;

import java.util.List;

public class Zoo {
    //lista generica -> qualsiasi tipo che sia sottotipo di Animale
    public static Animal findHighestAnimal(List<? extends Animal> animals) {
        Animal highest = animals.get(0);

        for (Animal animal : animals) {
            if (animal.getHeight() > highest.getHeight()) {
                highest = animal;
            }
        }
        return highest;
    }


    public static Animal findLowestAnimal(List<? extends Animal> animals) {
        Animal lowest = animals.get(0);

        for (Animal animal : animals) {
            if (animal.getHeight() < lowest.getHeight()) {
                lowest = animal;
            }
        }
        return lowest;
    }

    public static Animal findHeaviestAnimal(List<? extends Animal> animals) {
        Animal heaviest = animals.get(0);

        for (Animal animal : animals) {
            if (animal.getWeight() > heaviest.getWeight()) {
                heaviest = animal;
            }
        }
        return heaviest;
    }

    public static Animal findLightestAnimal(List<? extends Animal> animals) {
        Animal lightest = animals.get(0);

        for (Animal animal : animals) {
            if (animal.getWeight() < lightest.getWeight()) {
                lightest = animal;
            }
        }
        return lightest;
    }

    public static Animal findLargestWingspanAnimal(List<Animal> animals) throws VolatiliNonTrovatiException {
        Animal largestWingspan = null;

        for (Animal animal : animals) {
            if (animal instanceof WingedAnimal wingedAnimal) { //verifico se animale deriva da Volatile
                if (largestWingspan == null || wingedAnimal.getWingspan() >
                        ((WingedAnimal) largestWingspan).getWingspan()) ;
                {
                    largestWingspan = animal;
                }
            }
        }
        if (largestWingspan != null) {
            return largestWingspan;
        } else {
            throw new VolatiliNonTrovatiException("There are no animals with wings in the zoo");
        }
    }

    public static Animal findLongestTailAnimal(List<Animal> animali) throws CaudatiNonTrovatiException {
        Animal longestTail = null;

        for (Animal animal : animali) {
            if (animal instanceof TailedAnimal tailedAnimal) {
                if (longestTail == null || tailedAnimal.getTailLenght() > ((TailedAnimal) longestTail).getTailLenght()) {
                    longestTail = animal;
                }
            }
        }
        if (longestTail != null) {
            return longestTail;
        } else {
            throw new CaudatiNonTrovatiException("There are no animals with tails in the zoo");
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