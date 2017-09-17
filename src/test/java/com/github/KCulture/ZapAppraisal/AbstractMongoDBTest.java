package com.github.KCulture.ZapAppraisal;

import java.util.Arrays;
import java.util.Date;

import junit.framework.TestCase;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ZapAppraisal.class })
public abstract class AbstractMongoDBTest extends TestCase {

	/**
	 * please store Starter or RuntimeConfig in a static final field if you want
	 * to use artifact store caching (or else disable caching)
	 */

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ResponderRepository responderRepository;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	protected void makeEmployees() {

		Employee emp1 = new Employee("e1", "Blue", "One", new Date(), "a@b.c",
		    Arrays.asList(
		        new Responder("r1", "aname", "bname", "a.a@a", Arrays.asList("Q1"),
		            Arrays.asList("A1")), new Responder("r2", "bname", "cname",
		            "b.b@b", Arrays.asList("Q1"), Arrays.asList("A1"))), 1,
		    Arrays.asList("blessed", "faithful"), "2017", Arrays.asList("Q1"),
		    Arrays.asList("A1"));
		Employee emp2 = new Employee("e2", "Green", "Two", new Date(), "b@c.d",
		    Arrays.asList(
		        new Responder("r3", "ename", "fname", "e.e@e", Arrays.asList("Q1"),
		            Arrays.asList("A1")), new Responder("r4", "fname", "gname",
		            "f.f@f", Arrays.asList("Q1"), Arrays.asList("A1"))), 1,
		    Arrays.asList("blessed", "faithful"), "2017", Arrays.asList("Q1"),
		    Arrays.asList("A1"));
		employeeRepository.save(emp1);
		employeeRepository.save(emp2);
		return;
	}

	protected void makeResponders() {
		Responder rep1 = new Responder("r1", "aname", "bname", "a.a@a",
		    Arrays.asList("Q1"), Arrays.asList("A1"));
		Responder rep2 = new Responder("r2", "bname", "cname", "b.b@b",
		    Arrays.asList("Q1"), Arrays.asList("A1"));
		Responder rep3 = new Responder("r3", "ename", "fname", "e.e@e",
		    Arrays.asList("Q1"), Arrays.asList("A1"));
		Responder rep4 = new Responder("r4", "fname", "gname", "f.f@f",
		    Arrays.asList("Q1"), Arrays.asList("A1"));
		responderRepository.save(rep1);
		responderRepository.save(rep2);
		responderRepository.save(rep3);
		responderRepository.save(rep4);
		return;
	}

}
