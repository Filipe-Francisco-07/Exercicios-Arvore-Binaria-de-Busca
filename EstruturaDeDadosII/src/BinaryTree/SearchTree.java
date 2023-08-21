package BinaryTree;

import java.util.Queue;

import ListaEncadeada.ListaEncadeada;

import java.util.LinkedList;

public class SearchTree {
	private int tamanho_arvore;
	private int altura_arvore;
	private ListaEncadeada lista_encadeada;
    
	private class Nodo{
		private int key;
		private Nodo right,left;
		
		public Nodo(int item) {
			this.key = item;
			right = left = null;
		}
	}
	
	public SearchTree() {
		lista_encadeada = new ListaEncadeada();
	}

	public int getTamanho_arvore() {
		return tamanho_arvore;
	}

	public void setTamanho_arvore(int tamanho_arvore) {
		this.tamanho_arvore = tamanho_arvore;
	}

	public int getAltura_arvore() {
		return altura_arvore;
	}

	public void setAltura_arvore(int altura_arvore) {
		this.altura_arvore = altura_arvore;
	}
	
	//a) Mostrar o maior número
	public void mostrarMaiorNumero() {
		mostrarMaior(raiz);
	}
	
	private void mostrarMaior(Nodo raiz) {
	    int maiorValor = encontrarMaior(raiz);
	    System.out.println("O maior valor na arvore é: " + maiorValor);
	}
	
	private int encontrarMaior(Nodo raiz) {
	    if (raiz == null) {
	        return  Integer.MIN_VALUE;
	    }
	    
	    int maiorEsquerda = encontrarMaior(raiz.left);
	    int maiorDireita = encontrarMaior(raiz.right);
	    
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
	
	//b) Mostrar o menor número
	public void mostrarMenorNumero() {
		mostrarMenor(raiz);
	}
	
	private void mostrarMenor(Nodo raiz) {
	    int menorValor = encontrarMenor(raiz);
	    System.out.println("O menor valor na arvore é: " + menorValor);
	}
	
	private int encontrarMenor(Nodo raiz) {
	    if (raiz == null) {
	        return Integer.MAX_VALUE;
	    }
	    
	    int menorEsquerda = encontrarMenor(raiz.left);
	    int menorDireita = encontrarMenor(raiz.right);
	  
	    int menor;
	    if(menorEsquerda < menorDireita) {
	    	menor = menorEsquerda;
	    }else if(menorDireita < menorEsquerda){
	    	menor = menorDireita;
	    }else {
	    	menor = menorDireita;
	    }
	    
	    if(menor < raiz.key) {
	    	return menor;
	    }else {
	    	return raiz.key;
	    }
	 
	}
	
	//c) Mostrar os nós folhas
	
	 public void mostrarFolha() {
		 mostrarFolhas(raiz);
	 }
	 
	 private void mostrarFolhas(Nodo raiz) {
			if(raiz != null) {
				
				if(raiz.left == null  && raiz.right == null) {
					System.out.println(raiz.key);
				}
				
				mostrarFolhas(raiz.right);			
				mostrarFolhas(raiz.left);
			}
	}
	 
	 
	 //d) Mostrar os nós ancestrais de um nó
	 public void verAncestral(int valorAlvo) {
	        verAncestralNo(raiz, valorAlvo);
	    }

	    private boolean verAncestralNo(Nodo nodo, int valorAlvo) {
	        if (nodo == null) {
	            return false;
	        }

	        if (nodo.key == valorAlvo) {
	            return true; 
	        }

	        if (verAncestralNo(nodo.left, valorAlvo) || verAncestralNo(nodo.right, valorAlvo)) {
	            System.out.print(nodo.key + " ");
	            return true;
	        }

	        return false;
	    }	    
	    
	//e) Mostrar os nós descendentes de um nó
	    
	public void verDescendentes(int valor) {
		verDescendentesNo(raiz, valor);
	}

	private boolean verDescendentesNo(Nodo nodo, int valor) {
	    if (nodo == null) {
	        return false;
	    }

	    if (nodo.key == valor) {
	        verDescendentes(nodo.left);
	        verDescendentes(nodo.right);
	        return true; 
	    }

	    if (verDescendentesNo(nodo.left, valor) || verDescendentesNo(nodo.right, valor)) {
	        return true;
	    }

	    return false;
 }

	private void verDescendentes(Nodo nodo) {
	    if (nodo == null) {
	        return;
	    }
	        
	    System.out.print(nodo.key + " ");
	    verDescendentes(nodo.left);
	    verDescendentes(nodo.right);
    }
	
	//f) Mostrar a subárvore da direita de um nó
	public void verSubEsquerda(int valor) {
		
		verSubEsq(raiz, valor,false);
	}
	
	private void verSubEsq(Nodo raiz, int valor, boolean a) {
		if(raiz != null) {
			if(raiz.key == valor){
				a = true;
			}
			if(a) {
				System.out.println(raiz.key);
			}
			
			verSubEsq(raiz.left,valor,a);
		}			
		
	}
		
	//g) Mostrar a subárvore da esquerda de um nó
	public void verSubDireita(int valor) {	
		verSubDir(raiz, valor,false);
	}
	
	private void verSubDir(Nodo raiz, int valor, boolean a) {
		if(raiz != null) {
			if(raiz.key == valor){
				a = true;
			}
			if(a) {
				System.out.println(raiz.key);
			}
			
			verSubDir(raiz.right,valor,a);
		}			
		
	}
	
	//h) Transformar a árvore numa lista encadeada
	
	public ListaEncadeada converterParaListaEncadeada() {
    	  converterLista(raiz);
    	  return lista_encadeada;
	 }

	private void converterLista(Nodo raiz) {
		if (raiz == null) {
			return;
		}
	    converterLista(raiz.left);
	    lista_encadeada.inserirOrdenado(raiz.key);       

	    converterLista(raiz.right);
	    
	}
	
	//i) Mostrar somente os números pares	
	public void mostrarPares() {
		mostraPar(raiz);
	}
	
	private void mostraPar(Nodo raiz) {
		if(raiz != null) {
			mostraPar(raiz.left);
		
			if(raiz.key % 2 == 0)System.out.println(raiz.key);
			mostraPar(raiz.right);
		}
	}
	
	//j) Mostrar o nível de um nodo
	 public int verNivelDoNodo(int numero) {
	        return verNivel(raiz, numero, 0);
	 }

	 private int verNivel(Nodo nodo, int numero, int nivel) {
	        if (nodo == null) {
	            return -1;
	        }
	        if (nodo.key == numero) {
	            return nivel; 
	        }

	        int nivelEsquerda = verNivel(nodo.left, numero, nivel + 1);
	        if (nivelEsquerda != -1) {
	            return nivelEsquerda;
	        }
	        return verNivel(nodo.right, numero, nivel + 1);		       
	 
	 }
	 
	// k) Mostrar a altura da árvore
	 public int calcularAlturaArvore() {
		return calcularAltura(raiz);
	 }

	private int calcularAltura(Nodo raiz) {
		if (raiz == null) {
		    return 0; 
		}

		int alturaEsquerda = calcularAltura(raiz.left);
		int alturaDireita = calcularAltura(raiz.right);

		if(alturaEsquerda > alturaDireita) {
		    return(alturaEsquerda+1);
		}else {
		    return(alturaDireita+1);
		}
		    
	}
	
	//l) Mostra o tamanho da árvore
	
	public void mostrarTamanhoDaArvore() {
		//obs: o tamanho é incrementado sempre que um novo dado é inserido.
		System.out.println("Tamanho da arvore: "+tamanho_arvore);
	}
	
	Nodo raiz = null;
	
	public void insert(int key) {
		raiz = insertData(raiz,key);
	}
	
	private Nodo insertData(Nodo raiz, int key) {
		if(raiz == null) {
			raiz = new Nodo(key);
			System.out.println("inserted at the root");
			tamanho_arvore++;
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
	
	//m) Inserir um novo item na árvore, mas de forma não recursiva
	public void inserirSemRecursividade(int valor) {
	    Nodo novoNodo = new Nodo(valor);

	    if (raiz == null) {
	        raiz = novoNodo;
	        tamanho_arvore++;
	        return;
	    }

	    Nodo nodo = raiz;
	    Nodo aux;

	    while (true) {
	     	aux = nodo;
	        if (valor < nodo.key) {
	        	nodo = nodo.left;
	            if (nodo == null) {
	             	aux.left = novoNodo;
	                tamanho_arvore++;
	                return;
	            }
	        } else {
	        	nodo = nodo.right;
	            if (nodo == null) {
	                aux.right = novoNodo;
	                tamanho_arvore++;
	                return;
	            }
	        }
	    }
	}
	  
	// demais métodos aprendidos em aula 
	
	public void mostrarOrdemDescente() {
		mostrarDecrescente(raiz);
	}
	
	private void mostrarDecrescente(Nodo raiz) {
		if(raiz != null) {
			mostraOrdem(raiz.right);
		
			System.out.println(raiz.key);
			mostraOrdem(raiz.left);
		}
	}

	public void mostrarEmOrdem() {
		mostraOrdem(raiz);
	}
	
	private void mostraOrdem(Nodo raiz) {
		if(raiz != null) {
			mostraOrdem(raiz.left);
		
			System.out.println(raiz.key);
			mostraOrdem(raiz.right);
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
				tamanho_arvore--;
				return raiz.right;
			}else if(raiz.right == null) {
				tamanho_arvore--;
				return raiz.left;
			}else {
				Nodo next = encontrarProximo(raiz.right);
				raiz.key = next.key;
				raiz.right = removeItem(raiz.right,next.key);
			}
		}
	return raiz;
	}
	
	public void mostrarEmOrdemDeNivel() {
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
	
	private Nodo encontrarProximo(Nodo nodo) {
		while(nodo.left != null) {
			nodo = nodo.left;
		}
		return nodo;
	} 	 
	 
}