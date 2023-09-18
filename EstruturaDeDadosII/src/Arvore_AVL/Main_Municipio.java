package Arvore_AVL;

public class Main_Municipio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				ArvoreAVL_Municipios aavl = new ArvoreAVL_Municipios();
				
				aavl.inserir("agronomica",5,2);
				aavl.inserir("taio",5,500);
				aavl.inserir("rio do sul",5,2000);
				aavl.inserir("atalanta",5,2000);
				aavl.inserir("ituporanga",5,200023);
				
			System.out.println("numero de municipios: "+aavl.contarMunicipios());
				
			System.out.println("municipios com mais de 1000 habitantes: ");
			aavl.mostrarMunicipiosComMaisDeXHabitantes(aavl.raiz, 1000);
			aavl.mostrarDensidadeDemografica();
			
			
			System.out.println("area total "+ aavl.calcularPorcentagemAreaTotal());
			
			
			System.out.println("municipios com maior populacao: "+aavl.encontrarCidadeComMaiorPopulacao());
			
	}
}

