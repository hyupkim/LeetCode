/*
Set two pointers from outer bound to loop toward inside.
Set anohter pointer for local bound.
*/

public class Trap {
    public int trap(int[] height) {
        
        int i = 0, j = height.length - 1, res = 0;

        while (i < j) {

            if (height[i] <= height[j]) {
                int k = i + 1;
                while (height[i] > height[k]) {
                    res += height[i] - height[k];
                    k++;
                }
                i = k;

            } else {
                int k = j - 1;
                while (height[j] > height[k]) {
                    res += height[j] - height[k];
                    k--;
                }
                j = k;
            }
        }

        return res;
    }
}
