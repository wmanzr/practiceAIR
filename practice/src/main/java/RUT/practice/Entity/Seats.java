package RUT.practice.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "seats", schema = "public")
public class Seats extends BaseEntity{
  private int price;
  private String status;
  private Airplane airplaneId;
  private Airfly airflyId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "airplaneId", referencedColumnName = "id")
  @JsonIgnore
  public Airplane getAirplane() {
    return this.airplaneId;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "airflyId", referencedColumnName = "id")
  @JsonIgnore
  public Airfly getAirfly() {
    return this.airflyId;
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

  public void setAirfly(Airfly airfly) {
		this.airflyId = airfly;
	}

  public void setPrice(int price) {
		this.price = price;
	}

  public void setStatus(String status) {
		this.status = status;
	}
}