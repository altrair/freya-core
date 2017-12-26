package core.entities;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Set;

/**
 * Created by Altair on 26.09.2017.
 */
public class Category extends DataObject {

    private String name;
    private Set<Recipe> recipes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (object != null || object instanceof Category) {
            Category category = (Category) object;
            if (this.getId() != null && category.getId() != null && this.getId().equals(category.getId())) {
                return true;
            }
            if (this.name != null && this.name.equals(category.getName())) {
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
            return name.hashCode();
        }

    }

    @Override
    public String toString() {
        return "Category: " + name;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
