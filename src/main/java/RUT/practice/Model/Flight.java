package RUT.practice.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "flight", schema = "public")
public class Flight {
  @Id
  @Column(insertable = false, name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "departure")
  private String departure;

  @Column(name = "arrival")
  private String arrival;
}