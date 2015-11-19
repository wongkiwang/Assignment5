package simpledatabase;
import java.util.ArrayList;

public class Join extends Operator{

	private ArrayList<Attribute> newAttributeList;
	private String joinPredicate;
	ArrayList<Tuple> tuples1;

	
	//Join Constructor, join fill
	public Join(Operator leftChild, Operator rightChild, String joinPredicate){
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.joinPredicate = joinPredicate;
		newAttributeList = new ArrayList<Attribute>();
		tuples1 = new ArrayList<Tuple>();
		
		
	}
	
	
	/**
     * It is used to return a new tuple which is already joined by the common attribute
     * @return the new joined tuple
     */
	//The record after join with two tables
	@Override

	public Tuple next(){
		Tuple c = leftChild.next();  //Student//
		Tuple b = rightChild.next(); //Enroll//
		Tuple turn = null;
		int c_location = 0;
		int b_location = 2;
		while(c!=null){
			tuples1.add(c);
			c = leftChild.next();
		}
		int count = tuples1.size();
		while(b!=null){
			for(int i=0;i<count;i++){
				if((tuples1.get(i).getAttributeValue(c_location)).equals(b.getAttributeValue(b_location))){
					turn = new Tuple(tuples1.get(i).getAttributeList());
					return turn;
				}
			}
		}
		return null;
		}
	
	
	
	/**
     * The function is used to get the attribute list of the tuple
     * @return attribute list
     */
	public ArrayList<Attribute> getAttributeList(){
		if(joinPredicate.isEmpty())
			return child.getAttributeList();
		else
			return(newAttributeList);
	}

}