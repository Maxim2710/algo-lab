public class ContainerWithMostWater {
    public int maxArea(int[] heights) {
        int r = heights.length - 1;
        int l = 0;
        int res = 0;
        
        while (l < r) {
            int area = Math.min(heights[l], heights[r]) * (r - l);
            res = Math.max(area, res);
            
            if (heights[l] <= heights[r]) l++;
            else r--;

        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,7,2,5,4,7,3,6};
        int[] nums2 = new int[]{2,2,2};
        
        ContainerWithMostWater c = new ContainerWithMostWater();

        System.out.println(c.maxArea(nums1));
        System.out.println(c.maxArea(nums2));
    }
}

/*
1. Делаем цикл по всем высотам:
    - На каждой итерации считаем площадь бассейна и заполняем наибольшую
    - Если текущая левая граница меньше или равна правой, пробуем найти что-то более высокое и двигаем l
    - В противном же случае двигаем r
 */