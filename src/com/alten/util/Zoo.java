package com.alten.util;

import com.alten.exception.CaudatiNonTrovatiException;
import com.alten.exception.VolatiliNonTrovatiException;
import com.alten.model.Animale;
import com.alten.model.Caudato;
import com.alten.model.Volatile;

import java.util.List;

public class Zoo {
    //lista generica -> qualsiasi tipo che sia sottotipo di Animale
    public static Animale trovaPiuAlto(List<? extends Animale> animali) {
        Animale piuAlto = animali.get(0);

        for (Animale animale : animali) {
            if (animale.getAltezza() > piuAlto.getAltezza()) {
                piuAlto = animale;
            }
        }
        return piuAlto;
    }


    public static Animale trovaPiuBasso(List<? extends Animale> animali) {
        Animale piuBasso = animali.get(0);

        for (Animale animale : animali) {
            if (animale.getAltezza() < piuBasso.getAltezza()) {
                piuBasso = animale;
            }
        }
        return piuBasso;
    }

    public static Animale trovaPiuPesante(List<? extends Animale> animali) {
        Animale piuPesante = animali.get(0);

        for (Animale animale : animali) {
            if (animale.getPeso() > piuPesante.getPeso()) {
                piuPesante = animale;
            }
        }
        return piuPesante;
    }

    public static Animale trovaPiuLeggero(List<? extends Animale> animali) {
        Animale piuLeggero = animali.get(0);

        for (Animale animale : animali) {
            if (animale.getPeso() < piuLeggero.getPeso()) {
                piuLeggero = animale;
            }
        }
        return piuLeggero;
    }

    public static Animale trovaAnimaleConAperturaAlareMaggiore(List<Animale> animali) throws VolatiliNonTrovatiException {
        Animale animaleConAperturaAlareMaggiore = null;

        for (Animale animale : animali) {
            if (animale instanceof Volatile vol) { //verifico se animale deriva da Volatile
                if (animaleConAperturaAlareMaggiore == null || vol.getAperturaAlare() >
                        ((Volatile) animaleConAperturaAlareMaggiore).getAperturaAlare()) ;
                {
                    animaleConAperturaAlareMaggiore = animale;
                }
            }
        }
        if (animaleConAperturaAlareMaggiore != null) {
            return animaleConAperturaAlareMaggiore;
        } else {
            throw new VolatiliNonTrovatiException("Non ci sono volatili nello zoo");
        }
    }

    public static Animale trovaAnimaleConCodaPiuLunga(List<Animale> animali) throws CaudatiNonTrovatiException {
        Animale animaleConCodaPiuLunga = null;

        for (Animale animale : animali) {
            if (animale instanceof Caudato caudato) {
                if (animaleConCodaPiuLunga == null || caudato.getLunghezzaCoda() > ((Caudato) animaleConCodaPiuLunga).getLunghezzaCoda()) {
                    animaleConCodaPiuLunga = animale;
                }
            }
        }
        if (animaleConCodaPiuLunga != null) {
            return animaleConCodaPiuLunga;
        } else {
            throw new CaudatiNonTrovatiException("Non ci sono animali con la coda nello zoo");
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