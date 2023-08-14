package BinaryTree;

import java.util.Queue;
import java.util.LinkedList;

public class SearchTree {
	private class Nodo{
		private int key;
		private Nodo right,left;
		
		public Nodo(int item) {
			this.key = item;
			right = left = null;
		}
	}
	
	//a
	public void showBiggestNumber() {
		showBiggest(raiz);
	}
	
	private int findBiggestValue(Nodo raiz) {
	    if (raiz == null) {
	        return  Integer.MIN_VALUE;
	    }
	    
	    int maiorEsquerda = findBiggestValue(raiz.left);
	    int maiorDireita = findBiggestValue(raiz.right);
	    
	    int maior = 0;
	    if(maiorEsquerda > maiorDireita) {
	    	maior = maiorEsquerda;
	    }else if(maiorDireita > maiorEsquerda) {
	    	maior = maiorDireita;
	    }else {
	    	maior = maiorDireita;
	    }
	    
	    return Math.max(raiz.key, maior);
	}

	private void showBiggest(Nodo raiz) {
	    int maiorValor = findBiggestValue(raiz);
	    System.out.println("O maior valor na arvore é: " + maiorValor);
	}
	
	//b
	public void showSmallestNumber() {
		showSmallest(raiz);
	}
	
	private int findSmallestValue(Nodo raiz) {
	    if (raiz == null) {
	        return Integer.MAX_VALUE;
	    }
	    
	    int menorEsquerda = findSmallestValue(raiz.left);
	    int menorDireita = findSmallestValue(raiz.right);
	  
	    int menor;
	    if(menorEsquerda < menorDireita) {
	    	menor = menorEsquerda;
	    }else if(menorDireita < menorEsquerda){
	    	menor = menorDireita;
	    }else {
	    	menor = menorDireita;
	    }
	    
	    return Math.min(menor, raiz.key);
	}

	private void showSmallest(Nodo raiz) {
	    int menorValor = findSmallestValue(raiz);
	    System.out.println("O menor valor na arvore é: " + menorValor);
	}
	
	Nodo raiz = null;
	
	public void insert(int key) {
		raiz = insertData(raiz,key);
	}
	
	private Nodo insertData(Nodo raiz, int key) {
		if(raiz == null) {
			raiz = new Nodo(key);
			System.out.println("inserted at the root");
				return raiz;
		}
		if(key < raiz.key) {
			raiz.left = insertData(raiz.left,key);
			System.out.println("inserted at left side");
		}else if(key > raiz.key) {
			raiz.right = insertData(raiz.right,key);
			System.out.println("inserted at right side");
		}else {
			System.out.println("stop :(");
		}
		
		return raiz;
	}
	
	public void showInOrder() {
		showOrderly(raiz);
	}
	
	public void showInUnGrownOrder() {
		showUnGrownOrderly(raiz);
	}
	
	public void showInLevelingOrder() {
		if(raiz == null) {
			System.out.println("Empty tree.");
			return;
		}
		Queue<Nodo> fila = new LinkedList<>();
		fila.add(raiz);
		
		while(!fila.isEmpty()) {
			int LevelSize = fila.size();
			for(int i=0;i<LevelSize;i++) {
				Nodo actualNodo = fila.poll();
				if(actualNodo != null) {
					System.out.print(actualNodo.key+" ");
					fila.add(actualNodo.left);
					fila.add(actualNodo.right);
				}else {
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
	
	private void showUnGrownOrderly(Nodo raiz) {
		if(raiz != null) {
			showOrderly(raiz.right);
		
			System.out.println(raiz.key);
			showOrderly(raiz.left);
		}
	}
	
	private void showOrderly(Nodo raiz) {
		if(raiz != null) {
			showOrderly(raiz.left);
		
			System.out.println(raiz.key);
			showOrderly(raiz.right);
		}
	}
	
	public void remove(int chave) {
		raiz = removeItem(raiz,chave);
		
	}
	
	private Nodo removeItem(Nodo raiz, int chave) {
		if(raiz == null) {
			return null;
		}
		if(chave < raiz.key) {
			raiz.left = removeItem(raiz.left,chave);
		}else if(chave > raiz.key) {
			raiz.right = removeItem(raiz.right, chave);
		}else {
			if(raiz.left == null) {
				return raiz.right;
			}else if(raiz.right == null) {
				return raiz.left;
			}else {
				Nodo next = findNext(raiz.right);
				raiz.key = next.key;
				raiz.right = removeItem(raiz.right,next.key);
			}
		}
		
	return raiz;
	}
	
	private Nodo findNext(Nodo nodo) {
		while(nodo.left != null) {
			nodo = nodo.left;
		}
		return nodo;
	}
	
}
