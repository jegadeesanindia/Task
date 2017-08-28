import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.Query;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Stock s=new Stock();
		BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			//SessionFactory sf = new Configuration().configure().buildSessionFactory();
			session = sf.openSession();
			System.out.println("1.INSERT\n2.UPDATE\n3.VIEW ALL\n4.DELETE");
			System.out.println("\n\nENTER YOUR CHOICE:");
			int ch=Integer.valueOf(read.readLine());
			if(ch==1)
			{
				session.beginTransaction();
				System.out.println("ENTER ID:");
				s.setProduct_id(Integer.valueOf(read.readLine()));
				System.out.println("ENTER NAME");
				s.setProduct_Name(read.readLine());
				System.out.println("ENTER PRICE");
				s.setPRICE(Double.valueOf(read.readLine()));
				System.out.println("ENTER QUANTITY");
				s.setQuantity(Integer.valueOf(read.readLine()));
				System.out.println("ENTER TAX");
				s.setTax(Double.valueOf(read.readLine()));
				session.save(s);
				session.getTransaction().commit();
				session.close();

			}
			else if(ch==2)
			{
				System.out.println("1.UPADTEID\n2.UPDATENAME\n3.UPDATEPRICE\n");
				System.out.println("\n\nENTER YOUR CHOICE:");
				ch=Integer.valueOf(read.readLine());
				if(ch==1)
				{
					session.beginTransaction();
				 Query query = session.getNamedQuery("p_updateid");  
				    query.setParameter("name", "amit");
				    query.getResultList();
					session.getTransaction().commit();
					session.close();
				}
				else if(ch==2)
				{
					session.beginTransaction();
				 Query query = session.getNamedQuery("p_updatename");  
				    query.setParameter("id", read.readLine());
				    query.setParameter("name", read.readLine());
				    query.getResultList();
					session.getTransaction().commit();
					session.close();
				}
				else if(ch==3)
				{
					session.beginTransaction();
				 Query query = session.getNamedQuery("p_updateprice");  
				    query.setParameter("id", read.readLine());
				    query.setParameter("price", read.readLine());
				    query.getResultList();
					session.getTransaction().commit();
					session.close();
				}
			}
			else if(ch==3)
			{
				Query query=session.createQuery("from TBL_STOCK");
				List<Stock> u=query.getResultList();
				for(Stock i:u)
				{
					System.out.println("ID:"+i.getProduct_id());
					System.out.println("NAME:"+i.getProduct_Name());
					System.out.println("PRICE:"+i.getPRICE());
					System.out.println("TAX:"+i.getTax());
					System.out.println("QUANTITY:"+i.getQuantity());
				}
				session.close();
			}
			else if(ch==4)
			{
				session.beginTransaction();
				Query query=session.getNamedNativeQuery("delete");
				System.out.println("ENTER ID:");
				query.setParameter("id",read.readLine());
				System.out.println(query.getFirstResult());
				session.getTransaction().commit();
				session.close();
				
			}
			else
			{
			break;
			}
			

		}

	}

}
