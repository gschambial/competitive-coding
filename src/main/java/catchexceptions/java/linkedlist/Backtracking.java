package catchexceptions.java.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking {

	public static void main(String[] args) {
		int numRows = 3;
		int numCols = 3;
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(1, 1, 1));
		list.add(Arrays.asList(1, 0, 9));
		list.add(Arrays.asList(1, 1, 1));

		int[][] arr = new int[numRows][numCols];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				arr[i][j] = list.get(i).get(j);
			}
		}

		int left = cal(arr, numRows, numCols, -1, 0, 0);
		System.out.println(left - 1);

	}

	static int cal(int[][] arr, int rows, int cols, int fv, int i, int j) {
		if (i - 1 >= 0) {
			if (arr[i - 1][j] == 9) {
				if (fv == -1 || arr[i][j] + 1 < fv) {
					return arr[i][j] + 1;
				} else {
					return fv < arr[i][j] + 1 ? fv : arr[i][j] + 1;
				}
			} else if (arr[i - 1][j] >= 1 && !(i - 1 == 0 && j == 0)) {
				if (arr[i - 1][j] == 1 || arr[i - 1][j] > arr[i][j] + 1) {
					arr[i - 1][j] = arr[i][j] + 1;
					fv = cal(arr, rows, cols, fv, i - 1, j);
				}
			}
		}
		if (j - 1 >= 0) {
			if (arr[i][j - 1] == 9) {
				if (fv != -1 || arr[i][j] + 1 < fv) {
					return arr[i][j] + 1;
				} else {
					return fv < arr[i][j] + 1 ? fv : arr[i][j] + 1;
				}
			} else if (arr[i][j - 1] >= 1 && !(i == 0 && j - 1 == 0)) {
				if (arr[i][j - 1] == 1 || arr[i][j - 1] > arr[i][j] + 1) {
					arr[i][j - 1] = arr[i][j] + 1;
					fv = cal(arr, rows, cols, fv, i, j - 1);
				}

			}
		}
		if (i + 1 < rows) {
			if (arr[i + 1][j] == 9) {
				if (fv == -1 || arr[i][j] + 1 < fv) {
					return arr[i][j] + 1;
				} else {
					return fv < arr[i][j] + 1 ? fv : arr[i][j] + 1;
				}
			} else if (arr[i + 1][j] >= 1 && !(i + 1 == 0 && j == 0)) {
				if (arr[i + 1][j] == 1 || arr[i + 1][j] > arr[i][j] + 1) {
					arr[i + 1][j] = arr[i][j] + 1;
					fv = cal(arr, rows, cols, fv, i + 1, j);
				}
			}
		}

		if (j + 1 < cols) {
			if (arr[i][j + 1] == 9) {
				if (fv == -1 || arr[i][j] + 1 < fv) {
					return arr[i][j] + 1;
				} else {
					return fv < arr[i][j] + 1 ? fv : arr[i][j] + 1;
				}
			} else if (arr[i][j + 1] >= 1 && !(i == 0 && j + 1 == 0)) {
				if (arr[i][j + 1] == 1 || arr[i][j + 1] > arr[i][j] + 1) {
					arr[i][j + 1] = arr[i][j] + 1;
					fv = cal(arr, rows, cols, fv, i, j + 1);
				}
			}
		}
		return fv;
	}

}
