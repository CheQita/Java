package main;

public enum ShipType {
	CARRIER{
		int length() {
			return 5;
		}
		
	},
	BATTLESHIP{
		int length() {
			return 4;
		}
	},
	CRUISER{
		int length() {
			return 3;
		}
	},
	SUBMARINE{
		int length() {
			return 3;
		}
	},
	DESTROYER{
		int length() {
			return 2;
		}
	};
	int length() {
		// TODO Auto-generated method stub
		return 3;
	}

	
}
