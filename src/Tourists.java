import java.util.*;

/**
 * Not finished
 * https://naipc16.kattis.com/problems/tourists
 * Created by Alex Dao on 4/16/16.
 */
public class Tourists {
    private Map<Integer, Set<Integer>> map;

    public static void main(String args[]) {
        Tourists t = new Tourists();
        t.solve();
    }

    private void solve() {
        map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n - 1; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            if (map.containsKey(first)) {
                map.get(first).add(second);
            } else {
                Set<Integer> set = new HashSet<Integer>();
                set.add(second);
                map.put(first, set);
            }

            if (map.containsKey(second)) {
                map.get(second).add(first);
            } else {
                Set<Integer> set = new HashSet<Integer>();
                set.add(first);
                map.put(second, set);
            }
        }

        Set<Integer> keySet = map.keySet();

        int result = 0;
        for (int i : keySet) {
            result += findDistance(i);
        }
        System.out.println(result);
    }

    private int findDistance(int i) {
        HashSet<Integer> visited = new HashSet<>();
        Stack<NodeWithPath> stack = new Stack<>();
        stack.push(new NodeWithPath(i, 1));
        int length = 0;
        while (!stack.empty()) {
            NodeWithPath next = stack.pop();
            //base case
            if ((next.value % i == 0) && (next.value != i)) {
                //System.out.println("i: "+ i + "\tj: "+next.value + "\tlen: "+next.length);
                length += next.length;
            }

            if (!visited.contains(next.value)) {
                visited.add(next.value);
                Set<Integer> neighbors = map.get(next.value);
                for (int k : neighbors) {
                    if (!visited.contains(k)) {
                        stack.push(new NodeWithPath(k, next.length + 1));
                    }
                }
            }
        }

        return length;
    }

    private class NodeWithPath {

        int length;
        int value;

        private NodeWithPath(int value, int length) {
            this.value = value;
            this.length = length;
        }
    }
}