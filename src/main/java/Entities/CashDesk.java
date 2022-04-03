package Entities;

import java.util.logging.Logger;

public class CashDesk {
	
	private static Logger logger = Logger.getLogger("CashDeskLogger");
    private int cash;
    
	public CashDesk(int cash) {
		super();
		this.cash = cash;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}
    
	public void putMoney(int sum){
        if(sum >= 0){
            this.cash += sum;
            logger.info("Added: " + sum);
        }
    }

    public boolean getMoney(int sum){
        if(this.cash >= sum){
            this.cash -= sum;
            logger.info("Got: " + sum);
            return true;
        }
        else {
            logger.warning("Error sum > balance: " + sum);
            return false;
        }
    }

}
