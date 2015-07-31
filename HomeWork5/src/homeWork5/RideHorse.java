package homeWork5;


import java.util.LinkedList;
import java.util.Queue;

public class RideHorse {

	public Cell[][] crateMatrix(int n, int m) {
		Cell[][] matrix = new Cell[n][m];
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[0].length; y++) {
				matrix[x][y] = new Cell(x, y, 0);
			}
		}
		return matrix;
	}

	public Cell[][] ride(int n, int m, int r, int c) {
		Cell[][] matrix = crateMatrix(n, m);
		Queue<Cell> queue = new LinkedList<Cell>();
		int x = 0;
		int y = 0;

		Cell startCell = new Cell(r, c, 1);
		matrix[r][c] = startCell;
		queue.offer(startCell);

		do {
			Cell curentCell = queue.poll();
			x = curentCell.getX();
			y = curentCell.getY();

			// first position
			if ((x - 1) >= 0 && (y - 2) >= 0 && (x - 1) < matrix.length
					&& (y - 2) < matrix[x].length) {
				if (matrix[x - 1][y - 2].getValue() == 0) {
					matrix[x - 1][y - 2].setX(x - 1);
					matrix[x - 1][y - 2].setY(y - 2);
					matrix[x - 1][y - 2].setValue(matrix[x][y].getValue() + 1);
					queue.add(matrix[x - 1][y - 2]);
				}
			}
			// second position
			if ((x - 2) >= 0 && (y - 1) >= 0 && (x - 2) < matrix.length
					&& (y - 1) < matrix[x].length) {
				if (matrix[x - 2][y - 1].getValue() == 0) {
					matrix[x - 2][y - 1].setX(x - 2);
					matrix[x - 2][y - 1].setY(y - 1);
					matrix[x - 2][y - 1].setValue(matrix[x][y].getValue() + 1);
					queue.add(matrix[x - 2][y - 1]);
				}
			}
			// third position
			if ((x - 2) >= 0 && (y + 1) >= 0 && (x - 2) < matrix.length
					&& (y + 1) < matrix[x].length) {
				if (matrix[x - 2][y + 1].getValue() == 0) {
					matrix[x - 2][y + 1].setX(x - 2);
					matrix[x - 2][y + 1].setY(y + 1);
					matrix[x - 2][y + 1].setValue(matrix[x][y].getValue() + 1);
					queue.add(matrix[x - 2][y + 1]);
				}
			}
			// fourth position
			if ((x - 1) >= 0 && (y + 2) >= 0 && (x - 1) < matrix.length
					&& (y + 2) < matrix[x].length) {
				if (matrix[x - 1][y + 2].getValue() == 0) {
					matrix[x - 1][y + 2].setX(x - 1);
					matrix[x - 1][y + 2].setY(y + 2);
					matrix[x - 1][y + 2].setValue(matrix[x][y].getValue() + 1);
					queue.add(matrix[x - 1][y + 2]);
				}
			}
			// fifth position
			if ((x + 1) >= 0 && (y - 2) >= 0 && (x + 1) < matrix.length
					&& (y - 2) < matrix[x].length) {
				if (matrix[x + 1][y - 2].getValue() == 0) {
					matrix[x + 1][y - 2].setX(x + 1);
					matrix[x + 1][y - 2].setY(y - 2);
					matrix[x + 1][y - 2].setValue(matrix[x][y].getValue() + 1);
					queue.add(matrix[x + 1][y - 2]);
				}
			}
			// six position
			if ((x + 2) >= 0 && (y - 1) >= 0 && (x + 2) < matrix.length
					&& (y - 1) < matrix[x].length) {
				if (matrix[x + 2][y - 1].getValue() == 0) {
					matrix[x + 2][y - 1].setX(x + 2);
					matrix[x + 2][y - 1].setY(y - 1);
					matrix[x + 2][y - 1].setValue(matrix[x][y].getValue() + 1);
					queue.add(matrix[x + 2][y - 1]);
				}
			}
			// seventh position
			if ((x + 1) >= 0 && (y + 2) >= 0 && (x + 1) < matrix.length
					&& (y + 2) < matrix[x].length) {
				if (matrix[x + 1][y + 2].getValue() == 0) {
					matrix[x + 1][y + 2].setX(x + 1);
					matrix[x + 1][y + 2].setY(y + 2);
					matrix[x + 1][y + 2].setValue(matrix[x][y].getValue() + 1);
					queue.add(matrix[x + 1][y + 2]);
				}
			}
			// eight position
			if ((x + 2) >= 0 && (y + 1) >= 0 && (x + 2) < matrix.length
					&& (y + 1) < matrix[x].length) {
				if (matrix[x + 2][y + 1].getValue() == 0) {
					matrix[x + 2][y + 1].setX(x + 2);
					matrix[x + 2][y + 1].setY(y + 1);
					matrix[x + 2][y + 1].setValue(matrix[x][y].getValue() + 1);
					queue.add(matrix[x + 2][y + 1]);
				}
			}

		} while (queue.size() > 0);
		return matrix;

	}

	public static void printMiddleCol(Cell[][] matrix) {
		Cell[][] currentMatrix = matrix;
		int demandColumn = currentMatrix.length / 2;
		for (int x = 0; x < currentMatrix.length; x++) {
			for (int y = 0; y < currentMatrix.length; y++) {
				if (y == demandColumn) {
					System.out.println(currentMatrix[x][y].getValue());
				}
			}
		}
	}
}
