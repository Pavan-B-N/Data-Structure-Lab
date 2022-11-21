
package linkedliststackapp;

import java.util.Scanner;
public class LinkedListStackApp {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        LinkedListStack stack=new LinkedListStack();
        System.out.println("\t\tLinkedList App\t");
        boolean flag=true;
        while(flag){
            System.out.println("1.Push Element in Stack");
            System.out.println("2.Pop an element from stack");
            System.out.println("3.Display the stack");
            System.out.println("4.Exit");
            System.out.print("Selct your option = ");
            int choice=scan.nextInt();
            switch(choice){
                case 1:{
                    System.out.print("Enter the lement to push: ");
                    int ele=scan.nextInt();
                    if(stack.push(ele)){
                        System.out.println(ele+" Successfuly pushed to stack");
                    }else{
                        System.out.println("stack overflow");
                    }
                    break;
                }
                case 2:{
                    int ele=stack.pop();
                    if(ele==-1){
                        System.out.println("Stcak Underflow");
                    }else{
                        System.out.println(ele+" poped out of the stack");
                    }
                    break;
                }
                case 3:{
                    System.out.println("Stack contents are");
                    stack.display();
                    break;
                }
                case 4:{
                    flag=false;
                        break;
                }
                default:System.out.println("Invalid choice");
            }

            
        }
                    scan.close();
    }
    
}
class LinkedListStack{
    Node top;

    public LinkedListStack() {
        top=null;
    }
    
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    
    boolean push(int data){
        Node newNode=new Node(data);
        newNode.next=top;
        top=newNode;
        return (top!=null);
    }
    
    
    boolean isEmpty(){
        return top==null;
    }
    int pop(){
        if(isEmpty())
            return -1;
        else{
            int ele=top.data;
            top=top.next;
            return ele;
        }
    }
    int peek(){
        return top.data;
    }
    
    void display(){
        Node temp=top;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
}