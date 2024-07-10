package RUT.practice.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "passenger", schema = "public")
public class Passenger {
  @Id
  @Column(insertable = false, name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "firstname")
  private String fisrtname;

  @Column(name = "lastname")
  private String lastname;

  @Column(name = "pass")
  private String pass;

  @Column(name = "health")
  private String health;
}