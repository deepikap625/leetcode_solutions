class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[] crow = new int[m];
        for (int j = 0; j < m; j++) {
            crow[j] = matrix[0][j] - '0';
        }
        int maxans = largestRectangleArea(crow);

        for(int i=1; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    crow[j] += 1;
                } else {
                    crow[j] = 0;
                }
            }
            int cmaxans = largestRectangleArea(crow);
                maxans = Math.max(maxans,cmaxans);
        }

        return maxans;
    }

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int n = heights.length;
        int ps[] = new int[n];
        int ns[] = new int[n];
        Stack<Integer> s = new Stack<>();
        // 1 6 4 4 6 6 

        for(int i=0; i<n; i++) {
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if(s.isEmpty()) {
                ps[i] = -1;
            } else {
                ps[i] = s.peek();
            }
            s.push(i);
        }

        Stack<Integer> ss = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            while(!ss.isEmpty() &&  heights[ss.peek()] >= heights[i]) {
                ss.pop();
            }

            if(ss.isEmpty()) {
                ns[i] = n;
            } else {
                ns[i] = ss.peek();
            }
            ss.push(i);
        }

        for(int i=0; i<n; i++) {
            int cma = (ns[i] - ps[i]-1) * heights[i];
            max = Math.max(cma,max);
        }

        return max;
    }
}