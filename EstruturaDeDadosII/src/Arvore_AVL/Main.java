package Arvore_AVL;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArvoreAVL aavl = new ArvoreAVL();
		
		aavl.inserir(5);
		aavl.inserir(7);
		aavl.inserir(1212);
		aavl.inserir(123);
		aavl.inserir(11);
		aavl.inserir(7);
		aavl.inserir(2);
		
		aavl.mostrarEmOrdem();
		if(aavl.verAvl(aavl.raiz)) {
			System.out.println("e uma avl ");
		}
		
		aavl.remove(1212);
		
		System.out.println("removendo o 1212 ");
		aavl.mostrarEmOrdem();
		
		aavl.verNosPrimos();
		
		System.out.println("nodos nivel 1: ");
		aavl.mostrarNosNoNivel(1);
		
		int somaImpar = aavl.somaNivelImpar();
		System.out.println("Soma dos níveis ímpares: "+somaImpar);
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
