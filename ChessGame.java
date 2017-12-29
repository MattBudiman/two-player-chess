import java.util.Scanner;

public class ChessGame
{
	public static void main(String[] args)
	{
		System.out.println("Welcome! To make a move (eg. a1-a2):");
		System.out.println("1. Input the alegbraic coordinates (eg. a1) of the piece that you wish to move.");
		System.out.println("2. Input a dash.");
		System.out.println("3. Input the alegbraic coordinates of the square to which you want to move the piece.");
		System.out.println("4. White pieces are uppercase; black pieces are lowercase.");
		System.out.println("Have fun!");
		System.out.println();
		Chess game = new Chess();
		System.out.println(game.getBoard());
		System.out.println();
		Scanner in = new Scanner(System.in);
		boolean done = false;
		while (!done)
		{
			boolean successfulInput = true;
			if (game.isWhitesMove())
			{
				System.out.print("White's Move: ");
			}
			else
			{
				System.out.print("Black's Move: ");
			}
			String input = in.next();
			System.out.println();
			if (input.length() != 5)
			{
				successfulInput = false;
			}
			else if (!Chess.successfulFileInput(input.substring(0, 1)) || !Chess.successfulRankInput(input.substring(1, 2)) || !input.substring(2, 3).equals("-") || !Chess.successfulFileInput(input.substring(3, 4)) || !Chess.successfulRankInput(input.substring(4, 5)))
			{
				successfulInput = false;
			}
			if (!successfulInput)
			{
				System.out.println("Invalid input. Try Again");
				System.out.println();
			}
			else
			{
				int rank1 = Integer.parseInt(input.substring(1, 2));
				String file1 = input.substring(0, 1);
				int rank2 = Integer.parseInt(input.substring(4, 5));
				String file2 = input.substring(3, 4);
				if (game.move(Chess.toRow(rank1), Chess.toColumn(file1), Chess.toRow(rank2), Chess.toColumn(file2)))
				{
					if (game.findPawnOnLastRank())
					{
						boolean promoted = false;
						while (!promoted)
						{
							if (game.isWhitesMove())
							{
								System.out.print("Promote Pawn to (n, b, r, or q): ");
							}
							else
							{
								System.out.print("Promote Pawn to (N, B, R, or Q): ");
							}
							String promotion = in.next();
							System.out.println();
							if (game.successfulPromotion(promotion))
							{
								game.promote(promotion);
								promoted = true;
							}
							else
							{
								System.out.println("Invalid Pawn Promotion. Try Again.");
							}
						}
					}
					System.out.println(game.getBoard());
					System.out.println();
					if (game.kingIsInCheck())
					{
						if (game.checkmate())
						{
							if (game.isWhitesMove())
							{
								System.out.println("Checkmate. Black is the winner.");
							}
							else
							{
								System.out.println("Checkmate. White is the winner.");
							}
							done = true;
						}
						else
						{
							System.out.println("Check!");
							System.out.println();
						}
					}
					else if (game.stalemate())
					{
						System.out.println("Stalemate. The game is a draw.");
						done = true;
					}
				}
				else
				{
					System.out.println("Invalid Move. Try Again.");
					System.out.println();
				}
			}
		}
		in.close();
	}
}
