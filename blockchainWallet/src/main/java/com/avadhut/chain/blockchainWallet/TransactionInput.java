package com.avadhut.chain.blockchainWallet;

public class TransactionInput {

	public String transactionOutputId; //Reference to TransactionOutputs -> transactionId
	public TransactionOutput unspentTransactionOut; //Contains the Unspent transaction output
	
	public TransactionInput(String transactionOutputId) {
		this.transactionOutputId = transactionOutputId;
	}
}
