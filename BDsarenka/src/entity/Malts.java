package entity;

public class Malts {
    private long id;

	private String name;
    private String type;
    private String ebc;
    
    
    public Malts(long id, String name, String type, String ebc, String malthause) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.ebc = ebc;
		this.malthause = malthause;
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
	public String getEbc() {
		return ebc;
	}
	public void setEbc(String ebc) {
		this.ebc = ebc;
	}
	public String getMalthause() {
		return malthause;
	}
	public void setMalthause(String malthause) {
		this.malthause = malthause;
	}
	private String malthause;

}
