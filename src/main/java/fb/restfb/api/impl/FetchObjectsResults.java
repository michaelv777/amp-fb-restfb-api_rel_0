/**
 * 
 */
package fb.restfb.api.impl;

import com.restfb.Facebook;
import com.restfb.types.Page;
import com.restfb.types.User;

/**
 * @author MVEKSLER
 *
 */
public class FetchObjectsResults
{
	@Facebook
	User me;

	// If the Facebook property name doesn't match
	// the Java field name, specify the Facebook 
	// field name in the annotation.

	@Facebook("cocacola")
	Page page;
}
