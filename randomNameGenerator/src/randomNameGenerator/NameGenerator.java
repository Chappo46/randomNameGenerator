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
	private int maxLength;
	private List<Character> allVowels = new ArrayList<Character>();
	private List<Character> vowelsNoY = new ArrayList<Character>();
	private List<Character> noRepeats = new ArrayList<Character>();
	private List<Character> noRepeatsUnlessVowelFirst = new ArrayList<Character>();
	private List<Character> mustFollowVowel = new ArrayList<Character>();

	
	private char[] lowerVowels = {'a','e','i','o'};
	private char[] upperVowels = {'A','E','I','O'};
	private char[] lowerNV1 = {'n','r','s','t'};
	private char[] upperNV1 = {'N','R','S','T'};
	private char[] lowerNV2 = {'c','d','f','g','h','l','m','p'};
	private char[] upperNV2 = {'C','D','F','G','H','L','M','P'};
	private char[] lowerNV3 = {'b','j','k','q','w','x','z','y'};
	private char[] upperNV3 = {'B','J','K','Q','W','X','Z','Y'};
	private char[] trailingSpec1 = {'l','r'};
	private char[] trailingSpec2 = {'b','d','k','l','m','n','t','v'};
	

	
	public NameGenerator()
	{
		Collections.addAll(allVowels,'a','A','e','E','i','I','o','O','u','U','y','Y');
		Collections.addAll(vowelsNoY,'a','A','e','E','i','I','o','O','u','U');
		Collections.addAll(noRepeats, 'x','X','u','U','b','B','i','I','y','Y');
		Collections.addAll(noRepeatsUnlessVowelFirst, 's','S','f','F','t','T','r','R');
	}
	
	/**
	 * Generates a random name and returns it.
	 * Could be as short as 3 letter, and as long as maxLength.
	 * @param maxLength
	 * @return random name 
	 */
	public String generate(int maxLength)
	{
		this.maxLength = maxLength;
		if(maxLength<3)
		{
			maxLength=0;
		}
		StringBuilder name = new StringBuilder(1);
		int nameLength = rand.nextInt(maxLength-3)+3;
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
	
						if(name.length()==maxLength-1)
						{
							if(allVowels.contains(name.charAt(0)))
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
							else
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
						}
						//if last 2 are vowels 999 out of 1000 chance of non vowel
						else if(oneAwayVowel && twoAwayVowel)
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
						if(name.charAt(0) == 'Y')
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
						
						if(vowelsNoY.contains(name.charAt(0)))
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
						else
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
						validChar = validateChar(nextChar,name);	
					}

					
				}while(!validChar);
				return nextChar;

	}
	
	/*
	 * checks the random letter and validates it based on a set of criteria
	 */
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
		
		validChar = appropriateNext(c);
		
		if(c=='y')
		{
			validChar = boolChance(4,10);
		}

		return validChar;
	}
	
	private boolean appropriateNext(char c)
	{
		boolean valid = false;
		switch(c)
		{
		case 'b':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,100,trailingSpec1);
			if(valid == false) valid = letterPercent(c,15,'h');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'B':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,100,trailingSpec1);
			if(valid == false) valid = letterPercent(c,15,'h');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'c':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,100,'r');
			if(valid == false) valid = letterPercent(c,100,'h');
			if(valid == false) valid = letterPercent(c,100,'k');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'C':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,100,'r');
			if(valid == false) valid = letterPercent(c,100,'h');
			if(valid == false) valid = letterPercent(c,100,'k');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'd':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,100,'r');
			if(valid == false) valid = letterPercent(c,15,'h');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'D':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,100,'r');
			if(valid == false) valid = letterPercent(c,15,'h');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'f':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,100,trailingSpec1);
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'F':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,100,trailingSpec1);
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'g':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,100,trailingSpec1);
			if(valid == false) valid = letterPercent(c,15,'h');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'G':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,100,trailingSpec1);
			if(valid == false) valid = letterPercent(c,15,'h');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'h':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,40,trailingSpec2);
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'H':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,40,trailingSpec2);
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'j':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,20,'h');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'J':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,20,'h');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'k':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,100,trailingSpec1);
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'K':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,100,trailingSpec1);
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'l':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,50,'l');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'L':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'm':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,30,'b');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'M':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,30,'b');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'n':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,30,'p');
			if(valid == false) valid = boolChance(5,100);
			return valid;
		case 'N':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,30,'p');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'p':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,40,'h');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'P':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,40,'h');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'q':
			valid = letterPercent(c,50,lowerVowels);
			if(valid == false) valid = letterPercent(c,50,upperVowels);
			if(valid == false) valid = letterPercent(c,100,'u');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'Q':
			valid = letterPercent(c,50,lowerVowels);
			if(valid == false) valid = letterPercent(c,50,upperVowels);
			if(valid == false) valid = letterPercent(c,100,'u');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'r':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,100,trailingSpec2);
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'R':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,100,trailingSpec2);
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 's':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,70,'t');
			if(valid == false) valid = letterPercent(c,100,'h');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'S':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,70,'t');
			if(valid == false) valid = letterPercent(c,100,'h');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 't':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,70,'t');
			if(valid == false) valid = letterPercent(c,100,'h');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'T':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,70,'t');
			if(valid == false) valid = letterPercent(c,100,'h');
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'v':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,30,trailingSpec1);
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'V':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,30,trailingSpec1);
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'w':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,50,trailingSpec2);
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'W':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,50,trailingSpec2);
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'x':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'X':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'z':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,30,trailingSpec1);
			if(valid == false) valid = boolChance(3,100);
			return valid;
		case 'Z':
			valid = letterPercent(c,100,lowerVowels);
			if(valid == false) valid = letterPercent(c,100,upperVowels);
			if(valid == false) valid = letterPercent(c,30,trailingSpec1);
			if(valid == false) valid = boolChance(3,100);
			return valid;
			
		
		
		default:
				return true;
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
	 * Returns a boolean based on percent chance if the letter is specified in tests.
	 * Otherwise it returns true if the letter is not in tests.
	 */
	private boolean letterPercent(char c,int percent,char ... tests)
	{
		boolean testsContains = false;
		for(char el: tests)
		{
			if(el==c)
			{
				testsContains = true;
			}
		}
		
		if(testsContains)
		{
			if(boolChance(percent,100))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return true;
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


