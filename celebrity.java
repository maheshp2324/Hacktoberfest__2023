
// celebrity problem gfg 

class Solution
{
    // Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
        // Initialize a stack to keep track of potential celebrities.
        Stack<Integer> stack = new Stack<>();

        // Push all the people onto the stack.
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (knows(M, a, b)) {
                // If a knows b, a cannot be the celebrity, but b might be.
                stack.push(b);
            } else {
                // If a doesn't know b, b cannot be the celebrity, but a might be.
                stack.push(a);
            }
        }

        // The remaining person on the stack could be the celebrity.
        int potentialCelebrity = stack.pop();

        // Verify if the potential celebrity is indeed a celebrity.
        for (int i = 0; i < n; i++) {
            if (i != potentialCelebrity && (knows(M, potentialCelebrity, i) || !knows(M, i, potentialCelebrity))) {
                return -1; // There is no celebrity.
            }
        }

        return potentialCelebrity;
    }

    // Helper function to check if person a knows person b.
    boolean knows(int M[][], int a, int b) {
        return M[a][b] == 1;
    }
}
