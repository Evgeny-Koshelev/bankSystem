package Entities;

import Addition.Operation;

public class Client implements Comparable<Client> {

		
	 private Operation operation;
	 private int amount;
	 private int time;

	public Client(Operation operation, int amount, int time) {
		super();
		this.operation = operation;
		this.amount = amount;
		this.time = time;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTime() {
		return time;
	}

	public void setServiceTime(int time) {
		this.time = time;
	}
	 
	@Override
	public int compareTo(Client o) {
		return 0;
	}

}
