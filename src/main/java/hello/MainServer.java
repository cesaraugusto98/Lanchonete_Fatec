/*
 *  MainServer
 *  
 *  1.1
 *  
 *  Code by: Cesar Augusto e Julio Cesar
 * 
 */

package hello;

import static spark.Spark.*;


public class MainServer {
	
	final static Model model = new Model();

    public static void main(String[] args) {

		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            //port = 8080;
        	port = 1234;
        }
        port(port);

		//Servir conteudo html, css e javascript
		staticFileLocation("/static");
		inicializarLanches();
		
		Controller controller = new Controller(model);
		
		controller.buscarLanche();
		controller.adicionarLanche();
		controller.buscarBebida();
		controller.adicionarBebida();
		controller.verficarLogin();
		controller.adicionarFuncionario();
				
    }
    
	public static void inicializarLanches(){
		model.limpaLanche();
    	model.addLanche(new Lanche("Hamburgao", "Hamburgao com Queijo Cheddar", 3.50, 5));
    	model.addLanche(new Lanche("Hamburgao", "Hamburgao com Queijo Mussarela", 3.50, 5));
    	model.addLanche(new Lanche("Hamburgao", "Hamburgao com Tomate", 3.50, 5));
    	model.addLanche(new Lanche("Pastel", "Pastel de Pizza", 5.50, 5));
    	model.addLanche(new Lanche("Pastel", "Pastel de Frango com Catupiry", 6.50, 5));
    	model.addLanche(new Lanche("Pastel", "Pastel de Queijo", 5.00, 5));
    	
    	model.limpaBebida();
    	model.addBebida(new Bebida("Refrigerantes", "Coca-Cola Lata", 3.50, "Gelada", 3));
    	model.addBebida(new Bebida("Sucos", "DelVale Lata", 3.00, "Temperatura Ambiente", 10));
    	model.addBebida(new Bebida("Agua", "Agua com gás", 1.50, "Gelada", 15));
    	model.addBebida(new Bebida("Refrigerantes", "Coca-Cola 2L", 10.00, "Gelada", 5));
    	
    	model.limpaFuncionario();
    	model.addFuncionario(new Funcionario("Cesar Santos", "123.456.789-0", "ADMIN", "ADMIN", "02/06/1998", 1000.0));
    }
	
}
