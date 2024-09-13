package br.tec.db.model.animal;

import br.tec.db.model.shared.Bioma;

import java.util.Arrays;
import java.util.List;

import static br.tec.db.model.shared.Bioma.FLORESTA;
import static br.tec.db.model.shared.Bioma.RIO;
import static br.tec.db.model.shared.Bioma.SAVANA;

public enum Especie {

    LEAO(3, true, List.of(SAVANA)),
    CROCODILO(3, true, List.of(RIO)),
    LEOPARDO(2, true, List.of(SAVANA)),
    HIPOPOTAMO(3, false, List.of(RIO)),
    GAZELA(2, false, List.of(RIO, SAVANA)),
    MACACO(1, false, List.of(FLORESTA, SAVANA));

    private final int tamanho;
    private final boolean carnivoro;
    private final List<Bioma> biomas;

    Especie(int tamanho, boolean carnivoro, List<Bioma> biomas) {
        this.biomas = biomas;
        this.tamanho = tamanho;
        this.carnivoro = carnivoro;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean isCarnivoro() {
        return carnivoro;
    }

    public List<Bioma> getBiomas() {
        return biomas;
    }

    public static Especie validarAnimal(String animal) {

        return Arrays.stream(Especie.values())
                .filter(especie -> animal.equalsIgnoreCase(especie.name()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Animal inválido"));
    }
}