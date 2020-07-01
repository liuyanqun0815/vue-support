package com.example.vuesupport.program;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: lyq
 * @createDate: 2020/3/16
 */

@Slf4j
public class MsgLogServiceImpl {



    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        if (l1 ==null && l2 !=null){
            return l2;
        }
        if (l2==null && l1!=null){
            return l1;
        }
        if (l2==null && l1==null){
            return null;
        }
        if (l1.val>l2.val){
            node.val = l2.val;
            ListNode listNode = mergeTwoLists(l1, l2.next);
             node.next = listNode;

        }else {
            node.val = l1.val;
            ListNode listNode = mergeTwoLists(l2, l1.next);
            node.next = listNode;
        }
        return node;

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode curhead = head;
        while (curhead!=null &&curhead.next!=null ){
            int curVal = curhead.val;
            int nextVal = curhead.next.val;
            if (curVal == nextVal){
                curhead.next = curhead.next.next;
            }else{
                curhead = curhead.next;
            }


        }
        return head;
    }
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next==null){
            return false;
        }
        ListNode lower =head.next;
        ListNode faster = head.next.next;
        while (lower.next != null && faster!=null){
            if (lower.val == faster.val){
                return true;
            }
            lower = lower.next;
            if(faster.next ==null ){
                return false;
            }
            faster = faster.next.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {

        if (head == null || head.next==null){
            return false;
        }
       Set<ListNode> nodes = new HashSet<>();
        while (head!=null){
            if (nodes.contains(head)){
                return true;
            }else {
                nodes.add(head);
            }
            head = head.next;

        }
        return false;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        List<ListNode> set = new ArrayList<>();
        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            boolean remove = set.remove(headB);
            if(remove){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public static  ListNode removeElements(ListNode head, int val) {

        if (head ==null){
            return null;
        }
        ListNode curNode = new ListNode(0);
        curNode.next = head;
        ListNode node = curNode;
        while (curNode.next!=null){
            int hint = curNode.next.val;
            if(val == hint){
                curNode.next = curNode.next.next;
            }else {
                curNode = curNode.next;
            }
        }
        return node.next;

//        //哨兵节点将被用于伪头
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        //当前节点指向哨兵节点
//        ListNode curr = dummy;
//        while (curr != null){
//            //当下个节点值为val时，直接next=next.next，存在连续val的可能，所以用while
//            while (curr.next != null && curr.next.val == val){
//                curr.next = curr.next.next;
//            }
//            curr = curr.next;
//        }
//        return dummy.next;
    }

    public ListNode reverseList(ListNode head) {

        if (head == null){
            return null;
        }
        ListNode cur = head;
        ListNode last = null;
        while (cur != null){
            cur.next  = last;
            cur= cur.next;

        }
        return null;
    }

    public ListNode reverse(ListNode nodes){
        if (nodes ==null || nodes.next ==null){
            return nodes;
        }
        ListNode reverse = reverse(nodes.next);
        nodes.next.next = nodes;
        nodes.next = null;
        return reverse;
    }

    public ListNode reverseList2(ListNode head) {

        if (head == null){
            return null;
        }
        ListNode cur = null;
        while (head!= null){
            ListNode nextNode = head.next;
            head.next = cur;
            cur = head;
            head = nextNode;
        }
        return cur;
    }
    public static boolean isPalindrome(ListNode head) {
        if (head == null){
            return true;
        }
        ListNode cur = null;
        ListNode old = head;
        while (head!= null){
            ListNode nextNode = head.next;
            old.next = head.next;
            old = head;
            head.next = cur;
            cur = head;
            head = nextNode;
        }
        while (old != null){
            Integer val = old.val;
            Integer nodeVal = cur.val;
            if (val != nodeVal){
                return false;
            }
            old = old.next;
            cur = cur.next;
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head) {
       if (head == null){
           return false;
       }
       List<ListNode> list = new ArrayList<>();
       while (head!= null){
           list.add(head);
           head = head.next;
       }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).val!= list.get(list.size()-i-1).val && i<list.size()/2){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome3(ListNode head) {
//        // 输入校验
//        if (head == null || head.next == null)
//            return true;
//        // 避免递归中 空指针
//        if (head.next.next == null)
//            return head.val == head.next.val ? true : false;
////        ListNode[] temp = isPalindrome(head);
//        ListNode l1 = temp[0];
//        ListNode l2 = temp[1];
//        // 遍历两条新链表，判断是否相同
//        while (l1 != null && l2 != null) {
//            if (l1.val != l2.val)
//                return false;
//            l1 = l1.next;
//            l2 = l2.next;
//        }
        return true;
    }

    public void deleteNode(ListNode node,int num) {

        if (node == null){
            return;
        }
        ListNode empty = new ListNode(-1);
        empty.next = node;
        while (empty.next != null){
            ListNode next = empty.next;
            if(next.val == num){
                empty.next = empty.next.next;
            }
                empty = empty.next;

        }
    }



    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(1);
//        ListNode node3 = new ListNode(5);
//        node1.next=node2;
//        node2.next =node3;
        ListNode node11 = new ListNode(-11);
        ListNode node12 = new ListNode(-16);
        ListNode node13 = new ListNode(10);
        ListNode node14 = new ListNode(11);
        node11.next = node12;
//        node12.next = node13;
//        node13.next = node14;
//        ListNode node5 = removeElements(node1, 1);
//        System.out.println(node5);
//
//        ListNode node = mergeTwoLists(node1, node11);
//        System.out.println(node);
//
//        ListNode node4 = deleteDuplicates(node1);
//        System.out.println(node4);
        boolean palindrome = isPalindrome(node11);
        System.out.println(palindrome);
//        hasCycle(node1);
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class CircularQueue{
  private String[] items;
  private int n =0;
  private int head = 0;
  private int tail = 0;

  public CircularQueue(int capacity){
      items = new String[capacity];
      n = capacity;
  }

  public boolean enqueue(String item){
      if ((tail+1)%n == head){
          return false;
      }
      items[tail+1] = item;
      tail = (tail+1)/n;
      return true;
  }

  public String dequeue(){
      if (head == tail){
          return null;
      }
      String item = items[tail];
      head = (head+1)%n;
      return item;
  }

    public static void main(String[] args) {
        int a =3;
        int b=8/a+1;
        int i = a % b;

        System.out.println(i);
    }
}
  class ArrayQueue{
    private String[] items;
    private int n = 0 ;
    private int head = 0 ;
    private int tail = 0;
    public ArrayQueue(int capacity){
        items = new String[capacity];
        n = capacity;
    }
    public boolean enqueue(String item){
        if (tail == n){
            if (head ==0){
                return false;
            }
            for (int i = head; i <n ; i++) {
                items[i-head]=items[i];
            }
            tail = tail - head;
            head =0;
        }
        items[tail] = item;
        tail++;
        return true;

    }

    public String dequeue(){
        if (tail == head){
            return null;
        }
        String ret = items[head];
        ++head;
        return ret;
    }
  }