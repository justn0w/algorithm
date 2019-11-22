### 15 offer_24
题目：如果字符串是通过单链表来存储的，请判断该字符串是否为一个回文字符串

### 一、存在的问题
看下面的代码，
```java
ListNode node = head;
node.next = null;
```
这样执行一下，会发现以head为头结点的链表，突然next就为null。
因为，此时node和head指向同一个链表，所以，在node上操作链表就是在head上操作链表