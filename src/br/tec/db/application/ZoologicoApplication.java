package br.tec.db.application;

import br.tec.db.model.animal.Animal;
import br.tec.db.model.animal.Especie;
import br.tec.db.model.factory.ZoologicoFactory;
import br.tec.db.service.RecintoService;

import java.util.Arrays;
import java.util.Scanner;

public class ZoologicoApplication {

    private static final RecintoService recintoService = new RecintoService();

    public static void main(String[] args) {

        while (true) {
            try {
                var scanner = new Scanner(System.in);
                var zoologico = ZoologicoFactory.criar();

                System.out.println("Informe o tipo de animal: ");
                System.out.println(Arrays.toString(Especie.values()));
                var animal = scanner.next();

                System.out.println("Informe a quantidade: ");
                var quantidade = scanner.nextInt();

                var especie = Especie.validarAnimal(animal);
                var animalFiltrado = new Animal(especie);
                var result = recintoService.incluirAnimais(zoologico.getRecintos(), animalFiltrado, quantidade);

                System.out.println(result);

            } catch (RuntimeException exception) {
                System.out.println("\nErro: " + exception.getMessage() + "\n");
            }
        }
    }
}
