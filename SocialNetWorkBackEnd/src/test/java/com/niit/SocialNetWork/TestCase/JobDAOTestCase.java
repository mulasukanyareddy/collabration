package com.niit.SocialNetWork.TestCase;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SocialNetwork.Dao.JobDAO;
import com.niit.SocialNetwork.model.Job;



public class JobDAOTestCase 
{
	static JobDAO jobDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		jobDAO=(JobDAO)context.getBean("jobDAO");
	}
	
	
	@Test
	public void addTestCase()
	{
		Job job=new Job();
		
		job.setJobDesignation("Project Lead");
		job.setJobDesc("Need to maintain Team with different technologies");
		job.setCompany("SkyInformatica");
		job.setCompany("SkyInformatica");
		job.setSalary(60000);
		job.setLastDateApply(new java.util.Date());
		
		assertTrue("Problem in Adding Job",jobDAO.addJob(job));
	}
	/*
	@Test 
	public void deleteJobTestCase()
	{
		Job job=jobDAO.getJob(952);
		
		assertTrue("Problem in Deletion",jobDAO.deleteJob(job));
	}
	@Ignore
	@Test 
	public void updateJobTestCase()
	{
		Job job=jobDAO.getJob(953);
		
		job.setJobDesignation("Developer");
		job.setSalary(43000);
		
		assertTrue("Problem in Deletion",jobDAO.updateJob(job));
	}
	@Test
	public void listJobs()
	{
		List<Job> listJobs=jobDAO.listAllJobs();
		assertNotNull("Problem in listing Job",listJobs);
		
		for(Job job:listJobs)
		{
			System.out.println("Job Design:"+job.getJobDesignation());
			System.out.println("job Desc"+job.getJobDesc());
		}
	}
*/
}
