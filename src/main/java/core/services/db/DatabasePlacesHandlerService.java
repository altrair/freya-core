package core.services.db;

import core.entities.Place;
import core.services.HandlerServiceException;
import core.services.PlacesHandlerService;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.List;

/**
 * Created by Sergei_Vasilev.
 */
@Transactional
@Repository("placesHandlerService")
public class DatabasePlacesHandlerService implements PlacesHandlerService {

  private Logger logger = LoggerFactory.getLogger(DatabaseCategoryHandlerService.class);

  @Autowired
  private SessionFactory sessionFactory;

  @Nonnull
  @Override
  public List<Place> getPlacesByName(String name) throws HandlerServiceException {
    try {
      return sessionFactory.getCurrentSession().createCriteria(Place.class).
        add(Restrictions.eq("name", name)).list();
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }

  @Override
  public void save(@Nonnull Place place) throws HandlerServiceException {
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(place);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }

  @Override
  public void remove(@Nonnull Place place) throws HandlerServiceException {
    try {
      sessionFactory.getCurrentSession().delete(place);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }

  @Override
  public Place getById(@Nonnull Long id) throws HandlerServiceException {
    try {
      return (Place) sessionFactory.getCurrentSession().createCriteria(Place.class).
        add(Restrictions.eq("id", id)).uniqueResult();
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }

  @Nonnull
  @Override
  public Collection<Place> getAll() throws HandlerServiceException {
    try {
      return sessionFactory.getCurrentSession().createCriteria(Place.class).list();
    }catch (Exception e){
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }
}
