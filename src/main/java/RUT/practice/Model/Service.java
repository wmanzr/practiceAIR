package RUT.practice.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "service", schema = "public")
public class Service {
  @Id
  @Column(insertable = false, name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "type")
  private String type;

  @Column(name = "date")
  private LocalDate date;

  @Column(name = "time")
  private LocalTime time;

  @ManyToOne(optional = false)
  @JoinColumn(name = "passenger_id")
  private Passenger passenger;
}
