package RUT.practice.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "passenger", schema = "public")
public class Passenger extends BaseEntity{
  private String firstName;
  private String lastName;
  private int budget;
  private String pass;
  private String health;
  private String preferences;

  @Column(name = "firstName", nullable = false)
	public String getFirstname() {
		return firstName;
	}

  @Column(name = "lastName", nullable = false)
	public String getLastname() {
		return lastName;
	}

	@Column(name = "budget", nullable = false)
	public int getBudget() {
		return budget;
	}

  @Column(name = "pass", nullable = false)
	public String getPass() {
		return pass;
	}

  @Column(name = "health", nullable = false)
	public String getHealth() {
		return health;
	}

	@Column(name = "preferences", nullable = false)
	public String getPreferences() {
		return preferences;
	}
  
  public void setFirstname(String firstName) {
		this.firstName = firstName;
	}

  public void setLastname(String lastName) {
		this.lastName = lastName;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

  public void setPass(String pass) {
		this.pass = pass;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}
}