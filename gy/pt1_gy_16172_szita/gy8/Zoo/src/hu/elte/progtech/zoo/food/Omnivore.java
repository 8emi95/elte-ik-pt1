package hu.elte.progtech.zoo.food;

import hu.elte.progtech.zoo.animal.Animal;

public abstract class Omnivore extends Animal implements FoodConsumer<Food> {

    public Omnivore(String name) {
        super(name);
    }

    @Override
    public void feed(Food f) {
        feed();
    }

}
