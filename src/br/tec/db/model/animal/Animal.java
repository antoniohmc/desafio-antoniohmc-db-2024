package br.tec.db.model.animal;

public class Animal {

    private final Especie especie;

    public Animal(Especie especie) {
        this.especie = especie;
    }

    public Especie getEspecie() {
        return especie;
    }

}
