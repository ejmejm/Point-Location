//By Edan Meyer
public class Node {
	public Line line;
	public Node leftChild, rightChild;
	
	public Node(){ }
	
	public Node(Line line){
		this.line = line;
	}
	
	public Line insert(Line line){ //Insert a line into the bst
		Point intersection;
		if((intersection = line.intersects(this.line)) != null){ //If they intersect
			if(leftChild != null)
				leftChild.insert(new Line(intersection, line.ccwPoint(this.line), line.number));
			else 
				leftChild = new Node(new Line(intersection, line.ccwPoint(this.line), line.number));
			if(rightChild != null)
				rightChild.insert(new Line(intersection, line.cwPoint(this.line), line.number));
			else 
				rightChild = new Node(new Line(intersection, line.cwPoint(this.line), line.number));

		}else if(line.colinear(this.line)){ //If they are the same line do nothing
			return null;
		}else{ //If they don't intersect
			if(this.line.ccw(line)){
				if(leftChild != null) leftChild.insert(line);
				else leftChild = new Node(line);
			}else{
				if(rightChild != null) rightChild.insert(line);
				else rightChild = new Node(line);
			}
		}
		return null;
	}
	
	public int countExternNodes(){ //Count external nodes
		if(leftChild == null && rightChild == null)
			return 2;
		else if(leftChild != null && rightChild != null)
			return leftChild.countExternNodes() + rightChild.countExternNodes();
		else if(leftChild != null)
			return 1 + leftChild.countExternNodes();
		else
			return 1 + rightChild.countExternNodes();
	}
	
	public int externPathLength(int count){ //Count external path length
		if(leftChild == null && rightChild == null)
			return count + 1 + count + 1;
		else if(leftChild != null && rightChild != null)
			return leftChild.externPathLength(count + 1) + rightChild.externPathLength(count + 1);
		else if(leftChild != null)
			return count + 1 + leftChild.externPathLength(count + 1);
		else
			return count + 1 + rightChild.externPathLength(count + 1);
	}
	
	public void printPostOrder(){ //Print postorder
		if(leftChild != null) leftChild.printPostOrder();
		if(rightChild != null) rightChild.printPostOrder();
		System.out.print(line.number + " ");
	}
}
