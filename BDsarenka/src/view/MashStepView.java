package view;

public class MashStepView {
	
	private String recipe_id;
    private String step_nr;
    private String temperature;  
    private String minutes;
    
	public MashStepView(String recipe_id, String step_nr, String temperature, String minutes) {
		super();
		this.recipe_id = recipe_id;
		this.step_nr = step_nr;
		this.temperature = temperature;
		this.minutes = minutes;
	}
	public String getRecipe_id() {
		return recipe_id;
	}
	public String getStep_nr() {
		return step_nr;
	}
	public String getTemperature() {
		return temperature;
	}
	public String getMinutes() {
		return minutes;
	}
}
