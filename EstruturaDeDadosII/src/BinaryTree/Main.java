package BinaryTree;

import ListaEncadeada.ListaEncadeada;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		SearchTree tree = new SearchTree();		
		tree.inserirSemRecursividade(10);
		tree.inserirSemRecursividade(20);
		tree.inserirSemRecursividade(13);
		tree.inserirSemRecursividade(40);
		tree.insert(3);
		tree.insert(1232);
		tree.insert(2734);
		tree.insert(27);
		tree.insert(20000);
		
		System.out.println("Before removing:");
		
		tree.mostrarEmOrdem();
		
		tree.remove(25);
		tree.remove(22);
		
		System.out.println("After removing:");
		
		tree.mostrarOrdemDescente();
		
		System.out.println("Leveling order:");
		
		tree.mostrarEmOrdemDeNivel();
		
		//a) Mostrar o maior número
		tree.mostrarMaiorNumero();
		
		//b) Mostrar o menor número
		tree.mostrarMenorNumero();

		//c) Mostrar os nós folhas
		System.out.println("Nós folhas:");
		tree.mostrarFolha();
		
		//d) Mostrar os nós ancestrais de um nó
		System.out.println("Ancestrais do 40: ");
		tree.verAncestral(40);
		
		//e) Mostrar os nós descendentes de um nó
		System.out.println("\nDescendentes do 40: ");
		tree.verDescendentes(40);
		
		//f) Mostrar a subárvore da direita de um nó
		System.out.println("\nSubarvore da direita: ");
		tree.verSubDireita(10);
		
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
		tree.mostrarPares();
		
		//j) Mostrar o nível de um nodo
		int nivel = tree.verNivelDoNodo(40);
		System.out.println("Nível do nodo 40 : "+nivel);
		
		//k) Mostrar a altura da árvore
		int altura = tree.calcularAlturaArvore();
		System.out.println("Altura da árvore: "+altura);
		
		//l) Mostra o tamanho da árvore
		tree.mostrarTamanhoDaArvore();
		
		//m) Inserir um novo item na árvore, mas de forma não recursiva	
		tree.inserirSemRecursividade(44);
		
		System.out.println("Lista com o 44 inserido sem recursividade: ");
		tree.mostrarEmOrdem();
		
	}
}
