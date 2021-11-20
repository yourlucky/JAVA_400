import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JunitTest {
	@Test
	public void checkRootcolor() {
		
		RedBlackTree A = new RedBlackTree();
		A.insert(7);
		A.insert(14);
		A.insert(1);
				
		assertEquals(true,A.root.isBlack);
	
	}
	
	@Test
	public void checkInserterror() {
		
		RedBlackTree A = new RedBlackTree();
		A.insert(1);
		A.insert(2);
		A.insert(3);
		A.insert(4);
		A.insert(5);
		A.insert(6);
		A.insert(7);
		A.insert(8);
		A.insert(9);
		
		A.insert(14);
		A.insert(15);
		A.insert(16);
		A.insert(17);
		A.insert(18);
		A.insert(19);
		
		String s ="[ 1, 2, 3, 4, 5, 6, 7, 8, 9, 14, 15, 16, 17, 18, 19 ]";

		assertEquals(s,A.toString());
	
	}
	
	
	@Test
	public void checkRed_Red() {
		
		RedBlackTree A = new RedBlackTree();
		A.insert(1);
		A.insert(2);
		A.insert(3);
		A.insert(4);
		A.insert(5);
		A.insert(6);
		A.insert(7);
		A.insert(8);
		A.insert(9);
		
		A.insert(14);
		A.insert(15);
		A.insert(16);
		A.insert(17);
		A.insert(18);
		A.insert(19);
		
		int a=1;
		
		if(A.root.leftChild.isBlack==false && A.root.leftChild.leftChild.isBlack==false)
			a++;
		if(A.root.leftChild.isBlack==false && A.root.leftChild.rightChild.isBlack==false)
			a++;
		
		assertEquals(a,1);
	
	}


}
