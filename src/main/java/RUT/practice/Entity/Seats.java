package RUT.practice.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seats", schema = "public")
public class Seats extends BaseEntity{
  private int price;
  private String status;
  private Airplane airplaneId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "airplaneId", referencedColumnName = "id")
  public Airplane getAirplane() {
    return this.airplaneId;
  }

  @Column(name = "price", nullable = false)
	public int getPrice() {
		return price;
	}

  @Column(name = "status", nullable = false)
	public String getStatus() {
		return status;
	}

  public void setAirplane(Airplane airplane) {
		this.airplaneId = airplane;
	}

  public void setPrice(int price) {
		this.price = price;
	}

  public void setStatus(String status) {
		this.status = status;
	}
}