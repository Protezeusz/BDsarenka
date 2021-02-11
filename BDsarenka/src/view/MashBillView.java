package view;

public class MashBillView {
	private String recipe_id;
    private String name;
    private String kilograms;
	public MashBillView(String recipe_id, String name, String kilograms) {
		super();
		this.recipe_id = recipe_id;
		this.name = name;
		this.kilograms = kilograms;
	}
	public String getRecipe_id() {
		return recipe_id;
	}
	public String getName() {
		return name;
	}
	public String getKilograms() {
		return kilograms;
	}
}
