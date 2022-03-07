
public class FloodFill {

	int R = 0, C = 0;

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		R = image.length;
		C = image[0].length;
		helper(image, sr, sc, image[sr][sc], newColor);
		return image;

	}

	void helper(int[][] image, int x, int y, int pc, int cc) {
		if (x >= 0 && y >= 0 && x < R && y < C && image[x][y] == pc && image[x][y] != cc) {
			image[x][y] = cc;
			helper(image, x + 1, y, pc, cc);
			helper(image, x - 1, y, pc, cc);
			helper(image, x, y + 1, pc, cc);
			helper(image, x, y - 1, pc, cc);
		}

	}
}
