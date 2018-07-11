package cisco.java.challenge;

import java.util.*;

public class GNodeService {

    public ArrayList walkGraph(GNode gNode){
        List<GNode> gNodesChildren = Arrays.asList(gNode.getChildren());
        return new ArrayList(getAllChildren(new HashSet<>(gNodesChildren), gNodesChildren));
    }

    private Set<GNode> getAllChildren(Set<GNode> gNodeSet, List<GNode> getChildrenFromThis){

        getChildrenFromThis.forEach(gNode -> {
            if(gNode.getChildren().length != 0){
                gNodeSet.addAll(Arrays.asList(gNode.getChildren()));
                getAllChildren(gNodeSet, Arrays.asList(gNode.getChildren()));
            }
        });

        return gNodeSet;
    }

    public ArrayList paths(GNode gNode) {
        ArrayList<ArrayList<GNode>> mainList = new ArrayList<>();

        if(gNode.getChildren().length != 0){
            for(int i=0; i < gNode.getChildren().length; i++){
                makePath(new ArrayList<>(Arrays.asList(gNode, gNode.getChildren()[i])), mainList);
            }
        }

        return mainList;
    }

    private void makePath(ArrayList<GNode> currentList, ArrayList<ArrayList<GNode>> mainList){

        if(currentList.get(currentList.size()-1).getChildren().length == 0){
            mainList.add(currentList);
        }else {
            Arrays.asList(currentList.get(currentList.size()-1).getChildren()).forEach(gNode -> {
                ArrayList temp = new ArrayList(currentList);
                temp.add(gNode);
                makePath(temp, mainList);
            });
        }

    }
}
