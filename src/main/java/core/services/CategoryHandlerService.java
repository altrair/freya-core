package core.services;

import core.entities.Category;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Created by Altair on 20.09.2017.
 */
public interface CategoryHandlerService extends AbstractDataObjectService<Category> {

    /**
     * Get all categories with similar name
     *
     * @param name - name of category
     * @return categories by name
     */
    @Nonnull
    List<Category> getCategoriesByName(String name) throws HandlerServiceException;

}
