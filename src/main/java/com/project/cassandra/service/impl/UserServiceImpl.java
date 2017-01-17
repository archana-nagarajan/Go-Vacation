package com.project.cassandra.service.impl;

import com.project.cassandra.model.User;
import com.project.cassandra.service.UserService;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;


@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static Cluster cluster;
	private static Session session;
	
	static{
		cluster = Cluster.builder().addContactPoints("127.0.0.1","127.0.0.2","127.0.0.3").build();
		session = cluster.connect("govacation");
	}

	public void saveUserDetails(User user) {
		ResultSet rs=session.execute("select * from user_details where email=?",user.getEmail());
		System.out.println(user.getEmail());
		Row row = rs.one();
		if(row==null){
			System.out.println("new user");
			PreparedStatement statement = session.prepare("INSERT INTO user_details" + "(email,firstName,imageUrl,lastName)"+ "VALUES (?,?,?,?);");
			BoundStatement boundStatement = new BoundStatement(statement);
			session.execute(boundStatement.bind(user.getEmail(), user.getFirstName(), user.getImageUrl(), user.getLastName()));
		}
	}
}
