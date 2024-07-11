package RUT.practice.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "airfly", schema = "public")
public class Airfly extends BaseEntity{
  private LocalDate date;
  private LocalTime time;
  private String status;
  private Flight flightId;
  private Airplane airplaneId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "flightId", referencedColumnName = "id")
  public Flight getFlight() {
    return this.flightId;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "airplaneId", referencedColumnName = "id")
  public Airplane getAirplane() {
    return this.airplaneId;
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

  public void setFlight(Flight flight) {
		this.flightId = flight;
	}

  public void setAirplane(Airplane airplane) {
		this.airplaneId = airplane;
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