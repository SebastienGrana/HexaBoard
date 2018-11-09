package model.jeu;

public class Pion {
	
	private Integer id;
	
	private String name;
	
	private Double hp;
	
	private Double power;
	
	private Clan clan;
	
	private Boolean isAlive;
	
	private MyCases position;
	
	public Pion(Integer id) {
		super();
		this.id = id;
		
	}

	public Pion(Integer id, String name, Double hp, Double power, Clan clan, Boolean isAlive, MyCases position) {
		super();
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.power = power;
		this.clan = clan;
		this.isAlive = isAlive;
		this.position = position;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getHp() {
		return hp;
	}

	public void setHp(Double hp) {
		this.hp = hp;
	}

	public Double getPower() {
		return power;
	}

	public void setPower(Double power) {
		this.power = power;
	}

	public Clan getClan() {
		return clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public Boolean getIsAlive() {
		return isAlive;
	}

	public void setIsAlive(Boolean isAlive) {
		this.isAlive = isAlive;
	}

	public MyCases getPosition() {
		return position;
	}

	public void setPosition(MyCases position) {
		this.position = position;
	}


}
