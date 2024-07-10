package RUT.practice.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "passenger", schema = "public")
public class Passenger {
  private int id;
  private String fisrtname;
  private String lastname;
  private String pass;
  private String health;
  @Id
  @Column(insertable = false, name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getId() {
    return id;
  }

  @Column(name = "fisrtname", nullable = false)
	public String getFisrtname() {
		return fisrtname;
	}

  @Column(name = "lastname", nullable = false)
	public String getLastname() {
		return lastname;
	}

  @Column(name = "pass", nullable = false)
	public String getPass() {
		return pass;
	}

  @Column(name = "health", nullable = false)
	public String getHealth() {
		return health;
	}

  public void setId(int id) {
		this.id = id;
	}
  
  public void setFisrtname(String fisrtname) {
		this.fisrtname = fisrtname;
	}

  public void setLastname(String lastname) {
		this.lastname = lastname;
	}

  public void setPass(String pass) {
		this.pass = pass;
	}
}