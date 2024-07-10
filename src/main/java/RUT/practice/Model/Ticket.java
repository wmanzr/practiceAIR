package RUT.practice.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket", schema = "public")
public class Ticket {
  @Id
  @Column(insertable = false, name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "price")
  private String price;

  @Column(name = "seat")
  private String seat;

  @ManyToOne(optional = false)
  @JoinColumn(name = "passenger_id")
  private Passenger passenger;

  @ManyToOne(optional = false)
  @JoinColumn(name = "airfly_id")
  private Airfly airfly;
}

