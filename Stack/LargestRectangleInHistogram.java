import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = new int[]{7,1,7,2,2,4};

        LargestRectangleInHistogram l = new LargestRectangleInHistogram();

        System.out.println(l.largestRectangleArea(heights));
    }


    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && heights[i] < stack.peek()[1]) {
                int[] pair = stack.pop();
                int index = pair[0];
                int val = pair[1];
                maxArea = Math.max(val * (i - index), maxArea);
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }

        for (int[] pair : stack) {
            int index = pair[0];
            int val = pair[1];
            maxArea = Math.max(maxArea, val * (heights.length - index));
        }

        return maxArea;
    }
}

// 7,1,7,2,2,4

/*
stack:
1) [0, 7]
2) [0, 7] -> 1 -> 1 < 7 -> maxArea = 7 -> stack: [0, 1]
3) [0, 1] -> 7 > 1 -> [0,1], [2, 7]
4) [0,1], [2, 7] -> 2 < 7 -> maxArea = max(maxArea, 7 * (3 - 2)) = 7 -> [0,1], [2,2]
5) [0,1], [2,2] -> 2 < 2 -> [0,1], [2,2], [4, 2]
6) [0,1], [2,2], [4, 2], [5, 4]

for:
1) 1 * (6 - 0) = 5
2) 2 * (6 - 2) = 8
3) 2 * (6 - 4) = 4
4) 4 * (6 - 5) = 4

maxArea(maxArea, 8) => 8
 */
