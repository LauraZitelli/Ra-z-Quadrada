/*
	Cálculo para raiz quadrada
*/
public class Raiz {
	/*
		Calcula a raiz quadrada de um valor, com uma determinada
		precisão. Retorna esse valor, ou -1 quando:
		* a < 0
		* epsilon <= 0
		* epsilon >= 1
		
		Ou 0 quando a = 0
		
		Parâmetro:
			a - valor cuja raiz quadrada será calculada
			epsilon - precisão do cálculo
	*/
	static double raizQuadrada(double a, double epsilon) {
    //verificando se os parâmetros são válidos
    if(a < 0 || epsilon <=0 || epsilon >=1) return -1;
    //verificando se o parâmetro a é igual a zero
    else if(a == 0) return 0;
    //calculando a raiz do número "a" com precisao epsilon
    else{
      double x0 = (a/2.0);//valor inicial de x0
      double xi = 0;//declaracao de xi+1
      double condicao = (((a/2.0) + (a/(a/2.0)))/2.0);//condicao inicial de xi+1 - xi
      if(condicao < 0) condicao = - condicao;//calcula o módulo da condição
      while(condicao >= epsilon){
        xi = ((x0 + a/x0)/2.0);//xi+1 sendo calculado a partir do termo anterior x0.
        condicao = xi - x0;
        if(condicao < 0) condicao = - condicao;//módulo da condição
        x0 = xi;//x0 recebe seu próximo termo para dar continuidade ao processo. 
      }
      return xi;
    }
	}



	public static void main(String[] args) {
		
		// Exemplo de teste:
		double valor = 2;
		double precisao = 0.001;
		System.out.println("Raiz de: "+valor+" = "+raizQuadrada(valor, precisao));
	}
}