/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producer_comsumer_assignment;

/**
 *
 * @author L E G I O N
 */
public class Buffer 
{
    public int size = 0; // the buffer bound
    private long store[];
    Semaphore spaces;
    Semaphore elements;
    public long count=0;
    public long maxItem=0;
    public Buffer(int size)
    {
        this.size =size;
        store = new long[size];
        spaces = new Semaphore(size);
        elements = new Semaphore(0);
    }
    public int inptr = 0;
    public int outptr = 0;

    public void produce(long value)
    {
        spaces.P();
        store[inptr] = value;
        inptr = (inptr + 1) % size;
        count++;
        if(value>maxItem) {
            maxItem=value;
        }
        elements.V();

    }

    public long consume()
    {
        long value;
        elements.P();
        value = store[outptr];
        outptr = (outptr + 1) % size;
        spaces.V();
        return value;
    }

}
