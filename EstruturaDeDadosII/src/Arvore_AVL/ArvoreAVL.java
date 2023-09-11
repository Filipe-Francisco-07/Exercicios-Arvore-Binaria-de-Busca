package Arvore_AVL;

public class ArvoreAVL {
	private class Nodo{
	private int dado, altd, alte;
	private Nodo dir,esq;

	public Nodo(int dado) {
		this.dado = dado;
		dir = esq = null;
		altd = alte = 0;
	}
 }
	
	/*1) Desenhe a árvore AVL que resulta da inserção sucessiva das chaves Q-U-E-S-T-A-O-F-C-I-L.
Após as inserções desenhe as árvores resultantes das retiradas dos elementos E e depois U.

2) Escreva o método de exclusão de um elemento da árvore AVL.

4) Faça uma função que, dada uma árvore AVL, retorne à quantidade de nós que guardam
números primos.

5) Modificar o código da Árvore AVL para permitir a inserção de chaves duplicadas. Para fazer
isso, você deve acrescentar um atributo adicional à classe Nodo que armazena quantas
vezes uma chave específica foi inserida na árvore.
Modifique também os métodos de mostrar a árvore e remoção para levar em consideração
a contagem das chaves. Por exemplo, ao mostrar os nós da árvore, o método deve mostrar
ou retornar, além da chave do nó, o número de ocorrências da chave.

6) Escreva um método que receba um nível da arvore e mostre todos os nodos nesse nível

7) Faça um método para somar os nós presentes nos níveis ímpares de uma árvore AVL.

8) Monte uma arvore capaz de armazenar as seguintes informações: nome do município, área
total do município (em km2) e população. A chave do nó para inserção deverá ser o nome
do município. Implemente também as funções abaixo:
a. Contar o número de municípios, percorrendo os nós cadastrados na árvore.
b. Mostrar apenas os nomes dos municípios com mais de X habitantes. Por exemplo, X
pode ser 100.000 pessoas.
c. Mostrar a densidade demográfica de cada cidade. A densidade demográfica é a
relação entre a população e a área.
d. Mostrar o somatório de área em km2 de todas as cidades juntas em relação ao
território nacional (em porcentagem).
e. Mostrar o nome da cidade com a maior população.

Teste da Implementação:
Crie testes para cada exercício para verificar se o código funciona conforme o esperado.
Após o código de cada exercício acrescente prints dos testes realizados.*/

	Nodo raiz;
	public ArvoreAVL() {
		raiz = null;
	}

	public void inserir(int dado) {
		raiz = inserirDado(raiz,dado);
	}
	
	
	public void verNosPrimos() {
		int np = 0;
		System.out.println("Temos "+verPrimos(raiz,np)+ " primos na arvore.");
	}
	
	private int verPrimos(Nodo raiz, int np) {

			if (raiz != null) {
				verPrimos(raiz.esq,np);
				if(raiz.dado == 2) {
					System.out.println(raiz.dado);
					np++;
					System.out.println("np:"+np);
				}else
				if(raiz.dado == 3) {
					System.out.println(raiz.dado);
					np++;
				}else
				if(raiz.dado % 2 != 0 && raiz.dado % 3 != 0) {
					System.out.println(raiz.dado);
					np++;
					System.out.println("np:"+np);
				}
				verPrimos(raiz.dir,np);
			}
			return np;
		
	}

	private Nodo inserirDado(Nodo raiz, int dado) {
		if (raiz == null) {
			raiz = new Nodo(dado);
			return raiz;

		}
		if (dado < raiz.dado) {
			raiz.esq = inserirDado(raiz.esq,dado);
			if (raiz.esq.altd > raiz.esq.alte) {
				raiz.alte = raiz.esq.altd + 1;
			} else {
				raiz.alte = raiz.esq.alte + 1;
			}
			raiz = balanceamento(raiz);
		} else if (dado > raiz.dado) {
			raiz.dir = inserirDado(raiz.dir,dado);
			if (raiz.dir.altd > raiz.dir.alte) {
				raiz.altd = raiz.dir.altd + 1;
			} else {
				raiz.altd = raiz.dir.alte + 1;
			}
			raiz = balanceamento(raiz);
		}
		return raiz;
	}

	private Nodo balanceamento (Nodo raiz) {
		int ĩ = raiz.altd - raiz.alte;
		int ĩSubArv;
		if (ĩ == 2) {
			ĩSubArv = raiz.dir.altd - raiz.dir.alte;
			if (ĩSubArv >=0) {
				raiz = rotacao_esquerda(raiz);
			} else {
				raiz.dir = rotacao_direita(raiz.dir);
		raiz = rotacao_esquerda(raiz);
			}
		} else if (ĩ == -2) {
			ĩSubArv = raiz.esq.altd - raiz.esq.alte;
			if (ĩSubArv <= 0) {
				raiz = rotacao_direita(raiz);
			} else {
				raiz.esq = rotacao_esquerda(raiz.esq);
				raiz = rotacao_direita(raiz);
			}
		}
		return raiz;
	}
	
	//3) Escreva um algoritmo que retorna true se uma determinada árvore é uma árvore AVL e
	//false caso contrário.
	
	public boolean eAvl(ArvoreAVL arvore) {
		if(verAvl(arvore.raiz))
		return true;
		else {
			return false;
		}
		
	}
	
	public  boolean verAvl(Nodo raiz) {
	if (raiz != null) {
		verAvl(raiz.esq);
		if(raiz.altd - raiz.alte >= 2 || raiz.altd - raiz.alte <= -2){
			return false;
		}
		verAvl(raiz.dir);
	}
	return true;
}

	private Nodo rotacao_esquerda(Nodo raiz) {
		Nodo aux1, aux2;
		aux1 = raiz.dir;
		aux2 = raiz.esq;
		raiz.dir = aux2;
		aux1.esq = raiz;
		if (raiz.dir == null) {
			raiz.altd = 0;
		} else if (raiz.dir.alte > raiz.dir.altd) {
			raiz.altd = raiz.dir.alte + 1;
		} else {
			raiz.altd = raiz.dir.altd + 1;
		}
		if (aux1.esq.alte > aux1.esq.altd) {
			aux1.alte = aux1.esq.alte + 1;
		} else {
			aux1.alte = aux1.esq.altd + 1;
		}
		return aux1;
	}

	private Nodo rotacao_direita(Nodo raiz) {
		Nodo aux1, aux2;
		aux1 = raiz.esq;
		aux2 = aux1.dir;
		raiz.esq = aux2;
		aux1.dir = raiz;
		if (raiz.esq == null) {
			raiz.alte = 0;
		} else if (raiz.esq.alte > raiz.esq.altd) {
			raiz.alte = raiz.esq.alte + 1;
		} else {
			raiz.alte = raiz.esq.altd + 1;
		}
		if (aux1.dir.alte > aux1.dir.altd) {
			aux1.altd = aux1.dir.alte + 1;
		} else {
			aux1.altd = aux1.dir.altd + 1;
		} 
		return aux1;
	}
	
	public void remover(int dado) {
		removeDado(raiz, dado);
	}
	private void removeDado(Nodo raiz, int dado) {
		if (raiz != null) {
			removeDado(raiz.esq,dado);
			if(raiz.dado == dado) {
				if(raiz.dir != null) {			
				raiz.dado = raiz.dir.dado;
				raiz.dir = null;
				}else if(raiz.dir == null && raiz.esq != null) {
					raiz.dado = raiz.esq.dado;
					raiz.esq = null;
				}
				balanceamento(raiz);
				return;
			}
			removeDado(raiz.dir,dado);
		}
	}

	public void mostrarEmOrdem() {
		mostrandoOrdenado(raiz);
	}
	private void mostrandoOrdenado(Nodo raiz) {
		if (raiz != null) {
			mostrandoOrdenado(raiz.esq);
			System.out.println(raiz.dado);
			mostrandoOrdenado(raiz.dir);
		}
	}
}
