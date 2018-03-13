package com.test.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.test.entities.associations.many_to_many.Students_Bidirectional;
import com.test.entities.associations.many_to_many.Students_Unidirectional;
import com.test.entities.associations.many_to_many.Teacher;
import com.test.entities.associations.many_to_many.Teacher_Bidirectional;
import com.test.entities.associations.one_to_many.Pencil;
import com.test.entities.associations.one_to_many.PencilBox_UniDirectional;
import com.test.entities.associations.one_to_many.Smartphone;
import com.test.entities.associations.one_to_many.Teenager_JoinTable;
import com.test.entities.associations.one_to_one.Address;
import com.test.entities.associations.one_to_one.Person_OneToOneUnidirectional;
import com.test.entities.associations.one_to_one.User_OneToOneBidirectional;
import com.test.entities.associations.one_to_one.VoterCard;
import com.test.entities.entity_basic_types.Address_Embeddable;
import com.test.entities.entity_basic_types.Employee_CompositeValueType;
import com.test.entities.entity_basic_types.Movie_BasicValueType;
import com.test.entities.entity_basic_types.Office_CollectionValueType;
import com.test.entities.entity_basic_types.Person_CollectionValueType;
import com.test.entities.entity_basic_types.Student_CollectionBasicValueType;
import com.test.entities.entity_basic_types.User_CollectionMapValueType;
import com.test.new_annotations.FormulaTest;
import com.test.new_annotations.TemporalTest;
import com.test.new_annotations.TransientTest;

import config.HibernateUtils;

public class TestHibernate {
	public static void main(String[] args) {
		try {
			Students_Unidirectional s = new Students_Unidirectional();
			s.setAge(23);
			s.setName("Blake");
			
			Teacher t = new Teacher();
			t.setName("Ryder");
			t.setSubject("Phy");
			
			Set<Teacher> set = new HashSet<>();
			set.add(t);
			
			s.setList(set);
			
			SessionFactory factory = HibernateUtils.getSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();
			session.save(s);
			session.getTransaction().commit();
			
			session.close();
			factory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

