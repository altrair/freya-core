package core.services;

import core.entities.Ingredient;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Created by Altair on 20.09.2017.
 */
public interface IngredientHandlerService extends AbstractDataObjectService<Ingredient> {

    /**
     * Get all ingredients with similar name
     *
     * @param name - name of ingredient
     * @return ingredient by name
     */
    @Nonnull
    List<Ingredient> getIngredientsByName(String name) throws HandlerServiceException;

    /**
     * Get ingredient with similar
     *
     * @param name - name of ingredient
     * @return ingredient by name
     */
    @Nonnull
    Ingredient getIngredient(String name, long calories) throws HandlerServiceException;
}
