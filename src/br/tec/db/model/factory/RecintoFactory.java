package br.tec.db.model.factory;

import br.tec.db.model.recinto.Recinto;

import java.util.List;

import static br.tec.db.model.animal.Especie.GAZELA;
import static br.tec.db.model.animal.Especie.LEAO;
import static br.tec.db.model.animal.Especie.MACACO;
import static br.tec.db.model.shared.Bioma.FLORESTA;
import static br.tec.db.model.shared.Bioma.RIO;
import static br.tec.db.model.shared.Bioma.SAVANA;

class RecintoFactory {

    private RecintoFactory() {

    }

    static List<Recinto> criarRecintos() {

        return List.of(criarSavanaHerbivora(), criarFloresta(), criarSavanaRio(), criarRio(), criarSavanaCarnivora());
    }

    private static Recinto criarSavanaHerbivora() {

        var macaco = AnimalFactory.criar(MACACO);

        return new Recinto(1, 10, List.of(SAVANA), List.of(macaco, macaco, macaco));
    }

    private static Recinto criarFloresta() {

        return new Recinto(2, 5, List.of(FLORESTA), List.of());
    }

    private static Recinto criarSavanaRio() {

        var gazela = AnimalFactory.criar(GAZELA);

        return new Recinto(3, 7, List.of(SAVANA, RIO), List.of(gazela));
    }

    private static Recinto criarRio() {

        return new Recinto(4, 8, List.of(RIO), List.of());
    }

    private static Recinto criarSavanaCarnivora() {

        var leao = AnimalFactory.criar(LEAO);

        return new Recinto(5, 9, List.of(SAVANA), List.of(leao));
    }

}
