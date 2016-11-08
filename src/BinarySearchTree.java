//By Edan Meyer
public class BinarySearchTree {
	public Node root;
	
	public Line insert(Line line){ //Insert a line into the bst
		if(line == null) return null;
		if(root == null) root = new Node(line);
		return root.insert(line);
	}
	
	public boolean existsDivider(Point p1, Point p2){ //Check for line separating points
		if(p1.x > 1.0f || p1.x < 0.0f || p2.x > 1.0f || p2.x < 0.0f
				|| p1.y > 1.0f || p1.y < 0.0f || p2.y > 1.0f || p2.y < 0.0f){
			System.out.println("The query is out of range, please make sure to use values between 0 and 1, inclusive");
			return true;
		}
		if(root == null) return false;
		Node iNode = root;
		while(iNode != null){
			if(iNode.line.ccw(p1) && iNode.line.ccw(p2))
				iNode = iNode.leftChild;
			else if(!iNode.line.ccw(p1) && !iNode.line.ccw(p2))
				iNode = iNode.rightChild;
			else{
				System.out.println("Different regions, separated by Line " + iNode.line.number);
				return true;
			}
		}
		System.out.println("Same region");
		return false;
	}
	
	public int countExternNodes(){ //Returns number of leafs
		return root.countExternNodes();
	}
	
	public int externPathLength(){ //Returns summation of height of leaves
		return root.externPathLength(0);
	}
	
	public int avgPathLength(){ //Returns average path length for tree
		return externPathLength()/countExternNodes();
	}
	
	public void printPostOrder() { //Prints postorder
		if(root != null) root.printPostOrder();
		System.out.println();
	}
}
