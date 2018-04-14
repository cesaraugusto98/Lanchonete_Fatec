/*
 *  Controller
 *  
 *  1.6
 *  
 *  Code by: Cesar Augusto e Julio Cesar
 * 
 */

package hello;

import static spark.Spark.get;

import java.time.LocalDate;
import java.util.List;

import com.google.gson.Gson;


public class Controller {
	
	private Model model;
	
	
	public Controller(Model model){
		this.model = model;
	}
	
	public void buscarLanche(){
		get("/Lanche/:lanche", (req, res) -> {
			
			List<Lanche> LanchesEncontrados = model.buscarLanches(req.params(":lanche"));
			return new Gson().toJson(LanchesEncontrados);
			
		});
	}//Cesar Augusto
	
	public void buscarBebida(){
		get("/Bebida/:bebida", (req, res) -> {
			
			List<Bebida> BebidasEncontradas = model.buscarBebidas(req.params(":bebida"));
			return new Gson().toJson(BebidasEncontradas);
			
		});
	}//Cesar Augusto

	
	public void adicionarLanche(){
		
		get("/addLanche/:nome/:sabor/:preco/:qtd",  (req, res) -> {
			
			model.addLanche(new Lanche(req.params(":nome"),req.params(":sabor"), Double.parseDouble(req.params(":preco")), Integer.parseInt(req.params(":qtd"))));
			return new Gson().toJson(model.getLanches());
			
		});
		
	}//Cesar Augusto
	
	public void adicionarBebida() {
		get("/addBebida/:categoria/:nome/:preco/:temperatura/:qtd",  (req, res) -> {
			model.addBebida(new Bebida(req.params(":categoria"),req.params(":nome"), Double.parseDouble(req.params(":preco")), req.params(":temperatura"), Integer.parseInt(req.params(":qtd"))));
			return new Gson().toJson(model.getBebidas());
		});
	}//Cesar Augusto
	
	public void adicionarFuncionario() {
		get("/addFuncionario/:nome/:cpf/:login/:senha/:dtNascimento/:salario",  (req, res) -> {
			model.addFuncionario(new Funcionario(req.params(":nome"),req.params(":cpf"),req.params(":login"),req.params(":senha"), LocalDate.parse(req.params("dtNascimento").replace("-", "/")),Double.parseDouble(req.params(":salario"))));
			
			return new Gson().toJson(model.getFuncionariosTratados());
		});
	}//Julio Cesar
	
	public void verificarLogin() {
		get("/loginAdm/:login/:senha", (req,res)-> {
			return new Gson().toJson(model.verificarLogin(req.params(":login"),req.params(":senha")));
			
		});
	}//Cesar Augusto
}
