/**
 * 
 */
package fb.restfb.api.interfaces;

import java.util.List;

import com.restfb.types.Post;

/**
 * @author MVEKSLER
 *
 */
public interface RestFacebookInterface 
{
	public List<Post> getGroupFeeds(String groupId, int pageLimit, long minutesAgo);
	
	public boolean processGroupFeeds(String accessToken, String groupId); 
	
	public boolean publishGroupLink(String targetId, String linkUrl, String message); 
	
	public boolean publishPostComment(String targetId, String linkUrl, String message); 
}
