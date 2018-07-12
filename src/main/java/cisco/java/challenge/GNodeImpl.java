package cisco.java.challenge;

/**
 * Possible implementation of GNode interface.
 * Created to run and test the application.
 */
public class GNodeImpl implements GNode{
    private String name;
    private GNode[] children;

    public GNodeImpl(String name, GNode[] children) {
        this.name = name;
        this.children = children;

        if(children == null){
            this.children = new GNode[0];
        }
    }

    public String getName() {
        return name;
    }

    public GNode[] getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return name;
    }
}
