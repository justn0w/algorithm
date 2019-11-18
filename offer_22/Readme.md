### 题目：删除链表中重复的节点
在一个排序的链表中，如何删除重复的节点？例如：
1->2->2->3->4->4->4->5 删除重复之后<br>
1->3->5

#### 一、分析问题
##### 1、一定要看清题目，题目中说的是一个排序的链表，所以，重复的节点一定是紧挨着的。
#### 二、解题思路
1. 初始化一个空节点，作为头结点
2. 用last指针指向重复节点的指针，pre指向重复节点前面的一个节点。
3. 如果last的下一个指针不为空，同时last的下一个节点的值与last的值相同，说明此时该节点为重复节点。
然后，使用循环使last指向重复节点的最后一个节点。此时，因为要删除节点，所以我们还需要将pre.next指向last.next指向的节点，实现删除功能。
4. 如果last的下一个指针不为空，同时last的下一个节点的值与last的值不相同。那我们直接将pre和last分别后移一个节点
#### 三、代码如下
```java
    public ListNode deleteDuplication(ListNode headNode) {
        if (headNode == null) {
            return headNode;
        }

        ListNode head = new ListNode(); //创建一个空节点，防止第1个节点和之后的节点相同
        head.next = headNode;
        ListNode pre = head;
        ListNode last = pre.next;

        while (last != null) {
            if (last.next != null && last.val == last.next.val) {
                // 找到最后一个相同的节点
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            } else {
                pre = pre.next;
                last = last.next;
            }
        }
        return head.next;
    }
```