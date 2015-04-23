import java.util.ArrayList;

public class Buyer extends User{

	private ArrayList<Pet> pets = new ArrayList<Pet>(); //arrayList of THEIR pets 
	
	public Buyer(String u, String p, String e) {
		super(u, p, e);
	}

	public ArrayList<Pet> getPets() {
		return pets;
	}

	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}
	
	
}
