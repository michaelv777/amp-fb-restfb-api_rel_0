package fb.restfb.api.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.exception.FacebookException;
import com.restfb.exception.FacebookGraphException;
import com.restfb.exception.FacebookNetworkException;
import com.restfb.json.JsonObject;
import com.restfb.types.FacebookType;
import com.restfb.types.NamedFacebookType;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.util.StringUtils;

public class RestFacebookWorker extends RestFacebookBase
{
	//---class variables-------------
	protected AccessToken accessToken = new AccessToken();
	
	//---getters/setters-------------
	public void setAccessToken(AccessToken accessToken) {
		this.accessToken = accessToken;
	}

	public AccessToken getAccessToken() {
		return accessToken;
	}
	
	public RestFacebookWorker()
	{
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			this.setLcRes(false);
		}
	}
	
	public RestFacebookWorker(HashMap<String, String> cSystemConfiguration)
	{
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
	        this.setcSystemConfiguration(cSystemConfiguration);
	        
	        this.setSystemProperties();
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			this.setLcRes(false);
		}
	}
	
	public RestFacebookWorker(HashMap<String, String> cSystemConfiguration,
							HashMap<String, String> cWorkerConfiguration) 
	{
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
	        this.setcSystemConfiguration(cSystemConfiguration);
	        
	        this.setcWorkerConfiguration(cWorkerConfiguration);
	        
	        this.setSystemProperties();
	        
	        this.setWorkerProperties();
	        
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			this.setLcRes(false);
		}
	}

	//---class methods-------------
	public boolean getUserAccessToken(String redirectUri, String verificationCode) 
	{
		boolean cRes = true;
		
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
	        this.accessToken = new DefaultFacebookClient(Version.VERSION_2_8).obtainUserAccessToken(
	        						  this.FB_APP_ID, 
	        						  this.FB_APP_SECRET,
									  redirectUri, 
									  verificationCode);
			return cRes;
		
		}
		catch( FacebookNetworkException e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			e.printStackTrace();
			
			this.setLcRes(cRes = false);
			
			return cRes;
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			this.setLcRes(cRes = false);
			
			return cRes;
		}
	}
	
	public boolean getExtendedAccessToken(String accessToken) 
	{
		boolean cRes = true;
		
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
	        this.accessToken = new DefaultFacebookClient(accessToken, Version.VERSION_2_8).
		        	obtainExtendedAccessToken(
		        			this.FB_APP_ID, 
		        			this.FB_APP_SECRET);
			return cRes;
		
		}
		catch( FacebookNetworkException e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			e.printStackTrace();
			
			this.setLcRes(cRes = false);
			
			return cRes;
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			this.setLcRes(cRes = false);
			
			return cRes;
		}
	}
	
	public boolean getApplicationAccessToken() 
	{
		boolean cRes = true;
		
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
			this.accessToken = new DefaultFacebookClient(Version.VERSION_2_8).
					obtainAppAccessToken(
							this.FB_APP_ID, 
							this.FB_APP_SECRET);
	       
			return cRes;
		
		}
		catch( FacebookNetworkException e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			e.printStackTrace();
			
			this.setLcRes(cRes = false);
			
			return cRes;
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			this.setLcRes(cRes = false);
			
			return cRes;
		}
	}
	//---
	public boolean extendAccessToken(String accessToken) 
	{
		boolean cRes = true;
		
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
			String accessTokenNew = "";
			
			if ( StringUtils.isBlank(accessToken))
			{
				accessTokenNew = this.FB_ACCESS_TOKEN;
				
			}
			else
			{
				accessTokenNew = accessToken;
			}
			
			this.accessToken = new DefaultFacebookClient(Version.VERSION_2_8).
					obtainExtendedAccessToken(
							this.FB_APP_ID, 
							this.FB_APP_SECRET, 
							accessTokenNew);
			
			return cRes;
			
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			e.printStackTrace();
			
			this.setLcRes(cRes = false);
			
			return cRes;
		}
	}
	//---
	public boolean isUserLikes(String accessToken,
									  String userId, 	
									  String url) 
	{
		boolean cRes = true;
		
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
			Page page = this.getPage(accessToken, url);
	
			FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_8);
	
			String objectPath = userId + "/likes/";  /*example: "me/likes/" */
			
			Post.Likes postLikes = fbClient.fetchObject(
					objectPath + page.getId(), Post.Likes.class);
	
			List<NamedFacebookType> likes = postLikes.getData();
	
			if (likes.size() > 0) 
			{
				return true;
			}
	
			return cRes;
		
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			this.setLcRes(cRes = false);
			
			return cRes;
		}
	}
	//---
	public JsonObject fetchObjects(String accessToken, 
								   List<String> objectsIds,
								   List<String> objectsFields) throws Exception 
	{
		@SuppressWarnings("unused")
		boolean cRes = true;
		
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
			FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_8);
			
			String fields = "";
			
			
			for ( int findex = 0; findex < objectsFields.size(); ++findex)
			{
				String field  = objectsFields.get(findex);
				
				fields += field;
				
				if ( findex < (objectsFields.size() - 1))
				{
					fields += ",";
				}
			}
			
			JsonObject fetchObjectsResults = 
					fbClient.fetchObjects(objectsIds, 
							JsonObject.class,
							Parameter.with("fields", fields)); //fields example: "name,id"
			
			return fetchObjectsResults;
		
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			this.setLcRes(cRes = false);
			
			return null;
		}
	}
	//---
	public FetchObjectsResults fetchObjects(String accessToken, 
			   				  		        List<String> objectsIds) throws Exception 
	{
		@SuppressWarnings("unused")
		boolean cRes = true;
		
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
			FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_8);
			
			FetchObjectsResults fetchObjectsResults = 
					fbClient.fetchObjects(objectsIds, 
							FetchObjectsResults.class); 
			
			return fetchObjectsResults;
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			this.setLcRes(cRes = false);
			
			return null;
		}
	}
	//---
	public boolean publishGroupLink(String targetId, 
									String linkUrl, 
									String message) 
	{
		boolean cRes = true;
		
		String cMethodName = "";
		
		String cTargetPath = targetId + "/" + "feed"; 
	
		String accessToken = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	     
	        if ( StringUtils.isBlank(targetId))
	        {
	        	System.out.println("M.V. Custom::" + cMethodName + "::targetId is null!");
	        	
	        	cRes = false;
	        }
	        
	        if ( StringUtils.isBlank(linkUrl))
	        {
	        	System.out.println("M.V. Custom::" + cMethodName + "::linkUrl is null!");
	        	
	        	cRes = false;
	        }
	        
	        if ( cRes )
	        {
	        	accessToken = this.FB_ACCESS_TOKEN;
	        	
	        	cRes = this.extendAccessToken(accessToken);
	        }
	        if ( cRes )
	        {
	        	this.publishLink(accessToken, cTargetPath, linkUrl, message);
	        }
	        
	        return cRes;
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			e.printStackTrace();
			
			this.setLcRes(cRes = false);
			
			return cRes;
		}
	}
	
	//---
	public boolean publishLink(String accessToken,
					           String targetUrl,
					           String linkUrl,
					           String message) throws Exception 
	{
		boolean cRes = true;
		
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
			/*
			 * Target Url example: "me/feed", groupid: 1774237332905314/feed
			 * Link example: https://www.amazon.ca/AmazonBasics-Apple-Certified-Lightning-Cable/dp/B010S9N6OO?psc=1&SubscriptionId=AKIAIQU2FHPYCZDYXCIA&tag=michaelv777-20&linkCode=xm2&camp=2025&creative=165953&creativeASIN=B010S9N6OO
			 */
	        
	       
			FacebookClient fbClient = new DefaultFacebookClient(
					accessToken, 
					this.FB_APP_SECRET, 
					Version.VERSION_2_8);
			
			
			FacebookType response = fbClient.publish(targetUrl, FacebookType.class, 
			    Parameter.with("link", linkUrl),
				Parameter.with("message", message));
			
			String id = response.getId();
			System.out.println("id : " + id);
			
			Post post = fbClient.fetchObject(id, Post.class);
			System.out.println(post.getMessage());
		
			return cRes;
		}
		catch( FacebookException e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			e.printStackTrace();
			
			this.setLcRes(cRes = false);
			
			return cRes;
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			e.printStackTrace();
			
			this.setLcRes(cRes = false);
			
			return cRes;
		}
	}
	
	
	//---
	public boolean publishPostComment(String targetId, 
									  String linkUrl, 
									  String message) 
	{
		boolean cRes = true;
		
		String cMethodName = "";
		
		String cTargetPath = targetId + "/" + "comments"; 
	
		String accessToken = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	     
	        if ( StringUtils.isBlank(targetId))
	        {
	        	System.out.println("M.V. Custom::" + cMethodName + "::targetId is null!");
	        	
	        	cRes = false;
	        }
	        
	        if ( StringUtils.isBlank(linkUrl))
	        {
	        	System.out.println("M.V. Custom::" + cMethodName + "::linkUrl is null!");
	        	
	        	cRes = false;
	        }
	        
	        if ( cRes )
	        {
	        	accessToken = this.FB_ACCESS_TOKEN;
	        	
	        	cRes = this.extendAccessToken(accessToken);
	        }
	        if ( cRes )
	        {
	        	this.publishComment(accessToken, cTargetPath, linkUrl, message);
	        }
	        
	        return cRes;
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			e.printStackTrace();
			
			this.setLcRes(cRes = false);
			
			return cRes;
		}
	}
	//---
	public boolean publishComment(String accessToken,
					              String targetUrl,
					              String linkUrl,
					              String message) throws Exception 
	{
		boolean cRes = true;
		
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
			/*
			 * Target Url example: "1774237332905314_1835875440074836/comments", post: 1774237332905314_1835875440074836
			 */
	        
	       
			FacebookClient fbClient = new DefaultFacebookClient(
					accessToken, 
					this.FB_APP_SECRET, 
					Version.VERSION_2_8);
			
			
			FacebookType response = fbClient.publish(targetUrl, FacebookType.class, 
			    Parameter.with("comment", message),
				Parameter.with("message", message));
			
			String id = response.getId();
			System.out.println("id : " + id);
			
			Post post = fbClient.fetchObject(id, Post.class);
			System.out.println(post.getMessage());
		
			return cRes;
		}
		catch( FacebookException e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			e.printStackTrace();
			
			this.setLcRes(cRes = false);
			
			return cRes;
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			e.printStackTrace();
			
			this.setLcRes(cRes = false);
			
			return cRes;
		}
	}
	
	//---
	public Page getPage(String accessToken, String url) 
	{
		@SuppressWarnings("unused")
		boolean cRes = true;
		
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
			FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_8);
			
			Page page = fbClient.fetchObject(url, Page.class);
			
			return page;
		
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			this.setLcRes(cRes = false);
			
			return null;
		}
	}
	//---
	public List<Post> getPosts(String accessToken, String targetUrl, int pageLimit, int hoursAgo)
	{
		@SuppressWarnings("unused")
		boolean cRes = true;
		
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
			/*
			 * Target Url example: "me/feed" or "me/statuses", example of groupid feeds: 1774237332905314/feed
			 * Link example: https://www.amazon.ca/AmazonBasics-Apple-Certified-Lightning-Cable/dp/B010S9N6OO?psc=1&SubscriptionId=AKIAIQU2FHPYCZDYXCIA&tag=michaelv777-20&linkCode=xm2&camp=2025&creative=165953&creativeASIN=B010S9N6OO
			 */
			
			final Calendar hoursAgoCalendar = Calendar.getInstance();
			hoursAgoCalendar.add(Calendar.HOUR, hoursAgo); //example = -24
	
			FacebookClient fbClient = new DefaultFacebookClient(
					accessToken, this.FB_APP_SECRET, Version.VERSION_2_8);
			
			final List<Post> allPosts = new LinkedList<Post>();
			
			final Connection<Post> dataConnection = fbClient.fetchConnection(targetUrl, Post.class);
			//final List<Post> posts = feedConnection.getData();
			
			for (List<Post> posts : dataConnection) 
			{
				for(final Post post : posts) 
				{
					final Calendar statusDate = Calendar.getInstance();
				
					if ( post.getCreatedTime() != null )
					{
						statusDate.setTime(post.getCreatedTime());
					}
					else if ( post.getUpdatedTime() != null )
					{
						statusDate.setTime(post.getUpdatedTime());
					}
					else
					{
						statusDate.setTime(new Date());
					}
					
					if(statusDate.after(hoursAgoCalendar)) 
					{
						allPosts.add(post);
					} 
				}
				
				--pageLimit;
				
				if (pageLimit == 0) 
				{
					break;
				}
			}
			
			return allPosts;
		
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			this.setLcRes(cRes = false);
			
			return null;
		}
	}
	//---
	public List<Post> getPosts(String accessToken, String targetUrl, int pageLimit)
	{
		@SuppressWarnings("unused")
		boolean cRes = true;
		
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
			/*
			 * Target Url example: "me/feed" or "me/statuses", example of groupid
			 * feeds: 1774237332905314/feed Link example:
			 * https://www.amazon.ca/AmazonBasics-Apple-Certified-Lightning-Cable/dp
			 * /B010S9N6OO?psc=1&SubscriptionId=AKIAIQU2FHPYCZDYXCIA&tag=michaelv777
			 * -20&linkCode=xm2&camp=2025&creative=165953&creativeASIN=B010S9N6OO
			 */
	
			FacebookClient fbClient = new DefaultFacebookClient(
					accessToken, 
					this.FB_APP_SECRET, 
					Version.VERSION_2_8);
	
			final List<Post> allPosts = new LinkedList<Post>();
	
			final Connection<Post> dataConnection = fbClient.fetchConnection(targetUrl, Post.class);
	
			for (List<Post> posts : dataConnection) 
			{
				for (final Post post : posts) 
				{
					allPosts.add(post);
				}
	
				--pageLimit;
	
				if (pageLimit == 0) 
				{
					break;
				}
			}
			
			return allPosts;
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			this.setLcRes(cRes = false);
			
			return null;
		}
	}

	//---
	public List<Post> getPosts(String targetUrl, int pageLimit, int hoursAgo)
	{
		boolean cRes = true;
		
		String cMethodName = "";
		
		String accessToken = "";
		
		List<Post> allPosts = new LinkedList<Post>();
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
			/*
			 * Target Url example: "me/feed" or "me/statuses", example of groupid feeds: 1774237332905314/feed
			 * Link example: https://www.amazon.ca/AmazonBasics-Apple-Certified-Lightning-Cable/dp/B010S9N6OO?psc=1&SubscriptionId=AKIAIQU2FHPYCZDYXCIA&tag=michaelv777-20&linkCode=xm2&camp=2025&creative=165953&creativeASIN=B010S9N6OO
			 */
			
			Calendar hoursAgoCalendar = Calendar.getInstance();
			hoursAgoCalendar.add(Calendar.HOUR, hoursAgo); //example = -24
	
			if ( cRes )
			{
				accessToken = this.FB_ACCESS_TOKEN;
	        	
	        	cRes = this.extendAccessToken(accessToken);
			}
        	if ( cRes )
        	{
				FacebookClient fbClient = new DefaultFacebookClient(
						accessToken, 
						this.FB_APP_SECRET, 
						Version.VERSION_2_8);
				
				Connection<Post> dataConnection = fbClient.fetchConnection(targetUrl, Post.class);
				//final List<Post> posts = feedConnection.getData();
				
				for (List<Post> posts : dataConnection) 
				{
					for(final Post post : posts) 
					{
						final Calendar statusDate = Calendar.getInstance();
					
						if ( post.getCreatedTime() != null )
						{
							statusDate.setTime(post.getCreatedTime());
						}
						else if ( post.getUpdatedTime() != null )
						{
							statusDate.setTime(post.getUpdatedTime());
						}
						else
						{
							statusDate.setTime(new Date());
						}
						
						if(statusDate.after(hoursAgoCalendar)) 
						{
							allPosts.add(post);
						} 
					}
					
					--pageLimit;
					
					if (pageLimit == 0) 
					{
						break;
					}
				}
        	}
        	
			return allPosts;
		
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			this.setLcRes(cRes = false);
			
			return new LinkedList<Post>();
		}
	}
	//---
	public List<Post> getGroupFeeds(String groupId, int pageLimit, long minutesAgo) 
	{
		boolean cRes = true;
		
		String cMethodName = "";
		
		String accessToken = "";
		
		List<Post> allPosts = new LinkedList<Post>();
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
			// For each post, determine the type and add the appropriate
			// annotations.
			// Once the post vertex has been created and added, process the tags in
			// the post
			// (i.e., the "with" tags). Finally, process the likes and comments for
			// this post.
	        minutesAgo = (minutesAgo > 0 ) ? (minutesAgo * -1) : (minutesAgo);
	        
	        Calendar minutesAgoCalendar = Calendar.getInstance();
			minutesAgoCalendar.add(Calendar.MINUTE, (int)minutesAgo); //example = -24
	
			if ( cRes )
			{
				accessToken = this.FB_ACCESS_TOKEN;
	        	
	        	cRes = this.extendAccessToken(accessToken);
			}
	        
			if ( cRes )
			{
				LinkedList<String> postsVisited = new LinkedList<String>();
		
				FacebookClient fbClient = new DefaultFacebookClient(
						accessToken, this.FB_APP_SECRET, Version.VERSION_2_8);
		
				Connection<Post> groupFeeds = fbClient.fetchConnection(groupId + "/feed", Post.class,
						Parameter.with("fields", "id,name,from,message,link,created_time,type,with_tags,story_tags"));
				
				String postId       = "";
				String postCaption  = "";
				String postType     = ""; 
				String fromUserId   = "";
				String fromUserName = "";
				String name         = "";
				String message      = "";
				String link         = "";
						
				for (List<Post> groupFeed : groupFeeds) 
				{
					for (Post post : groupFeed) 
					{
						if( postsVisited.contains(post.getId()) )
			            {
			                System.out.println("skipped a post because it was in the photos");
			                continue;
			            }
						else
						{
							postsVisited.add(post.getId());
						}
						
						Calendar statusDate = Calendar.getInstance();
						
						if ( post.getCreatedTime() != null )
						{
							statusDate.setTime(post.getCreatedTime());
						}
						else if ( post.getUpdatedTime() != null )
						{
							statusDate.setTime(post.getUpdatedTime());
						}
						else
						{
							statusDate.setTime(new Date());
						}
						
						postType = post.getType();
						
						if ( postType != null )
						{
							if ( postType.equals("story") || postType.equals("message") || postType.equals("status") )
							{
									postId   	 = StringUtils.isBlank(post.getFrom().getId())   ? "" : post.getId();
									postCaption  = StringUtils.isBlank(post.getFrom().getId())   ? "" : post.getCaption();
									fromUserId   = StringUtils.isBlank(post.getFrom().getId())   ? "" : post.getFrom().getId();
									fromUserName = StringUtils.isBlank(post.getFrom().getName()) ? "" : post.getFrom().getName();
									name         = StringUtils.isBlank(post.getName())           ? "" : post.getName();
									message      = StringUtils.isBlank(post.getMessage())        ? "" : post.getMessage();
									
									System.out.println("postId:"   	   + postId);
									System.out.println("postCaption:"  + postCaption);
									System.out.println("fromUserId:"   + fromUserId);
									System.out.println("fromUserName:" + fromUserName);
									System.out.println("name:"         + name);
									System.out.println("message:"      + message);
									
									if(statusDate.after(minutesAgoCalendar)) 
									{
										System.out.println("M.V. Custom::" + cMethodName + "::Add postId:" + postId);
										
										allPosts.add(post);
									}
									
							}
							
							if ( postType.equals("link") )
							{
									postId   	 = StringUtils.isBlank(post.getFrom().getId())   ? "" : post.getId();
									postCaption  = StringUtils.isBlank(post.getFrom().getId())   ? "" : post.getCaption();
									fromUserId   = StringUtils.isBlank(post.getFrom().getId())   ? "" : post.getFrom().getId();
									fromUserName = StringUtils.isBlank(post.getFrom().getName()) ? "" : post.getFrom().getName();
									name         = StringUtils.isBlank(post.getName())           ? "" : post.getName();
									message      = StringUtils.isBlank(post.getMessage())        ? "" : post.getMessage();
									link = StringUtils.isBlank(post.getFrom().getId()) 			 ? "" : post.getLink();;
									
									System.out.println("postId:"   	   + postId);
									System.out.println("postCaption:"  + postCaption);
									System.out.println("fromUserId:"   + fromUserId);
									System.out.println("fromUserName:" + fromUserName);
									System.out.println("name:"         + name);
									System.out.println("message:"      + message);
									System.out.println("link:" 		   + link);
									
									if(statusDate.after(minutesAgoCalendar)) 
									{
										System.out.println("M.V. Custom::" + cMethodName + "::Add postId:" + postId);
										
										allPosts.add(post);
									} 
							}
							else if ( postType.equals("photo") )
							{
									
							}
							else if ( postType.equals("video") )
							{
								
							}
							
							// get message tags and with tags from every post
							for (NamedFacebookType user : post.getWithTags()) 
							{
								System.out.println("user:" + user.getId());
							}
							
							for (Post.MessageTag tag : post.getMessageTags()) 
							{
								System.out.println("tag:" + tag.getId());
							}
						}
					}
				}
			}
			
			return allPosts;
		}
		
		catch( FacebookGraphException e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			e.printStackTrace();
			
			this.setLcRes(cRes = false);
			
			return new LinkedList<Post>();
		}
		catch( FacebookException e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			e.printStackTrace();
			
			this.setLcRes(cRes = false);
			
			return new LinkedList<Post>();
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			e.printStackTrace();
			
			this.setLcRes(cRes = false);
			
			return new LinkedList<Post>();
		}
	}

	//---
	public boolean processGroupFeeds(String accessToken, String groupId) 
	{
		boolean cRes = true;
		
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
			// For each post, determine the type and add the appropriate
			// annotations.
			// Once the post vertex has been created and added, process the tags in
			// the post
			// (i.e., the "with" tags). Finally, process the likes and comments for
			// this post.
	
			LinkedList<String> postsVisited = new LinkedList<String>();
	
			FacebookClient fbClient = new DefaultFacebookClient(
					accessToken, this.FB_APP_SECRET, Version.LATEST);
	
			Connection<Post> groupFeeds = fbClient.fetchConnection(groupId + "/feed", Post.class,
					Parameter.with("fields", "id,name,from,message,link,created_time,type,with_tags,story_tags"));

			String postType     = ""; 
			String fromUserId   = "";
			String fromUserName = "";
			String name         = "";
			String message      = "";
			String link         = "";
					
			for (List<Post> groupFeed : groupFeeds) 
			{
				for (Post post : groupFeed) 
				{
					if( postsVisited.contains(post.getId()) )
		            {
		                System.out.println("skipped a post because it was in the photos");
		                continue;
		            }
					else
					{
						postsVisited.add(post.getId());
					}
					
					postType = post.getType();
					
					if ( postType != null )
					{
						if ( postType.equals("story") )
						{
								fromUserId   = post.getFrom().getId();
								fromUserName = post.getFrom().getName();
								name         = post.getName();
								message      =  post.getMessage();
								
								System.out.println("fromUserId:"   + fromUserId);
								System.out.println("fromUserName:" + fromUserName);
								System.out.println("name:"         + name);
								System.out.println("message:"      + message);
								
							}
								
						else if ( postType.equals("message") )
						{
								
								fromUserId   = post.getFrom().getId();
								fromUserName = post.getFrom().getName();
								name         = post.getName();
								message      = post.getMessage();
								
								System.out.println("fromUserId:"   + fromUserId);
								System.out.println("fromUserName:" + fromUserName);
								System.out.println("name:"         + name);
								System.out.println("message:"      + message);
								
						}
								
						else if ( postType.equals("status") )
						{
								
								fromUserId   = post.getFrom().getId();
								fromUserName = post.getFrom().getName();
								name         = post.getName();
								message      = post.getMessage();
								
								System.out.println("fromUserId:"   + fromUserId);
								System.out.println("fromUserName:" + fromUserName);
								System.out.println("name:"         + name);
								System.out.println("message:"      + message);
								
						}
						else if ( postType.equals("link") )
						{
								
								fromUserId   = post.getFrom().getId();
								fromUserName = post.getFrom().getName();
								name         = post.getName();
								message      = post.getMessage();
								link         = post.getLink();
								
								System.out.println("fromUserId:"   + fromUserId);
								System.out.println("fromUserName:" + fromUserName);
								System.out.println("name:"         + name);
								System.out.println("message:"      + message);
								System.out.println("link:"         + link);
								
						}
						else if ( postType.equals("photo") )
						{
								
						}
						else if ( postType.equals("video") )
						{
							
						}
						else
						{
							
						}
		
						// get message tags and with tags from every post
						for (NamedFacebookType user : post.getWithTags()) 
						{
							System.out.println("user:" + user.getId());
						}
						
						for (Post.MessageTag tag : post.getMessageTags()) 
						{
							System.out.println("tag:" + tag.getId());
						}
					}
				}
			}
			return cRes;
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			e.printStackTrace();
			
			this.setLcRes(cRes = false);
			
			return cRes;
		}
	}
	
	//---
	public boolean processUserPosts(String userId) 
	{
		boolean cRes = true;
		
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
		    // For each post, determine the type and add the appropriate annotations.
		    // Once the post vertex has been created and added, process the tags in the post
		    // (i.e., the "with" tags). Finally, process the likes and comments for this post.
		
			LinkedList<String> postsVisited = new LinkedList<String>();
			
			FacebookClient fbClient = new DefaultFacebookClient(
					this.FB_APP_ID, 
					this.FB_APP_SECRET, 
					Version.VERSION_2_8);
			
		    Connection<Post> userPosts = fbClient.fetchConnection(userId + "/posts", Post.class,
		    		Parameter.with("fields", "id,name,from,message,link,created_time,type,with_tags,story_tags"));
		    
		    String postType = ""; 
			String fromUserId = "";
			String fromUserName = "";
			String name = "";
			String message = "";
			String link = "";
			
		    for (List<Post> userPostsPage : userPosts) 
		    {
		        for (Post post : userPostsPage) 
		        {
		            if( postsVisited.contains(post.getId()) )
		            {
		                System.out.println("skipped a post because it was in the photos");
		                continue;
		            }
		            else
		            {
		            	postsVisited.add(post.getId());
		            }
					
		            postType = post.getType();
		            
		            if ( postType != null )
					{
						if ( postType.equals("story") )
						{
								fromUserId   = post.getFrom().getId();
								fromUserName = post.getFrom().getName();
								name         = post.getName();
								message      =  post.getMessage();
								
								System.out.println("fromUserId:" + fromUserId);
								System.out.println("fromUserName:" + fromUserName);
								System.out.println("name:" + name);
								System.out.println("message:" + message);
								
							}
								
						else if ( postType.equals("message") )
						{
								
								fromUserId   = post.getFrom().getId();
								fromUserName = post.getFrom().getName();
								name         = post.getName();
								message      =  post.getMessage();
								
								System.out.println("fromUserId:" + fromUserId);
								System.out.println("fromUserName:" + fromUserName);
								System.out.println("name:" + name);
								System.out.println("message:" + message);
								
						}
								
						else if ( postType.equals("status") )
						{
								
								fromUserId   = post.getFrom().getId();
								fromUserName = post.getFrom().getName();
								name         = post.getName();
								message      =  post.getMessage();
								
								System.out.println("fromUserId:" + fromUserId);
								System.out.println("fromUserName:" + fromUserName);
								System.out.println("name:" + name);
								System.out.println("message:" + message);
								
						}
						else if ( postType.equals("link") )
						{
								
								fromUserId   = post.getFrom().getId();
								fromUserName = post.getFrom().getName();
								name         = post.getName();
								message      =  post.getMessage();
								link         = post.getLink();
								
								System.out.println("fromUserId:" + fromUserId);
								System.out.println("fromUserName:" + fromUserName);
								System.out.println("name:" + name);
								System.out.println("message:" + message);
								System.out.println("link:" + link);
								
						}
						else if ( postType.equals("photo") )
						{
								
						}
						else if ( postType.equals("video") )
						{
							
						}
						else
						{
							
						}
		
						// get message tags and with tags from every post
						for (NamedFacebookType user : post.getWithTags()) 
						{
							System.out.println("user:" + user.getId());
						}
						
						for (Post.MessageTag tag : post.getMessageTags()) 
						{
							System.out.println("tag:" + tag.getId());
						}
					}
		        }
		    }
		    
		    return cRes;
		}
		catch( Exception e)
		{
			System.out.println("M.V. Custom::" + cMethodName + "::" + e.getMessage());
			
			this.setLcRes(cRes = false);
			
			return cRes;
		}
	}
}
