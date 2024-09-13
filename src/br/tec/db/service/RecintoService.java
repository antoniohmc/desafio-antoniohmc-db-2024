package br.tec.db.service;

import br.tec.db.model.animal.Animal;
import br.tec.db.model.recinto.Recinto;

import java.util.List;

public class RecintoService {

    public List<Boolean> incluirAnimais(List<Recinto> recintos, Animal animal, int quantidade) throws RuntimeException {

        return recintos.stream()
                .map(recinto -> recinto.validarCompatibilidade(animal, quantidade))
                .toList();
    }
}
