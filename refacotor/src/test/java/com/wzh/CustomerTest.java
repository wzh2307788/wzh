
package com.wzh; 
import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/** 
* Customer Tester. 
* 
* @author <Authors name> 
* @since <pre>$ date</pre> 
* @version 1.0 
*/ 
public class CustomerTest { 

    Logger log= LoggerFactory.getLogger(Customer.class);
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: addRental(Movie movie) 
* 
*/ 
@Test
public void testAddRental() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getName() 
* 
*/ 
@Test
public void testGetName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: set_name(String _name) 
* 
*/ 
@Test
public void testSet_name() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: statement() 
* 
*/ 
@Test
public void testStatement() throws Exception {
    Customer wzh=new Customer("wzh");
    Movie e=new Movie("我不是药神",Movie.REGULAR);
    Movie child=new Movie("爱丽丝仙境",Movie.CHILDREN);
    Movie adult=new Movie("春娇救志明",Movie.NEW_RELEASE);
    wzh.addRental(new Rental(e,3));
    wzh.addRental(new Rental(child,4));
    wzh.addRental(new Rental(adult,5));

   log.debug( wzh.statement());
} 


} 
