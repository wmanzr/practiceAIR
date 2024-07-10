package RUT.practice.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "service", schema = "public")
public class Service {
  private int id;
  private String type;
  private LocalDate date;
  private LocalTime time;
  private Passenger passenger_id;
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

  @Column(name = "date", nullable = false)
	public LocalDate getDate() {
		return date;
	}

  @Column(name = "time", nullable = false)
	public LocalTime getTime() {
		return time;
	}

  @Column(name = "type", nullable = false)
	public String getType() {
		return type;
	}

  public void setId(int id) {
		this.id = id;
	}

  public void setDate(LocalDate date) {
		this.date = date;
	}

  public void setTime(LocalTime time) {
		this.time = time;
	}

  public void setType(String type) {
		this.type = type;
	}

  public void setPassenger(Passenger passenger) {
		this.passenger_id = passenger;
	}
}
