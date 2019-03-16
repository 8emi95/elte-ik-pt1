package hu.elte.progtech.zoo;

public enum Species {
    LION,
    FISH;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
