package code;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FillReadyTestTest {
    @Parameterized.Parameter
    public Proces p1;
    @Parameterized.Parameter(value = 1)
    public Proces p2;
    @Parameterized.Parameter(value = 2)
    public Proces p3;
    @Parameterized.Parameter(value = 3)
    public Proces p4;
    @Parameterized.Parameter(value = 4)
    public double result;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {new Proces(0, 8), new Proces(2, 5), new Proces(3, 3), new Proces(9, 4), 4.0},
                {new Proces(0, 8), new Proces(1, 4), new Proces(2, 9), new Proces(3, 5), 6.5}
        };
        Object[][] data1 = new Object[][]{
            {new Proces(0, 7), new Proces(3, 5), new Proces(3, 4), new Proces(9, 5), 4.0},
            {new Proces(0, 6), new Proces(1, 5), new Proces(2, 6), new Proces(3, 6), 6.5}
        };
        
        Object[][] data2 = new Object[][]{
        	{new Proces(0, 8), new Proces(2, 5), new Proces(3, 3), new Proces(9, 4), 4.0},
        	{new Proces(0, 8), new Proces(1, 4), new Proces(2, 8), new Proces(3, 5), 6.5}
        };
        Object[][] data3 = new Object[][]{
        	{new Proces(0, 7), new Proces(2, 5), new Proces(3, 3), new Proces(9, 3), 4.0},
        	{new Proces(0, 5), new Proces(1, 4), new Proces(2, 7), new Proces(3, 5), 6.5}
        };
        return Arrays.asList(data);
    }

    @Test
    public void testFillReady_Filling_ReadyEqualsQueue() throws Exception {
        Collection<Proces> collection = Arrays.asList(p1, p2, p3, p4);
        PriorityQueue<Proces> queue = new PriorityQueue<>();
        queue.addAll(collection);

        FillReadyTest algorithm = new FillReadyTest(queue);
        algorithm.symulation();
        assertArrayEquals(collection.toArray(),algorithm.result.toArray());
    }

}