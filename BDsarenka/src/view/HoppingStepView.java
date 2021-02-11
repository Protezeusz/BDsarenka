package view;

public class HoppingStepView {
	
	private String recipe_id;
    private String name;
    private String grams;  
    private String minutes;
    
	public HoppingStepView(String recipe_id, String name, String grams, String minutes) {
		super();
		this.recipe_id = recipe_id;
		this.name = name;
		this.grams = grams;
		this.minutes = minutes;
	}
	public String getRecipe_id() {
		return recipe_id;
	}
	public String getName() {
		return name;
	}
	public String getGrams() {
		return grams;
	}
	public String getMinutes() {
		return minutes;
	}
}
