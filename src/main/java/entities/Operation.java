package entities;

import enumeration.OperationTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class Operation {

	private LocalDateTime dateTime;
	private BigDecimal amount;
	private BigDecimal newBalance;

	 Operation( BigDecimal amount, BigDecimal oldBalance) {
		this.amount = amount;
		this.dateTime = LocalDateTime.now();
		this.newBalance = calculateNewBalance(oldBalance, amount);
	}

	protected abstract BigDecimal calculateNewBalance(BigDecimal oldBalance, BigDecimal amount);

	public abstract OperationTypeEnum getOperationType();

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public BigDecimal getNewBalance() {
		return newBalance;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	@Override
	public String toString() {
		return "operation{" +
				"dateTime=" + dateTime +
				", amount=" + amount +
				", newBalance=" + newBalance +
				", operationType=" + this.getOperationType() +
				'}';
	}
}
