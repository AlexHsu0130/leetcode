package leetCode;

/**
 * <pre>
 * Minimum Time Visiting All Points
 * </pre>
 * 
 * @since Jan 23, 2021
 * @author AlexHsu
 * @version
 *          <ul>
 *          <li>Jan 23, 2021,AlexHsu,new
 *          </ul>
 */
// On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi].
// Return the minimum time in seconds to visit all the points in the order given by points.

// You can move according to these rules:

// In 1 second, you can either:
// move vertically by one unit,
// move horizontally by one unit, or
// move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).
// You have to visit the points in the same order as they appear in the array.
// You are allowed to pass through points that appear later in the order, but these do not count as visits.
// 求點到點間最短時間
public class MinimumTimeVisitingAllPoints {

    public static void main(String[] args) {
        MinimumTimeVisitingAllPoints test = new MinimumTimeVisitingAllPoints();
        System.out.println(test.minTimeToVisitAllPoints(new int[][] { { 3, 2 }, { -2, 2 } }));
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        int x = points[0][0];
        int y = points[0][1];
        int destX = 0;
        int destY = 0;
        for (int[] point : points) {
            if (x != point[0] || y != point[1]) {
                destX = Math.abs(point[0] - x);
                destY = Math.abs(point[1] - y);
                time = destX != destY ? time + Math.abs(destX - destY) : time;
                if (destX != 0 && destY != 0) {
                    if (destX > destY) {
                        time = time + destY;
                    } else {
                        time = time + destX;
                    }
                }
            }
            x = point[0];
            y = point[1];
        }

        return time;
    }
}
