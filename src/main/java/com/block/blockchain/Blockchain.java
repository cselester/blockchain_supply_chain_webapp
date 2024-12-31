package com.block.blockchain;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> chain;

    public Blockchain() {
        this.chain = new ArrayList<>();
        // Add the genesis block to start the chain
        this.chain.add(createGenesisBlock());
    }

    // Create the first block, the "genesis" block
    private Block createGenesisBlock() {
        Block genesisBlock = new Block("0", "0", "Genesis Block", System.currentTimeMillis(), null);
        genesisBlock.generateHash(); // Generate hash for genesis block
        return genesisBlock;
    }

    // Add a new block to the blockchain
    public void addBlock(String blockId, String previousHash, String data) {
        Block newBlock = new Block(blockId, previousHash, data, System.currentTimeMillis(), null);
        newBlock.generateHash(); // Generate hash for the new block
        this.chain.add(newBlock);
    }

    // Get the last block in the chain
    public Block getLastBlock() {
        return this.chain.get(this.chain.size() - 1);
    }

    // Display the blockchain for verification
    public void displayBlockchain() {
        for (Block block : this.chain) {
            System.out.println(block);
        }
    }

    public static void main(String[] args) {
        // Create the blockchain
        Blockchain blockchain = new Blockchain();

        // Add blocks to the blockchain
        blockchain.addBlock("1", blockchain.getLastBlock().getHash(), "Transaction 1");
        blockchain.addBlock("2", blockchain.getLastBlock().getHash(), "Transaction 2");

        // Display the blockchain
        blockchain.displayBlockchain();
    }
}
