package io.ytong.stanfordalgorithm.c3w2;

import java.util.HashSet;
import java.util.Set;

public class MutationHelper {
	public Set<String> mutateOneOrTwoBits(String binary) {
		Set<String> mutations = new HashSet<String>();
		for (int i=0; i<binary.length(); i++) {
			String flipBit = flipBit(binary.charAt(i));
			String mutation = binary.substring(0, i) + flipBit + binary.substring(i + 1);
			mutations.add(mutation);
		}
		for (int i=0; i<binary.length(); i++) {
			String flipBitI = flipBit(binary.charAt(i));
			for (int j=i+1; j<binary.length(); j++) {
				String flipBitJ = flipBit(binary.charAt(j));
				String mutation = binary.substring(0, i) + flipBitI 
						+ binary.substring(i + 1, j) + flipBitJ
						+ binary.substring(j + 1);
				mutations.add(mutation);
			}
		}
		return mutations;
	}
	
	private String flipBit(Character ch) {
		if (ch == '0') {
			return "1";
		} else {
			return "0";
		}
	}
}
