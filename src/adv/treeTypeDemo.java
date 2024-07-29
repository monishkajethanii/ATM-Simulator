package adv;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class treeTypeDemo extends JFrame{
    treeTypeDemo() {
        DefaultMutableTreeNode root=new DefaultMutableTreeNode("God");
        DefaultMutableTreeNode manager=new DefaultMutableTreeNode("Manager");
        DefaultMutableTreeNode human=new DefaultMutableTreeNode("Human");
        root.add(manager);
        root.add(human);
        JTree t=new JTree(root);
        add(t);
        setSize(500,500);
        setVisible(true);
    }
    public static void main(String[] args) {
        new treeTypeDemo();
    }
}
