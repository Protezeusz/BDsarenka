package entity;

public class MashSteps {
    private long id;

	private String recipe_id;
    private String step_nr;
    private String temperature;  
    private String minutes;
    
    
	public MashSteps(long id, String recipe_id, String step_nr, String temperature, String minutes) {
		super();
		this.id = id;
		this.recipe_id = recipe_id;
		this.step_nr = step_nr;
		this.temperature = temperature;
		this.minutes = minutes;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(String recipe_id) {
		this.recipe_id = recipe_id;
	}
	public String getStep_nr() {
		return step_nr;
	}
	public void setStep_nr(String step_nr) {
		this.step_nr = step_nr;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getMinutes() {
		return minutes;
	}
	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

}
