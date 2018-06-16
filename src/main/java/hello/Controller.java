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
import static spark.Spark.post;


import java.io.UnsupportedEncodingException;
import java.util.List;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;
import spark.Route;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
		
		post("/addLanche/lanche", new Route() {
			public Object handle(final Request request, final Response response) throws JSONException {
				response.header("Access-Control-Allow-Origin", "*");
		        
		        Gson gson = new Gson();
		        String json = request.body();
		        
		        Lanche lanche = gson.fromJson(json, Lanche.class);
		        try {
		        	model.addLanche(lanche);
		        	return new Gson().toJson(model.getLanches());
		        }catch (Exception e){
		        	return null;
		        }
			}			
		});		
	}//Cesar Augusto
	
	public void adicionarBebida() {
		
		post("/addBebida/bebida", new Route() {
			public Object handle(final Request request, final Response response) throws JSONException {
				response.header("Access-Control-Allow-Origin", "*");
		        
		        Gson gson = new Gson();
		        String json = request.body();
		        
		        Bebida bebida = gson.fromJson(json, Bebida.class);
		        try {
		        	model.addBebida(bebida);
		        	return new Gson().toJson(model.getBebidas());
		        }catch (Exception e){
		        	return null;
		        }
			}			
		});
		
		
	}//Cesar Augusto
	
	public LocalDate ConvertLocalDate(String dt) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        	
		LocalDate date = LocalDate.parse(dt, formatter);

		return date;
	}

	
	public void adicionarFuncionario() {
		
		post("/addFuncionario/funcionario", new Route() {
			public Object handle(final Request request, final Response response) throws JSONException {
				response.header("Access-Control-Allow-Origin", "*");
		        
		        Gson gson = new Gson();
		        String json = request.body();
		        
		        Funcionario funcionario = gson.fromJson(json, Funcionario.class);
		        try {
		        	model.addFuncionario(funcionario);
		        	return new Gson().toJson(model.getBebidas());
		        }catch (Exception e){
		        	return null;
		        }
			}			
		});
		
		/*get("/addFuncionario/:nome/:cpf/:login/:senha/:dtNascimento/:salario",  (req, res) -> {
			model.addFuncionario(new Funcionario(req.params(":nome"),req.params(":cpf"),req.params(":login"),req.params(":senha"), ConvertLocalDate(req.params(":dtNascimento")),Double.parseDouble(req.params(":salario"))));
			
			return new Gson().toJson(model.getFuncionariosTratados());
		});*/
	}//Julio Cesar
	
	/*public void verificarLogin() {
		get("/loginAdm/:login/:senha", (req,res)-> {
			return new Gson().toJson(model.verificarLogin(req.params(":login"),req.params(":senha")));
			
		});
	}//Cesar Augusto*/
	
	public void verficarLogin() {
		post("/loginAdm/funcionario", new Route() {
			public Object handle(final Request request, final Response response) throws JSONException {
				response.header("Access-Control-Allow-Origin", "*");

		        JSONObject json = new JSONObject(request.body());
		        	
		        String userName = json.getString("login");
		           
		        String password = json.getString("senha");
		        
		        try {
		        	return new Gson().toJson(model.verificarLogin(userName, password));
		        }
		        catch(Exception e) {
		        	return null;
		        }
			}	
		});
	}
}
