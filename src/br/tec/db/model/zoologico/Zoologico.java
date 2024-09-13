package br.tec.db.model.zoologico;

import br.tec.db.model.recinto.Recinto;

import java.util.List;

public class Zoologico {

    private final List<Recinto> recintos;

    public Zoologico(List<Recinto> recintos) {
        this.recintos = recintos;
    }

    public List<Recinto> getRecintos() {
        return recintos;
    }

}
