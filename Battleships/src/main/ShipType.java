package main;

public enum ShipType {
	CARRIER{
		int length() {
			return 5;
		}
		
	},
	BATTLESHIP{
		
	},
	CRUISER{
		
	},
	SUBMARINE{
		
	},
	DESTROYER{
		
	};

	int length() {
		// TODO Auto-generated method stub
		return 3;
	}

	
}
