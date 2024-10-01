package RUT.practice.Service;

import java.util.List;

import RUT.practice.DTO.SeatsDTO;

public interface PassengerService {

public List<SeatsDTO> getFreeSeatsForBudget(int airflyId, int passengerId);

}