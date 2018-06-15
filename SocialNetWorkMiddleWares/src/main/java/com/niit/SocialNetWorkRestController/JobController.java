package com.niit.SocialNetWorkRestController;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SocialNetwork.Dao.JobDAO;
import com.niit.SocialNetwork.model.Job;


@RestController
public class JobController 
{
	@Autowired
	JobDAO jobDAO;
	
	@PostMapping(value="/addJob")
	public ResponseEntity<String> addJob(@RequestBody Job job)
	{
		job.setLastDateApply(new java.util.Date());
		
		if(jobDAO.addJob(job))
		{
			return new ResponseEntity<String>("success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/deleteJob/{jobId}")
	public ResponseEntity<String> deleteJob(@PathVariable("jobId") int jobId)
	{
		Job job=jobDAO.getJob(jobId);
		
		if(jobDAO.deleteJob(job))
		{
			return new ResponseEntity<String>("success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/listJobs")
	public ResponseEntity<List<Job>> listAllJob()
	{
		List<Job> listJobs=jobDAO.listAllJobs();
		
		
			return new ResponseEntity<List<Job>>(listJobs,HttpStatus.OK);
	}
}

	