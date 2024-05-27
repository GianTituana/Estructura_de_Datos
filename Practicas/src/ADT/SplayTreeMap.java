package ADT;

import java.util.Comparator;

/*Animplementationofasortedmapusingasplaytree.*/
 public class SplayTreeMap<K,V> extends TreeMap<K,V>{
	 /*Constructsanemptymapusingthenaturalorderingofkeys.*/
	 public SplayTreeMap(){super();}
	 /*Constructsanemptymapusingthegivencomparatortoorderkeys.*/
	 public SplayTreeMap(Comparator<K>comp){super(comp);}
	 /*Utilityusedtorebalanceafteramapoperation.*/
	 private void splay(Position<Entry<K,V>>p){
		 while(!isRoot(p)){
			 Position<Entry<K,V>>parent=parent(p);
			 Position<Entry<K,V>>grand=parent(parent);
			 if(grand==null) //zigcase
				 rotate(p);
			 else if((parent==left(grand))==(p==left(parent))){ //zig-zigcase
				 rotate(parent); //movePARENTupward
				 rotate(p); //thenmovepupward
			 }else{ //zig-zagcase
				 rotate(p); //movepupward
				 rotate(p); //movepupwardagain
			 }
		 }
	 }
	 //overridethevariousTreeMaprebalancinghookstoperformtheappropriatesplay
	 protected void rebalanceAccess(Position<Entry<K,V>>p){
		 if(isExternal(p))p=parent(p);
		 if(p!=null)splay(p);
	 }
	 protected void rebalanceInsert(Position<Entry<K,V>>p){
		 splay(p);
	 }
	 protected void rebalanceDelete(Position<Entry<K,V>>p){
		 if(!isRoot(p))splay(parent(p));
	 }
 }