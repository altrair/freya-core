package core.entities;

import java.util.Set;

/**
 * Created by Altair on 04.10.2017.
 */
public class Place extends DataObject {

    private String name;
    private int rate;
    private Set<Recipe> menu;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Set<Recipe> getMenu() {
        return menu;
    }

    public void setMenu(Set<Recipe> menu) {
        this.menu = menu;
    }

    @Override
    public boolean equals(Object object) {
        if (object != null || object instanceof Place) {
            Place place = (Place) object;
            if (this.getId() != null && place.getId() != null && this.getId().equals(place.getId())) {
                return true;
            }

            if (this.name != null && this.name.equals(place.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder("Place name: ");
        buffer.append(name).append(";\n Rate: ").append(rate).append('\n');
        for (Recipe recipe : menu) {
            buffer.append("Recipe: ").append(recipe.toString()).append('\n');
        }
        return buffer.toString();
    }

    @Override
    public int hashCode() {
        if (getId() != null) {
            long id = getId();
            return (int) id * 10;
        } else {
            return name.hashCode();
        }
    }
}
