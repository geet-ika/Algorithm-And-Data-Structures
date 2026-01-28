
import java.util.Stack;

public class LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<Integer>();
        String[] arr = input.split("\n");
        int maxLen = 0;
        stack.push(0);

        for (String s : arr) {
            int numOfTabs = s.lastIndexOf("\t") + 1;

            int level = numOfTabs + 1;
            while (level < stack.size()) {
                stack.pop();
            }

            int currentLength = stack.peek() + s.length() - numOfTabs + 1;
            stack.push(currentLength);
            if (s.contains(".")) {
                maxLen = Math.max(maxLen, currentLength - 1);
            }
        }
        return maxLen;
    }
}
