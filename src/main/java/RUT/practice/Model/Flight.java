package RUT.practice.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "flight", schema = "public")
public class Flight {
  private int id;
  private String departure;
  private String arrival;
  @Id
  @Column(insertable = false, name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getId() {
    return id;
  }

  @Column(name = "departure", nullable = false)
	public String getDeparture() {
		return departure;
	}

  @Column(name = "arrival", nullable = false)
	public String getAarrival() {
		return arrival;
	}

  public void setId(int id) {
		this.id = id;
	}

  public void setDeparture(String departure) {
		this.departure = departure;
	}

  public void setArrival(String arrival) {
		this.arrival = arrival;
	}
}