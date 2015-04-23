import java.util.*;

public class Search
{
	public static ArrayList<Pet> search(ArrayList<Pet> list,String type,String breed,String color,int age,int size)//type, breed, color, age, size, price, availability (first 3 Strings, second 3 ints)
	{//"null" for empty strings, "-1" for empty ints
		ArrayList<Pet> matches=new ArrayList<Pet>();
		
		for(Pet i : list){
			matches.add(i);
		}
		
		
		
		if(type!=null)
			matches=searchType(matches,type.toLowerCase());
		if(breed!=null)
			matches=searchBreed(matches,breed.toLowerCase());
		if(color!=null)
			matches=searchColor(matches,color.toLowerCase());
		if(age!=-1)
			matches=searchAge(matches,age);
		if(size!=-1)
			matches=searchSize(matches,size);
		//matches=searchAvailability(matches);
		return matches;
	}
	private static ArrayList<Pet> searchType(ArrayList<Pet> list,String type)//takes pets as a 1D array of Pets
	{
		ArrayList<Pet> matches=new ArrayList<Pet>();
		
		for(int i=0;i<list.size();i++)
			if(list.get(i).getType().equals(type))
				matches.add(list.get(i));
		return matches;
	}	
	
	private static ArrayList<Pet> searchBreed(ArrayList<Pet> list,String breed)
	{
		ArrayList<Pet> matches=new ArrayList<Pet>();
		
		for(int i=0;i<list.size();i++)
			if(list.get(i).getBreed().equals(breed))
				matches.add(list.get(i));
		return matches;
	}
	
	private static ArrayList<Pet> searchColor(ArrayList<Pet> list,String color)
	{
		ArrayList<Pet> matches=new ArrayList<Pet>();
		
		for(int i=0;i<list.size();i++)
			if(list.get(i).getColor().equals(color))
				matches.add(list.get(i));
		return matches;
	}
	
	private static ArrayList<Pet> searchAge(ArrayList<Pet> list,int age)
	{
		ArrayList<Pet> matches=new ArrayList<Pet>();
		
		for(int i=0;i<list.size();i++)
			if(list.get(i).getAge()==age)
				matches.add(list.get(i));
		return matches;
	}
	
	private static ArrayList<Pet> searchSize(ArrayList<Pet> list,int size)
	{
		ArrayList<Pet> matches=new ArrayList<Pet>();
		
		for(int i=0;i<list.size();i++)
			if(list.get(i).getSize()==size)
				matches.add(list.get(i));
		return matches;
	}
}