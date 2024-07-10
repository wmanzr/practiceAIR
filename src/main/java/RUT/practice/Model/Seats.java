package RUT.practice.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "seats", schema = "public")
public class Seats {
  private int id;
  private int price;
  private Airplane airplane_id;
  @Id
  @Column(insertable = false, name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getId() {
    return id;
  }

  @ManyToOne
  @JoinColumn(name = "airplane_id", nullable = false)
  public Airplane getAirplane() {
    return this.airplane_id;
  }

  @Column(name = "price", nullable = false)
	public int getPrice() {
		return price;
	}

  public void setId(int id) {
		this.id = id;
	}

  public void setAirplane(Airplane airplane) {
		this.airplane_id = airplane;
	}

  public void setPrice(int price) {
		this.price = price;
	}
}
