package com.niit.SocialNetwork.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.SocialNetwork.Dao.BlogDAO;
import com.niit.SocialNetwork.Dao.BlogDAOImpl;
import com.niit.SocialNetwork.Dao.ForumDAO;
import com.niit.SocialNetwork.Dao.ForumDAOImpl;
import com.niit.SocialNetwork.Dao.FriendDAO;
import com.niit.SocialNetwork.Dao.FriendDAOImpl;
import com.niit.SocialNetwork.Dao.JobDAO;
import com.niit.SocialNetwork.Dao.JobDAOImpl;
import com.niit.SocialNetwork.Dao.ProfilePictureDAO;
import com.niit.SocialNetwork.Dao.ProfilePictureDAOImpl;
import com.niit.SocialNetwork.Dao.UserDetailDAO;
import com.niit.SocialNetwork.Dao.UserDetailDAOImpl;
import com.niit.SocialNetwork.model.Blog;
import com.niit.SocialNetwork.model.BlogComment;
import com.niit.SocialNetwork.model.Forum;
import com.niit.SocialNetwork.model.Friend;
import com.niit.SocialNetwork.model.Job;
import com.niit.SocialNetwork.model.ProfilePicture;
import com.niit.SocialNetwork.model.UserDetail;


@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class HibernetContextConfig 
{
	
	//1.Data Source Object
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("colladb");
		dataSource.setPassword("sukanya");
		return dataSource;
	}
	
	//2.Create SessionFactory Bean
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		
		Properties hibernateProp=new Properties();
		//hibernateProp.put("hibernate.hbmddl2.auto","update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		
		LocalSessionFactoryBuilder sessionFactoryBuilder=new LocalSessionFactoryBuilder(getDataSource());
		sessionFactoryBuilder.addProperties(hibernateProp);
		
		sessionFactoryBuilder.addAnnotatedClass(Blog.class);
		sessionFactoryBuilder.addAnnotatedClass(BlogComment.class);
		sessionFactoryBuilder.addAnnotatedClass(UserDetail.class);
		sessionFactoryBuilder.addAnnotatedClass(Job.class);
		sessionFactoryBuilder.addAnnotatedClass(ProfilePicture.class);
		sessionFactoryBuilder.addAnnotatedClass(Friend.class);
		sessionFactoryBuilder.addAnnotatedClass(Forum.class);
		
		SessionFactory sessionFactory=sessionFactoryBuilder.buildSessionFactory();
		System.out.println("----SessionFactory Object----------");
		return sessionFactory;
	}
	
	@Bean(name="blogDAO")
	public BlogDAO getBlogDAO()
	{
		return new BlogDAOImpl();
	}
	
	@Bean(name="userDetailDAO")
	public UserDetailDAO getUserDetailDAO()
	{
		return new UserDetailDAOImpl();
	}
	
	@Bean(name="jobDAO")
	public JobDAO getJobDAO()
	{
		return new JobDAOImpl();
	}
	
	@Bean(name="profilePictureDAO")
	public ProfilePictureDAO getProfilePictureDAO()
	{
		return new ProfilePictureDAOImpl();
	}
	
	@Bean(name="friendDAO")
	public FriendDAO getFriendDAO()
	{
		return new FriendDAOImpl();
	}
	
	@Bean(name="forumDAO")
	public ForumDAO getForumDAO()
	{
		return new ForumDAOImpl();
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("----Hibernate Object----------");
		return new HibernateTransactionManager(sessionFactory);
	}
}
