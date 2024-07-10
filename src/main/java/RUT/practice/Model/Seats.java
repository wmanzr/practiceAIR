package RUT.practice.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "seats", schema = "public")
public class Seats {
  @Id
  @Column(insertable = false, name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "price")
  private String price;

  @ManyToOne(optional = false)
  @JoinColumn(name = "airplane_id")
  private Airplane airplane;
}
