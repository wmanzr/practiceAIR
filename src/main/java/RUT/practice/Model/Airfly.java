package RUT.practice.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "airfly", schema = "public")
public class Airfly {
  @Id
  @Column(insertable = false, name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "date")
  private LocalDate date;

  @Column(name = "time")
  private LocalTime time;

  @Column(name = "status")
  private String status;

  @ManyToOne(optional = false)
  @JoinColumn(name = "airplane_id")
  private Airplane airplane;

  @ManyToOne(optional = false)
  @JoinColumn(name = "flight_id")
  private Flight flight;
}
