### 题目：在O(1) 时间内删除链表节点。
给定单链表的头指针和一个节点指针，定义一个函数在O(1) 时间内删除该节点。链表节点与函数定义如下：
```java
public List Node {
    int value;
    ListNode next; 
}

方法：
void deleteNode(ListNode head, Node toBeDeleted);
```

#### 一、本题解决的思路
个人感觉，本题的难点在于，待删除节点必须存在于链表中，可以通过下面的代码获取
```java
Node toBeDeleted = linkedList.head.next.next // 获取该链表的第二个节点
```

#### 二、考虑边界情况
* 待删除节点在尾部
* 该链表为空

#### 三、关于时间复杂度
按照常规思路来解决这个问题，一般是按照顺序从第一个节点开始查询，直到找到节点，然后将其删除。时间复杂度为O(n)
* 什么是平均时间复杂度？
* 题目中说的时间复杂度指的是什么复杂度？
