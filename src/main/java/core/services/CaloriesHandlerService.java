package core.services;

import core.entities.Recipe;

/**
 * Created by Altair on 04.10.2017.
 */
public interface CaloriesHandlerService {

    /**
     * Calculate calories in special recipe
     *
     * @param recipe - recipe, which calories method is going to calculate
     * @return calories
     */
    public long getCaloriesFromRecipe(Recipe recipe) throws HandlerServiceException;


}
