/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package producer_comsumer_assignment;

/**
 *
 * @author L E G I O N
 */

import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Consumer extends Thread 
{
    Buffer buf;
    long number;
    Producer p;
    String file;

    public Consumer(Buffer buf , long n,String file)
    {
        this.buf = buf;
        this.number = n;
        this.file=file;
    }

    public void run()
    {
        long x= number;
        for(int i=0;i<buf.count;i++)
        {
                try {
                    FileWriter f=new FileWriter(file,true);
                    BufferedWriter p =new BufferedWriter(f);
                    if(i%15==0)
                        p.append("\n");
                    p.append("'");
                    p.append(Long.toString(buf.consume()));
                    p.append("' ");
                    p.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        
        String one = Long.toString(buf.maxItem);// --> max prime
        String two = Long.toString(buf.count);// --> number of primes
        
        
        GUI.jLabel4.setText(one);//largest prime number
        GUI.jLabel7.setText(two);//# of prime numbers

    }
}
