package homeWork5;

public class Cell {
	private int x;
	private int y;
	private int value;
	
	public Cell(int x, int y, int value) {
		setX(x);
		setY(y);
		setValue(value);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}



}
