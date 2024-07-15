package RUT.practice.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "airplane", schema = "public")
public class Airplane extends BaseEntity{
  private int seats;
  private String model;
  private String status;
  private List<Seats> seatsList;

  @OneToMany(mappedBy = "airplane", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Seats> getSeatsList() {
        return seatsList;
    }

  @Column(name = "seats", nullable = false)
	public int getSeats() {
		return seats;
	}

  @Column(name = "model", nullable = false)
	public String getModel() {
		return model;
	}

  @Column(name = "status", nullable = false)
	public String getStatus() {
		return status;
	}

  public void setStatus(String status) {
		this.status = status;
	}

  public void setSeats(int seats) {
		this.seats = seats;
	}

  public void setModel(String model) {
		this.model = model;
	}

	public void setSeatsList(List<Seats> seatsList) {
        this.seatsList = seatsList;
    }
}