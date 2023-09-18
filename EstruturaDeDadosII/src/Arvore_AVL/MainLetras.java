package Arvore_AVL;

public class MainLetras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	ArvoreAVL aavl = new ArvoreAVL();
		

		aavl.inserirLetra("Q");
		aavl.inserirLetra("U");
		aavl.inserirLetra("E");
		aavl.inserirLetra("S");
		aavl.inserirLetra("T");
		aavl.inserirLetra("A");
		aavl.inserirLetra("O");
		aavl.inserirLetra("F");
		aavl.inserirLetra("C");
		aavl.inserirLetra("I");
		aavl.inserirLetra("L");
		
		System.out.println("Letras: ");
		
		aavl.mostrarLetraEmOrdem();
		
		aavl.removeLetra("E");
		aavl.removeLetra("U");
		
		System.out.println("Letras após remoção do E e U: ");
		
		aavl.mostrarLetraEmOrdem();
		
		
	}

}
