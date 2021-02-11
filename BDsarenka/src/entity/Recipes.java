package entity;

public class Recipes {
    private long id;

	private String name;
    private String style;
    private String expectedVolume;  
    private String blgOG;
	private String blgFG;
    private String abv;
    private String ibu;  
    private String yeast_id;
	private String yeastAdd;
    private String FermentationSpec;
    private String recipeComment;
    
	public Recipes(long id, String name, String style, String expectedVolume, String blgOG, String blgFG, String abv,
			String ibu, String yeast_id, String yeastAdd, String fermentationSpec, String recipeComment) {
		super();
		this.id = id;
		this.name = name;
		this.style = style;
		this.expectedVolume = expectedVolume;
		this.blgOG = blgOG;
		this.blgFG = blgFG;
		this.abv = abv;
		this.ibu = ibu;
		this.yeast_id = yeast_id;
		this.yeastAdd = yeastAdd;
		FermentationSpec = fermentationSpec;
		this.recipeComment = recipeComment;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getExpectedVolume() {
		return expectedVolume;
	}
	public void setExpectedVolume(String expectedVolume) {
		this.expectedVolume = expectedVolume;
	}
	public String getBlgOG() {
		return blgOG;
	}
	public void setBlgOG(String blgOG) {
		this.blgOG = blgOG;
	}
	public String getBlgFG() {
		return blgFG;
	}
	public void setBlgFG(String blgFG) {
		this.blgFG = blgFG;
	}
	public String getAbv() {
		return abv;
	}
	public void setAbv(String abv) {
		this.abv = abv;
	}
	public String getIbu() {
		return ibu;
	}
	public void setIbu(String ibu) {
		this.ibu = ibu;
	}
	public String getYeast_id() {
		return yeast_id;
	}
	public void setYeast_id(String yeast_id) {
		this.yeast_id = yeast_id;
	}
	public String getYeastAdd() {
		return yeastAdd;
	}
	public void setYeastAdd(String yeastAdd) {
		this.yeastAdd = yeastAdd;
	}
	public String getFermentationSpec() {
		return FermentationSpec;
	}
	public void setFermentationSpec(String fermentationSpec) {
		FermentationSpec = fermentationSpec;
	}
	public String getRecipeComment() {
		return recipeComment;
	}
	public void setRecipeComment(String recipeComment) {
		this.recipeComment = recipeComment;
	}
}
