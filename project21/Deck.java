import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class Deck extends Exception implements Serializable
{

	private int nextCardIndex;
	

	Cards[] deck = new Cards[52];

	public Deck()
    {

		int count = 0;
		try
        {
		for (int i = 1; i <= 13; i++) 
		{
			deck[count++] = new Card('H', i);
		}
		for (int i = 1; i <= 13; i++) 
		{
			deck[count++] = new Card('S', i);
		}
		for (int i = 1; i <= 13; i++) 
		{
			deck[count++] = new Card('C', i);
		}
		for (int i = 1; i <= 13; i++) 
		{
			deck[count++] = new Card('D', i);
		}
		}
        nextCardIndex = 0;
		
    }
}