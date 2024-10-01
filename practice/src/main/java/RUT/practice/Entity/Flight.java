package RUT.practice.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "flight", schema = "public")
public class Flight extends BaseEntity{
  private String departure;
  private String arrival;

  @Column(name = "departure", nullable = false)
	public String getDeparture() {
		return departure;
	}

  @Column(name = "arrival", nullable = false)
	public String getArrival() {
		return arrival;
	}

  public void setDeparture(String departure) {
		this.departure = departure;
	}

  public void setArrival(String arrival) {
		this.arrival = arrival;
	}
}