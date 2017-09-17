package com.github.KCulture.ZapAppraisal;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ZapAppraisal.class })
public class ZapAppraisalTest extends AbstractMongoDBTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ResponderRepository responderRepository;

	/**
	 * please store Starter or RuntimeConfig in a static final field if you want
	 * to use artifact store caching (or else disable caching)
	 */

	@Before
	public void setup() throws Exception {
		super.setUp();
		makeEmployees();
		makeResponders();
		// // collection.insert(Arrays.asList(new BasicDBObject(emps)));
		// collection.insert(Arrays.asList(new BasicDBObject(contacts)));
	}

	@After
	public void teardown() throws Exception {
		super.tearDown();
	}

	@Test
	public void findEmployeeById() {
		Employee testDBObj = employeeRepository.findOne("e1");
		assertTrue("Blue".equals(testDBObj.firstName));
	}

	@Test
	public void findResponderById() {
		Employee testDBObj = employeeRepository.findOne("e1");
		assertTrue("Blue".equals(testDBObj.firstName));
	}

	@Test
	public void findResponderByPropertyExp() {
		List<Employee> testDBObj = employeeRepository.findByContactsEmail("e.e@e");
		assertTrue("Green".equals(testDBObj.get(0).firstName));
	}
}