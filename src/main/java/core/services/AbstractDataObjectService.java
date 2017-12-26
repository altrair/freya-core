package core.services;


import core.entities.DataObject;

import javax.annotation.Nonnull;
import java.util.Collection;

/**
 * @param <T> DataObject subclass
 * @author Sergei_Vasilev
 */
public interface AbstractDataObjectService<T extends DataObject> {

    /**
     * Saving new object to storage or updating existing one
     *
     * @param object Object to save
     * @return saved object with assigned id
     */
    public void save(@Nonnull T object) throws HandlerServiceException;

    /**
     * Removing object from storage
     *
     * @param object Object to remove
     */
    public void remove(@Nonnull T object) throws HandlerServiceException;

    /**
     * Getting object by id from storage
     *
     * @param id id of the object
     * @return Found object or <code>null</code>
     */
    public T getById(@Nonnull Long id) throws HandlerServiceException;

    /**
     * Getting all objects from storage
     *
     * @return collection of objects
     */
    public @Nonnull
    Collection<T> getAll() throws HandlerServiceException;
}
