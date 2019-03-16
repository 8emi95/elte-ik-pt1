package CoctailExplorer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Optional;

/**
 *
 * @author Dobreff András
 */
public class CoctailExplorer implements ICoctailExplorer {
    
    private final Set<Coctail> coctails = new HashSet<>();
    
    @Override
    public Optional<Coctail> exploreCoctail(Set<Ingredient> ingredients)
            throws IllegalArgumentException {
        if(ingredients == null || ingredients.size() <= 1)
            throw new IllegalArgumentException("Coctail cannot be explored with"
                    + " less than 2 ingredients");
        
        Optional<Coctail> result = Optional.empty();
        for(Coctail coctail : this.coctails){
            Set<Ingredient> set = new HashSet<>(Arrays.asList(coctail.getIngredients()));
            if(set.equals(ingredients)){
                result = Optional.of(coctail);
                break;
            }
        }
        return result;
    }

    @Override
    public void init(Coctail[] coctails) {
        this.coctails.addAll(Arrays.asList(coctails));
    }

    @Override
    public Set<Ingredient> getAllIngredients() {
        HashSet<Ingredient> allIngredients = new HashSet<>();
        for(Coctail coctail : coctails){
          allIngredients.addAll(Arrays.asList(coctail.getIngredients()));
        }
        return allIngredients;
    }
    
}
