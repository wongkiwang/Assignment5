package simpledatabase;
import java.util.ArrayList;

public class Projection extends Operator{
	
	ArrayList<Attribute> newAttributeList;
	private String attributePredicate;


	public Projection(Operator child, String attributePredicate){ 
		this.attributePredicate = attributePredicate;
		this.child = child;
		newAttributeList = new ArrayList<Attribute>();
		
	}
	
	
	/**
     * Return the data of the selected attribute as tuple format
     * @return tuple
     */
	@Override
	public Tuple next(){
		Tuple t = child.next();
		Tuple a = null;
		if (t!=null){
			for(int i=0;i<t.getAttributeList().size();i++){
				if(t.getAttributeName(i).equals(attributePredicate)){
					newAttributeList.clear();
					newAttributeList.add(t.getAttributeList().get(i));
					a = new Tuple(newAttributeList);
			//		System.out.println(newAttributeList.size());
				}
			}
			return a;
		}
		return null;
		//Delete the lines below and add your code here
		
	}
		

	
	/**
     * The function is used to get the attribute list of the tuple
     * @return attribute list
     */
	public ArrayList<Attribute> getAttributeList(){
		return child.getAttributeList();
	}
	

}

