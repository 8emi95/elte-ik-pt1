package hu.elte.progtech.zoo.food;

public interface FoodConsumer<T extends Food> {
    public void feed(T food);
}
