package hu.elte.progtech.zoo.food;

import hu.elte.progtech.zoo.animal.Animal;

public abstract class Carnivore extends Animal implements FoodConsumer<Animal> {

    public Carnivore(String name) {
        super(name);
    }

    @Override
    public void feed(Animal f) {
        feed();
    }

}
