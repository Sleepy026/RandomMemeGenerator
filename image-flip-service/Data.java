package null;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@JsonProperty("page_url")
	private String pageUrl;

	@JsonProperty("url")
	private String url;

	public void setPageUrl(String pageUrl){
		this.pageUrl = pageUrl;
	}

	public String getPageUrl(){
		return pageUrl;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"page_url = '" + pageUrl + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}