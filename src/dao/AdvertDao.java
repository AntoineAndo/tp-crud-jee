package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Advert;

public class AdvertDao {
	
		private Connection connexion;
	
		public AdvertDao(){
			try{
				Class.forName("org.hsqldb.jdbcDriver").newInstance();
				connexion = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost", "sa",  "");				
/*
				String query = "CREATE TABLE advert (id INTEGER NOT NULL IDENTITY,title VARCHAR(140) NOT NULL,description VARCHAR(250) NOT NULL,PRIMARY KEY (id))";
				try{
					PreparedStatement preparedStatement = connexion.prepareStatement(query);
					preparedStatement.executeUpdate();
					preparedStatement.close();
				}
				catch(Exception e){
					e.printStackTrace();
				}	
				*/		
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	
		
		
		public List<Advert> getAllAdverts(){
			List<Advert> newList = new ArrayList<Advert>();
			String query = "SELECT * FROM ADVERT";
			try{
				Statement statement = connexion.createStatement();
				ResultSet result = statement.executeQuery(query);
				
				while(result.next()){
					Advert newAdvert = new Advert();
					newAdvert.setId(result.getInt("id"));
					newAdvert.setTitle(result.getString("title"));
					newAdvert.setDescription(result.getString("description"));

					newList.add(newAdvert);
				}
				result.close();
				statement.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return newList;
		}
		
		public Advert getAdvertById(int id){
			String query = "SELECT * FROM ADVERT WHERE id = ?";
			Advert newAdvert = new Advert();
			
			try{
				PreparedStatement preparedStatement = connexion.prepareStatement(query);
				preparedStatement.setInt(1, id);
				ResultSet result = preparedStatement.executeQuery();

				if(result.next()){
					newAdvert.setId(result.getInt("id"));
					newAdvert.setTitle(result.getString("title"));
					newAdvert.setDescription(result.getString("description"));

					result.close();
					preparedStatement.close();
				}
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return newAdvert;
		}
		
		public void deleteAdvert(int id){

			String query = "DELETE FROM ADVERT WHERE id = ?";
			
			try{
				PreparedStatement preparedStatement = connexion.prepareStatement(query);
				preparedStatement.setInt(1, id);
				preparedStatement.executeUpdate();
				preparedStatement.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public void updateAdvert(Advert advert){
			String query = "UPDATE ADVERT SET title = ?, description = ? WHERE id = ?";
			try{
				PreparedStatement preparedStatement = connexion.prepareStatement(query);
				preparedStatement.setString(1, advert.getTitle());
				preparedStatement.setString(2, advert.getDescription());
				preparedStatement.setInt(3, advert.getId());
				preparedStatement.executeUpdate();
				preparedStatement.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public int countAdverts(){
			int count = 0;
			String query = "SELECT COUNT(*) AS kanker FROM ADVERT";
			try{
				Statement statement = connexion.createStatement();
				ResultSet result = statement.executeQuery(query);
				
				if(result.next()){
					count = result.getInt("kanker");
				}
				
				result.close();
				statement.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return count;
		}
		
		public void deleteAll(){
			String query = "DELETE FROM advert";
			try{
				Statement statement = connexion.createStatement();
				statement.executeUpdate(query);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public void addAdvert(Advert advert){
			String query = "INSERT INTO advert (title, description) VALUES (?,?)";
			try{
				PreparedStatement preparedStatement = connexion.prepareStatement(query);
				preparedStatement.setString(1, advert.getTitle());
				preparedStatement.setString(2, advert.getDescription());
				preparedStatement.executeUpdate();
				preparedStatement.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
}

