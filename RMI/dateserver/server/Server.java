import java.rmi.Naming;
public class Server {
	public static void main(String[] args) throws Exception {

		DateImpl dateServer = new DateImpl();
		String url = "rmi://localhost:1099/";
		Naming.rebind(url+"DateServer", dateServer);
		System.out.println(Naming.list(url)[0]); 
	}
}