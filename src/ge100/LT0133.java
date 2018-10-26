package ge100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pojo.UndirectedGraphNode;

/**
 * 133. Clone Graph
 * */
public class LT0133
{

    public static void main(String[] args)
    {
        UndirectedGraphNode root = new UndirectedGraphNode(1);
        root.neighbors.add(root);
        
        UndirectedGraphNode result = new LT0133().Lt0133a(root);
        
        System.out.println(result);
    }

    // 3ms, most are [3, 5]ms
    private UndirectedGraphNode Lt0133a(UndirectedGraphNode node)
    {
        UndirectedGraphNode result = null;
        if (node == null)
        {
            return result;
        }
        
        result = new UndirectedGraphNode(node.label);
        // key: original, value: clone
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        map.put(node, result);
        this.recursiona(node, result, map);
        
        return result;
    }
    
    private UndirectedGraphNode recursiona(UndirectedGraphNode from, UndirectedGraphNode to, Map<UndirectedGraphNode, UndirectedGraphNode> map)
    {
        List<UndirectedGraphNode> listFrom = from.neighbors;
        UndirectedGraphNode node = null;
        List<UndirectedGraphNode> listTo = to.neighbors;
        for (UndirectedGraphNode n : listFrom)
        {
            if (map.containsKey(n))
            {
                listTo.add(map.get(n));
            }
            else
            {
                node = new UndirectedGraphNode(n.label);
                map.put(n, node);
                listTo.add(node);
                recursiona(n, node, map);
            }
        }
        return to;
    }
    
}
