package Main;

import java.util.logging.Logger;

import Addition.GenerationQueueClients;
import Entities.CashDesk;
import Entities.Operationist;

public class Work {
	
	private static Logger logger = Logger.getLogger("MainLogger");
    private static final int N = 5;

	public static void main(String[] args) {
		
		logger.info("Start of work");
        int min;
        Operationist[] operationists = new Operationist[N];
        CashDesk cashDesk = new CashDesk(1000000);
        GenerationQueueClients generator = new GenerationQueueClients();
        generator.start();

        for(int i=0; i<operationists.length; i++){
        	operationists[i] = new Operationist(cashDesk);
        	operationists[i].start();
        }

        while(true) {
            if (!generator.getClients().isEmpty()) {
                min = 0;
                for (int i = 1; i < operationists.length; i++) {
                    if (operationists[i].getClients().size() < operationists[min].getClients().size())
                        min = i;
                    logger.info("Queue size of the " + i + " operationist: " + operationists[i].getClients().size());
                }
                operationists[min].addToQueue(generator.getClients().peek());
                generator.getClients().poll();
            }
        }

	}

}
