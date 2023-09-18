package Arvore_AVL;


public class ArvoreAVL_Municipios {

	    class Nodo {
	        String nome;
	        int altura;
	        int area;
	        int populacao;
	        int alte;
	        int altd; 
	        Nodo esq, dir;
	        double area_tot;

	        public Nodo(String nome, int area, int populacao) {
	            this.nome = nome;
	            this.altura = 1;
	            this.area = area;
	            this.populacao = populacao;
	            this.alte = 0;
	            this.altd = 0;
	            this.area_tot = 0;
	        }
	    }
		
		Nodo raiz;
		double area_tot = 0;
		int primos = 0;
		public ArvoreAVL_Municipios() {
			raiz = null;
		}
		
		 public void inserir(String nome, int area, int populacao) {
		        raiz = inserirNodo(raiz, nome, area, populacao);
		    }

		    private Nodo inserirNodo(Nodo nodo, String nome, int area, int populacao) {
		        if (nodo == null) {
		            return new Nodo(nome, area, populacao);
		        }

		        if (nome.compareTo(nodo.nome) < 0) {
		            nodo.esq = inserirNodo(nodo.esq, nome, area, populacao);
		        } else if (nome.compareTo(nodo.nome) > 0) {
		            nodo.dir = inserirNodo(nodo.dir, nome, area, populacao);
		        } else {
		            // Tratar caso em que o município já existe na árvore
		        }

		        nodo.altura = Math.max(obterAltura(nodo.esq), obterAltura(nodo.dir)) + 1;
		        nodo.alte = obterAltura(nodo.esq);
		        nodo.altd = obterAltura(nodo.dir);
		        int balanceamento = obterBalanceamento(nodo);

		        if (balanceamento > 1 && nome.compareTo(nodo.esq.nome) < 0) {
		            return rotacaoDireita(nodo);
		        }

		        if (balanceamento < -1 && nome.compareTo(nodo.dir.nome) > 0) {
		            return rotacaoEsquerda(nodo);
		        }

		        if (balanceamento > 1 && nome.compareTo(nodo.esq.nome) > 0) {
		            nodo.esq = rotacaoEsquerda(nodo.esq);
		            return rotacaoDireita(nodo);
		        }

		        if (balanceamento < -1 && nome.compareTo(nodo.dir.nome) < 0) {
		            nodo.dir = rotacaoDireita(nodo.dir);
		            return rotacaoEsquerda(nodo);
		        }

		        return nodo;
		    }
		    
		   

		    private Nodo rotacaoEsquerda(Nodo raiz) {
		        Nodo aux1, aux2;
		        aux1 = raiz.dir;
		        aux2 = raiz.esq;
		        raiz.dir = aux2;
		        aux1.esq = raiz;
		        raiz.altd = obterAltura(raiz.dir);
		        aux1.alte = obterAltura(aux1.esq);
		        return aux1;
		    }

		    private Nodo rotacaoDireita(Nodo raiz) {
		        Nodo aux1, aux2;
		        aux1 = raiz.esq;
		        aux2 = aux1.dir;
		        raiz.esq = aux2;
		        aux1.dir = raiz;
		        raiz.alte = obterAltura(raiz.esq);
		        aux1.altd = obterAltura(aux1.dir);
		        return aux1;
		    }

		    private int obterAltura(Nodo nodo) {
		        if (nodo == null) {
		            return 0;
		        }
		        return nodo.altura;
		    }

		    private int obterBalanceamento(Nodo nodo) {
		        if (nodo == null) {
		            return 0;
		        }
		        return obterAltura(nodo.esq) - obterAltura(nodo.dir);
		    }

		
		 public int contarMunicipios() {
		       return contarNodos(raiz);
		   }

		   private int contarNodos(Nodo nodo) {
		       if (nodo == null) {
		           return 0;
		       }
		       return 1 + contarNodos(nodo.esq) + contarNodos(nodo.dir);
		   }

		   public void mostrarMunicipiosComMaisDeXHabitantes(Nodo nodo, int x) {
		       if (nodo == null) {
		           return;
		       }
		       mostrarMunicipiosComMaisDeXHabitantes(nodo.esq, x);
		       if (nodo.populacao > x) {
		           System.out.println(nodo.nome);
		       }
		       mostrarMunicipiosComMaisDeXHabitantes(nodo.dir, x);
		   }

		    public void mostrarDensidadeDemografica() {
		        mostrarDensidadeDemografica(raiz);
		    }

		    private void mostrarDensidadeDemografica(Nodo raiz) {
		        if (raiz != null) {
		            double densidade = raiz.populacao / raiz.area;
		            System.out.println(raiz.nome + ": " + densidade + " habitantes por km²");
		            mostrarDensidadeDemografica(raiz.esq);
		            mostrarDensidadeDemografica(raiz.dir);
		        }
		    }
		    
		    private double areatot(Nodo raiz) {
		        if (raiz != null) {
		            area_tot += raiz.area;
		            mostrarDensidadeDemografica(raiz.esq);
		            mostrarDensidadeDemografica(raiz.dir);
		        }
		        
		        return area_tot;
		    }

		    public double calcularPorcentagemAreaTotal() {
		    	double areaNacional = 8510000;
		    	double areaTotalMunicipios = areatot(raiz);
		        return (areaTotalMunicipios/ areaNacional) * 100 ;
		    }

		    private Nodo encontrarCidadeMaiorPopulacao(Nodo raiz) {
		        if (raiz == null) {
		            return null;
		        }

		        Nodo maiorPopulacao = raiz;
		        Nodo cidadeEsq = encontrarCidadeMaiorPopulacao(raiz.esq);
		        Nodo cidadeDir = encontrarCidadeMaiorPopulacao(raiz.dir);

		        if (cidadeEsq != null && cidadeEsq.populacao > maiorPopulacao.populacao) {
		            maiorPopulacao = cidadeEsq;
		        }
		        if (cidadeDir != null && cidadeDir.populacao > maiorPopulacao.populacao) {
		            maiorPopulacao = cidadeDir;
		        }

		        return maiorPopulacao;
		    }

		    public String encontrarCidadeComMaiorPopulacao() {
		        Nodo cidadeComMaiorPopulacao = encontrarCidadeMaiorPopulacao(raiz);
		        if (cidadeComMaiorPopulacao != null) {
		            return cidadeComMaiorPopulacao.nome;
		        } else {
		            return "Nenhuma cidade encontrada";
		        }
		    }
		

	}

