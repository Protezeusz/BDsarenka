package entity;

public class Yeast {
    private long id;

	private String name;
    private String type;
    private String minTemperature;  
    private String maxTemperature;
	private String maxAlcohol;
	
	public Yeast(long id, String name, String type, String minTemperature, String maxTemperature, String maxAlcohol) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.minTemperature = minTemperature;
		this.maxTemperature = maxTemperature;
		this.maxAlcohol = maxAlcohol;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMinTemperature() {
		return minTemperature;
	}
	public void setMinTemperature(String minTemperature) {
		this.minTemperature = minTemperature;
	}
	public String getMaxTemperature() {
		return maxTemperature;
	}
	public void setMaxTemperature(String maxTemperature) {
		this.maxTemperature = maxTemperature;
	}
	public String getMaxAlcohol() {
		return maxAlcohol;
	}
	public void setMaxAlcohol(String maxAlcohol) {
		this.maxAlcohol = maxAlcohol;
	}

}
