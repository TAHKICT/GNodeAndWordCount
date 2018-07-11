package cisco.java.challenge;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class GNodeWalkServiceTest {

    private GNodeService gNodeService;
    private GNode gNode;
    private int expectedPathQuantity;

    public GNodeWalkServiceTest(GNode gNode, int expectedPathQuantity){
        this.gNode = gNode;
        this.expectedPathQuantity = expectedPathQuantity;
    }

    @Before
    public void initService(){
        gNodeService = new GNodeService();
    }

    @Parameterized.Parameters(name = "{index}: testPathsQuantity {0}: {1}")
    public static Iterable<Object[]> data() {
        GNode gNode1 = new GNodeImpl("1", new GNodeImpl[0]);
        GNode gNode2 = new GNodeImpl("2", new GNodeImpl[0]);
        GNode gNode3 = new GNodeImpl("3", new GNodeImpl[0]);
        GNode gNode4 = new GNodeImpl("4", new GNodeImpl[0]);

        GNode gNode7 = new GNodeImpl("7", new GNode[]{gNode1, gNode2});
        GNode gNode8 = new GNodeImpl("8", new GNode[]{gNode7, gNode3});
        GNode gNode9 = new GNodeImpl("9", new GNode[]{gNode7, gNode3, gNode4});

        return Arrays.asList(new Object[][]{
                {gNode7, 2},
                {gNode8, 4},
                {gNode9, 5}
        });
    }

    @Test
    public void shouldHaveUniqueGraphsOnly(){
        System.out.println(gNodeService.walkGraph(gNode));
        assertEquals(expectedPathQuantity, gNodeService.walkGraph(gNode).size());
    }
}
