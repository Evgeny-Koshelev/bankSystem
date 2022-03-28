package Entities;

import java.util.logging.Logger;

public class CashDesk {
	
	private static Logger logger = Logger.getAnonymousLogger();
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
            logger.info("���������: " + sum);
        }
    }

    public boolean getMoney(int sum){
        if(this.cash >= sum){
            this.cash -= sum;
            logger.info("�����: " + sum);
            return true;
        }
        else {
            logger.warning("������� �� ����� ������: " + sum);
            return false;
        }
    }

}
