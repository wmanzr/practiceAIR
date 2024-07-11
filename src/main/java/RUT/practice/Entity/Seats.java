package RUT.practice.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seats", schema = "public")
public class Seats extends BaseEntity{
  private int price;
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

  public void setAirplane(Airplane airplane) {
		this.airplaneId = airplane;
	}

  public void setPrice(int price) {
		this.price = price;
	}
}
