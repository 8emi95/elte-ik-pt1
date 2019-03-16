package hu.elte.progtech.zoo;

public class Zoo {

    public static void main(String args[]) {
        Animal[] animals = new Animal[3];

        animals[0] = new Animal("Simba", "lion", "meow");
        animals[1] = new Animal("Kimba", "lion", "meow");
        animals[2] = new Animal("Wanda", "fish", "...");

        for (int i = 0; i < 3; ++i) {
            System.out.print("There is a(n) " + animals[i].getSpecies() + " in the zoo, that is called " + animals[i].getName());
            if (animals[i].getVoice() != "...") {
                System.out.print(" and introduces itself as " + animals[i].getVoice());
            }
            System.out.println();
            System.out.println(animals[i]);
        }
    }

}
