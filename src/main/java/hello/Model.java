/*
 *  Model
 *  
 *  1.1
 *  
 *  Code by: Cesar Augusto e Julio Cesar
 * 
 */

package hello;

import java.util.List;
import java.time.LocalDate;
import java.util.LinkedList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Model {

	
	//private List<Lanche> lanches = new LinkedList<Lanche>(); //papel de banco de dados
	ObjectContainer lanches = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/lanches.db4o");
	
	//private List<Bebida> bebidas = new LinkedList<Bebida>(); //papel de banco de dados
	ObjectContainer bebidas = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/bebidas.db4o");
	
	//private List<Funcionario> funcionarios = new LinkedList<Funcionario>(); //papel de banco de dados
	ObjectContainer funcionarios = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/funcionarios.db4o");

	
	public List<Lanche> buscarLanches(String nomeLanche){
		List<Lanche> lanchesEncontrados = new LinkedList<Lanche>();
		
		Query query = lanches.query();
		query.constrain(Lanche.class);
		ObjectSet<Lanche> allLanches = query.execute();
		
		for(Lanche lanche:allLanches){
			 if(nomeLanche.equals(lanche.getNome())) lanchesEncontrados.add(lanche);
		}
		
		return lanchesEncontrados;
		
	}//Cesar Augusto
	
	public void addLanche(Lanche lanche){
		//lanches.add(lanche);
		lanches.store(lanche);
		lanches.commit();
	}//Cesar Augusto
	
	public void limpaLanche() {
		List<Lanche> allLanches = getLanches();
		for(Lanche lan:allLanches) {
			lanches.delete(lan);	
		}
		lanches.commit();
	}
	
	public List<Lanche> getLanches(){
		Query query = lanches.query();
		query.constrain(Lanche.class);
		ObjectSet<Lanche> allLanche = query.execute();
		for(Lanche l: allLanche) {
			System.out.println(l);
		}
		return allLanche;
	}//Cesar Augusto
	
	public Funcionario verificarLogin(String login, String senha) {
		Query query = funcionarios.query();
		query.constrain(Funcionario.class);
		ObjectSet<Funcionario> allFuncionario = query.execute();
		
		for(Funcionario funcionario:allFuncionario) {
			if(login.equals(funcionario.getLogin()) && senha.equals(funcionario.getSenha()))
				return funcionario;
		}
		return null;
	}//Cesar Augusto
	
	public void addFuncionario(Funcionario func) {
		//funcionarios.add(func);
		funcionarios.store(func);
		funcionarios.commit();
	}//Julio Cesar

	public void limpaFuncionario() {
		List<Funcionario> allFuncionario = getFuncionariosTratados();
		for(Funcionario fun:allFuncionario) {
			funcionarios.delete(fun);	
		}
		funcionarios.commit();
	}	
	
	public List<Funcionario> getFuncionariosTratados(){
		Query query = funcionarios.query();
		query.constrain(Funcionario.class);
		ObjectSet<Funcionario> allFuncionario = query.execute();
		
		for(Funcionario func:allFuncionario) {
			func.setDtNascimento(LocalDate.parse(String.valueOf(func.getDtNascimento()).replace('/', '-')));
		}
		return allFuncionario;
	}//Julio Cesar
	
	/*public List<Funcionario> getFuncionarios(){
		return funcionarios;
	}//Cesar Augusto
*/	
	public void limpaBebida() {
		List<Bebida> allBebidas = getBebidas();
		for(Bebida beb:allBebidas) {
			bebidas.delete(beb);	
		}
		bebidas.commit();
	}
	
	public void addBebida(Bebida bebida){
		//bebidas.add(bebida);
		bebidas.store(bebida);
		bebidas.commit();
	}//Julio Cesar
	
	public List<Bebida> buscarBebidas(String nome){
		List<Bebida> bebidasEncontradas = new LinkedList<Bebida>();
		
		Query query = bebidas.query();
		query.constrain(Bebida.class);
		ObjectSet<Bebida> allBebidas = query.execute();
		
		for(Bebida bebida:allBebidas){
			 if(bebida.getNome().toUpperCase().contains(nome.toUpperCase())) bebidasEncontradas.add(bebida);
		}
		
		return bebidasEncontradas;
		
	}//Cesar Augusto
	
	public List<Bebida> getBebidas(){
		Query query = bebidas.query();
		query.constrain(Bebida.class);
		ObjectSet<Bebida> allBebida = query.execute();
		return allBebida;
	}//Cesar Augusto
	
}
