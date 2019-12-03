import java.io.*; 

public class LinkedList{

    static Node head;

    static class Node{
        Node next;
        int data;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    public static Node insert(int data){

        if(head == null){
            Node newNode = new Node(data);
            head = newNode;
        }else{
            Node runner = head;
            while(runner.next != null){
                runner = runner.next;
            }

                Node newNode = new Node(data);
                runner.next = newNode;
                
            }

            return head;
    }

    public static Node insertRecursive(Node runner, int data){
            if(runner == null){
                head = new Node(data);
                return head;
            }
            else if(runner.next == null){
                Node newNode = new Node(data);
                runner.next = newNode;
                return head;
            }
            insertRecursive(runner.next,data);
            return head;
        
    }

    public static void printList(){
        Node runner;

        runner = head;
        while(runner != null){
            System.out.println(runner.data);
            runner = runner.next;
        }
    }

    public static void printListRecursive(Node runner){

        if(runner == null){
            return;
        }

        System.out.println(runner.data);
        printListRecursive(runner.next);

    }

    public static void updateData(Node runner, int data,int newValue){
    
        if(runner == null){
            return;
        }
        if(runner.data == data){
            runner.data = newValue;
            return;
        }

        updateData(runner.next,data,newValue);

    }

    public static void deleteNode(Node runner,int value){

        Node prevNode = head;

        if(head == null){
            return;
        }else if(runner.data == value && runner == head){
            head = head.next;
            return;
        }

        while(runner != null && runner.data != value){
            prevNode = runner;
            runner = runner.next;
           }
        
        prevNode.next = runner.next;
    }

    public static void main(String args[]){

        LinkedList l = new LinkedList();

        l.insertRecursive(l.head,4);
        l.insertRecursive(l.head,3);
        l.insertRecursive(l.head,2);
        l.insertRecursive(l.head,1);

        l.updateData(l.head,4,-1);

        l.deleteNode(l.head,1);
        
        l.deleteNode(l.head,2);
        l.deleteNode(l.head,-1);
        


       l.printListRecursive(l.head);

    }

}



  
