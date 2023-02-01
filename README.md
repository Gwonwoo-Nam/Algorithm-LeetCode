3주차 알고리즘 

### 83. Remove Duplicates from Sorted List

### 접근

- 현재 노드에서 다음 노드의 값과 현재 노드의 값이 같은 경우 다음 노드를 삭제
- 현재 노드의 값과 다음 노드의 값이 다른 경우 다음 노드를 호출

```
public class ListNode {


        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        deleteNode(head);

        return head;
    }

    private static void deleteNode(ListNode node) {
        while (node != null && node.next != null) {
            int val = node.val; // 현재 노드 값 저장
            while (node != null && node.next != null && val == node.next.val) {
                ListNode temp2 = node.next.next;
                node.next = temp2;
            }
            node = node.next;
        }

    }
```

### 9. Palindrome Number

### 접근
- 팰린드롬 수인지 검사
- 나머지 연산을 이용해 reverse하고 음수를 제외시키는 방법
- String으로 StringBuffer reverse를 이용하는 방법

```aidl
public boolean isPalindrome(int x) {

        String str = Integer.toString(x);
        StringBuffer revStr = new StringBuffer(str);
        revStr.reverse();
        if (str.equals(revStr.toString())) {
            return true;
        }
        return false;
    }
```


### 14. Longest Common Prefix

### 접근

- BruteForce 접근법
- prefix의 길이를 하나씩 증가시키면서 str이 prefix로 startswith하는지 검사한다.

```aidl
public String longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE;
        String minStr = "";
        for (String str : strs) {
            min = Math.min(str.length(), min);
            minStr = str;
        }

        String prefix = "";
        for (int i = 0; i < min; i++) {
            for (String str : strs) {
                if (!str.startsWith(minStr.substring(0, i + 1))) {
                    return prefix;
                }
            }
            prefix = minStr.substring(0,i+1);
        }

        return prefix;
    }
```

### 141. Linked List Cycle

### 접근
- 노드를 순회할 때마다 노드의 배열에 추가한다.
- 이미 방문한 노드이면 true를 리턴한다.

```aidl
    public static boolean hasCycle(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        while (head != null && head.next != null) {
            if (nodes.contains(head.next)) { //다음 방문 노드가 이미 방문한 노드?
                return true;
            }
            nodes.add(head);
            head = head.next; //다음 노드로 넘어가기
        }
        return false;
    }
```

### 또 다른 접근법 (LeetCode)

Floyd’s Cycle-Finding Algorithm // fast slow approach // 2 pointers // "tortoise and the hare algorithm"

Approach: This is the fastest method and has been described below:

Traverse linked list using two pointers.

Move one pointer(slow_p) by one and another pointer(fast_p) by two.

If these pointers meet at the same node then there is a loop. If pointers do not meet then linked list doesn’t have a loop.

![img](https://assets.leetcode.com/users/images/55a1e7fb-e28e-4a21-b7c5-43274d77e10a_1646699998.33529.png)

Above linked list has a loop as node 5 is connected to node 2 foming a Cycle.

### 코드

```aidl
    public static boolean hasCycle(ListNode head) {

        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next; //느린 포인터는 1칸씩
            fastPtr = fastPtr.next.next; //빠른 포인터는 2칸씩
            if (slowPtr.equals(fastPtr)) { //두 포인터가 만나면?
                return true;
            }
        }
        return false;
    }
```