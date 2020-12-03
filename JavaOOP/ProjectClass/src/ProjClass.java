
public class ProjClass {
	
	private String name;
	private String description;
	
	
	// Default Constructor
	public ProjClass() {
		
	}
	
	// Construct with only name
	public ProjClass(String name) {
		this.name = name;
	}
	
	// Construct with name and description
	public ProjClass(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	// Return name and description
	public String elevatorPitch() {
		return (name + ": " + description);
	}
	
	// Get name
	public String getName() {
		return name;
	}
	
	// Set name 
	public void setName(String name) {
		this.name = name;
	}
	
	// Get description
	public String getDescription() {
		return description;
	}
	
	// Set description
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

