package backend;

import java.util.ArrayList;

public class ProductHomeMade extends Product {

    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

    public ProductHomeMade(String name, double buyPrice, double sellPrice) {
        super(name, buyPrice, sellPrice);
    }

    // Getters ----------------------------------------------------------------
    public ArrayList<Ingredient> getIngredients() {
        return this.ingredients;
    }

    // ------------------------------------------------------------------------
    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void popIngredient(int index) {
        this.ingredients.remove(index);
    }

}
