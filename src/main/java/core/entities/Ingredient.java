package core.entities;


/**
 * Created by Altair on 20.09.2017.
 */
public class Ingredient extends DataObject {

    private String name;
    private long calories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCalories() {
        return calories;
    }

    public void setCalories(long calories) {
        this.calories = calories;
    }

    @Override
    public boolean equals(Object object) {
        if (object != null || object instanceof Ingredient) {
            Ingredient ingredient = (Ingredient) object;
            if (this.getId() != null && ingredient.getId() != null && this.getId().equals(ingredient.getId())) {
                return true;
            }
            if (this.name != null && this.name.equals(ingredient.getName()) && this.calories == ingredient.getCalories()) {
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
            return (int) calories + name.hashCode();
        }

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Ingredient: ");
        builder.append(name).append(", calories: ").append(calories);
        return builder.toString();
    }
}
