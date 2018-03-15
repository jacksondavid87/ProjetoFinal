package repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import model.Recarga;


public class Recargas implements Serializable {

	private static final long serialVersionUID = 1223665118234259624L;
	
	@Inject
	private EntityManager manager;
	
	public Recarga porRec_codigo(Long rec_codigo) {
		return manager.find(Recarga.class, rec_codigo);
	}
	
	public List<Recarga> todas() {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Recarga.class);
		//Criteria criteria = criarCriteria();
		//Criteria criteria = session.createCriteria(Recarga.class);
		criteria.addOrder(Order.asc("rec_codigo"));
		return criteria.list();
		//return manager.createQuery("from Recarga", Recarga.class).getResultList();
	}
	
	public Recarga guardar(Recarga recarga) {
		return manager.merge(recarga);
	}
	
	public void remover(Recarga recarga) {
		recarga = porRec_codigo(recarga.getRec_codigo());
		manager.remove(recarga);
	}
	

}
