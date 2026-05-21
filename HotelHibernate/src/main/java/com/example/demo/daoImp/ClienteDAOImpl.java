package com.example.demo.daoImp;

import com.example.demo.dao.IClienteDAO;
import com.example.demo.entities.Cliente;
import com.example.demo.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ClienteDAOImpl implements IClienteDAO {

	@Override
	public List<Cliente> findAll() {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			return s.createQuery("FROM Cliente", Cliente.class).list();
		}
	}

	@Override
	public List<Cliente> findByHabitacion(String habitacion) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			return s.createQuery("FROM Cliente c WHERE c.habitacion = :habitacion", Cliente.class)
					.setParameter("habitacion", habitacion).list();
		}
	}

	@Override
	public Cliente findById(Long id) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			return s.get(Cliente.class, id);
		}
	}

	@Override
	public void save(Cliente c) {
		Transaction tx = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			tx = s.beginTransaction();
			s.saveOrUpdate(c);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			throw ex;
		}
	}

	@Override
	public void delete(Long id) {
		Transaction tx = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			tx = s.beginTransaction();
			Cliente c = s.get(Cliente.class, id);
			if (c != null)
				s.delete(c);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			throw ex;
		}
	}
}