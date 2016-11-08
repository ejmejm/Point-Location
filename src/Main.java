//By Edan Meyer
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		BinarySearchTree bst = new BinarySearchTree();
		
		int lines = sc.nextInt();
		
		for(int i = 0; i < lines; i++){
			bst.insert(new Line(new Point(sc.nextFloat(), sc.nextFloat()), new Point(sc.nextFloat(), sc.nextFloat())));
		}
		
		while(sc.hasNext()){
			bst.existsDivider(new Point(sc.nextFloat(), sc.nextFloat()), new Point(sc.nextFloat(), sc.nextFloat()));
		}
		sc.close();
		
		System.out.println("External Nodes: " + bst.countExternNodes());
		System.out.println("Average Path Length: " + bst.avgPathLength());
	}
}