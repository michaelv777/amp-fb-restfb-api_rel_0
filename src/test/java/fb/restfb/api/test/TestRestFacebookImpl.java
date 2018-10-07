/**
 * 
 */
package fb.restfb.api.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.restfb.types.Post;

import fb.restfb.api.impl.RestFacebookCommon;
import fb.restfb.api.impl.RestFacebookWorker;

/**
 * @author MVEKSLER
 *
 */
public class TestRestFacebookImpl {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		String certificatesTrustStorePath = "C:/glassfish3/jdk7/jre/lib/security/cacerts";
		
		System.setProperty("javax.net.trustStore", "NONE");
		System.setProperty("javax.net.debug", "SSL");
		System.setProperty("javax.net.ssl.trustStore", certificatesTrustStorePath);
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link fb.restfb.api.impl.RestFacebookWorker#fetchObjects(java.lang.String, java.util.List, java.util.List)}.
	 */
	@Ignore
	@Test
	public final void testFetchObjects() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link fb.restfb.api.impl.RestFacebookWorker#fetchObjects(java.lang.String, java.util.List)}.
	 */
	@Ignore
	@Test
	public final void testFetchObject() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link fb.restfb.api.impl.RestFacebookWorker#publishLink(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Ignore
	@Test
	public final void testPublishLink1() 
	{
		boolean cRes = true;
		
		String cMethodName = "";
		
		String cGroupId = "1774237332905314";
		String cGroupTarget = cGroupId + "/" + "feed"; 
		String linkUrl = "";
		String message = "";
		String accessToken = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
	        RestFacebookWorker cRFImpl = new RestFacebookWorker();
	        
	        if ( cRes )
	        {
	        	accessToken = RestFacebookCommon.MY_ACCESS_TOKEN;
	        	
	        	cRes = cRFImpl.extendAccessToken(accessToken);
	        }
	        if ( cRes )
	        {
	        	linkUrl = "https://www.amazon.ca/AmazonBasics-Apple-Certified-Lightning-Cable/dp/B010S9N6OO?psc=1&SubscriptionId=AKIAIQU2FHPYCZDYXCIA&tag=michaelv777-20&linkCode=xm2&camp=2025&creative=165953&creativeASIN=B010S9N6OO";
	        	message = "AmazonBasics Apple Certified Lightning to USB Cable - 6 Feet (1.8 Meters) - White";
	        	
	        	cRFImpl.publishLink(accessToken, cGroupTarget, linkUrl, message);
	        	
	        }
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			e.printStackTrace();
			
			fail(cMethodName + "::" + e.getMessage()); 
		}
	}

	@Ignore
	@Test
	public final void testPublishLink2() 
	{
		boolean cRes = true;
		
		String cMethodName = "";
		
		String cGroupId = "1774237332905314";
		String cGroupTarget = cGroupId + "/" + "feed"; 
		String linkUrl = "";
		String message = "";
		String accessToken = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
	        RestFacebookWorker cRFImpl = new RestFacebookWorker();
	        
	        if ( cRes )
	        {
	        	accessToken = RestFacebookCommon.MY_ACCESS_TOKEN;
	        	
	        	cRes = cRFImpl.extendAccessToken(accessToken);
	        }
	        if ( cRes )
	        {
	        	linkUrl = "https://www.amazon.ca/UGREEN-Adapter-Samsung-Android-Function/dp/B00N9S9Z0G?psc=1&SubscriptionId=AKIAIQU2FHPYCZDYXCIA&tag=michaelv777-20&linkCode=xm2&camp=2025&creative=165953&creativeASIN=B00N9S9Z0G";
	        	message = "UGREEN USB 2.0 OTG Cable On The Go Adapter Micro USB";
	        	
	        	cRFImpl.publishLink(accessToken, cGroupTarget, linkUrl, message);
	        	
	        }
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			e.printStackTrace();
			
			fail(cMethodName + "::" + e.getMessage()); 
		}
	}
	
	@Ignore
	@Test
	public final void testPublishPostComment() 
	{
		boolean cRes = true;
		
		String cMethodName = "";
		
		String cPostId = "1774237332905314_1835875440074836";
		@SuppressWarnings("unused")
		String cCommentTarget = cPostId + "/" + "comments"; 
		String linkUrl = "";
		String message = "";
		String accessToken = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
	        RestFacebookWorker cRFImpl = new RestFacebookWorker();
	        
	        if ( cRes )
	        {
	        	accessToken = RestFacebookCommon.MY_ACCESS_TOKEN;
	        	
	        	cRes = cRFImpl.extendAccessToken(accessToken);
	        }
	        if ( cRes )
	        {
	        	linkUrl = "https://www.amazon.ca/BLU-Advance-5-0-Unlocked-Smartphone/dp/B018IZ0SWI?psc=1&SubscriptionId=AKIAIQU2FHPYCZDYXCIA&tag=michaelv777-20&linkCode=xm2&camp=2025&creative=165953&creativeASIN=B018IZ0SWI";
	        	message = "https://www.amazon.ca/BLU-Advance-5-0-Unlocked-Smartphone/dp/B018IZ0SWI?psc=1&SubscriptionId=AKIAIQU2FHPYCZDYXCIA&tag=michaelv777-20&linkCode=xm2&camp=2025&creative=165953&creativeASIN=B018IZ0SWI";
	        	
	        	cRFImpl.publishPostComment(cPostId, linkUrl, message);
	        	
	        }
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			e.printStackTrace();
			
			fail(cMethodName + "::" + e.getMessage()); 
		}
	}
	
	/**
	 * Test method for {@link fb.restfb.api.impl.RestFacebookWorker#processGroupFeeds(java.lang.String, java.lang.String)}.
	 */
	
	@Test
	public final void testProcessGroupFeeds() 
	{
		boolean cRes = true;
		
		String cMethodName = "";
		
		String cGroupId = "1774237332905314";
		String accessToken = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
	        RestFacebookWorker cRFImpl = new RestFacebookWorker();
	        
	        if ( cRes )
	        {
	        	accessToken = RestFacebookCommon.MY_ACCESS_TOKEN;
	        	
	        	cRes = cRFImpl.extendAccessToken(accessToken);
	        }
	        if ( cRes )
	        {
	        	cRFImpl.processGroupFeeds(cRFImpl.getAccessToken().getAccessToken(), cGroupId);
	        }
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			e.printStackTrace();
			
			fail(cMethodName + "::" + e.getMessage()); 
		}
	}
	
	@Ignore
	@Test
	public final void testGetPosts() 
	{
		boolean cRes = true;
		
		String cMethodName = "";
		
		String cGroupId = "1774237332905314";
		String cGroupTarget = cGroupId + "/" + "feed"; 
		String accessToken = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
	        RestFacebookWorker cRFImpl = new RestFacebookWorker();
	        
	        if ( cRes )
	        {
	        	accessToken = RestFacebookCommon.MY_ACCESS_TOKEN;
	        	
	        	cRes = cRFImpl.extendAccessToken(accessToken);
	        }
	        if ( cRes )
	        {
	        	List<Post> cPosts = cRFImpl.getPosts(cGroupTarget, 10, -300);
	        	for( Post cPost : cPosts)
	        	{
	        		System.out.println(cPost.getCaption() + "::" + cPost.getMessage());
	        	}
	        }
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			e.printStackTrace();
			
			fail(cMethodName + "::" + e.getMessage()); 
		}
	}
}
