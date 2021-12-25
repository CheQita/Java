package main;

public class Die {
	
	int value;
	String[] face;
	public Die() {
		
	}
	
	public void roll() {
		value = (int) (Math.random() * 6) + 1;
		setFace();
	}
	public void setFace() {
		switch(value){
			case 1:
				face = new String[]{"-----",
									"|   |",
									"| o |",
									"|   |",
									"-----"};
				break;
			case 2:
				face = new String[]{"-----",
									"|o  |",
									"|   |",
									"|  o|",
									"-----"};
				break;
			case 3:
				face = new String[]{"-----",
									"|o  |",
									"| o |",
									"|  o|",
									"-----"};
				break;
			case 4:
				face = new String[]{"-----",
									"|o o|",
									"|   |",
									"|o o|",
									"-----"};
				break;
			case 5:
				face = new String[]{"-----",
									"|o o|",
									"| o |",
									"|o o|",
									"-----"};
				break;
			case 6:
				face = new String[]{"-----",
									"|o o|",
									"|o o|",
									"|o o|",
									"-----"};
				break;
			
		}
	}
}
