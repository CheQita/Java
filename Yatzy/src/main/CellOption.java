package main;

public enum CellOption {
	
	NAMN{
		String label() {
			return "Spelare:";
		}
	},
	ETTOR{
		String label() {
			return "Ettor";
		}
		
	},
	TV�OR{
		String label() {
			return "Tv�or";
		}
	},
	TREOR{
		String label() {
			return "Treor";
		}
	},
	FYROR{
		String label() {
			return "Fyror";
		}	
	},
	FEMMOR{
		String label() {
			return "Femmor";
		}
	},
	SEXOR{
		String label() {
			return "Sexor";
		}	
	},
	BONUS{
		String label() {
			return "Bonus";
		}
	},
	PAR{
		String label() {
			return "Par";
		}	
	},
	TV�_PAR{
		String label() {
			return "Tv� Par";
		}
	},
	TRISS{
		String label() {
			return "Triss";
		}	
	},
	FYRTAL{
		String label() {
			return "Fyrtal";
		}
	},
	K�K{
		String label() {
			return "K�k";
		}	
	},
	LITEN_STEGE{
		String label() {
			return "Liten Stege";
		}
	},
	STOR_STEGE{
		String label() {
			return "Stor Stege";
		}
	},
	CHANS{
		String label() {
			return "Chans";
		}	
	},
	YATZY{
		String label() {
			return "Yatzy";
		}
	},
	SUMMA{
		String label() {
			return "Summa:";
		}
	};
	String text;
	private CellOption() {
		
	}
	String label() {
		return "Ok�nd";
	}
}
