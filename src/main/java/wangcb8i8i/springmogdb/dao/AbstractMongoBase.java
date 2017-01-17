package wangcb8i8i.springmogdb.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public abstract class AbstractMongoBase<T> implements BaseDao<T> {

	@Resource
	protected MongoTemplate mongoTemplate;

	@Override
	public List<T> findAll(Map<String, Object> params, String collectionName) {
		Query query = new Query();
		for (Entry<String, Object> e : params.entrySet()) {
			if (e.getValue() != null)
				query.addCriteria(Criteria.where(e.getKey()).is(e.getValue()));
		}
		return mongoTemplate.find(query, ParameterizedType(0), collectionName);
	}

	@Override
	public T findOne(Map<String, Object> params, String collectionName) {
		return null;
	}

	@SuppressWarnings("unchecked")
	protected Class<T> ParameterizedType(int index) {
		Type superClazz = getClass().getGenericSuperclass();
		while (superClazz instanceof Class && !(superClazz instanceof ParameterizedType))
			superClazz = ((Class<?>) superClazz).getGenericSuperclass();
		if (superClazz instanceof ParameterizedType) {
			Type[] types = ((ParameterizedType) superClazz).getActualTypeArguments();
			if (types != null && types.length > 0) {
				return (Class<T>) types[index];
			}
		}
		return null;
	}

}
