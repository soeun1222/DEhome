package com.green.dehome;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyBatisConnectionTest {

	@Inject
	private SqlSessionFactory sessionFactory;

	@Test
	public void testFactory() {
		System.out.println("\n >>>>>>>> sqlFactory 출력 : " + sessionFactory);
	}
	
	@Test
	public void testSession() throws Exception {
		try (SqlSession session = sessionFactory.openSession()){
			System.out.println("\n >>>>>>>>> session 출력 : " + session + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
