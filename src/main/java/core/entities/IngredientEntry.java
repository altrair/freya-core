package core.entities;

import java.util.Set;

/**
 * Created by Altair on 20.09.2017.
 */
public class IngredientEntry extends DataObject{

    private Ingredient ingredient;
    private Dimension dimension;
    private double amount;
    private Set<Recipe> recipes;

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object object) {
        if (object != null || object instanceof IngredientEntry) {
            IngredientEntry quantity = (IngredientEntry) object;
            if (this.dimension == quantity.dimension && this.amount == quantity.amount) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder("IngredientEntry: ");
        buffer.append("Ingredient: ").append(ingredient).append("; Amount: ")
          .append(amount).append("; Dimension: ").append(dimension);
        return buffer.toString();
    }

    @Override
    public int hashCode() {
        return (int) (dimension.hashCode() + amount);
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

}
