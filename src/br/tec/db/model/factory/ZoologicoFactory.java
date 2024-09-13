package br.tec.db.model.factory;

import br.tec.db.model.zoologico.Zoologico;

public class ZoologicoFactory {

    private ZoologicoFactory() {

    }

    public static Zoologico criar() {

        return new Zoologico(RecintoFactory.criarRecintos());
    }
}
