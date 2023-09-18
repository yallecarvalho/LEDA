package problems;

/**
 * Dado um array A ordenado de inteiros de tamanho N e um valor x, possivelmente com mais de uma ocorrencia,
 * usar busca binária para encontrar as posicoes da primeira e ultima ocorrencias de x em  A.

Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].

 * Restricoes: 
 * - Seu algoritmo NÃO pode usar memória extra (a nao ser variaveis simples locais e nao de colecao/estrutura) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * - Retornar um array com dois elementos [primeiraPosicao,ultimaPosicao], onde primeiraPosicao
 *   tem o valor do indice da primeira ocorrencia de x em A, e ultimaPosicao tem o valor do indice 
 *   da ultima ocorrencia de x em A
 * - Note que se x nao esta em A entao o retorno deve ser [-1,-1]
 *
 */
public class StartEndPositionImpl implements StartEndPosition{


	@Override
	public int[] startEndPosition(Integer[] array, Integer x){
		int left = 0;
		int right = array.length-1;
		int[] result = new int[2];
		
		result[0] = buscaBinariaPrimeira(array, left, right, x);
		result[1] = buscaBinariaUltima(array, left, right, x);
		
		return result;
		
	}
	
	//Aplica a busca binária para buscar a primeira posição de x
	private int buscaBinariaPrimeira(Integer[] array, int left, int right, Integer x) {
		
		int result = -1;
		
		if(left <= right) {
			int mid = (left+ right)/2;
			
			if(array[mid] > x) {
				result = buscaBinariaPrimeira(array, left, mid-1, x);
			} else if (array[mid] < x) {
				result = buscaBinariaPrimeira(array, mid+1, right, x);
			} else if (right >= 3) {
				if(array[mid] == x && array[mid-1] < x) {
					result = mid;
				} else if(array[mid] == x && array[mid-1] == x) {
					result = mid-1;
				}
			} else {
				result = mid;
			}
		} return result;	
		
	}
	//Aplica a busca binária para buscar a ultima posição de x
	private int buscaBinariaUltima(Integer[] array, int left, int right, Integer x) {
		
		if(left <= right) {
			int mid = (left+ right)/2;
			
			if(array[mid] > x) {
				return buscaBinariaUltima(array, left, mid-1, x);
			} else if (array[mid] < x) {
				return buscaBinariaUltima(array, mid+1, right, x);
			} else if (right >= 3) {
				if(array[mid] == x && array[mid+1] > x) {
					return mid;
				} else if(array[mid] == x && array[mid+1] == x) {
					return mid+1;
				}
			} else {
				return mid;
			}
		} return -1;					
		
	}
	
	

}
