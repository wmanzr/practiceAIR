package RUT.practice.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "airplane", schema = "public")
public class Airplane {
  @Id
  @Column(insertable = false, name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "seats")
  private int seats;

  @Column(name = "model")
  private String model;

  @Column(name = "status")
  private String status;
}