package com.crm.sharphawk.genericutility;

import java.util.Random;

public class JavaUtility
{
/**
 *@author iamsachin
 * it is used to generate random numbers
 */
		public int getRandomNUm()
		{
			Random r=new Random();
			int random=r.nextInt(30000);
			return random;
		}
	}


