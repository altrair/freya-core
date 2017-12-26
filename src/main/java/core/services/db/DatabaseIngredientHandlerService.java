package core.services.db;

import core.entities.Ingredient;
import core.services.HandlerServiceException;
import core.services.IngredientHandlerService;
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
@Repository("ingredientHandlerService")
public class DatabaseIngredientHandlerService implements IngredientHandlerService {

  private Logger logger = LoggerFactory.getLogger(DatabaseIngredientHandlerService.class);

  @Autowired
  private SessionFactory sessionFactory;

  @Nonnull
  @Override
  public List<Ingredient> getIngredientsByName(String name) throws HandlerServiceException {
    try {
      return sessionFactory.getCurrentSession().createCriteria(Ingredient.class).
        add(Restrictions.eq("name", name)).list();
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }

  @Nonnull
  @Override
  public Ingredient getIngredient(String name, long calories) throws HandlerServiceException {
    try {
      return (Ingredient) sessionFactory.getCurrentSession().createCriteria(Ingredient.class).
        add(Restrictions.eq("name", name)).add(Restrictions.eq("calories", calories)).uniqueResult();
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }

  @Override
  public void save(@Nonnull Ingredient ingredient) throws HandlerServiceException {
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(ingredient);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }

  @Override
  public void remove(@Nonnull Ingredient ingredient) throws HandlerServiceException {
    try {
      sessionFactory.getCurrentSession().delete(ingredient);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }

  @Override
  public Ingredient getById(@Nonnull Long id) throws HandlerServiceException {
    try {
      return (Ingredient) sessionFactory.getCurrentSession().createCriteria(Ingredient.class).
        add(Restrictions.eq("id", id)).uniqueResult();
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }

  @Nonnull
  @Override
  public Collection<Ingredient> getAll() throws HandlerServiceException {
    try {
      return sessionFactory.getCurrentSession().createCriteria(Ingredient.class).list();
    }catch (Exception e){
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }
}
