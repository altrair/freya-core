package core.services.db;

import core.entities.Category;
import core.services.CategoryHandlerService;
import core.services.HandlerServiceException;
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
@Repository("categoryHandlerService")
public class DatabaseCategoryHandlerService implements CategoryHandlerService {

  private Logger logger = LoggerFactory.getLogger(DatabaseCategoryHandlerService.class);

  @Autowired
  private SessionFactory sessionFactory;

  @Nonnull
  @Override
  public List<Category> getCategoriesByName(String name) throws HandlerServiceException {
    try {
      return sessionFactory.getCurrentSession().createCriteria(Category.class).
        add(Restrictions.eq("name", name)).list();
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }

  @Override
  public void save(@Nonnull Category category) throws HandlerServiceException {
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(category);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }

  @Override
  public void remove(@Nonnull Category category) throws HandlerServiceException {
    try {
      sessionFactory.getCurrentSession().delete(category);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }

  @Override
  public Category getById(@Nonnull Long id) throws HandlerServiceException {
    try {
      return (Category) sessionFactory.getCurrentSession().createCriteria(Category.class).
        add(Restrictions.eq("id", id)).uniqueResult();
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }

  @Nonnull
  @Override
  public Collection<Category> getAll() throws HandlerServiceException {
    try {
      return sessionFactory.getCurrentSession().createCriteria(Category.class).list();
    }catch (Exception e){
      logger.error(e.getMessage(), e);
      throw new HandlerServiceException(e.getMessage(), e);
    }
  }
}
