import java.util.Scanner;

public class BlackJack {

  public static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println(
      "Welcome to Java Casino !\nDo you have a knack for Black Jack? \nWe shall see...\n..Ready? Press anything to begin !"
    );
    scan.nextLine();

    int randCard1 = drawRandomCard();
    int randcard2 = drawRandomCard();

    int dealerCard1 = drawRandomCard();
    int dealerCard2 = drawRandomCard();

    System.out.println("You get a\n" + randomCard(randCard1));
    System.out.println("and a\n" + randomCard(randcard2));

    int handValue = Math.min(randCard1, 10) + Math.min(randcard2, 10);
    System.out.println("Your hand value is: " + handValue);

    System.out.println("\nThe dealer shows\n" + randomCard(dealerCard1));
    System.out.println("and has a card facing down\n" + faceDown());

    int dealerTotal = Math.min(dealerCard1, 10) + Math.min(dealerCard2, 10);

    System.out.println("The dealer's total value is hidden");

    while (true) {
      String optionSelected = hitOrStay();
      if (optionSelected.equals("stay")) {
        break;
      }

      int newCard = drawRandomCard();
      System.out.println("\nYou get a \n" + randomCard(newCard));
      handValue += Math.min(newCard, 10);
      System.out.println("your new total is: " + handValue);

      if (handValue >= 21) {
        System.out.println("---- Bust! Player loses ----");
        System.exit(0);
      }
    }

    System.out.println("Dealer's turn");
    System.out.println(
      "\n The dealer's cards are \n " +
      randomCard(dealerCard1) +
      "\n and a \n" +
      randomCard(dealerCard2)
    );
    System.out.println("\nDealer's Total: " + dealerTotal);
    while (dealerTotal < 17) {
      int newCard = drawRandomCard();
      dealerTotal += Math.min(newCard, 10);
      System.out.println("\nDealer's gets a \n " + randomCard(newCard));
      System.out.println("\nDealer's Total: " + dealerTotal);
    }
    if (dealerTotal > 21) {
      System.out.println("\n---- Bust! Dealer loses ----");
      System.exit(0);
    }
    if (handValue > dealerTotal) {
      System.out.println("\n---- User Wins! ----");
    } else {
      System.out.println("\n---- Dealer Wins! ----");
    }
    scan.close();
  }

  public static String hitOrStay() {
    System.out.println("\nwould you like or hit ot stay");
    System.out.print("-> ");
    String userOption = scan.nextLine();
    while (!(userOption.equals("hit") || userOption.equals("stay"))) {
      System.out.println("Please enter hit or stay");
      System.out.print("-> ");
      userOption = scan.nextLine();
    }

    return userOption;
  }

  public static String randomCard(int drawCard) {
    switch (drawCard) {
      case 1:
        return (
          "   _____\n" +
          "  |A _  |\n" +
          "  | ( ) |\n" +
          "  |(_'_)|\n" +
          "  |  |  |\n" +
          "  |____V|\n"
        );
      case 2:
        return (
          "   _____\n" +
          "  |2    |\n" +
          "  |  o  |\n" +
          "  |     |\n" +
          "  |  o  |\n" +
          "  |____Z|\n"
        );
      case 3:
        return (
          "   _____\n" +
          "  |3    |\n" +
          "  | o o |\n" +
          "  |     |\n" +
          "  |  o  |\n" +
          "  |____E|\n"
        );
      case 4:
        return (
          "   _____\n" +
          "  |4    |\n" +
          "  | o o |\n" +
          "  |     |\n" +
          "  | o o |\n" +
          "  |____h|\n"
        );
      case 5:
        return (
          "   _____ \n" +
          "  |5    |\n" +
          "  | o o |\n" +
          "  |  o  |\n" +
          "  | o o |\n" +
          "  |____S|\n"
        );
      case 6:
        return (
          "   _____ \n" +
          "  |6    |\n" +
          "  | o o |\n" +
          "  | o o |\n" +
          "  | o o |\n" +
          "  |____6|\n"
        );
      case 7:
        return (
          "   _____ \n" +
          "  |7    |\n" +
          "  | o o |\n" +
          "  |o o o|\n" +
          "  | o o |\n" +
          "  |____7|\n"
        );
      case 8:
        return (
          "   _____ \n" +
          "  |8    |\n" +
          "  |o o o|\n" +
          "  | o o |\n" +
          "  |o o o|\n" +
          "  |____8|\n"
        );
      case 9:
        return (
          "   _____ \n" +
          "  |9    |\n" +
          "  |o o o|\n" +
          "  |o o o|\n" +
          "  |o o o|\n" +
          "  |____9|\n"
        );
      case 10:
        return (
          "   _____ \n" +
          "  |10  o|\n" +
          "  |o o o|\n" +
          "  |o o o|\n" +
          "  |o o o|\n" +
          "  |___10|\n"
        );
      case 11:
        return (
          "   _____\n" +
          "  |J  ww|\n" +
          "  | o {)|\n" +
          "  |o o% |\n" +
          "  | | % |\n" +
          "  |__%%[|\n"
        );
      case 12:
        return (
          "   _____\n" +
          "  |Q  ww|\n" +
          "  | o {(|\n" +
          "  |o o%%|\n" +
          "  | |%%%|\n" +
          "  |_%%%O|\n"
        );
      case 13:
        return (
          "   _____\n" +
          "  |K  WW|\n" +
          "  | o {)|\n" +
          "  |o o%%|\n" +
          "  | |%%%|\n" +
          "  |_%%%>|\n"
        );
      default:
        return "Not Possible";
    }
  }

  public static String faceDown() {
    return 
      "    _____ \n" +
      "  |     |\n" +
      "  |  J  |\n" +
      "  | JJJ |\n" +
      "  |  J  |\n" +
      "  |____ |\n";
  }

  public static int drawRandomCard() {
    int drawCard = (int) (Math.random() * 13 + 1);
    return drawCard;
  }
}
