
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
	
}
