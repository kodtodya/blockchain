package com.avadhut.chain;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class MyFirstChain {

	private static ArrayList<Block> blockchain = new ArrayList<Block>();
	private static int difficuly;
	
	public static void main(String[] args) {
		
		blockchain.add(new Block("Hi im the first block", "0"));
		mine();
		
		
		blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash));
		mine();
		
		blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));
		mine();
		
		System.out.println(isValid()?"blockchain is VALID..":"blockchain is NOT VALID..");
		
		System.out.println("BlockChain string is:\n" + new GsonBuilder().setPrettyPrinting().create().toJson(blockchain));
				

	}
	
	public static void mine() {
		int position = blockchain.size()-1;
		System.out.println("trying to mine block: "+ position);
		blockchain.get(position).mineBlock(difficuly);
	}
	
	public static boolean isValid() {
		
		Block currentBlock; 
		Block previousBlock;
		
		//loop through blockchain to check hashes:
		for(int i=1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			//compare registered hash and calculated hash:
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			//compare previous hash and registered previous hash
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
		}
		return true;
	}

}
