package Arvore_AVL;

public class ArvoreAVL {
	private class Nodo{
	private int dado, altd, alte, copy;
	private Nodo dir,esq;
	
	
	public Nodo(int dado) {
		this.dado = dado;
		dir = esq = null;
		altd = alte = 0;
		copy = 1;
		

	}
 }
	
	Nodo raiz;
	int primos = 0;
	public ArvoreAVL() {
		raiz = null;
	}

	public void inserir(int dado) {
		raiz = inserirDado(raiz,dado);
	}
	
	public void inserirLetra(String letra) {
		raiz = insereLetra(raiz,letra);
	}
	
	
	public void verNosPrimos() {
		verPrimos(raiz);
		System.out.println("Temos "+primos+ " primos na arvore.");
	}
	
	private void verPrimos(Nodo raiz) {

			if (raiz != null) {
				verPrimos(raiz.esq);
				if(raiz.dado == 2 || raiz.dado == 3) {
					System.out.println(raiz.dado+" é primo");		
					primos++;
				}else if(!(raiz.dado % 2 ==0) && !(raiz.dado % 3 == 0) ) {
					System.out.println(raiz.dado+" é primo");
					primos++;

				}
				verPrimos(raiz.dir);
			}
			return;
		
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

		}else {
			raiz.copy++;
		}
		return raiz;
	}
	
	private Nodo insereLetra(Nodo raiz, String  letra) {
		int dado = verNumeroDaLetra(letra);

		if (raiz == null) {
			raiz = new Nodo(dado);
			return raiz;

		}
		if (dado < raiz.dado) {
			letra = verLetraDoNumero(dado);
			raiz.esq = insereLetra(raiz.esq,letra);
			if (raiz.esq.altd > raiz.esq.alte) {
				raiz.alte = raiz.esq.altd + 1;
			} else {
				raiz.alte = raiz.esq.alte + 1;
			}
			raiz = balanceamento(raiz);
		} else if (dado > raiz.dado) {
			letra = verLetraDoNumero(dado);
			raiz.dir = insereLetra(raiz.dir,letra);
			if (raiz.dir.altd > raiz.dir.alte) {
				raiz.altd = raiz.dir.altd + 1;
			} else {
				raiz.altd = raiz.dir.alte + 1;
			}
			raiz = balanceamento(raiz);
		}else {
			raiz.copy++;
		}
		return raiz;
	}
	
	private String verLetraDoNumero(int dado) {
		String letra = null;
		switch(dado) {
		case ( 1 ):
			letra = "A";
			break;	
		case ( 2 ):
			letra = "B";
			break;
		case ( 3 ):
			letra = "C";
			break;
		case(4):
			letra = "D";
			break;
		case(5):
			letra = "E";
			break;
		case(6):
			letra = "F";
			break;
		case(7):
			letra = "G";
			break;
		case(8):
			letra = "H";
			break;
		case(9):
			letra = "I";
			break;
		case(10):
			letra = "J";			
			break;
		case(11):
			letra = "K";
			break;
		case(12):
			letra = "L";
			break;
		case(13):
			letra = "M";
			break;
		case(14):
			letra = "N";
			break;
		case(15):
			letra = "O";
			break;
		case(16):
			letra = "P";
			break;
		case(17):
			letra = "Q";
			break;
		case(18):
			letra = "R";
			break;
		case(19):
			letra = "S";
			break;
		case(20):
			letra = "T";
			break;
		case(21):
			letra = "U";
			break;
		case(22):
			letra = "V";
			break;
		case(23):
			letra = "W";
			break;
		case(24):
			letra = "X";
			break;
		case(25):
			letra = "Y";
			break;
		case(26):
			letra = "Z";
			break;
		
		}
		return letra;
	}
	
	private int verNumeroDaLetra(String letra) {
		int dado = 0;
		switch(letra) {
		case ( "A" ):
			dado = 1;
			break;	
		case ( "B" ):
			dado = 2;
			break;
		case ( "C" ):
			dado = 3;
		break;
		case("D"):
			dado = 4;
			break;
		case("E"):
			dado = 5;
			break;
		case("F"):
			dado = 6;
			break;
		case("G"):
			dado = 7;
			break;
		case("H"):
			dado = 8;
			break;
		case("I"):
			dado = 9;
			break;
		case("J"):
			dado = 10;
			break;
		case("K"):
			dado = 11;
			break;
		case("L"):
			dado = 12;
			break;
		case("M"):
			dado = 13;
			break;
		case("N"):
			dado = 14;
			break;
		case("O"):
			dado = 15;
			break;
		case("P"):
			dado = 16;
			break;
		case("Q"):
			dado = 17;
			break;
		case("R"):
			dado = 18;
			break;
		case("S"):
			dado = 19;
			break;
		case("T"):
			dado = 20;
			break;
		case("U"):
			dado = 21;
			break;
		case("V"):
			dado = 22;
			break;
		case("W"):
			dado = 23;
			break;
		case("X"):
			dado = 24;
			break;
		case("Y"):
			dado = 25;
			break;
		case("Z"):
			dado = 26;
			break;
		
		}
		return dado;
	}
	
	public void removeLetra(String letra ){
		int chave = verNumeroDaLetra(letra);
		raiz = removeLetra(raiz,chave);
		
	}
	
	private Nodo removeLetra(Nodo raiz, int chave) {
		if(raiz == null) {
			return null;
		}
		if(chave < raiz.dado) {
			raiz.esq = removeLetra(raiz.esq,chave);
			raiz.copy--;
		}else if(chave > raiz.dado) {
			raiz.dir = removeLetra(raiz.dir, chave);
			raiz.copy--;
		}else {
			if(raiz.esq == null) {
				return raiz.dir;
			}else if(raiz.dir == null) {
				return raiz.esq;
			}else {
				Nodo next = findNext(raiz.dir);
				raiz.dado = next.dado;
				raiz.dir = removeLetra(raiz.dir,next.dado);
			}
			raiz.copy--;
		}
	return raiz;
	}
	
	public void remove(int chave) {
		raiz = removeItem(raiz,chave);
		
	}
	
	private Nodo removeItem(Nodo raiz, int chave) {
		if(raiz == null) {
			return null;
		}
		if(chave < raiz.dado) {
			raiz.esq = removeItem(raiz.esq,chave);
		}else if(chave > raiz.dado) {
			raiz.dir = removeItem(raiz.dir, chave);
		}else {
			if(raiz.esq == null) {
				return raiz.dir;
			}else if(raiz.dir == null) {
				return raiz.esq;
			}else {
				Nodo next = findNext(raiz.dir);
				raiz.dado = next.dado;
				raiz.dir = removeItem(raiz.dir,next.dado);
			}
		}
	return raiz;
	}
	
	private Nodo findNext(Nodo nodo) {
		while(nodo.esq != null) {
			nodo = nodo.esq;
		}
		return nodo;
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
	
	public void mostrarLetraEmOrdem() {
		mostrandoOrdenadoLetra(raiz);
	}
	private void mostrandoOrdenadoLetra(Nodo raiz) {
		String letra;
		if (raiz != null) {
			mostrandoOrdenadoLetra(raiz.esq);
			letra = verLetraDoNumero(raiz.dado);
			System.out.println(letra);
			mostrandoOrdenadoLetra(raiz.dir);
		}
	}

	public void mostrarEmOrdem() {
		mostrandoOrdenado(raiz);
	}
	private void mostrandoOrdenado(Nodo raiz) {
		if (raiz != null) {
			mostrandoOrdenado(raiz.esq);
			System.out.println(raiz.dado+" vezes adicionada: "+raiz.copy);
			mostrandoOrdenado(raiz.dir);
		}
	}
	
	public void mostrarNosNoNivel(int nivelDesejado) {
	    mostrarNosNoNivelRecursivo(raiz, nivelDesejado, 0);
	}

	private void mostrarNosNoNivelRecursivo(Nodo raiz, int nivelAlvo, int nivelAtual) {
	    if (raiz == null) {
	        return;
	    }
	    
	    if (nivelAtual == nivelAlvo) {
	        System.out.println(raiz.dado);
	    }
	    
	    mostrarNosNoNivelRecursivo(raiz.esq, nivelAlvo, nivelAtual + 1);
	    mostrarNosNoNivelRecursivo(raiz.dir, nivelAlvo, nivelAtual + 1);
	}
	
	public int somaNivelImpar() {
	    return somarNosImpares(raiz, 0);
	}

	private int somarNosImpares(Nodo raiz, int nivelAtual) {
	    if (raiz == null) {
	        return 0;
	    }

	    int soma = 0;
	    if (nivelAtual % 2 != 0) {
	        soma += raiz.dado;
	    }

	    soma += somarNosImpares(raiz.esq, nivelAtual + 1);
	    soma += somarNosImpares(raiz.dir, nivelAtual + 1);
	    return soma;
	}
	
	/* fazer:

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

}
