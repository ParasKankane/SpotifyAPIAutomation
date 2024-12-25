package Utility;

public enum ResourceManagement {
		
	
	createPlaylist("v1/users/{user_id}/playlists");
	String resource;
	
	ResourceManagement(String resource)
	{
		this.resource= resource;
	}
	
	public String getResource()
	{
		return resource;
	}
}
