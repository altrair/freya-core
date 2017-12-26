package core.services;

import core.entities.Place;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Created by Altair on 04.10.2017.
 */
public interface PlacesHandlerService extends AbstractDataObjectService<Place> {

    @Nonnull
    List<Place> getPlacesByName(String name) throws HandlerServiceException;

}
