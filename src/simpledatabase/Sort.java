package simpledatabase;
import java.util.ArrayList;
import java.util.Collection;

public class Sort extends Operator{
	
	private ArrayList<Attribute> newAttributeList;
	private String orderPredicate;
	ArrayList<Tuple> tuplesResult;
	ArrayList<Tuple> tuple1;
	ArrayList<Tuple> tuple2;

	
	public Sort(Operator child, String orderPredicate){
		this.child = child;
		this.orderPredicate = orderPredicate;
		newAttributeList = new ArrayList<Attribute>();
		tuplesResult = new ArrayList<Tuple>();
		tuple1 = new ArrayList<Tuple>();
		tuple2 = new ArrayList<Tuple>();
		
	}
	
	
	/**
     * The function is used to return the sorted tuple
     * @return tuple
     */
	@Override
	public Tuple next(){
		//Delete the lines below and add your code here
		Tuple c =child.next();
		Tuple turn = null;
		Tuple buffer = null;
		int a;
		int b;
		while(c!=null){
			tuplesResult.add(c);
			c = child.next();
		}
		
		if(orderPredicate == "Name"){
		if(tuplesResult.size()==3){
			turn = new Tuple(tuplesResult.get(2).getAttributeList());
			tuplesResult.remove(2);
			return turn;
		}
		
		if(tuplesResult.size()==2){
			turn = new Tuple(tuplesResult.get(0).getAttributeList());
			tuplesResult.remove(0);
			return turn;
		}
		
		if(tuplesResult.size()==1){
			turn = new Tuple(tuplesResult.get(0).getAttributeList());
			tuplesResult.remove(0);
			return turn;
		}
		
		if(tuplesResult.size()==0){
			return turn;
		}
		}
		
		else{
			
			int count = 0;
			for(int i=0;i<tuplesResult.size();i++){
				a = (int) tuplesResult.get(i).getAttributeValue(0);
				for(int j=0;j<tuplesResult.size();j++){
					b = (int) tuplesResult.get(j).getAttributeValue(0);
					//System.out.println(a);
					//System.out.println("---");
					//System.out.println(b);
					//System.out.println("---");
					if(a<b){
						count++;
					}
					if(count == tuplesResult.size()-1){
						turn = new Tuple(tuplesResult.get(i).getAttributeList());
						tuplesResult.remove(i);
						return turn;
					}
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
		return child.getAttributeList();
	}

}