package entity;

//@Entity
//@Table(name = "hops")
public class Hop {

//	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	private String name;
    private String alphaAcid;
    private String country;
    
    // standard constructors / setters / getters
    
    public Hop(long id, String name, String alphaAcid, String country) {
		super();
		this.id = id;
		this.name = name;
		this.alphaAcid = alphaAcid;
		this.country = country;
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
	public String getAlphaAcid() {
		return alphaAcid;
	}
	public void setAlphaAcid(String alphaAcid) {
		this.alphaAcid = alphaAcid;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
