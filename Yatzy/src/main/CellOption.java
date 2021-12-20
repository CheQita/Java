package main;

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
		
	},
	TVÅOR{
		String label() {
			return "Tvåor";
		}
		int index() {
			return 2;
		}
	},
	TREOR{
		String label() {
			return "Treor";
		}
		int index() {
			return 3;
		}
	},
	FYROR{
		String label() {
			return "Fyror";
		}
		int index() {
			return 4;
		}
	},
	FEMMOR{
		String label() {
			return "Femmor";
		}
		int index() {
			return 5;
		}
	},
	SEXOR{
		String label() {
			return "Sexor";
		}	
		int index() {
			return 6;
		}
	},
	BONUS{
		String label() {
			return "Bonus: ";
		}
		int index() {
			return 7;
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
			for(Die d1 : dice) {
				for(Die d2 : dice){
					if (d1.value == d2.value) {
						similarDices++;
					}
					if(similarDices == 4) {
						return 22;
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
			int similarDices = 0;
			for(Die d1 : dice) {
				for(Die d2 : dice){
					if (d1.value == d2.value) {
						similarDices++;
					}
					if(similarDices == 5) {
						return 28;
					}	
				}
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
	},
	STOR_STEGE{
		String label() {
			return "Stor Stege";
		}
		int index() {
			return 14;
		}
	},
	CHANS{
		String label() {
			return "Chans";
		}
		int index() {
			return 15;
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
				result += column.cells[i].value;
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
}
