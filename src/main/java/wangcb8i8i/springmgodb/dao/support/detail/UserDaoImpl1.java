package wangcb8i8i.springmgodb.dao.support.detail;

import java.util.Map;

import org.springframework.stereotype.Repository;

import wangcb8i8i.springmgodb.dao.AbstractMongoBase;
import wangcb8i8i.springmgodb.dao.support.UserDao;
import wangcb8i8i.springmgodb.model.User;

@Repository("userDaoImpl1")
public class UserDaoImpl1 extends AbstractMongoBase<User> implements UserDao {

	@Override
	public void insert(User object, String collectionName) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(Map<String, Object> params, String collectionName) {
		// TODO Auto-generated method stub
	}

	@Override
	public void createCollection(String collectionName) {
		// TODO Auto-generated method stub
	}

	@Override
	public void remove(Map<String, Object> params, String collectionName) {
		// TODO Auto-generated method stub
	}

}
