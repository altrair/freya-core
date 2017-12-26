package core.services.db;

import core.entities.Dimension;
import core.services.DimensionHandlerService;
import core.services.HandlerServiceException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.List;

/**
 * Created by Altair on 21.12.2017.
 */
@Transactional
@Repository("dimensionHandlerService")
public class DatabaseDimensionHandlerService implements DimensionHandlerService {

    private Logger logger = LoggerFactory.getLogger(DatabaseDimensionHandlerService.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Nonnull
    @Override
    public List<Dimension> getDimensionsByName(String name) throws HandlerServiceException {
        try {
            return sessionFactory.getCurrentSession().createCriteria(Dimension.class).
              add(Restrictions.eq("name", name)).list();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new HandlerServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void save(@Nonnull Dimension dimension) throws HandlerServiceException {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(dimension);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new HandlerServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void remove(@Nonnull Dimension dimension) throws HandlerServiceException {
        try {
            sessionFactory.getCurrentSession().delete(dimension);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new HandlerServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Dimension getById(@Nonnull Long id) throws HandlerServiceException {
        try {
            return (Dimension) sessionFactory.getCurrentSession().createCriteria(Dimension.class).
              add(Restrictions.eq("id", id)).uniqueResult();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new HandlerServiceException(e.getMessage(), e);
        }
    }

    @Nonnull
    @Override
    public Collection<Dimension> getAll() throws HandlerServiceException {
        try {
            return sessionFactory.getCurrentSession().createCriteria(Dimension.class).list();
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new HandlerServiceException(e.getMessage(), e);
        }
    }
}
