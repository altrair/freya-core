package core.entities;

import java.util.Set;

/**
 * Created by Altair on 20.09.2017.
 */
public class Recipe extends DataObject {

    private String name;
    private Category category;
    private Set<IngredientEntry> ingredients;
    private Set<Place> places;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<IngredientEntry> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<IngredientEntry> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object object) {
        if (object != null || object instanceof Recipe) {
            Recipe recipe = (Recipe) object;
            if (this.getId() != null && recipe.getId() != null && this.getId().equals(recipe.getId())) {
                return true;
            }
            if (name != null && name.equals(recipe.getName()) && category != null && category.equals(recipe.category)) {
                for (IngredientEntry entry : ingredients) {
                    if(!recipe.getIngredients().contains(entry)){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (getId() != null) {
            long id = getId();
            return (int) id * 10;
        } else {
            return name.hashCode() + category.hashCode();
        }
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder("Name: ");
        buffer.append(name).append(";\n Category: ").append(category).append('\n');
        for (IngredientEntry entry : ingredients) {
            buffer.append("Ingredient: ").append(entry.getIngredient()).append("; amount: ").append(entry.getAmount())
            .append("; dimension: ").append(entry.getDimension());
        }
        return buffer.toString();
    }

    public Set<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
    }
}
