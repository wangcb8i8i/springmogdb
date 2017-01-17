package wangcb8i8i.springmogdb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import wangcb8i8i.springmogdb.dao.support.UserDao;
import wangcb8i8i.springmogdb.model.User;

public class TestUser {

	private static UserDao userDaoImpl1;
	private static ClassPathXmlApplicationContext appContext;
	private static String collectionName;

	@BeforeClass
	public static void initSpring() {
		try {
			appContext = new ClassPathXmlApplicationContext(new String[] { "classpath:Spring.xml" });
			userDaoImpl1 = (UserDao) appContext.getBean("userDaoImpl1");
			collectionName = "users";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAdd() {

		// 添加一百个user
//		for (int i = 0; i < 100; i++) {
//			User user = new User();
//			user.setId("" + i);
//			user.setAge(i);
//			user.setName("zcy" + i);
//			user.setPassword("zcy" + i);
//			userDaoImpl1.insert(user, collectionName);
//		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("age", 50);
		List<User> list = userDaoImpl1.findAll(params, collectionName);
		for (User user : list) {
			System.out.println(user);
		}
		System.out.println("user.count()==" + list.size());
	}
}