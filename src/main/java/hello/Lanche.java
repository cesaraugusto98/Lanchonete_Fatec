/*
 *  FormaPagamento
 *  
 *  1.0
 *  
 *  Code by: Cesar Augusto Siqueira Santos
 * 
 */

package hello;

public class Lanche {
	private String nome;
	private String sabor;
	private Double preco;
	private int qtd;
	
	

	public Lanche(String nome,String sabor, Double preco, int qtd){
		this.nome = nome;
		this.sabor = sabor;
		this.preco = preco;
		this.qtd = qtd;
		
	}
	
	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	
	public String getNome(){
		return this.nome;
	}
	
	public String getSabor(){
		return this.sabor;
	}
	
	public Double getPreco(){
		return this.preco;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setSabor(String sabor){
		this.sabor = sabor;
	}
	
	public void setPreco(Double preco){
		this.preco = preco ;
	}
	
	
	public boolean comparar(String lanche){
		if(nome.equals(lanche)){
			return true;
		} else {
			return false;
		}
	}//Cesar Augusto
	
	public void atualizarPreco(String lanche, Double preco){
		if(nome.equals(lanche)){
			this.preco = preco;
		}
	}//Cesar Augusto

}
