package RUT.practice.Repository;

import RUT.practice.Entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

    Passenger findPassengerById(int id);

    List<Passenger> findAllByFisrtnameAndLastname(String firstName, String lastName);

    @Transactional
    @Modifying
    @Query("INSERT INTO Service (type, serv, date, time, passengerId) " +
            "SELECT 'Special', " +
            "CASE WHEN p.health IN ('Инвалид', 'Даун') THEN 'Инвалидная коляска' " +
            "     WHEN p.health IN ('Паралич', 'Лишен конечности', 'Артрит', 'Заболевания головного мозга') THEN 'Инвалидная коляска' " +
            "     WHEN p.health IN ('Синдром Дауна', 'Пожилой') THEN 'Сопровождение' " +
            "     ELSE NULL " +
            "END, " +
            "CURRENT_DATE, CURRENT_TIME, p " +
            "FROM Passenger p " +
            "WHERE p.id = :passengerId " +
            "AND p.health IN ('Инвалид', 'Даун', 'Паралич', 'Лишен конечности', 'Артрит', 'Заболевания головного мозга', 'Синдром Дауна', 'Пожилой')")
    void ProvidingServicesSpecial(@Param("passengerId") int passengerId);

    @Transactional
    @Modifying
    @Query("INSERT INTO Service (type, serv, date, time, passengerId) " +
            "SELECT 'Food', " +
            "CASE p.preferences " +
            "     WHEN 'Рыба' THEN 'Рыба' " +
            "     WHEN 'Курица' THEN 'Курица' " +
            "     WHEN 'Говядина' THEN 'Говядина' " +
            "     WHEN 'Чай' THEN 'Чай' " +
            "     WHEN 'Кофе' THEN 'Кофе' " +
            "     ELSE " +
            "       CASE WHEN p.health = 'Диабетик' THEN 'Без сахара' " +
            "            WHEN p.health = 'Гастрит' THEN 'Обезжиренное' " +
            "            ELSE NULL " +
            "       END " +
            "END, " +
            "CURRENT_DATE, CURRENT_TIME, p " +
            "FROM Passenger p " +
            "WHERE p.id = :passengerId " +
            "AND (p.preferences IN ('Рыба', 'Курица', 'Говядина', 'Чай', 'Кофе') " +
            "     OR p.health IN ('Диабетик', 'Гастрит'))")
    void ProvidingServicesFood(@Param("passengerId") int passengerId);
}