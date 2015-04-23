public class Pet{
	String name;
	String type;
	String breed;
	String color;
	int age;
	int size;
	Buyer adopter;
	
	public Pet(String setName,String setType,String setBreed,String setColor,int setAge,int setSize){
		name=setName.toLowerCase();
		type=setType.toLowerCase();
		breed=setBreed.toLowerCase();
		color=setColor.toLowerCase();
		age=setAge;
		size=setSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Buyer getAdopter() {
		return adopter;
	}

	public void setAdopter(Buyer adopter) {
		this.adopter = adopter;
	}
	
}
