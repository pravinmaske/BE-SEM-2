package dining;

/*
@ Author :Pravin Maske*/
import com.mongodb.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Dining
{
    public static void main(String str[])
    {
        Lock fork[] = new ReentrantLock[5];
        
        try
        {
            MongoClient mongoClient = new MongoClient("localhost");
            System.out.println("\n connection created success");
            DB db = mongoClient.getDB("mydb");
            System.out.println("\nDatabase created success");
            DBCollection coll = db.createCollection("mycol", null);
            System.out.println("\n collection created success");
        }catch(Exception e){}
        
        for(int i=0;i<5;i++)
        {
            fork[i] = new ReentrantLock();
        }
        
        
       
        Thread p1 = new Thread(new Philosopher(fork[4], fork[0], "first"));
        Thread p2 = new Thread(new Philosopher(fork[0], fork[1], "second"));
        Thread p3 = new Thread(new Philosopher(fork[1], fork[2], "third"));
        Thread p4 = new Thread(new Philosopher(fork[2], fork[3], "fourth"));
        Thread p5 = new Thread(new Philosopher(fork[3], fork[4], "fifth"));

        
        
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        
    }
}

 class Philosopher implements Runnable
{
    Lock leftFork = new ReentrantLock();
    Lock rightFork = new ReentrantLock();
    String name;
    
    Philosopher(Lock leftFork,Lock rightFork,String name)
    {
            this.leftFork = leftFork;
            this.rightFork = rightFork;
            this.name = name;
    }
    public void run()
    {

            try
        {

            think(name);
            eat(leftFork,rightFork,name);

        }catch(Exception e){e.printStackTrace();}
    }
    
    public void eat(Lock leftFork,Lock rightFork,String name)throws Exception
    {
        leftFork.lock();
        rightFork.lock();
        try
        {
           
            MongoClient mongoClient =new MongoClient("localhost");
            DB db = mongoClient.getDB("mydb");
            DBCollection coll = db.getCollection("mycol");
            System.out.println(name+" ..is eating");
            BasicDBObject doc = new BasicDBObject(name ,"..eating");
            coll.insert(doc);
            Thread.sleep(1000);
            
        }catch(Exception e){e.fillInStackTrace();}
        finally
        {
            System.out.println(name+"  eating done now thinking.. ");
            MongoClient mongoClient = new MongoClient("localhost");
            DB db =mongoClient.getDB("mydb");
            DBCollection coll = db.getCollection("mycol");
            BasicDBObject doc2 = new BasicDBObject(name,"  eating done now thinking..");
            coll.insert(doc2);
            leftFork.unlock();
            rightFork.unlock();
        }        
                
        
        
    }
    
    public void think(String name)
    {
        try{
            MongoClient mongoClient  = new MongoClient("localhost");
            DB db = mongoClient.getDB("mydb");
            DBCollection coll =db.getCollection("mycol");
            System.out.println(name +" is thinking");
            BasicDBObject doc3 = new BasicDBObject(name,"  is thinking");
            coll.insert(doc3);
                Thread.sleep(1000);
            
        }catch(Exception e){e.printStackTrace();}
    }
    
    
    
    
}



/*

connection created success

Database created success

 collection created success
second is thinking
fourth is thinking
first is thinking
fifth is thinking
third is thinking
fifth ..is eating
third ..is eating
fifth  eating done now thinking.. 
third  eating done now thinking.. 
fourth ..is eating
second ..is eating
fourth  eating done now thinking.. 
second  eating done now thinking.. 
first ..is eating
first  eating done now thinking.. 
BUILD SUCCESSFUL (total time: 5 seconds

*/
