package main;

import java.util.ArrayList;
import java.util.Collections;

public enum CellOption {
	
	NAMN{
		String label() {
			return "Spelare:";
		}
		int index() {
			return 0;
		}
	},
	ETTOR{
		String label() {
			return "Ettor";
		}
		int index() {
			return 1;
		}
		int calculateScore(Die[] dice, Column column) {
			int result = 0;
			for(Die d : dice) {
				if(d.value == 1)
					result += d.value;
					
			}
			return result;
			
		}
		
	},
	TVÅOR{
		String label() {
			return "Tvåor";
		}
		int index() {
			return 2;
		}
		int calculateScore(Die[] dice, Column column) {
			int result = 0;
			for(Die d : dice) {
				if(d.value == 2)
					result += d.value;
					
			}
			return result;
			
		}
	},
	TREOR{
		String label() {
			return "Treor";
		}
		int index() {
			return 3;
		}
		int calculateScore(Die[] dice, Column column) {
			int result = 0;
			for(Die d : dice) {
				if(d.value == 3)
					result += d.value;
					
			}
			return result;
			
		}
	},
	FYROR{
		String label() {
			return "Fyror";
		}
		int index() {
			return 4;
		}
		int calculateScore(Die[] dice, Column column) {
			int result = 0;
			for(Die d : dice) {
				if(d.value == 4)
					result += d.value;
					
			}
			return result;
			
		}
	},
	FEMMOR{
		String label() {
			return "Femmor";
		}
		int index() {
			return 5;
		}
		int calculateScore(Die[] dice, Column column) {
			int result = 0;
			for(Die d : dice) {
				if(d.value == 5)
					result += d.value;
					
			}
			return result;
			
		}
	},
	SEXOR{
		String label() {
			return "Sexor";
		}	
		int index() {
			return 6;
		}
		int calculateScore(Die[] dice, Column column) {
			int result = 0;
			for(Die d : dice) {
				if(d.value == 6)
					result += d.value;
					
			}
			return result;
			
		}
	},
	BONUS{
		String label() {
			return "Bonus: ";
		}
		int index() {
			return 7;
		}
		int calculateScore(Die[] dice, Column column) {
			int result = 0;
			for(int i= 1; i < 7; i++) {
				result += column.cells[i].value;
			}
			if(result >= 63) {
				return 50;
			}
			return 0;
			
		}
	},
	PAR{
		String label() {
			return "Par";
		}
		int index() {
			return 8;
		}
		int calculateScore(Die[] dice, Column column) {
			int similarDices = 0;
			for(Die d1 : dice) {
				similarDices = 0;
				for(Die d2 : dice){
					if (d1.value == d2.value) {
						similarDices++;
					}
					if(similarDices == 2) {
						return 12;
					}	
				}
			}
			return 0;
				
			}
	},
	TVÅ_PAR{
		String label() {
			return "Två Par";
		}
		int index() {
			return 9;
		}
		int calculateScore(Die[] dice, Column column) {
			int similarDices = 0;
			int pairFound = 0;
			for(Die d1 : dice) {
				similarDices = 0;
				for(Die d2 : dice){
					if (d1.value == d2.value) {
						similarDices++;
					}
					if(similarDices == 2) {
						similarDices = 0;
						pairFound ++;
						if(pairFound == 4) {
							return 22;
						}
					}	
				}
			}
			return 0;
				
			}
		
	},
	TRISS{
		String label() {
			return "Triss";
		}
		int index() {
			return 10;
		}
		int calculateScore(Die[] dice, Column column) {
			int similarDices = 0;
			for(Die d1 : dice) {
				similarDices = 0;
				for(Die d2 : dice){
					if (d1.value == d2.value) {
						similarDices++;
					}
					if(similarDices == 3) {
						return 18;
					}	
				}
			}
			return 0;
				
			}
	},
	FYRTAL{
		String label() {
			return "Fyrtal";
		}
		int index() {
			return 11;
		}
			
		int calculateScore(Die[] dice, Column column) {
			int similarDices = 0;
			for(Die d1 : dice) {
				similarDices = 0;
				for(Die d2 : dice){
					if (d1.value == d2.value) {
						similarDices++;
					}
					if(similarDices == 4) {
						return 24;
					}	
				}
			}
			return 0;
				
			}
		
	},
	KÅK{
		String label() {
			return "Kåk";
		}
		int index() {
			return 12;
		}
		int calculateScore(Die[] dice, Column column) {
			int[] amount = { 0, 0, 0, 0, 0, 0 };
			for(int i=0; i< dice.length; i++) {
				amount[dice[i].value-1]++;
			}
			boolean pairFound = false, trissFound = false;
			for(int i = 0; i < amount.length && (!trissFound || !pairFound); i++) {
			       if(!trissFound && amount[i] == 3) {
			          trissFound = true; 
			       } else if(!pairFound && amount[i] == 2) {
			          pairFound = true;
			       }
			  }

			  if(trissFound && pairFound) {
			      return 28;
			  }
			
			return 0;
		}
	},
	LITEN_STEGE{
		String label() {
			return "Liten Stege";
		}
		int index() {
			return 13;
		}
		int calculateScore(Die[] dice, Column column) {
			Die[] dice2 = new Die[dice.length];
			for(int i=0; i<dice.length; i++) {
				Die d = new Die();
				d.value = dice[i].value;
				dice2[i] = d;
				
			}
			dice2 = sortDice(dice2);
			if(dice2[0].value != 1) {
				return 0;
			}
			for(int i=0; i< dice2.length - 1; i++) {
				if(dice2[i].value != (dice2[i+1].value -1)) {
					return 0;
				}
			}
			return 25;
		}
	},
	STOR_STEGE{
		String label() {
			return "Stor Stege";
		}
		int index() {
			return 14;
		}
		int calculateScore(Die[] dice, Column column) {
			Die[] dice2 = new Die[dice.length];
			for(int i=0; i<dice.length; i++) {
				Die d = new Die();
				d.value = dice[i].value;
				dice2[i] = d;
				
			}
			dice2 = sortDice(dice2);
			if(dice2[0].value != 2) {
				return 0;
			}
			for(int i=0; i< dice2.length - 1; i++) {
				if(dice2[i].value != (dice2[i+1].value -1)) {
					return 0;
				}
			}
			return 30;
		}
	},
	CHANS{
		String label() {
			return "Chans";
		}
		int index() {
			return 15;
		}
		int calculateScore(Die[] dice, Column column) {
			int result = 0;
			for(Die d : dice) {
				result += d.value;
			}
			return result;
		}
	},
	YATZY{
		String label() {
			return "Yatzy";
		}
		int index() {
			return 16;
		}
		int calculateScore(Die[] dice, Column column) {
			int v = dice[0].value;
			for(Die d : dice) {
				if(v != d.value)
					return 0;
			}
			return 50;
		}
		
		
		
	},
	SUMMA{
		String label() {
			return "Summa:";
		}
		int index() {
			return 17;
		}
		int calculateScore(Die[] dice, Column column) {
			int result = 0;
			for(int i=1; i<column.cells.length-1; i++) {
				if(column.cells[i].locked == true) {
				result += column.cells[i].value;
				}
			}
			return result;
		}
	};
	String text;
	private CellOption() {
		
	}
	String label() {
		return "Okänd";
	}
	int index() {
		// TODO Auto-generated method stub
		return 0;
	}
	int calculateScore(Die[] dice, Column column) {
		int result = 0;
		for(Die d : dice) {
			result += d.value;
		}
		return 0;
	}
	public Die[] sortDice(Die[] _dice) {	 //Den sorterar arrayen varje gång vilket gör att man spara fel tärning		
		ArrayList<Integer> diceValues = new ArrayList<Integer>();
		for(int i=0; i<_dice.length; i++) {
			diceValues.add(i, _dice[i].value);
		}
		Collections.sort(diceValues);
		for(int i=0; i<_dice.length; i++) {
			_dice[i].value = diceValues.get(i);
		}
		return _dice;
		
		
		
	}
}
