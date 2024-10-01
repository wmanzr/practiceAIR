package RUT.practice.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "airplane", schema = "public")
public class Airplane extends BaseEntity{
  private int seats;
  private String model;
  private String status;
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
}