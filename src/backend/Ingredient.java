package backend;

public class Ingredient {

    private String name = "";

    private double carbohydrates = 0.0;
    private double saturatedFat = 0.0;
    private double proteins = 0.0;
    private double calories = 0.0;

    public Ingredient(String name, double carbohydrates, double saturatedFat, double proteins, double calories) {
        this.setName(name);
        this.setCarbohydrates(carbohydrates);
        this.setSaturatedFat(saturatedFat);
        this.setProteins(proteins);
        this.setCalories(calories);
    }

    // Getters ----------------------------------------------------------------
    public String getName() {
        return this.name;
    }

    public double getCarbohydrates() {
        return this.carbohydrates;
    }

    public double getSaturatedFat() {
        return this.saturatedFat;
    }

    public double getProteins() {
        return this.proteins;
    }

    public double getCalories() {
        return this.calories;
    }

    // Setters ----------------------------------------------------------------
    public void setName(String name) {
        this.name = name;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public void setSaturatedFat(double saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

}
