package Payload;
import POJO.*;

public class SpotifyPayload {

	
	
	public static CreatePlaylist createPlaylist(String name, String description)
	{
		CreatePlaylist create = new CreatePlaylist();
		create.setName(name);
		create.setDescription(description);
		create.setCollabrative(false);
		
		return create;
	}
	
}
