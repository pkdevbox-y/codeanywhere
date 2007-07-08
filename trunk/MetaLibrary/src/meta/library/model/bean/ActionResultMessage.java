/**
 * None-persistent bean
 */
package meta.library.model.bean;

/**
 * @author Biao Zhang
 *
 */
public class ActionResultMessage {
	private String message;
	private String url;
	
	public ActionResultMessage() {
		this.message = "";
		this.url = "";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
