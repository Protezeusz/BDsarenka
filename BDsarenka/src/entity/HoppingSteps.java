package entity;

public class HoppingSteps {
    private long id;

	private String recipe_id;
    private String hop_id;
    private String days;  
    private String minutes;
    
	public HoppingSteps(long id, String recipe_id, String hop_id, String days, String minutes) {
		super();
		this.id = id;
		this.recipe_id = recipe_id;
		this.hop_id = hop_id;
		this.days = days;
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
	public String getMinutes() {
		return minutes;
	}
	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}
}
