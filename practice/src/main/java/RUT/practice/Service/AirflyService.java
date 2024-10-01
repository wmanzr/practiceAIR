package RUT.practice.Service;

import java.util.List;
import RUT.practice.DTO.SeatsDTO;

public interface AirflyService {

public List<SeatsDTO> getAvailableSeatsForNextAirfly(String departure, String arrival);

}