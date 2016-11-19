package it.alfasoft.viviana.dao;

import hibernateUtil.HibernateUtil;
import it.alfasoft.viviana.model.Fattura;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FatturaDao {
	
	//1-Create
		public boolean creaFattura(Fattura f) {
			boolean bool=false;

			Session session =HibernateUtil.openSession();
			Transaction tx=null;

			try{
				tx=session.getTransaction();
				tx.begin();

				session.persist(f);
				bool=true;

				tx.commit();
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}

			return bool;
		}




		//2-Trova fattura per id
		public Fattura trovaFatturaId(long id_f)
		{
			Fattura f=null;
			Session session =HibernateUtil.openSession();
			Transaction tx=null;

			try{
				tx=session.getTransaction();
				tx.begin();


				Query query= session.createQuery("from Fattura where id_fattura=:id");
				query.setLong("id", id_f);
				f=(Fattura) query.uniqueResult();

				tx.commit();
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}
			return f;
		}

		
		
		//2-Trova fattura per codice
				public Fattura trovaFatturaCodice(String codice)
				{
					Fattura f=null;
					Session session =HibernateUtil.openSession();
					Transaction tx=null;

					try{
						tx=session.getTransaction();
						tx.begin();


						Query query= session.createQuery("from Fattura where codiceCliente=:cod");
						query.setString("cod", codice);
						f=(Fattura) query.uniqueResult();

						tx.commit();
					}catch(Exception ex){
						tx.rollback();
					}finally{
						session.close();
					}
					return f;
				}

		
		
		
		
		//metodo per leggere tutte le fatture
		@SuppressWarnings("unchecked")
		public List<Fattura> getTutteLeFatture()
		{
			List<Fattura> fatture= new ArrayList<Fattura>();
			
			
			
			Session session =HibernateUtil.openSession();
			
			Transaction tx=null;

			try{
			tx=session.getTransaction();
			tx.begin();

			Query query= session.createQuery("from Fattura");
			fatture=query.list();
			
			 tx.commit();
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}
			return fatture;
		}

		
		
		
		// 5- Update 

				public boolean aggiornaFattura(Fattura f){
					boolean res=false;
					Session session=HibernateUtil.openSession();
					Transaction tx=null;

					try{

						tx=session.getTransaction();

						tx.begin();
						session.update(f); 


						tx.commit(); 
						res=true;
					}catch(Exception ex){

						tx.rollback();


					}finally{
						session.close();
					}



					return res;

				}

		
		
		//5-Delete
		public boolean rimuoviFattura(Fattura f) {
			boolean bool=false;

			Session session =HibernateUtil.openSession();
			Transaction tx=null;

			try{
				tx=session.getTransaction();
				tx.begin();
				
				session.delete(f);
				bool=true;

				tx.commit();
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}

			return bool;
		}


}
