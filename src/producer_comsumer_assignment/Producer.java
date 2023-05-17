/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package producer_comsumer_assignment;

/**
 *
 * @author L E G I O N
 */
public class Producer extends Thread 
{
    Buffer buf;
    long number;
    public long count=0;
    public long maxItem=0;

    public Producer(Buffer buf, long n)
    {
        this.buf = buf;
        this.number = n;
    }

    public void run()
    {

        for (int i=1; i<=number; i++)
        {
            boolean flag = true;
            int div = i/2;
            for (int j=2; j<=div; j++) //loop that checks if number i prime or not
            {
                if(i % j == 0)
                {
                    flag = false;
                }
            }
            if(flag == true) {
                buf.produce(i);
                if(i>maxItem) {
                    maxItem=i;
                }
            }

        }
//         System.out.println("Max : "+store[size-1]);
    }
 
 

}
