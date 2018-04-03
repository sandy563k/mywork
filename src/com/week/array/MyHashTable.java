package com.week.array;


public class MyHashTable {
    Node[] nArray;
    int size;

    MyHashTable(int initialCapacity){
        nArray=new Node[initialCapacity];
        this.size=initialCapacity;
    }



    public boolean put(Object key,Object value){
        boolean result=true;
        Node head=nArray[genHashcodeIndex(key)];
       if(head==null){
           head=new Node();
           head.key=key;
           head.value=value;
           head.next=null;
           nArray[genHashcodeIndex(key)]=head;
           return true;

       }

           if(head.key==key)
           {
               head.value=value;
               return true;
           }

        while(head.next!=null){
            if(head.key==key){
                head.value=value;
                return true;
            }
            head=head.next;

        }
        head.next=new Node();
        head.next.key=key;
        head.next.value=value;


        return result;
    }

   /* public Integer get(int key){
        Node head=nArray[genHashcodeIndex(key)];
        while (head!=null){
            if(key==head.key){
                return head.value;
            }else{
                head=head.next;
            }

        }
        return null;
    }*/



   int genHashcodeIndex(Object key){
        int result= key.hashCode()%size;
        return result;
   }

    class Node{
        Object key;
        Object value;
        Node next;
    }
}
