package hu.elte.progtech.zoo;

public class Zoo {

    public static void main(String args[]) {
        String[] names = new String[3];
        String[] species = new String[3];
        String[] voices = new String[3];

        // add a lion
        names[0] = "Simba";
        species[0] = "lion";
        voices[0] = "meow";

        // add another lion
        names[1] = "Kimba";
        species[1] = "lion";
        voices[1] = "meow";

        // add a fish
        names[2] = "Wanda";
        species[2] = "fish";
        voices[2] = "...";

        for (int i = 0; i < 3; ++i) {
            System.out.print("There is a(n) " + species[i] + " in the zoo, that is called " + names[i]);
            if (voices[i] != "...") {
                System.out.print(" and introduces itself as " + voices[i]);
            }
            System.out.println();
        }
    }

}
