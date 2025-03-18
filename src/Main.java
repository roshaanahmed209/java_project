import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

class Node {
    int data;
    Node next;
    String names;

    public Node(String names) {
        this.names = names;
    }

    Node(int data) {
        this.data = data;
        next = null;
    }
}
class queue {
    Node head = null;
    Node tail = null;


    public  boolean isEmpty() {
        return head == null && tail == null;
    }

    public  void addname(String n) {
        Node newNode = new Node(n);
        if(isEmpty()) {
            tail = head = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }


    public  void add(int data) {
        Node newNode = new Node(data);
        if(isEmpty()) {
            tail = head = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }


    public  int remove() {
        if(isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }
        int front = head.data;
        if(head == tail) {
            tail = null;
        }
        head = head.next;
        return front;
    }

    public  int peek() {
        if(isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }
        return head.data;
    }

    public String peekname() {
        if(isEmpty()) {
            return "empty queue";
        }
        return head.names;
    }
}





class rank{


    queue q1=new queue();
    queue q2=new queue();
    String[] names= new String[7];
    int[] capability =new int[7];



    Scanner sc=new Scanner(System.in);
    String yes="yes",YES="YES";
    String no="no",NO="NO";
    int count=0;

    public void ranking(){
        for (int i=0;i< names.length;i++){
            count=0;
            System.out.println("\t---------ENTER NAME: ---------");
            names[i]=sc.next();
            System.out.println();
            System.out.println("\t---------SKILLS--------------");
            System.out.println();
            System.out.println("Answer the following questions in yes or no");
            System.out.println();

//            System.out.println("ARE YOU FIMALIAR WITH JAVA?");
//            String ans1=sc.next();
//            counting(yes,ans1,YES);
//            System.out.println();
//
//
//            System.out.println("ARE YOU FIMALIAR WITH PYTHON?");
//            String ans2=sc.next();
//            counting(yes,ans2,YES);
//            System.out.println();
////
//
//            System.out.println("ARE YOU FIMALIAR WITH JAVASCRIPT?");
//            String ans4=sc.next();
//            counting(yes,ans4,YES);
//            System.out.println();
////

            System.out.println("ENTER YEARS OF EXPERIENCE RELATED TO THIS FIELD:");
            int exp=sc.nextInt();
            count=count+exp;
            System.out.println();



            capability[i]=count;
            System.out.println("counter"+ i+" "+capability[i]);
            queadd(names[i],count);
        }


    }
    public void counting(String s1, String s2, String s3){
        if(s1.equals(s2) || s2.equals(s3))
            count++;
    }

    public void queadd(String name,int cap){
        q1.add(cap);
        q2.addname(name);

    }


    public void quepeek(){
        System.out.println(q1.peek());
        q1.remove();
        System.out.println(q2.peekname());
        q2.remove();
    }


    int[] sort = new int[capability.length];
    String[] sortname = new String[names.length];

    public void sorting() throws InterruptedException {

        for (int i = 0; i < sort.length; i++) {

            Thread.sleep(2000);
            System.out.println("---------NEXT CONTESTANT--------");
            System.out.println(q2.peekname());


            sort[i] = q1.peek();
            q1.remove();
            sortname[i] = q2.peekname();
            q2.remove();


            int key = sort[i];
            int j = i - 1;
            String keyname = sortname[i];

            while (j >= 0 && sort[j] > key) {
                sort[j + 1] = sort[j];
                sortname[j + 1] = sortname[j];
                j = j - 1;
            }
            sort[j + 1] = key;
            sortname[j + 1] = keyname;
        }
//        System.out.println("sorted arrays: ");
//
//        for (int i = 0; i < sort.length; i++) {
//            System.out.println(sort[i]);
//        }
//        for (int i = 0; i < sortname.length; i++) {
//            System.out.println(sortname[i]
//            );
//        }


    }
    public void elimination(){
        //stack using Linked List


        Stack st = new Stack();
        Stack1 stn=new Stack1();

        int[] revarr=new int[sort.length];
        String[] revname=new String[sortname.length];

        for(int i=sort.length-1,x=0;i>=0;i--,x++){
            revarr[x]=sort[i];
            revname[x]=sortname[i];

        }
        for(int i=0;i< sort.length;i++){
            st.push(revarr[i]);
            stn.push(revname[i]);
        }
        System.out.println("-------CONTENDERS WITH LESS THEN 6 SCORE WILL BE ELIMINATED--------");
        System.out.println("------------------REMAINING CONTENDERS ARE: -----------------------");
        System.out.println();

        for(int i=0;i< revarr.length;i++){
            if(revarr[i]<6){
                st.pop();
                stn.pop();
            }

        }
        while(!stn.isEmpty()) {
            System.out.println(stn.peek());
            stn.pop();
        }



    }
    //    public void fileC(){
//        try {
//            File myObj = new File("C:\\Users\\ROSHAAN\\Desktop\\cvdata.txt");
//            if (myObj.createNewFile()) {
//                System.out.println("File created: " + myObj.getName());
//            } else {
//                System.out.println("File already exists.");
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }
    public void fileWnR() throws IOException {
        File file = new File("H:\\codes\\semester 3\\cvdata.txt");

        BufferedReader br= new BufferedReader(new FileReader(file));
        BufferedReader br1= new BufferedReader(new FileReader(file));
        BufferedReader br2= new BufferedReader(new FileReader(file));
        String st,tt,pt;
        int idx=0,idx2=0;
        Boolean flag=true;
        int cut=0;

        while ((pt = br1.readLine()) != null){
            for (int i=0;(tt = br1.readLine()) != null&&flag;i++){
                if(tt.equals(" ")){
                    break;
                }
                if(i==0){
                    names[idx]=pt;
                    System.out.println(names[idx]);
                    idx++;
                    flag=false;
                    cut=0;
                }
                if(tt.toLowerCase().equals("java")){
                    cut++;
                    flag = true;
                }
                if(tt.toLowerCase().equals("python")){
                    cut++;
                    flag = true;
                }
                if(tt.toLowerCase().equals("sql")){
                    cut++;
                    flag = true;
                }
                if(tt.toLowerCase().equals("javascript")){
                    cut++;
                    flag = true;
                }
                if(tt.toLowerCase().equals("powerbi")){
                    cut++;
                    flag = true;
                }
                if(tt.toLowerCase().equals("excel")){
                    cut++;
                    flag = true;
                }
                if(tt.toLowerCase().equals("c++")){
                    cut++;
                    flag = true;
                }


                capability[idx2]=cut;
            }

            idx2++;

        }


        for(int i =0;i<capability.length;i++){
            queadd(names[i],capability[i] );
        }

    }
    public void eliminationf(){
        class node{

            node next;
            int data;
            String name;


        }
        class list{
            node head;
            public void build(int a){
                node newnode=new node();
                newnode.data=a;
                newnode.next=null;

                if(head==null){
                    head=newnode;
                }else{
                    node temp=head;
                    while(temp.next!= null){
                        temp=temp.next;
                    }
                    temp.next=newnode;
                }

            }
            public void buildname(String a){
                node newnode=new node();
                newnode.name=a;
                newnode.next=null;

                if(head==null){
                    head=newnode;
                }else{
                    node temp=head;
                    while(temp.next!= null){
                        temp=temp.next;
                    }
                    temp.next=newnode;
                }

            }

            public void del(int index){
                node temp=head;
                node temp2=temp;
                for(int i=0;i<=index;i++){
                    temp2=temp;
                    temp=temp.next;
                }
                temp2.next=temp.next;
                temp=null;

            }
            public void deleteNode(int key) {
                node temp = head, prev = null;
                if (temp != null && temp.data == key) {
                    head = temp.next; // Changed head
                    return;
                }
                while (temp != null && temp.data != key) {
                    prev = temp;
                    temp = temp.next;
                }

                if (temp == null)
                    return;

                prev.next = temp.next;
            }
            public void deleteNode2(String key) {
                node temp = head, prev = null;
                if (temp != null && !temp.name.equals(key)) {
                    head = temp.next;
                    return;
                }
                while (temp != null && !temp.name.equals(key)) {
                    prev = temp;
                    temp = temp.next;
                }

                if (temp == null)
                    return;

                prev.next = temp.next;
            }

            void remove(String str){
                var current = head;
                int index = 0;
                while(current!=null && current.name!=str){
                    current = current.next;
                    index++;
                }
                if(current == null)
                    return;
                current = head;
                node prev = null;
                for(int idx = 0; idx<=index; idx++){
                    if(idx == index-1){
                        prev = current;
                    }
                    current = current.next;
                }
                prev.next = current.next;
                var t = current;
                t = null;
            }

            public void display(){
                node temp=head;
                while (temp!=null){
                    System.out.println(temp.data);
                    temp=temp.next;
                }
            }
            public void display2(){
                node temp=head;
                while (temp!=null){
                    System.out.println(temp.name);
                    temp=temp.next;
                }
            }
        }



        list l=new list();
        list l2=new list();
        int[] revarr=new int[sort.length];
        String[] revname=new String[sortname.length];

        int x=0;
        for(int i=sort.length-1;i>=0;i--){
            revarr[x]=sort[i];
            revname[x]=sortname[i];
            x++;
        }

        for(int i=0;i< revarr.length;i++){
            if(revarr[i]>5) {
                l.build(revarr[i]);
                l2.buildname(revname[i]);
            }
        }

        System.out.println("-------CONTENDERS WITH LESS THEN 6 SCORE WILL BE ELIMINATED--------");
        System.out.println("------------------REMAINING CONTENDERS ARE: -----------------------");
        System.out.println();
        l2.display2();

    }


}

class Noden {
    int data;
    Noden next;

    Noden(int data) {
        this.data = data;
        next = null;
    }
}

class Stack {
    public  Noden head = null;

    public  void push(int data) {
        Noden newNode = new Noden(data);

        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public  boolean isEmpty() {
        return head == null;
    }

    public  int pop() {
        if(isEmpty()) {
            return -1;
        }
        Noden top = head;
        head = head.next;
        return top.data;
    }

    public  int peek() {
        if(isEmpty()) {
            return -1;
        }
        Noden top = head;
        return top.data;
    }
}
class Node1 {
    String name;
    Node1 next;

    Node1(String name) {
        this.name = name;
        next = null;
    }
}

class Stack1 {
    public  Node1 head = null;

    public  void push(String name) {
        Node1 newNode = new Node1(name);

        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public  boolean isEmpty() {
        return head == null;
    }

    public  String pop() {
        if(isEmpty()) {
            return "n";
        }
        Node1 top = head;
        head = head.next;
        return top.name;
    }

    public  String peek() {
        if(isEmpty()) {
            return "n";
        }
        Node1 top = head;
        return top.name;
    }
}

public class Main {
    public static void main(String args[]) throws InterruptedException, IOException {
        rank r=new rank();
        Scanner sc=new Scanner(System.in);

        System.out.println("------DO YOU WANT TO READ A FILE OR ENTER NEW DATA------");
        System.out.println("--------------------------ENTER------------------------- \n1-TO READ A FILE\n2-TO ENTER NEW DATA");
        int x = sc.nextInt();

        switch (x) {
            case 1:
                r.fileWnR();
                r.sorting();
                r.eliminationf();
                break;
            case 2:
                r.ranking();
                r.sorting();
                r.elimination();
                break;
        }



    }

}