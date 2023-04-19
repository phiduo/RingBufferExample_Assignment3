package at.jku.swtesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class RingBufferCoverageTest {

    // ---- Same setup as before ----

    RingBuffer<String> ringBuffer;

    @BeforeEach
    void setUp() {
        ringBuffer = new RingBuffer<>(3);
    }


    // ---- New tests starting here ----

    @Test
    void ifRingBufferIsEmpty_iteratorThrowsException(){
        Iterator<String> ringBufferIterator = ringBuffer.iterator();
        assertThrows(NoSuchElementException.class, ringBufferIterator::next);
    }

    @Test
    void ifItemRemoved_iteratorThrowsException(){
        Iterator<String> ringBufferIterator = ringBuffer.iterator();
        assertThrows(UnsupportedOperationException.class, ringBufferIterator::remove);
    }

    @Test
    void ifRingBufferIsFull_isFullreturnsTrue(){
        ringBuffer.enqueue("a");
        ringBuffer.enqueue("b");
        ringBuffer.enqueue("c");
        assertTrue(ringBuffer.isFull());
    }

    @Test
    void ifRingBufferIsNotFull_isFullreturnsFalse(){
        ringBuffer.enqueue("a");
        ringBuffer.enqueue("b");
        assertFalse(ringBuffer.isFull());
    }


}
