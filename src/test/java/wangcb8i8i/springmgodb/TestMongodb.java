package wangcb8i8i.springmgodb;

import org.bson.Document;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class TestMongodb {
	@Test
	public void testMongodb() {
		try {
			// 连接到 mongodb 服务
			MongoClient mongoClient = new MongoClient("192.168.24.243", 8899);
			// 根据mongodb数据库的名称获取mongodb对象 ,
			MongoIterable<String> dbNames = mongoClient.listDatabaseNames();
			for (String dbName : dbNames) {
				System.out.println("DB Name:" + dbName);
				MongoDatabase db = mongoClient.getDatabase(dbName);
				MongoIterable<String> cNames = db.listCollectionNames();
				for (String cName : cNames) {
					System.out.println("Collection Name:" + cName);
					MongoCollection<Document> documents = db.getCollection(cName);
					System.out.println("document count:" + documents.count());
					FindIterable<Document> docs = documents.find();
					System.out.println("document detail:");
					for (Document doc : docs)
						System.out.println(doc.toJson());
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
