package RUT.practice.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "service", schema = "public")
public class Services extends BaseEntity{
  private String type;
  private String serv;
  private LocalDate date;
  private LocalTime time;
  private Passenger passengerId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "passengerId", referencedColumnName = "id")
  public Passenger getPassenger() {
    return this.passengerId;
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

	@Column(name = "serv", nullable = false)
	public String getServ() {
		return serv;
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

	public void setServ(String serv) {
		this.serv = serv;
	}

  public void setPassenger(Passenger passenger) {
		this.passengerId = passenger;
	}
}
