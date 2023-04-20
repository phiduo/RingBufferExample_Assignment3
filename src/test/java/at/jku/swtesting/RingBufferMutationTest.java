package at.jku.swtesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class RingBufferMutationTest {

    // ---- Same setup as before ----

    RingBuffer<String> ringBuffer;

    @BeforeEach
    void setUp() {
        ringBuffer = new RingBuffer<>(3);
    }


    // ---- New tests starting here ----

    @Test
    void ifCapacityEqualsOne_noExceptionThrown() {
        new RingBuffer<>(1);
    }

    @Test
    void ifAllItemsIterated_iteratorNextThrowsException(){
        ringBuffer.enqueue("a");
        ringBuffer.enqueue("b");
        ringBuffer.enqueue("c");
        Iterator<String> ringBufferIterator = ringBuffer.iterator();
        for (int i = 0; i < 3; i++) {
            ringBufferIterator.next();
            if (i == 2) {
                assertFalse(ringBufferIterator.hasNext());
            }
        }
    }

}
