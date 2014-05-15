package com.cv.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cv.model.School;
/**
 * DAO Interface Implementation for School.
 * @author Smitha
 *
 */
@Repository
public class SchoolDAOImpl implements SchoolDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<School> listSchool() {
		List<School> schools = sessionFactory.getCurrentSession().createQuery("from School").list();		
		return schools;
	}
}
