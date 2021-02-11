package entity;

public class MashBill {
    private long id;

	private String recipe_id;
    private String malt_id;
    private String kilogramc;
    
    
	public MashBill(long id, String recipe_id, String malt_id, String kilogramc) {
		super();
		this.id = id;
		this.recipe_id = recipe_id;
		this.malt_id = malt_id;
		this.kilogramc = kilogramc;
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
	public String getMalt_id() {
		return malt_id;
	}
	public void setMalt_id(String malt_id) {
		this.malt_id = malt_id;
	}
	public String getKilogramc() {
		return kilogramc;
	}
	public void setKilogramc(String kilogramc) {
		this.kilogramc = kilogramc;
	}  

}
