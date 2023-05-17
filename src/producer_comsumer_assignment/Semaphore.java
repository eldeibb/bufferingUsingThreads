 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package producer_comsumer_assignment;

/**
 *
 * @author L E G I O N
 */

public class Semaphore 
{
    protected int value = 0 ;
    protected Semaphore() { value = 0 ; }
    protected Semaphore(int initial) { value = initial ; }
    
    public synchronized void P() 
    {
        value-- ;
        if (value < 0)
            try { wait() ; } catch( InterruptedException e ) { }
    }
    
    public synchronized void V() 
    {
        value++ ; if (value <= 0) notify() ;
    }
}
