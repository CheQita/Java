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
			return "Bonus";
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
	},
	TVÅ_PAR{
		String label() {
			return "Två Par";
		}
		int index() {
			return 9;
		}
	},
	TRISS{
		String label() {
			return "Triss";
		}
		int index() {
			return 10;
		}
	},
	FYRTAL{
		String label() {
			return "Fyrtal";
		}
		int index() {
			return 11;
		}
	},
	KÅK{
		String label() {
			return "Kåk";
		}
		int index() {
			return 12;
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
	},
	SUMMA{
		String label() {
			return "Summa:";
		}
		int index() {
			return 17;
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
		return 5;
	}
}
