package io.ytong.stanfordalgorithm.c3w3;

public class HuffmanMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// init
		String file = "c3w3/huffman.txt";
		HuffmanHelper huffmanHelper = new HuffmanHelper(file);
		int[] weights = huffmanHelper.getWeights();
		
		
		// build tree
		TreeNode root = HuffmanSolver.buildHuffmanTree(weights);
		
		// find min and max length of codeword
		int[] lengths = TreeHelper.getMaxAndMinLength(root);
		
		// output
		System.out.println(String.format(
				"The maximum length of a codeword in the resulting Huffman code is %d", lengths[1]));
		System.out.println(String.format(
				"The minimum length of a codeword in your Huffman code is %d", lengths[0]));
	}

}
