package RUT.practice.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket", schema = "public")
public class Ticket extends BaseEntity{
  private int price;
  private String seat;
  private Passenger passengerId;
  private Airfly airflyId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "passengerId", referencedColumnName = "id")
  public Passenger getPassenger() {
    return this.passengerId;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "airflyId", referencedColumnName = "id")
  public Airfly getAirfly() {
    return this.airflyId;
  }

  @Column(name = "price", nullable = false)
	public int getPrice() {
		return price;
	}

  @Column(name = "seat", nullable = false)
	public String getSeat() {
		return seat;
	}

  public void setPassenger(Passenger passenger) {
		this.passengerId = passenger;
	}

  public void setAirfly(Airfly airfly) {
		this.airflyId = airfly;
	}

  public void setPrice(int price) {
		this.price = price;
	}

  public void setSeat(String seat) {
		this.seat = seat;
	}
}

