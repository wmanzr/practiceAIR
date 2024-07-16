package RUT.practice.Exception;

public class NoFreeSeats extends RuntimeException{
    public NoFreeSeats(Integer airplaneId) {
        super("No empty seats found on the airplane " + airplaneId);
    }
}