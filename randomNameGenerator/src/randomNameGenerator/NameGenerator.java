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
	private List<Character> lead1 = new ArrayList<Character>();
	private List<Character> follow1 = new ArrayList<Character>();
	private List<Character> noRepeats = new ArrayList<Character>();
	private List<Character> noRepeatsUnlessVowelFirst = new ArrayList<Character>();
	private List<Character> mustFollowVowel = new ArrayList<Character>();
	private List<Character> higherH = new ArrayList<Character>();
	private List<Character> ANA = new ArrayList<Character>();
	private List<Character> ANB = new ArrayList<Character>();
	private List<Character> ANC = new ArrayList<Character>();
	private List<Character> AND = new ArrayList<Character>();
	private List<Character> ANE = new ArrayList<Character>();
	private List<Character> ANF = new ArrayList<Character>();
	private List<Character> ANG = new ArrayList<Character>();
	private List<Character> ANH = new ArrayList<Character>();
	private List<Character> ANI = new ArrayList<Character>();
	private List<Character> ANJ = new ArrayList<Character>();
	private List<Character> ANK = new ArrayList<Character>();
	private List<Character> ANL = new ArrayList<Character>();
	private List<Character> ANM = new ArrayList<Character>();
	private List<Character> ANN = new ArrayList<Character>();
	private List<Character> ANO = new ArrayList<Character>();
	private List<Character> ANP = new ArrayList<Character>();
	private List<Character> ANQ = new ArrayList<Character>();
	private List<Character> ANR = new ArrayList<Character>();
	private List<Character> ANS = new ArrayList<Character>();
	private List<Character> ANT = new ArrayList<Character>();
	private List<Character> ANU = new ArrayList<Character>();
	private List<Character> ANV = new ArrayList<Character>();
	private List<Character> ANW = new ArrayList<Character>();
	private List<Character> ANX = new ArrayList<Character>();
	private List<Character> ANY = new ArrayList<Character>();
	private List<Character> ANZ = new ArrayList<Character>();
	
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
		Collections.addAll(noRepeats, 'x','X','u','U','b','B','i','I','y','Y');
		Collections.addAll(noRepeatsUnlessVowelFirst, 's','S','f','F','t','T','r','R');
		Collections.addAll(mustFollowVowel, 'x','X','j','J');
		Collections.addAll(lead1, 's','S');
		Collections.addAll(follow1, 'm','M','n','N','p','P');
		Collections.addAll(higherH, 't','T','c','C','s','S');
		
		Collections.addAll(ANA, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANB, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANC, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(AND, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANE, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANF, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANG, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANH, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANI, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANJ, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANK, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANL, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANM, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANN, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANO, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANP, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANQ, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANR, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANS, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANT, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANU, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANV, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANW, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANX, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANY, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');
		
		Collections.addAll(ANZ, 'a','A','b','B','c','C','d','D','e','E','f','F','g','G',
				'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P',
				'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z');

	}
	
	/**
	 * Generates a random name and returns it.
	 * Could be as short as 3 letter, and as long as maxLength.
	 * @param maxLength
	 * @return random name 
	 */
	public String generate(int maxLength)
	{
		if(maxLength<3)
		{
			maxLength=0;
		}
		StringBuilder name = new StringBuilder(1);
		int nameLength = rand.nextInt(maxLength-3)+3;
//		boolean firstVowel = rand.nextBoolean();
//		if(firstVowel)
//		{
//			name.append(randomVowel(true));
//		}
//		else
//		{
//			name.append(randomNonVowel(true));
//		}
		name.append(randomLetter(true));
		
		
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


				char nextChar;
				boolean validChar;
				
				do 
				{
					if(name.length()>=2)
					{
						char oneAway = name.charAt(name.length()-1);
						char twoAway = name.charAt(name.length()-2);
						boolean oneAwayVowel = isVowel(name.charAt(name.length()-1));
						boolean twoAwayVowel = isVowel(name.charAt(name.length()-2));
						
						if(higherH.contains(oneAway));
						{
							if(boolChance(4,10)==true)
							{
								nextChar = 'h';
							}
							else
							{
	
							}
						}
						//if last 2 are vowels 999 out of 1000 chance of non vowel
						if(oneAwayVowel && twoAwayVowel)
						{
							boolean anotherVowel =boolChance(1,1000);
							if(anotherVowel)
							{
								nextChar = randomVowel(boolChance(1,700));
							}
							else
							{
								nextChar = randomNonVowel(boolChance(1,700));
							}
						}
						//if last 2 are non vowels 999 out of 1000 chance of vowel
						else if(!oneAwayVowel && !twoAwayVowel)
						{
							boolean anotherNonVowel = boolChance(1,1000);
							if(anotherNonVowel)
							{
								nextChar = randomNonVowel(boolChance(1,700));
							}
							else
							{
								nextChar = randomVowel(boolChance(1,700));
							}
						}
						else
						{
							nextChar = randomLetter(boolChance(1,1000));
						}

						validChar = validateChar(nextChar,name);
					}	
					else
					{
						nextChar = randomLetter(boolChance(1,1000));
						validChar = validateChar(nextChar,name);	
					}

					
				}while(!validChar);
				return nextChar;

	}
	
	
	private boolean validateChar(char c, String str)
	{
		boolean validChar = true;
		char oneAway = str.charAt(str.length()-1);
		
		if(str.length()>1)
		{
				char twoAway = str.charAt(str.length()-2);
				
				if(noRepeatsUnlessVowelFirst.contains(c) && oneAway == c && !isVowel(twoAway))
				{
					validChar = boolChance(5,100);
				}
				
				if(mustFollowVowel.contains(c) && c == oneAway)
				{
					validChar = boolChance(5,100);
				}
		}

		
		if(noRepeats.contains(c) && oneAway == c)
		{
			validChar = boolChance(5,100);
		}
		
		if(str.length()==1 && noRepeatsUnlessVowelFirst.contains(c) && oneAway == c)
		{
			validChar = boolChance(5,100);
		}
		
		if(mustFollowVowel.contains(c) && !isVowel(oneAway))
		{
			validChar = boolChance(5,100);
		}

		return validChar;
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
		else 
		{
			if(isUpper)
			{
				return 'Y';
			}
			else
			{
				return 'y';
			}
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
	private char randomLetter(boolean cap)
	{

		boolean capital = cap;
		boolean vowel = rand.nextBoolean();
		
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
		else return false;
	}
}


