package core.services;

import core.entities.Dimension;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Created by Altair on 20.09.2017.
 */
public interface DimensionHandlerService extends AbstractDataObjectService<Dimension> {
    /**
     * Get all dimensions with similar name
     *
     * @param name - name of dimension
     * @return dimensions by name
     */
    @Nonnull
    List<Dimension> getDimensionsByName(String name) throws HandlerServiceException;

}
