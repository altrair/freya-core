package core.services.db;

import core.entities.Category;
import core.entities.Recipe;
import core.services.HandlerServiceException;
import core.services.RecipesHandlerService;
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
@Repository("recipesHandlerService")
public class DatabaseRecipeHandlerService implements RecipesHandlerService {

  private Logger logger = LoggerFactory.getLogger(DatabaseCategoryHandlerService.class);

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public List<Recipe> getRecipesByName(String name) throws HandlerServiceException {
    try {
      return sessionFactory.getCurrentSession().createCriteria(Recipe.class).
        add(Restrictions.eq("name", name)).list();
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }

  @Override
  public List<Recipe> getRecipesByCategory(Category category) throws HandlerServiceException {
    try {
      return sessionFactory.getCurrentSession().createCriteria(Recipe.class).
        add(Restrictions.eq("id_category", category.getId())).list();
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }

  @Override
  public void save(@Nonnull Recipe recipe) throws HandlerServiceException {
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(recipe);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }

  @Override
  public void remove(@Nonnull Recipe recipe) throws HandlerServiceException {
    try {
      sessionFactory.getCurrentSession().delete(recipe);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }

  @Override
  public Recipe getById(@Nonnull Long id) throws HandlerServiceException {
    try {
      return (Recipe) sessionFactory.getCurrentSession().createCriteria(Recipe.class).
        add(Restrictions.eq("id", id)).uniqueResult();
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }

  @Nonnull
  @Override
  public Collection<Recipe> getAll() throws HandlerServiceException {
    try {
      return sessionFactory.getCurrentSession().createCriteria(Recipe.class).list();
    }catch (Exception e){
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }
}
