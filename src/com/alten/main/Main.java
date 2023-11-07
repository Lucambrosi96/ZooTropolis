package com.alten.main;

import com.alten.exception.CaudatiNonTrovatiException;
import com.alten.exception.VolatiliNonTrovatiException;
import com.alten.model.*;
import com.alten.util.Zoo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws VolatiliNonTrovatiException, CaudatiNonTrovatiException {

        List<Leone> leoni = new ArrayList<>();
        List<Tigre> tigri = new ArrayList<>();
        List<Aquila> aquile = new ArrayList<>();
        List<Animale> animali = new ArrayList<>();

        leoni.add(new Leone("Simba", "Zebra", 2, "20-03-2023", 1.50f, 100f, 0.50f));
        leoni.add(new Leone("Mufasa", "Bufalo", 8, "05-11-2019", 2.50f, 200f, 1.00f));
        leoni.add(new Leone("Nala", "Zebra", 4, "09-01-2021", 1.70f, 155.5f, 0.75f));

        tigri.add(new Tigre("Diego", "Gazzella", 1, "20-03-2023", 1.40f, 50f, 0.20f));
        tigri.add(new Tigre("Red", "Antilope", 5, "20-03-2023", 1.80f, 150f, 0.50f));
        tigri.add(new Tigre("Black", "Gazzella", 7, "20-03-2023", 2.00f, 270f, 0.80f));


        aquile.add(new Aquila("Olympia", "Coniglio", 3, "20-03-2023", 0.75f, 3f, 1.80f));
        aquile.add(new Aquila("Sky", "Coniglio", 3, "20-03-2023", 0.50f, 4f, 1.60f));
        aquile.add(new Aquila("Blue", "Trota", 4, "20-03-2023", 0.60f, 2f, 2.15f));

        animali.addAll(leoni);
        animali.addAll(tigri);
        animali.addAll(aquile);


        Animale leonePiuAlto = Zoo.trovaPiuAlto(leoni);
        Animale leonePiuBasso = Zoo.trovaPiuBasso(leoni);
        Animale leonePiuPesante = Zoo.trovaPiuPesante(leoni);
        Animale leonePiuLeggero = Zoo.trovaPiuLeggero(leoni);

        Animale tigrePiuAlta = Zoo.trovaPiuAlto(tigri);
        Animale tigrePiuBassa = Zoo.trovaPiuBasso(tigri);
        Animale tigrePiuPesante = Zoo.trovaPiuPesante(tigri);
        Animale tigrePiuLeggera = Zoo.trovaPiuLeggero(tigri);

        Animale aquilaPiuAlta = Zoo.trovaPiuAlto(aquile);
        Animale aquilaPiuBassa = Zoo.trovaPiuBasso(aquile);
        Animale aquilaPiuPesante = Zoo.trovaPiuPesante(aquile);
        Animale aquilaPiuLeggera = Zoo.trovaPiuLeggero(aquile);

        Animale aperturaAlareMaggiore = Zoo.trovaAnimaleConAperturaAlareMaggiore(animali);

        Animale codaPiuLunga = Zoo.trovaAnimaleConCodaPiuLunga(animali);


        System.out.println("Il leone più alto è " + leonePiuAlto.getNome() + ", il leone più basso è "
                + leonePiuBasso.getNome() + ", il leone più pesante è " + leonePiuPesante.getNome()
                + ", il leone più leggero è " + leonePiuLeggero.getNome());

        System.out.println("La tigre più alta è " + tigrePiuAlta.getNome() + ", la tigre più bassa è "
                + tigrePiuBassa.getNome() + ", la tigre più pesante è " + tigrePiuPesante.getNome()
                + ", la tigre più leggera è " + tigrePiuLeggera.getNome());

        System.out.println("L'aquila più alta è " + aquilaPiuAlta.getNome() + ", l'aquila più bassa è "
                + aquilaPiuBassa.getNome() + ", l'aquila più pesante è " + aquilaPiuPesante.getNome()
                + ", l'aquila più leggera è " + aquilaPiuLeggera.getNome());

        System.out.println("L'animale con l'apertura alare maggiore è " + aperturaAlareMaggiore.getNome());

        System.out.println("L'animale con la coda più lunga è " + codaPiuLunga.getNome());

    }
}