// --== CS400 File Header Information ==--
// Name: YoonChae Na
// Email: yna23@wisc.edu
// Team: DE
// TA: Daniel
// Lecturer: Florian
// Notes to Grader: N/A


import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Stack;

public class TestRedBlackTree {
	
	
	
	/**
	 * Check Root Color(isBlack)
	 * If it is black, isBlack value is true
	 * Pass the test
	 */
	@Test
	public void One_Root_Color() {
		
		RedBlackTree A = new RedBlackTree();
		A.insert(7);
		A.insert(14);
		A.insert(1);
				
		assertEquals(true,A.root.isBlack);
	
	}
	
	
	/**
	 * Check Insert Error
	 * Put a number of positive numbers, 
	 * and check it did or not without missing or error
	 * comparing toSting return value( which is return  every elements)
	 */
	
	@Test
	public void Two_Insert_Error() {
		
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
		
		
		A.insert(21);
		A.insert(22);
		A.insert(23);
		A.insert(24);
		A.insert(25);
		A.insert(26);
		
		String s ="[ 1, 2, 3, 4, 5, 6, 7, 8, 9, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26 ]";
		//System.out.println(A.toString());

		assertEquals(s,A.toString());
	
	}
	
	/**
	 * Check Random Insert Error
	 * Put a random number(without any sequence)-positive and negative
	 * check it did or not without missing or error
	 * comparing toSting return value( which is return  every elements)
	 */
	
	@Test
	public void Three_Random_Insert_Error() {
		
		RedBlackTree A = new RedBlackTree();
		A.insert(1);
		A.insert(2);
		A.insert(-3);
		A.insert(14);
		A.insert(25);
		A.insert(36);
		A.insert(47);
		A.insert(58);
		A.insert(69);
		
		A.insert(-14);
		A.insert(-15);
		A.insert(-16);
		A.insert(-17);
		A.insert(-18);
		A.insert(-19);
		
		
		A.insert(201);
		A.insert(32);
		A.insert(63);
		A.insert(94);
		A.insert(-25);
		A.insert(0);
		
		String s ="[ -25, -19, -18, -17, -16, -15, -14, -3, 0, 1, 2, 14, 25, 32, 36, 47, 58, 63, 69, 94, 201 ]";
	
		assertEquals(s,A.toString());
	
	}
	
	
	/**
	 * Check root color is always black
	 * Right after inserting the value, check root color
	 * when it is not red, increased the number
	 * If number is not zero, root color is not always black
	 * If number is zero, test passed
	 */
	
	
	@Test
	public void checkRed_Red() {
		
		int number=0;
		
		RedBlackTree A = new RedBlackTree();
		A.insert(1);
		if (!A.root.isBlack)
			number++;

		A.insert(2);
		if (!A.root.isBlack)
			number++;
		
		A.insert(-3);
		if (!A.root.isBlack)
			number++;
		
		A.insert(14);
		if (!A.root.isBlack)
			number++;
		
		A.insert(25);
		if (!A.root.isBlack)
			number++;
		
		A.insert(-36);
		if (!A.root.isBlack)
			number++;
		
		A.insert(0);
		if (!A.root.isBlack)
			number++;
		
		A.insert(158);
		if (!A.root.isBlack)
			number++;
		
		assertEquals(number,0);
	
	}

}

	
