package hu.elte.progtech.zoo.animal;

public enum Species {
    LION,
    FISH;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
