import java.util.ArrayList;

class starter {
	
	public static void main(String[] args)
	{
		EasyReader infile = new EasyReader("mobydick.txt");
		//System.out.print("\nThere are "+countWhales(infile)+" whale occurances in Moby Dick.\n#Savethewhales\n");
		System.out.print("\nA random word from Moby Dick is "+getRandomWord(infile));
	}
	public static int countWhales(EasyReader file)
	{
		int numOfWhales = 0;
		while(!file.eof())
		{
			String currentWord = file.readWord();
			if(currentWord!=null && (currentWord.contains("whale") || currentWord.contains("Whale") || currentWord.contains("whaling") || currentWord.contains("Whaling")))
			   numOfWhales++;
		}
		return numOfWhales;
	}
	//good time for arraylists?
	public static String getRandomWord(EasyReader file)
	{
		ArrayList<String> words = new ArrayList<String>();
		while(!file.eof())
		{
			String currentWord = file.readWord();
			if(currentWord != null)
			   words.add(currentWord);
		}
		String randomWord = "";
		//while loop that checks condition at the end
		do
		{
			randomWord = words.get((int)(Math.random()*words.size()));
		}
		while(!checkPunctaution(randomWord));
		return randomWord;
	}
	//checks for excess punctuation and empty words
	public static boolean checkPunctaution(String word)
	{
		return !word.contains(",") && !word.contains(".") && 
		       !word.contains("!") && !word.contains("?") &&
			   !word.contains("--") && word.length() > 0;
	}
}