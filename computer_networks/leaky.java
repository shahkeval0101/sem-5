	CN EXP NO -8 \AIM: Implement Leaky Bucket Algorithm for congestion control.

PROGRAM:
import java.io.*; 
import java.util.*; 
  
class Leakybucket { 
    public static void main (String[] args) { 
        int no_of_queries,storage,output_pkt_size; 
        int input_pkt_size,bucket_size,size_left; 
          
         //initial packets in the bucket 
        storage=0;     
          
        //total no. of times bucket content is checked 
        no_of_queries=4;  
          
        //total no. of packets that can  
        // be accomodated in the bucket  
        bucket_size=10; 
          
        //no. of packets that enters the bucket at a time 
        input_pkt_size=4;  
          
        //no. of packets that exits the bucket at a time 
        output_pkt_size=1;  
        for(int i=0;i<no_of_queries;i++) 
        { 
            size_left=bucket_size-storage; //space left 
              
            if(input_pkt_size<=(size_left))          
            { 
                storage+=input_pkt_size; 
                System.out.println("Buffer size= "+storage+ 
                    " out of bucket size= "+bucket_size); 
            } 
            else
            { 
                System.out.println("Packet loss = "
                            +(input_pkt_size-(size_left))); 
                              
                     //full size        
                storage=bucket_size;  
                  
                System.out.println("Buffer size= "+storage+ 
                            " out of bucket size= "+bucket_size); 
                  
            } 
            storage-=output_pkt_size; 
        } 
    } 
} 
OUTPUT:-

C:\Users\admin\Desktop>javac leaky.java
C:\Users\admin\Desktop>java Leakybucket
Buffer size= 4 out of bucket size= 10
Buffer size= 7 out of bucket size= 10
Buffer size= 10 out of bucket size= 10
Packet loss = 3
Buffer size= 10 out of bucket size= 10

