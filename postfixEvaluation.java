/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedliststackapp;

/**
 *
 * @author REVA9
 */
import java.util.Scanner;
public class postFixExpressionEvaluation {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter the Expression in postfix : ");
        String exp=scan.nextLine();
        System.out.println("Result = "+evaluatePostfix(exp));
        scan.close();
        
    }
    static int evaluatePostfix(String exp){
        Stack stack=new Stack();
        for(int i=0;i<exp.length();i++){
        char c=exp.charAt(i);
        if(Character.isSpaceChar(c))
                continue;
        else if(Character.isAlphabetic(c)){
            System.out.print("Expresion should contains only digits");
            System.exit(0);
        }
        
        else if(Character.isDigit(c)){
            int n=0;
            while(Character.isDigit(c)){
                n=n*10+(int)(c-'0');
                i++;
                c=exp.charAt(i);
            }
            i--;
            stack.push(n);
        }
        else{
            int v1=stack.pop();
            int v2=stack.pop();
            switch(c){
                case '+':{
                    stack.push(v1+v2);
                    break;
                }
                
                case '-':{
                    stack.push(v2-v1);
                    break;
                }
                
                case '*':{
                    stack.push(v1*v2);
                    break;
                }
                
                case '/':{
                    stack.push(v2/v1);
                    break;
                }
            }
        }
        
        }
        return stack.pop();
    }
}
class Stack{
    Node top;

    public Stack() {
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