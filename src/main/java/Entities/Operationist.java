package Entities;

import java.util.PriorityQueue;
import java.util.logging.Logger;

import Addition.Operation;

public class Operationist extends Thread{
	
	private static Logger logger = Logger.getLogger("OperationistLogger");
    private final PriorityQueue<Client> clients;
    private final CashDesk cashDesk;
    private Client client;
    
	public Operationist(CashDesk cashDesk) {
		super();
        this.clients = new PriorityQueue<Client>();
        this.cashDesk = cashDesk;
        this.client = null;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public PriorityQueue<Client> getClients() {
		return clients;
	}
	
	 @Override
	 public void run() {
		 while (true){
			 startService();
	        }
	    }
	
	public synchronized void addToQueue(Client newClient){
        clients.add(newClient);
        if(client == null)
            notify();
        logger.info("The queue includes : " + clients.size() + " people");
    }

    private synchronized void startService(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service();
    }

    private void service(){
        synchronized (cashDesk) {
            client = clients.peek();
            logger.info("Start of servicing the: " + client.hashCode() + " client");
            if(client.getOperation() == Operation.PUT_MONEY){
                cashDesk.putMoney(client.getAmount());
                logger.info("Client: " + client.hashCode() + " added money");
                logger.info("Balance: " + cashDesk.getCash());
            }
            else if(client.getOperation() == Operation.GET_MONEY){
                while(!cashDesk.getMoney(client.getAmount())) {
                    clients.poll();
                }
                logger.info("Client: " + client.hashCode() + " got money");
                logger.info("Balance: " + cashDesk.getCash());
            }
        }
        try {
            sleep(client.getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        client = null;
        if(clients.size() > 0)
            service();
    }


    
    

}
