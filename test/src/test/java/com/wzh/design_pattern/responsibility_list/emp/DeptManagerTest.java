
package com.wzh.design_pattern.responsibility_list.emp; 
import com.wzh.design_pattern.responsibility_list.req.FeeRequest;
import com.wzh.design_pattern.responsibility_list.req.Request;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* DeptManager Tester. 
* 
* @author <Authors name> 
* @since <pre>$ date</pre> 
* @version 1.0 
*/ 
public class DeptManagerTest {

    DeptManager manager=null;
    Request request=null;
@Before
public void before() throws Exception {
    manager=new DeptManager();
    Employee employee=new Employee("wzh","normal");
    request=new FeeRequest(employee,500d);
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: handle(Request req) 
* 
*/ 
@Test
public void testHandleReq() throws Exception { 

    manager.handle(request);
} 

/** 
* 
* Method: handle(FeeRequest request) 
* 
*/ 
@Test
public void testHandleRequest() throws Exception { 
//TODO: Test goes here... 
} 


} 
