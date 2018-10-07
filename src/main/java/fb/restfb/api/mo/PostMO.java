/**
 * 
 */
package fb.restfb.api.mo;

import java.util.Date;

import com.restfb.types.Post;

/**
 * @author MVEKSLER
 *
 */
public class PostMO 
{
	protected Post cPost = new Post();

	protected Date cReadDate = new Date();

	protected String cParentId = "";
	
	protected String cDescription = "";
	
	public PostMO(Post cPost) 
	{
		this.cPost = cPost;
	}

	public PostMO(Post cPost, String cParentId) 
	{
		this.setcPost(cPost);
		
		this.setcParentId(cParentId);
	}
	
	public Post getcPost() {
		return cPost;
	}

	public void setcPost(Post cPost) {
		this.cPost = cPost;
	}

	public Date getcReadDate() {
		return cReadDate;
	}

	public void setcReadDate(Date cReadDate) {
		this.cReadDate = cReadDate;
	}

	public String getcDescription() {
		return cDescription;
	}

	public void setcDescription(String cDescription) {
		this.cDescription = cDescription;
	}

	public String getcParentId() {
		return cParentId;
	}

	public void setcParentId(String cParentId) {
		this.cParentId = cParentId;
	}
	
	public String getPostMessge() 
	{
		boolean cRes = true;
		
		String cMethodName = "";
		
		String cPostMessage = "";
		String cMessage = "";
		String cName    = "";
		String cCaption = "";
	
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
	        if ( null == cPost )
	        {
	        	cRes = false;
	        }
	        //---get post message
	        if ( cRes )
	        {
				cMessage = this.getcPost().getMessage();
				cName    = this.getcPost().getName();
				cCaption = this.getcPost().getCaption();
				
				if ( cMessage != null )
				{
					cPostMessage = cMessage;
				}
				else if (cName != null)
				{
					cPostMessage = cName;
				}
				else if ( cCaption != null)
				{
					cPostMessage = cCaption;
				}
	        }
		
	        return cPostMessage;
		}
		catch( Exception e)
		{
			System.out.println(cMethodName + "::" + e.getStackTrace() );
			
			return "";
		}
	}
}
