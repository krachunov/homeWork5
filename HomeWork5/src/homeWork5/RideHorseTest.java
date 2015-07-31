package homeWork5;

public class RideHorseTest {

	public static void main(String[] args) {

		RideHorse horse = new RideHorse();

		Cell[][] mat = horse.ride(6, 7, 3, 4);

		RideHorse.printMiddleCol(mat);

	}
}
