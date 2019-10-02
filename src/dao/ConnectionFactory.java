package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;

public class ConnectionFactory {
	public Connection getConnection() throws ServletException{
		// TODO Auto-generated constructor stub
		
		try{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection("jdbc:mysql://localhost/automovel", "root", "");
		} catch(Exception e) {
			System.out.println("Não Conectou");
			throw new ServletException(e);
		}
	}
}
