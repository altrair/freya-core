package core.services;

import core.entities.Category;
import core.entities.Recipe;

import java.util.List;

/**
 * Created by Altair on 20.09.2017.
 */
public interface RecipesHandlerService extends AbstractDataObjectService<Recipe> {


    /**
     * Get all recipes with similar name
     *
     * @param name - name of recipe
     * @return recipes by name
     */
    List<Recipe> getRecipesByName(String name) throws HandlerServiceException;


    /**
     * Get all recipes by special category
     *
     * @param category - name of category
     * @return recipes by name
     */
    List<Recipe> getRecipesByCategory(Category category) throws HandlerServiceException;

}
