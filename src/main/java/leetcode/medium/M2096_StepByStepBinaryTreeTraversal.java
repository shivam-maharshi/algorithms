package leetcode.medium;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Link: https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another
 *
 * @author shivam.maharshi
 */
public class M2096_StepByStepBinaryTreeTraversal extends TestCase {

    @Test
    public static void test() {
        assertEquals("UURL", getDirections(null, 3, 6));
    }

    public static String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder start = new StringBuilder(), dest = new StringBuilder(), result = new StringBuilder();
        find(root, startValue, start);
        find(root, destValue, dest);
        start.reverse();
        dest.reverse();
        int minLength = Math.min(start.length(), dest.length());
        int i = 0, j = 0;
        while (i < minLength) {
            if (start.charAt(i) == dest.charAt(j)) {
                i++;
                j++;
            } else {
                break;
            }
        }

        while (i < start.length()) {
            result.append("U");
            i++;
        }

        while (j < dest.length()) {
            result.append(dest.charAt(j));
            j++;
        }

        return result.toString();
    }

    private static boolean find(TreeNode root, int val, StringBuilder sb) {
        if (root.val == val) {
            return true;
        } else if (root.left != null && find(root.left, val, sb)) {
            sb.append("L");
        } else if (root.right != null && find(root.right, val, sb)) {
            sb.append("R");
        }
        return sb.length() > 0;
    }

}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}