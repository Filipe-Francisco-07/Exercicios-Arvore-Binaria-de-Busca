package BinaryTree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SearchTree tree = new SearchTree();		
		tree.insert(25);
		tree.insert(22);
		tree.insert(35);
		tree.insert(6666);
		tree.insert(21);
		tree.insert(22);
		tree.insert(27);
		tree.insert(27434);
		tree.insert(273);
		
		System.out.println("Before removing:");
		
		tree.showInOrder();
		
		tree.remove(25);
		tree.remove(22);
		
		System.out.println("After removing:");
		
		tree.showInUnGrownOrder();
		
		System.out.println("Leveling order:");
		
		tree.showInLevelingOrder();
		
		tree.showBiggestNumber();
		
		tree.showSmallestNumber();
		
	}
}
