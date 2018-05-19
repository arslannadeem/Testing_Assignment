package code;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FCFSTest {
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
                {new Proces(0, 8), new Proces(2, 5), new Proces(3, 3), new Proces(9, 4), 5.75},
                {new Proces(0, 8), new Proces(9, 5), new Proces(9, 3), new Proces(9, 4), 3.25}
        };
        Object[][] data1 = new Object[][]{
            {new Proces(0, 7), new Proces(3, 5), new Proces(3, 4), new Proces(9, 5), 4.0},
            {new Proces(0, 6), new Proces(1, 5), new Proces(2, 6), new Proces(3, 6), 6.5}
        };
        
        Object[][] data2 = new Object[][]{
        	{new Proces(0, 8), new Proces(2, 5), new Proces(3, 3), new Proces(9, 4), 4.0},
        	{new Proces(0, 8), new Proces(1, 4), new Proces(2, 9), new Proces(3, 5), 6.5}
        };
        Object[][] data3 = new Object[][]{
        	{new Proces(0, 6), new Proces(2, 5), new Proces(3, 4), new Proces(9, 4), 4.0},
        	{new Proces(0, 8), new Proces(1, 5), new Proces(2, 8), new Proces(3, 5), 6.5}
        };
        Object[][] data4 = new Object[][]{
            {new Proces(0, 7), new Proces(3, 5), new Proces(3, 4), new Proces(9, 5), 4.0},
            {new Proces(0, 6), new Proces(1, 5), new Proces(2, 6), new Proces(3, 6), 6.5}
        };
        
        Object[][] data5 = new Object[][]{
        	{new Proces(0, 8), new Proces(2, 5), new Proces(3, 3), new Proces(9, 4), 4.0},
        	{new Proces(0, 8), new Proces(1, 4), new Proces(2, 9), new Proces(3, 5), 6.5}
        };
        Object[][] data6 = new Object[][]{
            {new Proces(0, 7), new Proces(3, 5), new Proces(3, 4), new Proces(9, 5), 4.0},
            {new Proces(0, 6), new Proces(1, 5), new Proces(2, 6), new Proces(3, 6), 6.5}
        };
        return Arrays.asList(data);
    }

    @Test
    public void testSymulation() throws Exception {
        PriorityQueue<Proces> queue = new PriorityQueue<>();
        queue.addAll(Arrays.asList(p1, p2, p3, p4));
        SchedulingAlgorithms algorithm = new FCFS(queue);
        assertThat(algorithm.symulation(), is(result));
    }
}