package com.test.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.test.entities.entity_basic_types.Movie_BasicValueType;

import config.HibernateUtils;

public class Application {
	public static void main(String[] args) {
		try {
			Session session = HibernateUtils.getSessionFactory().openSession();
			
			Movie_BasicValueType movie = new Movie_BasicValueType();
			movie.setId(1);
			movie.setName("Batman");
			movie.setRatings(9.0f);
			movie.setSummery("Good One");
			
			
			//session.save(movie);
			
			session.beginTransaction();
			movie = (Movie_BasicValueType)session.get(Movie_BasicValueType.class, movie.getId());
			movie.setName(null);
			movie.setSummery("Good");
			session.update(movie);
			session.getTransaction().commit();
			
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
