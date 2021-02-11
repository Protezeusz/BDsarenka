package entity;

public class Accounts {
   
	private long id;

	private String nick;
    private String password;
    
	public Accounts(long id, String nick, String password) {
		super();
		this.id = id;
		this.nick = nick;
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
