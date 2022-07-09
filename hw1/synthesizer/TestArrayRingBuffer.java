package synthesizer;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        //ArrayRingBuffer arb = new ArrayRingBuffer(10);
        ArrayRingBuffer arb = new ArrayRingBuffer<Integer>(4);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.enqueue(5);
        arb.enqueue(6);
        System.out.println(arb.peek());
        arb.dequeue();
        arb.dequeue();
        System.out.println(arb.peek());
        arb.enqueue(7);
        arb.enqueue(8);
        System.out.println(arb.peek());

        Iterator<Integer> iterator = arb.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

//    /** Calls tests for ArrayRingBuffer. */
//    public static void main(String[] args) {
//        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
//    }
} 
