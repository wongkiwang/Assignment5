package simpledatabase;
import java.util.ArrayList;

public class Selection extends Operator{
	
	ArrayList<Attribute> attributeList;
	String whereTablePredicate;
	String whereAttributePredicate;
	String whereValuePredicate;

	
	public Selection(Operator child, String whereTablePredicate, String whereAttributePredicate, String whereValuePredicate) {
		this.child = child;
		this.whereTablePredicate = whereTablePredicate;
		this.whereAttributePredicate = whereAttributePredicate;
		this.whereValuePredicate = whereValuePredicate;
		attributeList = new ArrayList<Attribute>();

	}
	
	
	/**
     * Get the tuple which match to the where condition
     * @return the tuple
     */
	@Override
	public Tuple next(){
		Tuple t = child.next();
		int count = 0 ;
		if(child.from.equals(whereTablePredicate)){
		while (t!=null){
			for(int i=0;i<t.getAttributeList().size();i++){
				if(t.getAttributeName(i).equals(whereAttributePredicate)){
					if(t.getAttributeValue(i).equals(whereValuePredicate)&&count==0){
					return t;
					}
					}
				}
			t = child.next();
		}
		}
		else{
			return t;
		}
		return null;	
	}
	
	/**
     * The function is used to get the attribute list of the tuple
     * @return the attribute list
     */
	public ArrayList<Attribute> getAttributeList(){
		
		return(child.getAttributeList());
	}

	
}

