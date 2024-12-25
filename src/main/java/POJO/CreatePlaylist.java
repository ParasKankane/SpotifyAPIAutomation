package POJO;

public class CreatePlaylist {

	private String name;
	private String description;
	private boolean collaborative;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public boolean getCollaborative()
	{
		return collaborative;
	}
	
	public void setCollabrative(boolean collaborative)
	{
		this.collaborative= collaborative;
	}
}
