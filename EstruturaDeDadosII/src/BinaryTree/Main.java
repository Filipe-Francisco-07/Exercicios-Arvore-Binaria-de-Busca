package BinaryTree;

import ListaEncadeada.ListaEncadeada;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		SearchTree tree = new SearchTree();		
		tree.inserirSemRecursividade(50);
		tree.inserirSemRecursividade(90);
		tree.inserirSemRecursividade(38);
		tree.inserirSemRecursividade(40);
		tree.insert(15);
		
		System.out.println("Before removing:");
		
		tree.showInOrder();
		
		tree.remove(40);
		
		System.out.println("After removing:");
		
		tree.showInUnGrownOrder();
		
		System.out.println("Leveling order:");
		
		tree.showInLevelingOrder();
		
		//a) Mostrar o maior número
		tree.showBiggestNumber();
		
		//b) Mostrar o menor número
		tree.showSmallestNumber();

		//c) Mostrar os nós folhas
		System.out.println("Nós folhas:");
		tree.mostrarFolha();
		
		//d) Mostrar os nós ancestrais de um nó
		System.out.println("Ancestrais: ");
		tree.verAncestral(40);
		
		//e) Mostrar os nós descendentes de um nó
		System.out.println("\nDescendentes: ");
		tree.verDescendentes(50);
		
		//f) Mostrar a subárvore da direita de um nó
		System.out.println("\nSubarvore da direita: ");
		tree.verSubDireita(50);
		
		//g) Mostrar a subárvore da esquerda de um nó
		System.out.println("\nSubarvore da esquerda: ");
		tree.verSubEsquerda(10);
		
		//h) Transformar a árvore numa lista encadeada
		System.out.println("Árvore convertida em lista encadeada: ");
		ListaEncadeada lista = new ListaEncadeada();
		lista = tree.converterParaListaEncadeada();
		lista.mostraLista();

		//i) Mostrar somente os números pares
		System.out.println("Pares:");
		tree.showJustPairs();
		
		//j) Mostrar o nível de um nodo
		int nivel = tree.verNivelDoNodo(40);
		System.out.println("Nível do nodo 40 : "+nivel);
		
		//k) Mostrar a altura da árvore
		int altura = tree.calcularAlturaArvore();
		System.out.println("Altura da árvore: "+altura);
		
		//l) Mostra o tamanho da árvore
		System.out.println("Tamanho da árvore: "+tree.getTamanho_arvore());
		
		//m) Inserir um novo item na árvore, mas de forma não recursiva	
		
		
	}
}
