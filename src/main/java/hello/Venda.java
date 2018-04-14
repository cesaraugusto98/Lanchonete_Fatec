package hello;

public class Venda {
	private int idVenda;
	private String produto;
	private String cpfFunc;
	
	public Venda(int idVenda, String produto, String cpfFunc)
	{
		this.idVenda = idVenda;
		this.produto = produto;
		this.cpfFunc = cpfFunc;
	}
	
	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getCpfFunc() {
		return cpfFunc;
	}

	public void setCpfFunc(String cpfFunc) {
		this.cpfFunc = cpfFunc;
	}



}
