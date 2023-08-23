/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Avarna Swaika
*/
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
public class Card
{
String suit;//variable to store the suit of the card (spades,clubs,hearts,diamonds)
String rank;//variable to store the rank of the card (2,3,4,5,6,7,8,9,10,Jack,Queen,King,Ace)

	// Default constructor with no argument
	// NOTE: You can overload the constructor but you must
	// have this default constructor and it must generate a valid card
    public Card()
    {
      suit="spades";
      rank="2";
    }
    //Parameterised constructor where s stores the suit of the card and r stores the rank of the card
    public Card(String s,String r)
    {
      suit=s;
      rank=r;
    }

  // Override the method equals which is inherited from class Object
	// (similar to what we did in class Employee), and make it return true if the
	// two cards have the same suit and rank
	// Important: Use the @Override annotation
  @Override
  public boolean equals (Object ob)
  {
    if(!(ob instanceof Card))
    return false;
    Card c = (Card) ob;
    if (this.suit.equals(c.suit) && this.rank.equals(c.rank))
    return true;
    else
    return false;
  }

	// Public static method that takes in an empty deck and constructs a
	// randomly shuffled standard 52-card deck. A standard 52-card deck
	// is comprised of 13 ranks in each of the four French suits:
	// clubs, diamonds, hearts, and spades. Each suit includes an Ace, a King,
	// a Queen, and a Jack with the numeric cards from two to ten.
	// Important: Two calls to the build deck should likely return 2 different shuffles.
    public static void buildDeck(ArrayList<Card> deck)
    {
      //adds all the spade cards to the deck
      deck.add(new Card("spades","2"));
      deck.add(new Card("spades","3"));
      deck.add(new Card("spades","4"));
      deck.add(new Card("spades","5"));
      deck.add(new Card("spades","6"));
      deck.add(new Card("spades","7"));
      deck.add(new Card("spades","8"));
      deck.add(new Card("spades","9"));
      deck.add(new Card("spades","10"));
      deck.add(new Card("spades","Jack"));
      deck.add(new Card("spades","Queen"));
      deck.add(new Card("spades","King"));
      deck.add(new Card("spades","Ace"));

      //adds all the club cards to the deck
      deck.add(new Card("clubs","2"));
      deck.add(new Card("clubs","3"));
      deck.add(new Card("clubs","4"));
      deck.add(new Card("clubs","5"));
      deck.add(new Card("clubs","6"));
      deck.add(new Card("clubs","7"));
      deck.add(new Card("clubs","8"));
      deck.add(new Card("clubs","9"));
      deck.add(new Card("clubs","10"));
      deck.add(new Card("clubs","Jack"));
      deck.add(new Card("clubs","Queen"));
      deck.add(new Card("clubs","King"));
      deck.add(new Card("clubs","Ace"));

      //adds all the heart cards to the deck
      deck.add(new Card("hearts","2"));
      deck.add(new Card("hearts","3"));
      deck.add(new Card("hearts","4"));
      deck.add(new Card("hearts","5"));
      deck.add(new Card("hearts","6"));
      deck.add(new Card("hearts","7"));
      deck.add(new Card("hearts","8"));
      deck.add(new Card("hearts","9"));
      deck.add(new Card("hearts","10"));
      deck.add(new Card("hearts","Jack"));
      deck.add(new Card("hearts","Queen"));
      deck.add(new Card("hearts","King"));
      deck.add(new Card("hearts","Ace"));

      //adds all the diamond cards to the deck
      deck.add(new Card("diamonds","2"));
      deck.add(new Card("diamonds","3"));
      deck.add(new Card("diamonds","4"));
      deck.add(new Card("diamonds","5"));
      deck.add(new Card("diamonds","6"));
      deck.add(new Card("diamonds","7"));
      deck.add(new Card("diamonds","8"));
      deck.add(new Card("diamonds","9"));
      deck.add(new Card("diamonds","10"));
      deck.add(new Card("diamonds","Jack"));
      deck.add(new Card("diamonds","Queen"));
      deck.add(new Card("diamonds","King"));
      deck.add(new Card("diamonds","Ace"));
      //shuffle the deck randomly
      for(int i=0;i<52;i++)
      {
        //swapping two random index in the array list to generate a randonly shuffled deck of 52 cards
        Random r1 = new Random();
        int result1 = r1.nextInt(52);
        Random r2 = new Random();
        int result2 = r2.nextInt(52);
        Card temp1 = deck.get(result1);
        Card temp2 = deck.get(result2);
        deck.set(result2,temp1);
        deck.set(result1,temp2);
      }
    }

	// Method that takes a non-empty deck and deals 2 cards to the player's hand
	// and deals 2 cards to the dealer's hand. The deck at the end of
	// this method should have 4 less cards than when it started.
    public static void initialDeal(ArrayList<Card> deck, ArrayList<Card> playerHand, ArrayList<Card> dealerHand)
    {
        for(int i=1;i<=4;i++)//to deal 4 cards
        {
          if(i%2==0)
          dealerHand.add(deck.get(0));//deals card to player first
          else
          playerHand.add(deck.get(0));//deals card to dealer second
          deck.remove(0);//removes the delt card from the deck
        }
    }

	// Method that takes a non-empty deck and deals 1 card to the hand.
	// The deck at the end of this method should have
	// 1 less card than when it started.
    public static void dealOne(ArrayList<Card> deck, ArrayList<Card> hand)
    {
        hand.add(deck.get(0));//deals the top most card
        deck.remove(0);//removes delt card from the deck
    }

  // Method that gets the total value of the hand. The Jack, Queen, and
  // King cards take on the value 10, while an Ace can be 1 or 11.
	// Thus, if the hand contains a 10 of Spades and a Jack of Hearts
	// it will return a 20. If the hand contains a 5 of Clubs and a
	// Queen of Spades, this method should return a 15.
    public static int getHandValue(ArrayList<Card> hand)
    {
      int sum=0;//to store the sum of the hand
      int cnt=0;//to store the count of the aces
      for(int i=0;i<hand.size();i++)//removing each card from the hand
      {
        String st= hand.get(i).rank;
        if(st=="Jack"|| st=="Queen"||st=="King"||st=="10")
        sum+=10;
        else if (st=="9")
        sum+=9;
        else if (st=="8")
        sum+=8;
        else if (st=="7")
        sum+=7;
        else if (st=="6")
        sum+=6;
        else if (st=="5")
        sum+=5;
        else if (st=="4")
        sum+=4;
        else if (st=="3")
        sum+=3;
        else if (st=="2")
        sum+=2;
        else if (st=="Ace")
        cnt++;
      }
      //there can never be two aces or more with value 11 cause there will be a bust 
        if(cnt==1)//if there is one ace in the hand
        {
          if(sum<=10)//if the sum is less than equal to ten then the ace value will be 11
          sum+=11;
          else
          sum+=1;//otherwise ace value will be 1 to prevent a bust
        }
        else if(cnt==2)//if there are two aces in the hand
        {
          if(sum<=9)//if the sum is less than equal to nine then the ace value will be 11 for one and 1 for one
          sum+=12;
          else
          sum+=2;//otherwise ace value will be 1 for both to prevent a bust
        }
        else if(cnt==3)//if there are three aces in the hand
        {
          if(sum<=8)//if the sum is less than equal to eight then the ace value will be 11 for one and 1 for the other two
          sum+=13;
          else
          sum+=3;//otherwise ace value will be 1 for all three to prevent a bust
        }
        else if(cnt==4)//if there are four aces in the hand
        {
          if(sum<=7)//if the sum is less than equal to seven then the ace value will be 11 for one and 1 for the other three
          sum+=14;
          else//otherwise ace value will be 1 for all four to prevent a bust
          sum+=4;
        }
        //a deck can have a maximum of 4 aces only
      return sum;//returns sum of the total value of the hand
    }

	// Method that checks whether the given hand's value exceeds 21.
    public static boolean checkBust(ArrayList<Card> hand)
    {
       int value= getHandValue(hand);//stores the value of the hand
       if(value>21)//if value is more than 21
       return true;//return true as the hand will be busted
       else
    	 return false;
    }

    // Method that conduct the dealer's turn. The return value should be
    // true if the dealer busts and false otherwise. For the dealer's turn,
    // your code should continue to hit (or get a card) if the hand is less than 17
    // otherwise stand if the hand is greater than or equal to 17.
    public static boolean dealerTurn(ArrayList<Card> deck, ArrayList<Card> hand)
    {
      int sumvalue = getHandValue(hand);//stores the value of the hand
      if(sumvalue>=17 && sumvalue<22)//if the value is more than 17 and less than 22 then the dealer stands and his hand is not busted
    	return false;
      else
      {
        while(sumvalue<17)//till the value of the hand is less than 17
        {
          dealOne(deck,hand);//deals one more card to the dealer
          sumvalue=getHandValue(hand);//updates the value of the hand
        }
        if(sumvalue>21)//if if the value is less than or equal to 21 then the hand is not busted
        return true;
        else
        return false;
      }
    }

    //The return value should be
    // 1 if the player wins and 2 if the dealer wins. Winning is determined by who has
    // the closer value to 21 without busting (going over 21).
    public static int whoWins(ArrayList<Card> playerHand, ArrayList<Card> dealerHand)
    {
      int player=getHandValue(playerHand);//store the hand value of the player
      int dealer=getHandValue(dealerHand);//store the hand value of the dealer
      if(player>dealer && checkBust(playerHand)==false)//if players hand value is more than the dealers and player has not busted then the player wins
    	return 1;
      else if(dealer>player && dealer>22)//if dealers value is more than the players and dealers value is less than equal to 21 then dealer wins
      return 2;
      else//inacse of a tie or if a player busts then the dealer wins
      return 2;
    }

    // Method that describes the card (value and suit) located at index 1
    // in the hand. This is used to show one of the cards that the dealer has.
    public static String displayCard(ArrayList<Card> hand)
    {
      int index=1;//storing the index
      String s1= hand.get(index).suit;//extracting and storing the suit
      String s2= hand.get(index).rank;//extracting and storing the rank
    	return s2+" of "+s1;
    }

    // Method that describes the cards (values and suits) in the hand.
    public static String displayHand(ArrayList<Card> hand)
    {
      String str="";
      String s1="",s2="";
      for(int i=0;i<hand.size();i++)//extracting ever card in the hand one by one
      {
        s1= hand.get(i).suit;//extracting and storing the suit
        s2= hand.get(i).rank;//extracting and storing the rank
        str+= s2+" of "+s1+" ";
      }
    	return str;
    }

    // Method that clears both the player hand and dealer hand.
    // There should be no cards in either hand after this method is called.
    public static void clearHands(ArrayList<Card> playerHand, ArrayList<Card> dealerHand)
    {
      playerHand.clear();//clear the playerhand array
      dealerHand.clear();//clear the playerhand array
    }


    // Do not change anything after this!
    public static void main(String[] args) {

		int playerChoice, winner;
		ArrayList<Card> deck = new ArrayList<Card> ();

		playerChoice = JOptionPane.showConfirmDialog(null, "Ready to Play Blackjack?", "Blackjack", JOptionPane.OK_CANCEL_OPTION);

		if((playerChoice == JOptionPane.CLOSED_OPTION) || (playerChoice == JOptionPane.CANCEL_OPTION))
		    System.exit(0);


		Object[] options = {"Hit", "Stand"};
		boolean isBusted, dealerBusted;
		boolean isPlayerTurn;
		ArrayList<Card> playerHand = new ArrayList<>();
		ArrayList<Card> dealerHand = new ArrayList<>();

		do{ // Game loop
			// Clear the hands
			clearHands(playerHand, dealerHand);
			// Clear the deck and build if not enough cards left to play a new game
			if (deck.size() <= 12) {
				deck.clear();
				buildDeck(deck);
			}

		    initialDeal(deck, playerHand, dealerHand);
		    isPlayerTurn=true;
		    isBusted=false;
		    dealerBusted=false;

		    while (isPlayerTurn){
		    	System.out.println("Player hand value is:" + String.valueOf(getHandValue(playerHand)));

				// Shows the hand and prompts player to hit or stand
				playerChoice = JOptionPane.showOptionDialog(null, "Dealer shows " + displayCard(dealerHand) + "\nYour hand is: " + displayHand(playerHand) + "\nWhat do you want to do?","Hit or Stand",
									   JOptionPane.YES_NO_OPTION,
									   JOptionPane.QUESTION_MESSAGE,
									   null,
									   options,
									   options[0]);

				// Player chooses to close the game
				if (playerChoice == JOptionPane.CLOSED_OPTION)
				    System.exit(0);

				// Player chooses to Hit
				else if(playerChoice == JOptionPane.YES_OPTION){
				    dealOne(deck, playerHand);
				    System.out.println("Player hand value after hitting is:" + String.valueOf(getHandValue(playerHand)));
				    isBusted = checkBust(playerHand);
				    if(isBusted){
						// Case: Player Busts
						playerChoice = JOptionPane.showConfirmDialog(null,"Your hand: " +  displayHand(playerHand) + "\nPlayer has busted!", "You lose", JOptionPane.OK_CANCEL_OPTION);

						if((playerChoice == JOptionPane.CLOSED_OPTION) || (playerChoice == JOptionPane.CANCEL_OPTION))
						    System.exit(0);

						isPlayerTurn = false;
				    }
				}
			    // Player chooses to Stand
				else{
				    isPlayerTurn = false;
				}
		    }
		    System.out.println("Dealer hand value is:" + String.valueOf(getHandValue(dealerHand)));

		    if (!isBusted) { // Continues if player hasn't busted
				dealerBusted = dealerTurn(deck, dealerHand);
				System.out.println("Dealer hand value after turn is:" + String.valueOf(getHandValue(dealerHand)));

				if(dealerBusted){ // Case: Dealer Busts
				    playerChoice = JOptionPane.showConfirmDialog(null, "The dealer's hand: " + displayHand(dealerHand) + "\n \nYour hand: " + displayHand(playerHand) + "\nThe dealer busted.\nCongratulations!", "You Win!!!", JOptionPane.OK_CANCEL_OPTION);

					if((playerChoice == JOptionPane.CLOSED_OPTION) || (playerChoice == JOptionPane.CANCEL_OPTION))
						System.exit(0);
				}


				else{ //The Dealer did not bust.  The winner must be determined
				    winner = whoWins(playerHand, dealerHand);

				    if (winner == 1){ //Player Wins
						playerChoice = JOptionPane.showConfirmDialog(null, "The dealer's hand: " + displayHand(dealerHand) + "\n \nYour hand: " + displayHand(playerHand) + "\nCongratulations!", "You Win!!!", JOptionPane.OK_CANCEL_OPTION);

						if((playerChoice == JOptionPane.CLOSED_OPTION) || (playerChoice == JOptionPane.CANCEL_OPTION))
						    System.exit(0);
				    }

				    else{ //Player Loses
						playerChoice = JOptionPane.showConfirmDialog(null, "The dealer's hand: " +displayHand(dealerHand) + "\n \nYour hand: " + displayHand(playerHand) + "\nBetter luck next time!", "You lose!!!", JOptionPane.OK_CANCEL_OPTION);

						if((playerChoice == JOptionPane.CLOSED_OPTION) || (playerChoice == JOptionPane.CANCEL_OPTION))
						    System.exit(0);
				    }
				}
		    }
		} while(true);
    }
}
