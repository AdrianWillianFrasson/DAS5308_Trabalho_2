package backend;

import java.util.ArrayList;

public class ProductHomeMade extends Product {

    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

    public ProductHomeMade(String name, String barCode, double sellPrice, int stock) {
        super(name, barCode, sellPrice, stock);
    }

    // Getters ----------------------------------------------------------------
    public ArrayList<Ingredient> getAllIngredients() {
        return this.ingredients;
    }

    // ------------------------------------------------------------------------
    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void popIngredient(int index) {
        this.ingredients.remove(index);
    }

    // ------------------------------------------------------------------------
    public String toString() {
        return String.format(super.toString() + " | Tipo: Proprio");
    }

}
