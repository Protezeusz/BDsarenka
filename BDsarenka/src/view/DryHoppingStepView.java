package view;

public class DryHoppingStepView {

	private String recipe_id;
    private String name;
    private String grams;  
    private String days;
    
	public DryHoppingStepView(String recipe_id, String name, String grams, String days) {
		super();
		this.recipe_id = recipe_id;
		this.name = name;
		this.grams = grams;
		this.days = days;
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
	public String getDays() {
		return days;
	}

}
