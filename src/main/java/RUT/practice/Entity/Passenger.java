package RUT.practice.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "passenger", schema = "public")
public class Passenger extends BaseEntity{
  private String fisrtName;
  private String lastName;
  private String pass;
  private String health;

  @Column(name = "fisrtName", nullable = false)
	public String getFisrtname() {
		return fisrtName;
	}

  @Column(name = "lastName", nullable = false)
	public String getLastname() {
		return lastName;
	}

  @Column(name = "pass", nullable = false)
	public String getPass() {
		return pass;
	}

  @Column(name = "health", nullable = false)
	public String getHealth() {
		return health;
	}
  
  public void setFisrtname(String fisrtName) {
		this.fisrtName = fisrtName;
	}

  public void setLastname(String lastName) {
		this.lastName = lastName;
	}

  public void setPass(String pass) {
		this.pass = pass;
	}
}