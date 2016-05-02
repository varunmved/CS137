package com.mycompany.a2;

import java.util.ArrayList;
import java.util.Random;

public class GameObjectCollection implements ICollection {

//***********************************************Attributes
	private ArrayList<GameObject> gameObjects;
	private Random random;
//***********************************************Constructors
	public GameObjectCollection(){
		gameObjects = new ArrayList<GameObject>();
	}
//***********************************************Methods
	public void add(GameObject n){//ICollection
		gameObjects.add(n);
	}

	public void remove(int i){
		gameObjects.remove(i);
	}
	public void remove(GameObject x) {//ICollection
		if(gameObjects.contains(x)){//do we have it?
			gameObjects.remove(x);
		}
		else{System.out.println("removeFromCollection() doesn't have that object");}
	}
	public GameObject getRandomGameObject(String key){
		
		if(key.equals("CAT")){
			return gameObjects.get(getRandomCatIndex());
		}
		else if(key.equals("DOG")){
			return gameObjects.get(getRandomDogIndex());
		}
		else{
			return null;
			//return gameObjects.get(getRandomCatIndex());
		}
	}
	
	private int getRandomCatIndex(){
        int z,r=-1; int arraySize = gameObjects.size();
        random = new Random();    
        z = random.nextInt(100) % arraySize;
       while(!(gameObjects.get(z) instanceof Cat)){
          z = random.nextInt(100) % arraySize;
        }
        r = z ;
        return r;
    }
	private int getRandomDogIndex(){
        int z,r=-1; int arraySize = gameObjects.size();
        random = new Random();    
        z = random.nextInt(100) % arraySize;
       while(!(gameObjects.get(z) instanceof Dog)){
          z = random.nextInt(100) % arraySize;
        }
        r = z ;
        return r;
    }
	
	public IIterator getIterator() {
		return new MyIterator();
	}
	
//***CLASS **** MyIterator *********************************
	private class MyIterator implements IIterator { 
		private int currIndex;
		public MyIterator(){
			currIndex=-1;
		}
		public boolean hasNext() { //IIterator
			boolean temp = false;
			if(currIndex<gameObjects.size()-1){
				temp = true;
			}
			else if(gameObjects.size()<=0){
				temp = false;
			}
			else{temp = false;}
			
			
			//boolean temp = true;
			//if(gameObjects.size() < 1){temp=false;}
			//if(currIndex == gameObjects.size()-1){temp=false;}
			return temp;
		}

		public GameObject getNext() {//IIterator
			if(hasNext()){
				return gameObjects.get(++currIndex);
			}
			else{
				System.out.println("getNext() has none to Get");
				return null;
			}
		}//getNext()
		public void iRemoveLast() {//IIterator
			gameObjects.remove(currIndex);
		}
	}//myIterator class*************************************

	public int size(){
		return gameObjects.size();
	}
	
}//end GameObjectCollection
