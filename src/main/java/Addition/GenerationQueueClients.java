package Addition;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.logging.Logger;

import Entities.Client;

public class GenerationQueueClients extends Thread{
	
	
	private static Logger logger = Logger.getLogger("ClientLogger");
	private final int CLIENTS_PER_MINUTE = 5000;
	private final int SERVICE_TIME = 5000;
	private final PriorityQueue<Client> clients;
	
	public GenerationQueueClients() {
		 this.clients = new PriorityQueue<Client>();
	}

	public PriorityQueue<Client> getClients() {
		return clients;
	}
	
	 @Override
	 public void run() {
		 Random rnd = new Random();
		 while(true){
			 try{
				 sleep(rnd.nextInt(2000));
				 
	            }catch (InterruptedException e) {
	                e.printStackTrace();
	            }
			 synchronized (clients){
				 Random random = new Random(10);
				 Client client = new Client(random.nextBoolean() ? Operation.PUT_MONEY : Operation.GET_MONEY, random.nextInt(CLIENTS_PER_MINUTE) + 1, random.nextInt(SERVICE_TIME));
	             clients.add(client);
	             logger.info("New client: " + client.hashCode());
	            }
	        }
	    }

}
