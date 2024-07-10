package RUT.practice.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket", schema = "public")
public class Ticket {
  private int id;
  private int price;
  private String seat;
  private Passenger passenger_id;
  private Airfly airfly_id;
  @Id
  @Column(insertable = false, name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getId() {
    return id;
  }

  @ManyToOne
  @JoinColumn(name = "passenger_id", nullable = false)
  public Passenger getPassenger() {
    return this.passenger_id;
  }

  @ManyToOne
  @JoinColumn(name = "airfly_id", nullable = false)
  public Airfly getAirfly() {
    return this.airfly_id;
  }

  @Column(name = "price", nullable = false)
	public int getPrice() {
		return price;
	}

  @Column(name = "seat", nullable = false)
	public String getSeat() {
		return seat;
	}

  public void setId(int id) {
		this.id = id;
	}

  public void setPassenger(Passenger passenger) {
		this.passenger_id = passenger;
	}

  public void setAirfly(Airfly airfly) {
		this.airfly_id = airfly;
	}

  public void setPrice(int price) {
		this.price = price;
	}

  public void setSeat(String seat) {
		this.seat = seat;
	}

}

