package com.tmall.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Interceptor;
import org.hibernate.LockMode;
import org.hibernate.ReplicationMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.tmall.dao.impl.DAOImpl;

public class ServiceDelegateDAO {
	@Autowired DAOImpl dao;

	public void afterPropertiesSet() {
		dao.afterPropertiesSet();
	}

	public int bulkUpdate(String queryString, Object... values) throws DataAccessException {
		return dao.bulkUpdate(queryString, values);
	}

	public int bulkUpdate(String queryString, Object value) throws DataAccessException {
		return dao.bulkUpdate(queryString, value);
	}

	public int bulkUpdate(String queryString) throws DataAccessException {
		return dao.bulkUpdate(queryString);
	}

	public void clear() throws DataAccessException {
		dao.clear();
	}

	public void closeIterator(Iterator arg0) throws DataAccessException {
		dao.closeIterator(arg0);
	}

	public boolean contains(Object entity) throws DataAccessException {
		return dao.contains(entity);
	}

	public DataAccessException convertHibernateAccessException(HibernateException ex) {
		return dao.convertHibernateAccessException(ex);
	}

	public void delete(Object entity, LockMode lockMode) throws DataAccessException {
		dao.delete(entity, lockMode);
	}

	public void delete(Object entity) throws DataAccessException {
		dao.delete(entity);
	}

	public void delete(String entityName, Object entity, LockMode lockMode) throws DataAccessException {
		dao.delete(entityName, entity, lockMode);
	}

	public void delete(String entityName, Object entity) throws DataAccessException {
		dao.delete(entityName, entity);
	}

	public void deleteAll(Collection entities) throws DataAccessException {
		dao.deleteAll(entities);
	}

	public Filter enableFilter(String filterName) throws IllegalStateException {
		return dao.enableFilter(filterName);
	}

	public boolean equals(Object obj) {
		return dao.equals(obj);
	}

	public void evict(Object entity) throws DataAccessException {
		dao.evict(entity);
	}

	public <T> T execute(HibernateCallback<T> action) throws DataAccessException {
		return dao.execute(action);
	}

	public List executeFind(HibernateCallback<?> action) throws DataAccessException {
		return dao.executeFind(action);
	}

	public <T> T executeWithNativeSession(HibernateCallback<T> action) {
		return dao.executeWithNativeSession(action);
	}

	public <T> T executeWithNewSession(HibernateCallback<T> action) {
		return dao.executeWithNewSession(action);
	}

	public List find(String queryString, Object... values) throws DataAccessException {
		return dao.find(queryString, values);
	}

	public List find(String queryString, Object value) throws DataAccessException {
		return dao.find(queryString, value);
	}

	public List find(String queryString) throws DataAccessException {
		return dao.find(queryString);
	}

	public List findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults) throws DataAccessException {
		return dao.findByCriteria(criteria, firstResult, maxResults);
	}

	public List findByCriteria(DetachedCriteria criteria) throws DataAccessException {
		return dao.findByCriteria(criteria);
	}

	public List findByExample(Object exampleEntity, int firstResult, int maxResults) throws DataAccessException {
		return dao.findByExample(exampleEntity, firstResult, maxResults);
	}

	public List findByExample(Object exampleEntity) throws DataAccessException {
		return dao.findByExample(exampleEntity);
	}

	public List findByExample(String entityName, Object exampleEntity, int firstResult, int maxResults)
			throws DataAccessException {
		return dao.findByExample(entityName, exampleEntity, firstResult, maxResults);
	}

	public List findByExample(String entityName, Object exampleEntity) throws DataAccessException {
		return dao.findByExample(entityName, exampleEntity);
	}

	public List findByNamedParam(String queryString, String paramName, Object value) throws DataAccessException {
		return dao.findByNamedParam(queryString, paramName, value);
	}

	public List findByNamedParam(String queryString, String[] paramNames, Object[] values) throws DataAccessException {
		return dao.findByNamedParam(queryString, paramNames, values);
	}

	public List findByNamedQuery(String queryName, Object... values) throws DataAccessException {
		return dao.findByNamedQuery(queryName, values);
	}

	public List findByNamedQuery(String queryName, Object value) throws DataAccessException {
		return dao.findByNamedQuery(queryName, value);
	}

	public List findByNamedQuery(String queryName) throws DataAccessException {
		return dao.findByNamedQuery(queryName);
	}

	public List findByNamedQueryAndNamedParam(String queryName, String paramName, Object value)
			throws DataAccessException {
		return dao.findByNamedQueryAndNamedParam(queryName, paramName, value);
	}

	public List findByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] values)
			throws DataAccessException {
		return dao.findByNamedQueryAndNamedParam(queryName, paramNames, values);
	}

	public List findByNamedQueryAndValueBean(String queryName, Object valueBean) throws DataAccessException {
		return dao.findByNamedQueryAndValueBean(queryName, valueBean);
	}

	public List findByValueBean(String queryString, Object valueBean) throws DataAccessException {
		return dao.findByValueBean(queryString, valueBean);
	}

	public void flush() throws DataAccessException {
		dao.flush();
	}

	public <T> T get(Class<T> entityClass, Serializable id, LockMode lockMode) throws DataAccessException {
		return dao.get(entityClass, id, lockMode);
	}

	public <T> T get(Class<T> entityClass, Serializable id) throws DataAccessException {
		return dao.get(entityClass, id);
	}

	public Object get(String entityName, Serializable id, LockMode lockMode) throws DataAccessException {
		return dao.get(entityName, id, lockMode);
	}

	public Object get(String entityName, Serializable id) throws DataAccessException {
		return dao.get(entityName, id);
	}

	public Interceptor getEntityInterceptor() throws IllegalStateException, BeansException {
		return dao.getEntityInterceptor();
	}

	public int getFetchSize() {
		return dao.getFetchSize();
	}

	public String[] getFilterNames() {
		return dao.getFilterNames();
	}

	public int getFlushMode() {
		return dao.getFlushMode();
	}

	public SQLExceptionTranslator getJdbcExceptionTranslator() {
		return dao.getJdbcExceptionTranslator();
	}

	public int getMaxResults() {
		return dao.getMaxResults();
	}

	public String getQueryCacheRegion() {
		return dao.getQueryCacheRegion();
	}

	public SessionFactory getSessionFactory() {
		return dao.getSessionFactory();
	}

	public int hashCode() {
		return dao.hashCode();
	}

	public void initialize(Object arg0) throws DataAccessException {
		dao.initialize(arg0);
	}

	public boolean isAllowCreate() {
		return dao.isAllowCreate();
	}

	public boolean isAlwaysUseNewSession() {
		return dao.isAlwaysUseNewSession();
	}

	public boolean isCacheQueries() {
		return dao.isCacheQueries();
	}

	public boolean isCheckWriteOperations() {
		return dao.isCheckWriteOperations();
	}

	public boolean isExposeNativeSession() {
		return dao.isExposeNativeSession();
	}

	public Iterator iterate(String queryString, Object... values) throws DataAccessException {
		return dao.iterate(queryString, values);
	}

	public Iterator iterate(String queryString, Object value) throws DataAccessException {
		return dao.iterate(queryString, value);
	}

	public Iterator iterate(String queryString) throws DataAccessException {
		return dao.iterate(queryString);
	}

	public <T> T load(Class<T> entityClass, Serializable id, LockMode lockMode) throws DataAccessException {
		return dao.load(entityClass, id, lockMode);
	}

	public <T> T load(Class<T> entityClass, Serializable id) throws DataAccessException {
		return dao.load(entityClass, id);
	}

	public void load(Object entity, Serializable id) throws DataAccessException {
		dao.load(entity, id);
	}

	public Object load(String entityName, Serializable id, LockMode lockMode) throws DataAccessException {
		return dao.load(entityName, id, lockMode);
	}

	public Object load(String entityName, Serializable id) throws DataAccessException {
		return dao.load(entityName, id);
	}

	public <T> List<T> loadAll(Class<T> entityClass) throws DataAccessException {
		return dao.loadAll(entityClass);
	}

	public void lock(Object entity, LockMode lockMode) throws DataAccessException {
		dao.lock(entity, lockMode);
	}

	public void lock(String entityName, Object entity, LockMode lockMode) throws DataAccessException {
		dao.lock(entityName, entity, lockMode);
	}

	public <T> T merge(String entityName, T entity) throws DataAccessException {
		return dao.merge(entityName, entity);
	}

	public <T> T merge(T entity) throws DataAccessException {
		return dao.merge(entity);
	}

	public void persist(Object entity) throws DataAccessException {
		dao.persist(entity);
	}

	public void persist(String entityName, Object entity) throws DataAccessException {
		dao.persist(entityName, entity);
	}

	public void refresh(Object entity, LockMode lockMode) throws DataAccessException {
		dao.refresh(entity, lockMode);
	}

	public void refresh(Object entity) throws DataAccessException {
		dao.refresh(entity);
	}

	public void replicate(Object entity, ReplicationMode replicationMode) throws DataAccessException {
		dao.replicate(entity, replicationMode);
	}

	public void replicate(String entityName, Object entity, ReplicationMode replicationMode)
			throws DataAccessException {
		dao.replicate(entityName, entity, replicationMode);
	}

	public Serializable save(Object entity) throws DataAccessException {
		return dao.save(entity);
	}

	public Serializable save(String entityName, Object entity) throws DataAccessException {
		return dao.save(entityName, entity);
	}

	public void saveOrUpdate(Object entity) throws DataAccessException {
		dao.saveOrUpdate(entity);
	}

	public void saveOrUpdate(String entityName, Object entity) throws DataAccessException {
		dao.saveOrUpdate(entityName, entity);
	}

	public void saveOrUpdateAll(Collection entities) throws DataAccessException {
		dao.saveOrUpdateAll(entities);
	}

	public void setAllowCreate(boolean allowCreate) {
		dao.setAllowCreate(allowCreate);
	}

	public void setAlwaysUseNewSession(boolean alwaysUseNewSession) {
		dao.setAlwaysUseNewSession(alwaysUseNewSession);
	}

	public void setBeanFactory(BeanFactory beanFactory) {
		dao.setBeanFactory(beanFactory);
	}

	public void setCacheQueries(boolean cacheQueries) {
		dao.setCacheQueries(cacheQueries);
	}

	public void setCheckWriteOperations(boolean checkWriteOperations) {
		dao.setCheckWriteOperations(checkWriteOperations);
	}

	public void setEntityInterceptor(Interceptor entityInterceptor) {
		dao.setEntityInterceptor(entityInterceptor);
	}

	public void setEntityInterceptorBeanName(String entityInterceptorBeanName) {
		dao.setEntityInterceptorBeanName(entityInterceptorBeanName);
	}

	public void setExposeNativeSession(boolean exposeNativeSession) {
		dao.setExposeNativeSession(exposeNativeSession);
	}

	public void setFetchSize(int fetchSize) {
		dao.setFetchSize(fetchSize);
	}

	public void setFilterName(String filter) {
		dao.setFilterName(filter);
	}

	public void setFilterNames(String[] filterNames) {
		dao.setFilterNames(filterNames);
	}

	public void setFlushMode(int flushMode) {
		dao.setFlushMode(flushMode);
	}

	public void setFlushModeName(String constantName) {
		dao.setFlushModeName(constantName);
	}

	public void setJdbcExceptionTranslator(SQLExceptionTranslator jdbcExceptionTranslator) {
		dao.setJdbcExceptionTranslator(jdbcExceptionTranslator);
	}

	public void setMaxResults(int maxResults) {
		dao.setMaxResults(maxResults);
	}

	public void setQueryCacheRegion(String queryCacheRegion) {
		dao.setQueryCacheRegion(queryCacheRegion);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		dao.setSessionFactory(sessionFactory);
	}

	public String toString() {
		return dao.toString();
	}

	public void update(Object entity, LockMode lockMode) throws DataAccessException {
		dao.update(entity, lockMode);
	}

	public void update(Object entity) throws DataAccessException {
		dao.update(entity);
	}

	public void update(String entityName, Object entity, LockMode lockMode) throws DataAccessException {
		dao.update(entityName, entity, lockMode);
	}

	public void update(String entityName, Object entity) throws DataAccessException {
		dao.update(entityName, entity);
	}

}
