package com.epam.task4;
/*PROBLEM STATEMENT
 
 
A queue is an abstract data type that maintains the order in which elements were added to it, allowing the oldest elements to be removed from the front and new elements to be added to the rear. This is called a First-In-First-Out (FIFO) data structure because the first element added to the queue (i.e., the one that has been waiting the longest) is always the first one to be removed.

A basic queue has the following operations:

Enqueue: add a new element to the end of the queue.
Dequeue: remove the element from the front of the queue and return it.
In this challenge, you must first implement a queue using two stacks. Then process  queries, where each query is one of the following  types:

1 x: Enqueue element  into the end of the queue.
2: Dequeue the element at the front of the queue.
3: Print the element at the front of the queue.

* Input Format

	The first line contains a single integer, , denoting the number of queries. 
	Each line  of the  subsequent lines contains a single query in the form described in the problem statement above. All three queries start with an integer denoting the query , but only query  is followed by an additional space-separated value, , denoting the value to be enqueued.

* Constraints
	1<=q<=10^5
	1<=type<=3
	1<=|x|<=10^9
	It is guaranteed that a valid answer always exists for each query of type .
	 
 
* Output Format

	For each query of type , print the value of the element at the front of the queue on a new line.

* Sample Input							* Sample Output

	10									14
	1 42									14
	2
	1 14
	3
	1 28
	3
	1 60
	1 78
	2
	2


 */

import java.util.Scanner; 


class Queue_Using_stack
{
    public static final int MAX = 1000000; 
    static int top1=-1;
    static int top2=-1; 
    static int stack1[] = new int[MAX];
    static int stack2[] = new int[MAX];
    public static void enqueue(int x)  //function for passing elements into stack
    { 
        // Push item into a1  
    	stack1[++top1]=x;
        if(top1==0)//if top1 is 0 then i am assigning the given element into stack stack2
        	stack2[0]=x;
    }  
  
    public static void dequeue(int type)  //function for removing and printing elements from the queue
    {  
        // if first stack is empty  
        if (top1==-1)  
        {  
            //System.out.println("Q is Empty");  
            //System.exit(0);  
        }  
        // deleting top of stack1  
        if(type==2)
        {   int c=0;
            for(int i=0;i<=top1-1;i++)//performing left shift operation
            {
            	stack1[i]=stack1[i+1];
                c++;
            }
           
            for(int i=0;i<c;i++) //copying all the elemets of stack1 to stack2
            {
            	stack2[i]=stack1[i];
            }
             top1--;
        }
        else
        System.out.println(stack1[0]);//printing the first element
          
    }
    public static void main(String[] args) 
    {
        int type,no_of_queries,x,i;
        Scanner sc=new Scanner(System.in);
        no_of_queries=sc.nextInt();
        for(i=0;i<no_of_queries;i++)
        {
            type=sc.nextInt();
            if(type==1)/*if type is one we are pushing it */
            {
               
                x=sc.nextInt();
                enqueue(x);
            }
            else 
            dequeue(type);
            
        }
        sc.close();
    }
    
}

