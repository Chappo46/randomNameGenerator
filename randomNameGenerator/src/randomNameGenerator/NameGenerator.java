package randomNameGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Generates random names.
 * @author Patrick Murphy
 *
 */
public class NameGenerator {

	private Random rand = new Random();
	private List<Character> allVowels = new ArrayList<Character>();

	private char[] lowerVowels = {'a','e','i','o'};
	private char[] upperVowels = {'A','E','I','O'};
	private char[] lowerNV1 = {'n','r','s','t'};
	private char[] upperNV1 = {'N','R','S','T'};
	private char[] lowerNV2 = {'c','d','f','g','h','l','m','p'};
	private char[] upperNV2 = {'C','D','F','G','H','L','M','P'};
	private char[] lowerNV3 = {'b','j','k','q','w','x','z','y'};
	private char[] upperNV3 = {'B','J','K','Q','W','X','Z','Y'};
	private char[] vowelFirst = {'x','X'};
	private char[] trailingSpec = {'l','r'};

	
	public NameGenerator()
	{
		Collections.addAll(allVowels,'a','A','e','E','i','I','o','O','u','U','y','Y');
	}
	
	/**
	 * Generates a random name and returns it.
	 * Could be as short as 3 letter, and as long as maxLength.
	 * @param maxLength
	 * @return random name 
	 */
	public String generate(int maxLength)
	{
		StringBuilder name = new StringBuilder(1);
		int nameLength = rand.nextInt(maxLength-3)+3;
		boolean firstVowel = rand.nextBoolean();
		if(firstVowel)
		{
			name.append(randomVowel(true));
		}
		else
		{
			name.append(randomNonVowel(true));
		}
		for(int i = 1;i<nameLength;i++)
		{
			name.append(nextLetter(name.toString()));
		}
		
		return name.toString();
		
	}
	
	/*
	 * Returns an appropriate next letter based on the previous two letter.
	 */
	private char nextLetter(String name)
	{
			if(name.length()>2)
			{
				boolean oneAwayVowel = isVowel(name.charAt(name.length()-1));
				boolean twoAwayVowel = isVowel(name.charAt(name.length()-2));
				if(oneAwayVowel && twoAwayVowel)
				{
					return randomNonVowel(boolChance(1,1000));
				}
				else if(!oneAwayVowel)
				{
					return randomVowel(boolChance(1,1000));
				}
				else
				{
					boolean vowel = boolChance(1,2);
					if(vowel) 
					{
						return randomVowel(boolChance(1,1000));
					}
					else
					{
						return randomNonVowel(boolChance(1,1000));
					}
				}
			}
			else
			{
				return randomLetter();
			}
	}
	
	/*
	 * Returns a random vowel character.
	 * Requires a boolean, to tell if it is upper or lower case.
	 */
	private char randomVowel(boolean isUpper)
	{
		
		char[] vowels;
		if(isUpper)
		{
			vowels = upperVowels;
		}
		else
		{
			vowels = lowerVowels;
		}
		
		int i = rand.nextInt(10);
		
		if(i<7)
		{
			int j = rand.nextInt(vowels.length);
			return vowels[j];
		}
		
		else if(i<9)
		{
			if(isUpper)
			{
				return 'U';
			}
			else
			{
				return 'u';
			}
		}
		if(isUpper)
		{
			return 'Y';
		}
		else
		{
			return 'y';
		}
	}
	
	/*
	 * Returns a random non vowel character.
	 * Requires a boolean, to tell if it is upper or lower case.
	 * It is most likely to return characters in the top which are the most common non vowels in the English language.
	 * It is less likely to return characters in the mid, and it is least likely in bot.
	 */
	private char randomNonVowel(boolean isUpper)
	{
		char[] top;
		char[] mid;
		char[] bot;
		if(isUpper)
		{
			top = upperNV1;
			mid = upperNV2;
			bot = upperNV3;
		}
		else
		{
			top = lowerNV1;
			mid = lowerNV2;
			bot = lowerNV3;
		}
		int i = rand.nextInt(10);
		if(i<7)
		{
			int j = rand.nextInt(top.length);
			return top[j];
		}
		
		else if(i<9)
		{
			int j = rand.nextInt(mid.length);
			return mid[j];
		}
		else;
		{
			int j = rand.nextInt(bot.length);
			return bot[j];
		}
	}
	
	/*
	 * Returns a random letter.
	 * Higher chance of returning a lower case letter.
	 */
	private char randomLetter()
	{
		int capitalChance = rand.nextInt(10);
		boolean capital;
		boolean vowel = rand.nextBoolean();
		if(capitalChance<8)
		{
			capital = false;
		}
		else
		{
			capital = true;
		}
		
		if(vowel)
		{
			return randomVowel(capital);
		}
		else
		{
			return randomNonVowel(capital);
		}
	
			
	}
	/*
	 * returns a boolean based on chance defined by the parameters.
	 * chance is the likelihood of rolling true out of outOf.
	 */
	private boolean boolChance(int chance, int outOf)
	{
		int roll = rand.nextInt(outOf);
		boolean result;
		if(roll<chance)
		{
			result = true;
		}
		else
		{
			result = false;
		}
		return result;
	}
	
	/*
	 * Returns true if c is a vowel.
	 * Otherwise it returns false.
	 */
	private boolean isVowel(char c)
	{
		if(allVowels.contains(c))
		{
			return true;
		}
		else return true;
	}
}


