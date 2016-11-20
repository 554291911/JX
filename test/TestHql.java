
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import edu.xupt.entites.Candidate;
import edu.xupt.entites.Week;

public class TestHql {

	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
	
	@Test
	@Transactional
	public void findTalent(){
		String hql = "from Candidate c left join c.weeks w where w.id = 1";
		Session session = sessionFactory.openSession();
		List<Object> list = session.createQuery(hql).list();
        Iterator it=list.iterator(); 
        List<Candidate> candidateList = new ArrayList<Candidate>();
		while( it.hasNext()){   
            Object[] obj=(Object[])it.next();   
            Candidate c=(Candidate)obj[0];   
            System.out.println(c.getCustomer());
            candidateList.add(c);
		}   
		session.close();
	}
	
	@Test
	@Transactional
	public void getByLastWeek(){
//		String hql = "SELECT top 1 * FROM Week w WHERE user_id = 6 ORDER BY w.id desc";
		Session session = sessionFactory.openSession();
		Week week=(Week)session.createQuery("from Week w where user_id= 6 order by w.id desc ").setFirstResult(0).setMaxResults(1).uniqueResult();
//		List<Object> list = session.createQuery(hql).list();
//        Iterator it=list.iterator(); 
//        List<Week> candidateList = new ArrayList<Week>();
//		while(it.hasNext()){   
//            Object[] obj=(Object[])it.next();   
//            Week w=(Week)obj[0];   
//            System.out.println(w.getName());
//            candidateList.add(w);
//		}   
		System.out.println(week);
		System.out.println(week.getStatus());
		session.close();
	}
	
}
