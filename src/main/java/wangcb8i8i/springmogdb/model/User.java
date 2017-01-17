package wangcb8i8i.springmogdb.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private int age;
	private String password;
}
