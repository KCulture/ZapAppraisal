package com.github.KCulture.ZapAppraisal;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZapAppraisal implements CommandLineRunner {

	@Autowired
	public final EmployeeRepository employeeRepository;

	@Autowired
	public final ResponderRepository responderRepository;

	@Autowired
	public ZapAppraisal(EmployeeRepository employeerepository,
	    ResponderRepository responderRepository) {
		this.employeeRepository = employeerepository;
		this.responderRepository = responderRepository;
	}

	public static void main(String[] args) {

		SpringApplication.run(ZapAppraisal.class, args);
		System.out.println("Well, Hello we are ONE");
	}

	public void run(String... args) throws Exception {

		employeeRepository.deleteAll();
		responderRepository.deleteAll();

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

		Responder rep1 = new Responder("r1", "aname", "bname", "a.a@a",
		    Arrays.asList("Q1"), Arrays.asList("A1"));
		Responder rep2 = new Responder("r2", "bname", "cname", "b.b@b",
		    Arrays.asList("Q1"), Arrays.asList("A1"));
		Responder rep3 = new Responder("r3", "ename", "fname", "e.e@e",
		    Arrays.asList("Q1"), Arrays.asList("A1"));
		Responder rep4 = new Responder("r4", "fname", "gname", "f.f@f",
		    Arrays.asList("Q1"), Arrays.asList("A1"));

		employeeRepository.save(emp1);
		employeeRepository.save(emp2);
		responderRepository.save(rep1);
		responderRepository.save(rep2);
		responderRepository.save(rep3);
		responderRepository.save(rep4);
	}

}
