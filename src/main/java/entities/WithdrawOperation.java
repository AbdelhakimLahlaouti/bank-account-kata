package entities;

import enumeration.OperationTypeEnum;

import java.math.BigDecimal;

public class WithdrawOperation extends Operation {

	 public WithdrawOperation(final BigDecimal amount, final BigDecimal oldBalance) {
		super(amount, oldBalance);
	}

	@Override
	protected BigDecimal calculateNewBalance(final BigDecimal oldBalance, final BigDecimal amount) {
		return oldBalance.subtract(amount);
	}

	@Override
	public OperationTypeEnum getOperationType() {
		return OperationTypeEnum.WITHDRAWAL;
	}
}
