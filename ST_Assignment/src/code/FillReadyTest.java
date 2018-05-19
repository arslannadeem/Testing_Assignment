package code;

import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;

public class FillReadyTest extends SJFw {

    public Collection result=new ArrayList<>();

    FillReadyTest(PriorityQueue<Proces> queue) throws CloneNotSupportedException {
        super(queue);
    }

    @Override
    public double symulation() {
        while (!queue.isEmpty()) {
            fillReady();
            result.addAll(ready);
            ready.clear();
        }
        return 0.0;
    }
}
