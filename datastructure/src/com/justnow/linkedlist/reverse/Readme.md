### 题目
反转一个链表
示例：
> 输入：1->2->3->4->5->NULL
输出：5->4->3->2->1->NULL

### 方法二：
该方法的整体思路是，保持原有的顺序不变，只是将next的指针反转。
如：
> 1->2->3->4->5->NULL
> NUll<-1<-2<-3<-4<-5 

现在需要完成，如何将后一个结点的next指针指向前一个结点，同时保证不断链。
首先需要一个cur结点，该结点为当前结点，其次还需要一个next结点作为cur的下一个结点。我们直接让
ListNode next = cur.next，即可。每次只需要将cur的next结点为前一个结点就ok了。所以，我们还需要一个pre结点
来保存cur的前一个结点，这样才能保持不断链。正确的做法如下：
第一步：让pre=null，cur=head;在本题中为cur为1这个结点
第二步：如果cur不为null，说名至少有一个结点。
第三步：next=cur.next,即next结点为下一个结点。
第四步：cur.next = pre, 让cur.next结点为其前一个结点
第五步：完成了上述步骤，一次反转就搞定了。然后需要将pre设置为当前结点，pre=cur,同时，开始反转下一个结点，所以cur=next;
第六步：现在基本上都搞定了，开始循环直到cur为null为止！
```java
ListNode pre = null, cur = head;
while (cur != null) {
    ListNode next = cur.next;
    cur.next = pre;
    pre = cur;
    cur = next;
}
return pre;
```
