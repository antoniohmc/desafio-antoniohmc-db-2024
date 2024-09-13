package br.tec.db.model.recinto;

import br.tec.db.model.animal.Animal;
import br.tec.db.model.shared.Bioma;

import java.util.List;

public class Recinto {

    private final int numero;
    private final int tamanho;
    private final List<Bioma> bioma;
    private final List<Animal> animaisExistentes;

    public Recinto(int numero, int tamanho, List<Bioma> bioma, List<Animal> animaisExistentes) {
        this.bioma = bioma;
        this.numero = numero;
        this.tamanho = tamanho;
        this.animaisExistentes = animaisExistentes;
    }

    public int getNumero() {
        return numero;
    }

    public int getTamanho() {
        return tamanho;
    }

    public List<Bioma> getBioma() {
        return bioma;
    }

    public List<Animal> getAnimaisExistentes() {
        return animaisExistentes;
    }

    public boolean validarCompatibilidade(Animal animal, int quantidade) {

        if (validarBioma(animal) && validarHabitoAlimentar(animal))
            return validarEspaco(animal, quantidade);

        return false;
    }

    private boolean validarBioma(Animal animal) {

        for (int i = 0; i < animal.getEspecie().getBiomas().size(); i++) {

            if (this.bioma.contains(animal.getEspecie().getBiomas().get(i)))

                return true;
        }

        return false;
    }

    private boolean validarHabitoAlimentar(Animal animal) {

        if (validarCarnivoroMesmaEspecie(animal)) {
            return true;

        } else return !validarCarnivoroComEspecieHerbivora(animal);
    }

    private boolean validarCarnivoroMesmaEspecie(Animal animal) {

        return animal.getEspecie().isCarnivoro() && validarMesmaEspecie(animal);
    }

    private boolean validarCarnivoroComEspecieHerbivora(Animal animal) {

        return animal.getEspecie().isCarnivoro()
                && this.animaisExistentes
                .stream()
                .anyMatch(animalExistente -> !animalExistente.getEspecie().isCarnivoro());
    }


    private boolean validarEspaco(Animal animal, int quantidade) {

        var espacoOcupado = calcularEspacoOcupado();

        return calcularEspacoComNovoAnimal(animal, quantidade, espacoOcupado) <= this.tamanho;
    }

    private int calcularEspacoOcupado() {

        var total = 0;

        for (int i = 0; i < this.getAnimaisExistentes().size(); i++) {
            total += this.getAnimaisExistentes().get(i).getEspecie().getTamanho();
        }

        return total;
    }

    private int calcularEspacoComNovoAnimal(Animal animal, int quantidade, int espacoOcupado) {

        if (validarMesmaEspecie(animal))
            return (animal.getEspecie().getTamanho() * quantidade) + espacoOcupado;

        return (animal.getEspecie().getTamanho() * quantidade + 1) + espacoOcupado;
    }

    private boolean validarMesmaEspecie(Animal animal) {

        return this.animaisExistentes
                .stream()
                .allMatch(animalExistente -> animalExistente.getEspecie().equals(animal.getEspecie()));
    }
}