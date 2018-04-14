/*
 *  Bebida
 *  
 *  1.0
 *  
 *  Code by: Julio Cesar Rangel
 * 
 */

package hello;

public class Bebida {
	private String categoria;
	private String nome;
	private Double preco;
	private String temperatura;
	private int qtd;

	public Bebida(String categoria,String nome, Double preco, String temperatura, int qtd){
		this.categoria = categoria;		
		this.nome = nome;
		this.preco = preco;
		this.temperatura = temperatura;
		this.qtd = qtd;
		
	}
	
	public String getCategoria(){
		return this.categoria;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public Double getPreco(){
		return this.preco;
	}
	
	public String getTemperatura()	{
		return this.temperatura;
	}
	
	public void setCategoria(String categoria){
		this.categoria = categoria;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setPreco(Double preco){
		this.preco = preco ;
	}
	
	public void setTemperatura(String temperatura){
		this.temperatura = temperatura;
	}
	
	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	public boolean comparar(String bebida){
		if(nome.equals(bebida)){
			return true;
		} else {
			return false;
		}
	}//Cesar Augusto
	
	public void atualizarPreco(String nome, Double preco){
		if(nome.equals(nome)){
			this.preco = preco;
		}
	}//Cesar Augusto
	
	
}
