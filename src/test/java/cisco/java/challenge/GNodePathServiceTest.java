package cisco.java.challenge;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GNodePathServiceTest {

    private GNodeService service;

    @Before
    public void init(){
        service = new GNodeService();
    }

    @Parameterized.Parameters(name = "{index}: paths quantity of {0} = {1}")
    public static Iterable<Object[]> data() {
        GNode gNode1 = new GNodeImpl("1", new GNodeImpl[0]);
        GNode gNode2 = new GNodeImpl("2", new GNodeImpl[0]);
        GNode gNode3 = new GNodeImpl("3", new GNodeImpl[0]);
        GNode gNode4 = new GNodeImpl("4", new GNode[]{gNode1, gNode2});

        return Arrays.asList(new Object[][] {
                {new GNodeImpl("A", new GNode[]{gNode1, gNode2}), 2},
                {new GNodeImpl("B", new GNode[]{gNode1, gNode2, gNode3}), 3},
                {new GNodeImpl("C", new GNode[]{gNode4}), 2},
                {new GNodeImpl("D", new GNode[]{gNode4, gNode4}), 4},
                {new GNodeImpl("E", new GNode[]{gNode4, gNode4, gNode3}), 5},
        });
    }

    private GNode gNode;
    private int expectedPathQuantity;

    public GNodePathServiceTest(GNode gNode, int expectedPathQuantity) {
        this.gNode = gNode;
        this.expectedPathQuantity = expectedPathQuantity;
    }

    @Test
    public void pathsQuantityTests(){
        assertEquals(expectedPathQuantity, service.paths(gNode).size());
    }

}
