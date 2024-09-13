package br.tec.db.model.factory;

import br.tec.db.model.animal.Animal;
import br.tec.db.model.animal.Especie;
import br.tec.db.model.shared.Bioma;

import java.util.List;

class AnimalFactory {

    private AnimalFactory() {

    }

    static Animal criar(Especie especie) {

        return new Animal(especie);
    }

}
