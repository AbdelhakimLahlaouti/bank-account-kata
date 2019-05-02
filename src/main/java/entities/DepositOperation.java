package entities;

import enumeration.OperationTypeEnum;

import java.math.BigDecimal;

public class DepositOperation extends Operation {

	 public DepositOperation(BigDecimal amount, BigDecimal oldBalance) {
		super(amount, oldBalance);
	}

	@Override
	protected BigDecimal calculateNewBalance(BigDecimal oldBalance, BigDecimal amount) {
		return oldBalance.add(amount);
	}

	@Override
	public OperationTypeEnum getOperationType() {
		return OperationTypeEnum.DEPOSIT;
	}
}
