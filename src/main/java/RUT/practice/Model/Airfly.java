package RUT.practice.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "airfly", schema = "public")
public class Airfly {
  private int id;
  private LocalDate date;
  private LocalTime time;
  private String status;
  private Flight flight_id;
  private Airplane airplane_id;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(insertable = false, name = "id")
  public int getId() {
		return id;
	}

  @ManyToOne
  @JoinColumn(name = "flight_id", nullable = false)
  public Flight getFlight() {
    return this.flight_id;
  }

  @ManyToOne
  @JoinColumn(name = "airplane_id", nullable = false)
  public Airplane getAirplane() {
    return this.airplane_id;
  }

  @Column(name = "date", nullable = false)
	public LocalDate getDate() {
		return date;
	}

  @Column(name = "time", nullable = false)
	public LocalTime getTime() {
		return time;
	}

  @Column(name = "status", nullable = false)
	public String getStatus() {
		return status;
	}

  public void setId(int id) {
		this.id = id;
	}

  public void setFlight(Flight flight) {
		this.flight_id = flight;
	}

  public void setAirplane(Airplane airplane) {
		this.airplane_id = airplane;
	}

  public void setDate(LocalDate date) {
		this.date = date;
	}

  public void setTime(LocalTime time) {
		this.time = time;
	}

  public void setStatus(String status) {
		this.status = status;
	}
}