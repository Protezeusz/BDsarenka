package entity;

public class DryHoppingSteps {
    private long id;

	private String recipe_id;
    private String hop_id;
    private String days;  
    private String grams;
    
	public DryHoppingSteps(long id, String recipe_id, String hop_id, String days, String grams) {
		super();
		this.id = id;
		this.recipe_id = recipe_id;
		this.hop_id = hop_id;
		this.days = days;
		this.grams = grams;
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
	public String getHop_id() {
		return hop_id;
	}
	public void setHop_id(String hop_id) {
		this.hop_id = hop_id;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getGrams() {
		return grams;
	}
	public void setGrams(String grams) {
		this.grams = grams;
	}
}
