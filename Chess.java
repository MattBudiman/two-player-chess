/**
 * A chess game.
 * Created by Matthew Budiman.
 */
public class Chess
{
	private String[][] board;
	private boolean whitesMove;
	private boolean a1RookHasMoved;
	private boolean h1RookHasMoved;
	private boolean a8RookHasMoved;
	private boolean h8RookHasMoved;
	private boolean whiteKingHasMoved;
	private boolean blackKingHasMoved;
	private int blackPawnCol;
	private int whitePawnCol;
	
	public static final int ROWS = 8;
	public static final int COLUMNS = 8;
	
	/**
	 * Constructs a new chess game with the default board position, white to move.
	 */
	public Chess()
	{
		whitesMove = true;
		a1RookHasMoved = false;
		h1RookHasMoved = false;
		a8RookHasMoved = false;
		h8RookHasMoved = false;
		whiteKingHasMoved = false;
		blackKingHasMoved = false;
		blackPawnCol = -1;
		whitePawnCol = -1;
		board = new String[ROWS][COLUMNS];
		for (int r = 0; r < ROWS; r++)
		{
			for (int c = 0; c < COLUMNS; c++)
			{
				if (r == 0)
				{
					if (c == 0 || c == 7)
					{
						board[r][c] = "r";
					}
					else if (c == 1 || c == 6)
					{
						board[r][c] = "n";
					}
					else if (c == 2 || c == 5)
					{
						board[r][c] = "b";
					}
					else if (c == 3)
					{
						board[r][c] = "q";
					}
					else if (c == 4)
					{
						board[r][c] = "k";
					}
					else
					{
						board[r][c] = " ";
					}
				}
				else if (r == 7)
				{
					if (c == 0 || c == 7)
					{
						board[r][c] = "R";
					}
					else if (c == 1 || c == 6)
					{
						board[r][c] = "N";
					}
					else if (c == 2 || c == 5)
					{
						board[r][c] = "B";
					}
					else if (c == 3)
					{
						board[r][c] = "Q";
					}
					else if (c == 4)
					{
						board[r][c] = "K";
					}
					else
					{
						board[r][c] = " ";
					}
				}
				else if (r == 1)
				{
					board[r][c] = "p";
				}
				else if (r == ROWS - 2)
				{
					board[r][c] = "P";
				}
				else
				{
					board[r][c] = " ";
				}
			}
		}
	}
	
	/**
	 * Converts a given file input to its corresponding column index.
	 * @param file a file on a chessboard (a, b, c, d, e, f, g, h)
	 * @return the corresponding column index
	 */
	public static int toColumn(String file)
	{
		int column;
		if (file.equals("a"))
		{
			column = 0;
		}
		else if (file.equals("b"))
		{
			column = 1;
		}
		else if (file.equals("c"))
		{
			column = 2;
		}
		else if (file.equals("d"))
		{
			column = 3;
		}
		else if (file.equals("e"))
		{
			column = 4;
		}
		else if (file.equals("f"))
		{
			column = 5;
		}
		else if (file.equals("g"))
		{
			column = 6;
		}
		else
		{
			column = 7;
		}
		return column;
	}
	
	/**
	 * Converts a given rank input to its corresponding row index.
	 * @param rank a rank on a chessboard (1, 2, 3, 4, 5, 6, 7, 8)
	 * @return the corresponding row index.
	 */
	public static int toRow(int rank)
	{
		int row;
		if (rank == 8)
		{
			row = 0;
		}
		else if (rank == 7)
		{
			row = 1;
		}
		else if (rank == 6)
		{
			row = 2;
		}
		else if (rank == 5)
		{
			row = 3;
		}
		else if (rank == 4)
		{
			row = 4;
		}
		else if (rank == 3)
		{
			row = 5;
		}
		else if (rank == 2)
		{
			row = 6;
		}
		else
		{
			row = 7;
		}
		return row;
	}
	
	/**
	 * Tests if a string input is a file on a chessboard.
	 * @param input a file letter
	 * @return true if input is a file on a chessboard, false otherwise
	 */
	public static boolean successfulFileInput(String input)
	{
		boolean success = false;
		if (input.equals("a"))
		{
			success = true;
		}
		else if (input.equals("b"))
		{
			success = true;
		}
		else if (input.equals("c"))
		{
			success = true;
		}
		else if (input.equals("d"))
		{
			success = true;
		}
		else if (input.equals("e"))
		{
			success = true;
		}
		else if (input.equals("f"))
		{
			success = true;
		}
		else if (input.equals("g"))
		{
			success = true;
		}
		else if (input.equals("h"))
		{
			success = true;
		}
		return success;
	}
	
	/**
	 * Tests if a string input is a rank on a chessboard.
	 * @param input a rank String number
	 * @return true if input is a rank on a chessboard, false otherwise
	 */
	public static boolean successfulRankInput(String input)
	{
		boolean success = false;
		if (input.equals("8"))
		{
			success = true;
		}
		else if (input.equals("7"))
		{
			success = true;
		}
		else if (input.equals("6"))
		{
			success = true;
		}
		else if (input.equals("5"))
		{
			success = true;
		}
		else if (input.equals("4"))
		{
			success = true;
		}
		else if (input.equals("3"))
		{
			success = true;
		}
		else if (input.equals("2"))
		{
			success = true;
		}
		else if (input.equals("1"))
		{
			success = true;
		}
		return success;
	}
	
	/**
	 * Tests if a particular string input is a valid pawn promotion piece.
	 * @param input a valid pawn promotion piece (knight, bishop, rook, or queen)
	 * @return true if valid, false otherwise
	 */
	public boolean successfulPromotion(String input)
	{
		boolean success = false;
		if (whitesMove)
		{
			if (input.equals("n"))
			{
				success = true;
			}
			else if (input.equals("b"))
			{
				success = true;
			}
			else if (input.equals("r"))
			{
				success = true;
			}
			else if (input.equals("q"))
			{
				success = true;
			}
		}
		else
		{
			if (input.equals("N"))
			{
				success = true;
			}
			else if (input.equals("B"))
			{
				success = true;
			}
			else if (input.equals("R"))
			{
				success = true;
			}
			else if (input.equals("Q"))
			{
				success = true;
			}
		}
		return success;
	}
	
	/**
	 * Resets the board to the standard starting position, white to move.
	 */
	public void reset()
	{
		whitesMove = true;
		a1RookHasMoved = false;
		h1RookHasMoved = false;
		a8RookHasMoved = false;
		h8RookHasMoved = false;
		whiteKingHasMoved = false;
		blackKingHasMoved = false;
		blackPawnCol = -1;
		whitePawnCol = -1;
		for (int r = 0; r < ROWS; r++)
		{
			for (int c = 0; c < COLUMNS; c++)
			{
				if (r == 0)
				{
					if (c == 0 || c == 7)
					{
						board[r][c] = "r";
					}
					else if (c == 1 || c == 6)
					{
						board[r][c] = "n";
					}
					else if (c == 2 || c == 5)
					{
						board[r][c] = "b";
					}
					else if (c == 3)
					{
						board[r][c] = "q";
					}
					else if (c == 4)
					{
						board[r][c] = "k";
					}
					else
					{
						board[r][c] = " ";
					}
				}
				else if (r == 7)
				{
					if (c == 0 || c == 7)
					{
						board[r][c] = "R";
					}
					else if (c == 1 || c == 6)
					{
						board[r][c] = "N";
					}
					else if (c == 2 || c == 5)
					{
						board[r][c] = "B";
					}
					else if (c == 3)
					{
						board[r][c] = "Q";
					}
					else if (c == 4)
					{
						board[r][c] = "K";
					}
					else
					{
						board[r][c] = " ";
					}
				}
				else if (r == 1)
				{
					board[r][c] = "p";
				}
				else if (r == ROWS - 2)
				{
					board[r][c] = "P";
				}
				else
				{
					board[r][c] = " ";
				}
			}
		}
	}
	
	/**
	 * Gets a string representation of the board, from white's perspective
	 * if white's move, and from black's perspective otherwise.
	 * @return the string representation of the board.
	 */
	public String getBoard()
	{
		String theBoard = "";
		if (whitesMove)
		{
			for (int r = 0; r < ROWS; r++)
			{
				for (int c = 0; c < COLUMNS; c++)
				{
					if (c == 0)
					{
						theBoard = theBoard + (ROWS - r) + "|";
					}
					theBoard = theBoard + board[r][c] + "|";
					if (c == COLUMNS - 1)
					{
						theBoard = theBoard + "\n";
					}
				}
			}
			theBoard = theBoard + "  a b c d e f g h";
		}
		else
		{
			for(int r = ROWS - 1; r >= 0; r--)
			{
				for (int c = COLUMNS - 1; c >=0; c--)
				{
					if (c == COLUMNS - 1)
					{
						theBoard = theBoard + (ROWS - r) + "|";
					}
					theBoard = theBoard + board[r][c] + "|";
					if (c == 0)
					{
						theBoard = theBoard + "\n";
					}
				}
			}
			theBoard = theBoard + "  h g f e d c b a";
		}
		return theBoard;
	}
	
	/**
	 * Gets a copy of the board.
	 * @return a copy of the board.
	 */
	public String[][] copyBoard()
	{
		String[][] copy = new String[ROWS][COLUMNS];
		for (int r = 0; r < ROWS; r++)
		{
			for (int c = 0; c < COLUMNS; c++)
			{
				copy[r][c] = board[r][c];
			}
		}
		return copy;
	}
	
	/**
	 * Determines whether it is currently white's move.
	 * @return true if white's move, false otherwise.
	 */
	public boolean isWhitesMove()
	{
		return whitesMove;
	}
	
	/**
	 * Promotes a pawn on the bank rank with a specified piece.
	 * @param piece the piece with which to promote the pawn.
	 */
	public void promote(String piece)
	{
		if (!whitesMove)
		{
			for (int c = 0; c < COLUMNS; c++)
			{
				if (board[0][c].equals("P"))
				{
					board[0][c] = piece;
				}
			}
		}
		else
		{
			for (int c = 0; c < COLUMNS; c++)
			{
				if (board[7][c].equals("p"))
				{
					board[7][c] = piece;
				}
			}
		}
	}
	
	/**
	 * Determines whether there is a pawn on the last rank.
	 * @return true if a pawn is on the last rank, false otherwise.
	 */
	public boolean findPawnOnLastRank()
	{
		boolean found = false;
		if (whitesMove)
		{
			for (int c = 0; c < COLUMNS; c++)
			{
				if (board[7][c].equals("p"))
				{
					found = true;
				}
			}
		}
		else
		{
			for (int c = 0; c < COLUMNS; c++)
			{
				if (board[0][c].equals("P"))
				{
					found = true;
				}
			}
		}
		return found;
	}
	
	/**
	 * Moves a piece from board[row1][col1] to board[row2][col2] after determining
	 * whether such a move is indeed possible, adjusting all instance fields as
	 * necessary.
	 * @param row1 the row of the piece to move
	 * @param col1 the column of the piece to move
	 * @param row2 the row of the destination square
	 * @param col2 the column of the destination square
	 * @return true if the move could be successfully made, false otherwise.
	 */
	public boolean move(int row1, int col1, int row2, int col2)
	{
		String[][] copy = copyBoard();
		String piece = board[row1][col1];
		boolean hitPiece = false;
		boolean foundSquare = false;
		int r;
		int c;
		if (whitesMove)
		{
			if (piece.equals("P"))
			{
				if (row2 == row1 - 1)
				{
					if (col2 == col1 + 1 || col2 == col1 - 1)
					{
						if (Character.isLowerCase(board[row2][col2].charAt(0)))
						{
							board[row1][col1] = " ";
							board[row2][col2] = piece;
						}
						else if (blackPawnCol >= 0)
						{
							if (row1 == 3 && Math.abs(col1 - col2) == 1 && col2 == blackPawnCol)
							{
								board[row1][col1] = " ";
								board[row1][blackPawnCol] = " ";
								board[row2][col2] = piece;
							}
							else
							{
								return false;
							}
						}
						else
						{
							return false;
						}
					}
					else if (col2 == col1)
					{
						if (board[row2][col2].equals(" "))
						{
							board[row1][col1] = " ";
							board[row2][col2] = piece;
						}
						else
						{
							return false;
						}
					}
					else
					{
						return false;
					}
				}
				else if (row2 == row1 - 2 && col2 == col1 && row1 == 6)
				{
					if (board[row2 + 1][col2].equals(" ") && board[row2][col2].equals(" "))
					{
						board[row1][col1] = " ";
						board[row2][col2] = piece;
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
				if (row1 == 6 && row2 == 4)
				{
					whitePawnCol = col2;
				}
				else
				{
					whitePawnCol = -1;
				}
			}
			else if (piece.equals("N"))
			{
				if (Math.abs(row2 - row1) == 2 && Math.abs(col2 - col1) == 1)
				{
					if (!Character.isUpperCase(board[row2][col2].charAt(0)))
					{
						board[row1][col1] = " ";
						board[row2][col2] = piece;
					}
					else
					{
						return false;
					}
				}
				else if (Math.abs(row2 - row1) == 1 && Math.abs(col2 - col1) == 2)
				{
					if (!Character.isUpperCase(board[row2][col2].charAt(0)))
					{
						board[row1][col1] = " ";
						board[row2][col2] = piece;
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
				whitePawnCol = -1;
			}
			else if (piece.equals("B"))
			{
				if (row2 > row1)
				{
					if (col2 > col1)
					{
						r = row1 + 1;
						c = col1 + 1;
						while (r < ROWS && c < COLUMNS && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r++;
							c++;
						}
					}
					else if (col2 < col1)
					{
						r = row1 + 1;
						c = col1 - 1;
						while (r < ROWS && c >= 0 && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r++;
							c--;
						}
					}
				}
				else if (row2 < row1)
				{
					if (col2 > col1)
					{
						r = row1 - 1;
						c = col1 + 1;
						while (r >= 0 && c < COLUMNS && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r--;
							c++;
						}
					}
					else if (col2 < col1)
					{
						r = row1 - 1;
						c = col1 - 1;
						while (r >= 0 && c >= 0 && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r--;
							c--;
						}
					}
				}
				if (!foundSquare)
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
				whitePawnCol = -1;
			}
			else if (piece.equals("R"))
			{
				if (row2 == row1)
				{
					if (col2 > col1)
					{
						for (int col = col1 + 1; col < COLUMNS && !hitPiece && !foundSquare; col++)
						{
							if (board[row2][col].equals(" "))
							{
								if (col == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[row2][col].charAt(0)))
								{
									if (col == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
					else if (col2 < col1)
					{
						for (int col = col1 - 1; col >= 0 && !hitPiece && !foundSquare; col--)
						{
							if (board[row2][col].equals(" "))
							{
								if (col == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[row2][col].charAt(0)))
								{
									if (col == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
				}
				else if (col2 == col1)
				{
					if (row2 > row1)
					{
						for (int row = row1 + 1; row < ROWS && !hitPiece && !foundSquare; row++)
						{
							if (board[row][col2].equals(" "))
							{
								if (row == row2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[row][col2].charAt(0)))
								{
									if (row == row2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
					else if (row2 < row1)
					{
						for (int row = row1 - 1; row >= 0 && !hitPiece && !foundSquare; row--)
						{
							if (board[row][col2].equals(" "))
							{
								if (row == row2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[row][col2].charAt(0)))
								{
									if (row == row2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
				}
				if (!foundSquare)
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
				whitePawnCol = -1;
				if (row1 == 7)
				{
					if (col1 == 0)
					{
						a1RookHasMoved = true;
					}
					if (col1 == 7)
					{
						h1RookHasMoved = true;
					}
				}
			}
			else if (piece.equals("Q"))
			{
				if (row2 > row1)
				{
					if (col2 > col1)
					{
						r = row1 + 1;
						c = col1 + 1;
						while (r < ROWS && c < COLUMNS && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r++;
							c++;
						}
					}
					else if (col2 < col1)
					{
						r = row1 + 1;
						c = col1 - 1;
						while (r < ROWS && c >= 0 && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r++;
							c--;
						}
					}
				}
				else if (row2 < row1)
				{
					if (col2 > col1)
					{
						r = row1 - 1;
						c = col1 + 1;
						while (r >= 0 && c < COLUMNS && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r--;
							c++;
						}
					}
					else if (col2 < col1)
					{
						r = row1 - 1;
						c = col1 - 1;
						while (r >= 0 && c >= 0 && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r--;
							c--;
						}
					}
				}
				if (row2 == row1)
				{
					if (col2 > col1)
					{
						for (int col = col1 + 1; col < COLUMNS && !hitPiece && !foundSquare; col++)
						{
							if (board[row2][col].equals(" "))
							{
								if (col == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[row2][col].charAt(0)))
								{
									if (col == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
					else if (col2 < col1)
					{
						for (int col = col1 - 1; col >= 0 && !hitPiece && !foundSquare; col--)
						{
							if (board[row2][col].equals(" "))
							{
								if (col == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[row2][col].charAt(0)))
								{
									if (col == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
				}
				else if (col2 == col1)
				{
					if (row2 > row1)
					{
						for (int row = row1 + 1; row < ROWS && !hitPiece && !foundSquare; row++)
						{
							if (board[row][col2].equals(" "))
							{
								if (row == row2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[row][col2].charAt(0)))
								{
									if (row == row2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
					else if (row2 < row1)
					{
						for (int row = row1 - 1; row >= 0 && !hitPiece && !foundSquare; row--)
						{
							if (board[row][col2].equals(" "))
							{
								if (row == row2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[row][col2].charAt(0)))
								{
									if (row == row2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
				}
				if (!foundSquare)
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
				whitePawnCol = -1;
			}
			else if (piece.equals("K"))
			{
				if (Math.abs(row2 - row1) <= 1 && Math.abs(col2 - col1) <= 1)
				{
					if (!attackAt(row2, col2) && !Character.isUpperCase(board[row2][col2].charAt(0)))
					{
						board[row1][col1] = " ";
						board[row2][col2] = piece;
					}
					else
					{
						return false;
					}
				}
				else if (!whiteKingHasMoved && !h1RookHasMoved && col2 == col1 + 2 && row1 == row2 && !kingIsInCheck() && !attackAt(7, 5) && board[7][5].equals(" ") && !attackAt(7, 6) && board[7][6].equals(" ") && !attackAt(row2, col2) && board[row2][col2].equals(" "))
				{
					board[row1][col1] = " ";
					board[row2][col2] = piece;
					String rook = board[7][7];
					board[7][7] = " ";
					board[7][5] = rook;
					h1RookHasMoved = true;
				}
				else if (!whiteKingHasMoved && !a1RookHasMoved && col2 == col1 - 2 && row1 == row2 && !kingIsInCheck() && board[7][1].equals(" ") && !attackAt(7, 2) && board[7][2].equals(" ") && !attackAt(7, 3) && board[7][3].equals(" ") && !attackAt(row2, col2) && board[row2][col2].equals(" "))
				{
					board[row1][col1] = " ";
					board[row2][col2] = piece;
					String rook = board[7][0];
					board[7][0] = " ";
					board[7][3] = rook;
					a1RookHasMoved = true;
				}
				else
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
				whitePawnCol = -1;
				whiteKingHasMoved = true;
			}
			else
			{
				return false;
			}
			whitesMove = false;
		}
		else
		{
			if (piece.equals("p"))
			{
				if (row2 == row1 + 1)
				{
					if (col2 == col1 + 1 || col2 == col1 - 1)
					{
						if (Character.isUpperCase(board[row2][col2].charAt(0)))
						{
							board[row1][col1] = " ";
							board[row2][col2] = piece;
						}
						else if (whitePawnCol >= 0)
						{
							if (row1 == 4 && Math.abs(col1 - col2) == 1 && col2 == whitePawnCol)
							{
								board[row1][col1] = " ";
								board[row1][whitePawnCol] = " ";
								board[row2][col2] = piece;
							}
							else
							{
								return false;
							}
						}
						else
						{
							return false;
						}
					}
					else if (col2 == col1)
					{
						if (board[row2][col2].equals(" "))
						{
							board[row1][col1] = " ";
							board[row2][col2] = piece;
						}
						else
						{
							return false;
						}
					}
					else
					{
						return false;
					}
				}
				else if (row2 == row1 + 2 && col2 == col1 && row1 == 1)
				{
					if (board[row2 - 1][col2].equals(" ") && board[row2][col2].equals(" "))
					{
						board[row1][col1] = " ";
						board[row2][col2] = piece;
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
				if (row1 == 1 && row2 == 3)
				{
					blackPawnCol = col2;
				}
				else
				{
					blackPawnCol = -1;
				}
			}
			else if (piece.equals("n"))
			{
				if (Math.abs(row2 - row1) == 2 && Math.abs(col2 - col1) == 1)
				{
					if (!Character.isLowerCase(board[row2][col2].charAt(0)))
					{
						board[row1][col1] = " ";
						board[row2][col2] = piece;
					}
					else
					{
						return false;
					}
				}
				else if (Math.abs(row2 - row1) == 1 && Math.abs(col2 - col1) == 2)
				{
					if (!Character.isLowerCase(board[row2][col2].charAt(0)))
					{
						board[row1][col1] = " ";
						board[row2][col2] = piece;
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
				blackPawnCol = -1;
			}
			else if (piece.equals("b"))
			{
				if (row2 > row1)
				{
					if (col2 > col1)
					{
						r = row1 + 1;
						c = col1 + 1;
						while (r < ROWS && c < COLUMNS && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r++;
							c++;
						}
					}
					else if (col2 < col1)
					{
						r = row1 + 1;
						c = col1 - 1;
						while (r < ROWS && c >= 0 && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r++;
							c--;
						}
					}
				}
				else if (row2 < row1)
				{
					if (col2 > col1)
					{
						r = row1 - 1;
						c = col1 + 1;
						while (r >= 0 && c < COLUMNS && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r--;
							c++;
						}
					}
					else if (col2 < col1)
					{
						r = row1 - 1;
						c = col1 - 1;
						while (r >= 0 && c >= 0 && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r--;
							c--;
						}
					}
				}
				if (!foundSquare)
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
				blackPawnCol = -1;
			}
			else if (piece.equals("r"))
			{
				if (row2 == row1)
				{
					if (col2 > col1)
					{
						for (int col = col1 + 1; col < COLUMNS && !hitPiece && !foundSquare; col++)
						{
							if (board[row2][col].equals(" "))
							{
								if (col == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[row2][col].charAt(0)))
								{
									if (col == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
					else if (col2 < col1)
					{
						for (int col = col1 - 1; col >= 0 && !hitPiece && !foundSquare; col--)
						{
							if (board[row2][col].equals(" "))
							{
								if (col == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[row2][col].charAt(0)))
								{
									if (col == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
				}
				else if (col2 == col1)
				{
					if (row2 > row1)
					{
						for (int row = row1 + 1; row < ROWS && !hitPiece && !foundSquare; row++)
						{
							if (board[row][col2].equals(" "))
							{
								if (row == row2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[row][col2].charAt(0)))
								{
									if (row == row2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
					else if (row2 < row1)
					{
						for (int row = row1 - 1; row >= 0 && !hitPiece && !foundSquare; row--)
						{
							if (board[row][col2].equals(" "))
							{
								if (row == row2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[row][col2].charAt(0)))
								{
									if (row == row2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
				}
				if (!foundSquare)
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
				blackPawnCol = -1;
				if (row1 == 0)
				{
					if (col1 == 0)
					{
						a8RookHasMoved = true;
					}
					if (col1 == 7)
					{
						h8RookHasMoved = true;
					}
				}
			}
			else if (piece.equals("q"))
			{
				if (row2 > row1)
				{
					if (col2 > col1)
					{
						r = row1 + 1;
						c = col1 + 1;
						while (r < ROWS && c < COLUMNS && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r++;
							c++;
						}
					}
					else if (col2 < col1)
					{
						r = row1 + 1;
						c = col1 - 1;
						while (r < ROWS && c >= 0 && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r++;
							c--;
						}
					}
				}
				else if (row2 < row1)
				{
					if (col2 > col1)
					{
						r = row1 - 1;
						c = col1 + 1;
						while (r >= 0 && c < COLUMNS && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r--;
							c++;
						}
					}
					else if (col2 < col1)
					{
						r = row1 - 1;
						c = col1 - 1;
						while (r >= 0 && c >= 0 && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r--;
							c--;
						}
					}
				}
				if (row2 == row1)
				{
					if (col2 > col1)
					{
						for (int col = col1 + 1; col < COLUMNS && !hitPiece && !foundSquare; col++)
						{
							if (board[row2][col].equals(" "))
							{
								if (col == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[row2][col].charAt(0)))
								{
									if (col == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
					else if (col2 < col1)
					{
						for (int col = col1 - 1; col >= 0 && !hitPiece && !foundSquare; col--)
						{
							if (board[row2][col].equals(" "))
							{
								if (col == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[row2][col].charAt(0)))
								{
									if (col == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
				}
				else if (col2 == col1)
				{
					if (row2 > row1)
					{
						for (int row = row1 + 1; row < ROWS && !hitPiece && !foundSquare; row++)
						{
							if (board[row][col2].equals(" "))
							{
								if (row == row2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[row][col2].charAt(0)))
								{
									if (row == row2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
					else if (row2 < row1)
					{
						for (int row = row1 - 1; row >= 0 && !hitPiece && !foundSquare; row--)
						{
							if (board[row][col2].equals(" "))
							{
								if (row == row2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[row][col2].charAt(0)))
								{
									if (row == row2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
				}
				if (!foundSquare)
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
				blackPawnCol = -1;
			}
			else if (piece.equals("k"))
			{
				if (Math.abs(row2 - row1) <= 1 && Math.abs(col2 - col1) <= 1)
				{
					if (!attackAt(row2, col2) && !Character.isLowerCase(board[row2][col2].charAt(0)))
					{
						board[row1][col1] = " ";
						board[row2][col2] = piece;
					}
					else
					{
						return false;
					}
				}
				else if (!blackKingHasMoved && !h8RookHasMoved && col2 == col1 + 2 && row1 == row2 && !kingIsInCheck() && !attackAt(0, 5) && board[0][5].equals(" ") && !attackAt(0, 6) && board[0][6].equals(" ") && !attackAt(row2, col2) && board[row2][col2].equals(" "))
				{
					board[row1][col1] = " ";
					board[row2][col2] = piece;
					String rook = board[0][7];
					board[0][7] = " ";
					board[0][5] = rook;
					h8RookHasMoved = true;
				}
				else if (!blackKingHasMoved && !a8RookHasMoved && col2 == col1 - 2 && row1 == row2 && !kingIsInCheck() && board[0][1].equals(" ") && !attackAt(0, 2) && board[0][2].equals(" ") && !attackAt(0, 3) && board[0][3].equals(" ") && !attackAt(row2, col2) && board[row2][col2].equals(" "))
				{
					board[row1][col1] = " ";
					board[row2][col2] = piece;
					String rook = board[0][0];
					board[0][0] = " ";
					board[0][3] = rook;
					a8RookHasMoved = true;
				}
				else
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
				blackPawnCol = -1;
				blackKingHasMoved = true;
			}
			else
			{
				return false;
			}
			if (kingIsInCheck())
			{
				board = copy;
				return false;
			}
			whitesMove = true;
		}
		return true;
	}
	
	/**
	 * Tests whether moving a piece from board[row1][col1] to board[row2][col2] is
	 * possible without adjusting instance fields.
	 * @param row1 the row of the piece to move
	 * @param col1 the column of the piece to move
	 * @param row2 the row of the destination square
	 * @param col2 the column of the destination square
	 * @return true if the move can be successfully made, false otherwise.
	 */
	public boolean testMove(int row1, int col1, int row2, int col2)
	{
		String[][] copy = copyBoard();
		String piece = board[row1][col1];
		boolean hitPiece = false;
		boolean foundSquare = false;
		int r;
		int c;
		if (whitesMove)
		{
			if (piece.equals("P"))
			{
				if (row2 == row1 - 1)
				{
					if (col2 == col1 + 1 || col2 == col1 - 1)
					{
						if (Character.isLowerCase(board[row2][col2].charAt(0)))
						{
							board[row1][col1] = " ";
							board[row2][col2] = piece;
						}
						else if (blackPawnCol >= 0)
						{
							if (row1 == 3 && Math.abs(col1 - col2) == 1 && col2 == blackPawnCol)
							{
								board[row1][col1] = " ";
								board[row1][blackPawnCol] = " ";
								board[row2][col2] = piece;
							}
							else
							{
								return false;
							}
						}
						else
						{
							return false;
						}
					}
					else if (col2 == col1)
					{
						if (board[row2][col2].equals(" "))
						{
							board[row1][col1] = " ";
							board[row2][col2] = piece;
						}
						else
						{
							return false;
						}
					}
					else
					{
						return false;
					}
				}
				else if (row2 == row1 - 2 && col2 == col1 && row1 == 6)
				{
					if (board[row2 + 1][col2].equals(" ") && board[row2][col2].equals(" "))
					{
						board[row1][col1] = " ";
						board[row2][col2] = piece;
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
			}
			else if (piece.equals("N"))
			{
				if (Math.abs(row2 - row1) == 2 && Math.abs(col2 - col1) == 1)
				{
					if (!Character.isUpperCase(board[row2][col2].charAt(0)))
					{
						board[row1][col1] = " ";
						board[row2][col2] = piece;
					}
					else
					{
						return false;
					}
				}
				else if (Math.abs(row2 - row1) == 1 && Math.abs(col2 - col1) == 2)
				{
					if (!Character.isUpperCase(board[row2][col2].charAt(0)))
					{
						board[row1][col1] = " ";
						board[row2][col2] = piece;
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
			}
			else if (piece.equals("B"))
			{
				if (row2 > row1)
				{
					if (col2 > col1)
					{
						r = row1 + 1;
						c = col1 + 1;
						while (r < ROWS && c < COLUMNS && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r++;
							c++;
						}
					}
					else if (col2 < col1)
					{
						r = row1 + 1;
						c = col1 - 1;
						while (r < ROWS && c >= 0 && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r++;
							c--;
						}
					}
				}
				else if (row2 < row1)
				{
					if (col2 > col1)
					{
						r = row1 - 1;
						c = col1 + 1;
						while (r >= 0 && c < COLUMNS && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r--;
							c++;
						}
					}
					else if (col2 < col1)
					{
						r = row1 - 1;
						c = col1 - 1;
						while (r >= 0 && c >= 0 && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r--;
							c--;
						}
					}
				}
				if (!foundSquare)
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
			}
			else if (piece.equals("R"))
			{
				if (row2 == row1)
				{
					if (col2 > col1)
					{
						for (int col = col1 + 1; col < COLUMNS && !hitPiece && !foundSquare; col++)
						{
							if (board[row2][col].equals(" "))
							{
								if (col == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[row2][col].charAt(0)))
								{
									if (col == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
					else if (col2 < col1)
					{
						for (int col = col1 - 1; col >= 0 && !hitPiece && !foundSquare; col--)
						{
							if (board[row2][col].equals(" "))
							{
								if (col == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[row2][col].charAt(0)))
								{
									if (col == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
				}
				else if (col2 == col1)
				{
					if (row2 > row1)
					{
						for (int row = row1 + 1; row < ROWS && !hitPiece && !foundSquare; row++)
						{
							if (board[row][col2].equals(" "))
							{
								if (row == row2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[row][col2].charAt(0)))
								{
									if (row == row2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
					else if (row2 < row1)
					{
						for (int row = row1 - 1; row >= 0 && !hitPiece && !foundSquare; row--)
						{
							if (board[row][col2].equals(" "))
							{
								if (row == row2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[row][col2].charAt(0)))
								{
									if (row == row2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
				}
				if (!foundSquare)
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
			}
			else if (piece.equals("Q"))
			{
				if (row2 > row1)
				{
					if (col2 > col1)
					{
						r = row1 + 1;
						c = col1 + 1;
						while (r < ROWS && c < COLUMNS && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r++;
							c++;
						}
					}
					else if (col2 < col1)
					{
						r = row1 + 1;
						c = col1 - 1;
						while (r < ROWS && c >= 0 && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r++;
							c--;
						}
					}
				}
				else if (row2 < row1)
				{
					if (col2 > col1)
					{
						r = row1 - 1;
						c = col1 + 1;
						while (r >= 0 && c < COLUMNS && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r--;
							c++;
						}
					}
					else if (col2 < col1)
					{
						r = row1 - 1;
						c = col1 - 1;
						while (r >= 0 && c >= 0 && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r--;
							c--;
						}
					}
				}
				if (row2 == row1)
				{
					if (col2 > col1)
					{
						for (int col = col1 + 1; col < COLUMNS && !hitPiece && !foundSquare; col++)
						{
							if (board[row2][col].equals(" "))
							{
								if (col == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[row2][col].charAt(0)))
								{
									if (col == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
					else if (col2 < col1)
					{
						for (int col = col1 - 1; col >= 0 && !hitPiece && !foundSquare; col--)
						{
							if (board[row2][col].equals(" "))
							{
								if (col == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[row2][col].charAt(0)))
								{
									if (col == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
				}
				else if (col2 == col1)
				{
					if (row2 > row1)
					{
						for (int row = row1 + 1; row < ROWS && !hitPiece && !foundSquare; row++)
						{
							if (board[row][col2].equals(" "))
							{
								if (row == row2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[row][col2].charAt(0)))
								{
									if (row == row2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
					else if (row2 < row1)
					{
						for (int row = row1 - 1; row >= 0 && !hitPiece && !foundSquare; row--)
						{
							if (board[row][col2].equals(" "))
							{
								if (row == row2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isLowerCase(board[row][col2].charAt(0)))
								{
									if (row == row2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
				}
				if (!foundSquare)
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
			}
			else if (piece.equals("K"))
			{
				if (Math.abs(row2 - row1) <= 1 && Math.abs(col2 - col1) <= 1)
				{
					if (!attackAt(row2, col2) && !Character.isUpperCase(board[row2][col2].charAt(0)))
					{
						board[row1][col1] = " ";
						board[row2][col2] = piece;
					}
					else
					{
						return false;
					}
				}
				else if (!whiteKingHasMoved && !h1RookHasMoved && col2 == col1 + 2 && row1 == row2 && !kingIsInCheck() && !attackAt(7, 5) && board[7][5].equals(" ") && !attackAt(7, 6) && board[7][6].equals(" ") && !attackAt(row2, col2) && board[row2][col2].equals(" "))
				{
					board[row1][col1] = " ";
					board[row2][col2] = piece;
					String rook = board[7][7];
					board[7][7] = " ";
					board[7][5] = rook;
				}
				else if (!whiteKingHasMoved && !a1RookHasMoved && col2 == col1 - 2 && row1 == row2 && !kingIsInCheck() && board[7][1].equals(" ") && !attackAt(7, 2) && board[7][2].equals(" ") && !attackAt(7, 3) && board[7][3].equals(" ") && !attackAt(row2, col2) && board[row2][col2].equals(" "))
				{
					board[row1][col1] = " ";
					board[row2][col2] = piece;
					String rook = board[7][0];
					board[7][0] = " ";
					board[7][3] = rook;
				}
				else
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		else
		{
			if (piece.equals("p"))
			{
				if (row2 == row1 + 1)
				{
					if (col2 == col1 + 1 || col2 == col1 - 1)
					{
						if (Character.isUpperCase(board[row2][col2].charAt(0)))
						{
							board[row1][col1] = " ";
							board[row2][col2] = piece;
						}
						else if (whitePawnCol >= 0)
						{
							if (row1 == 4 && Math.abs(col1 - col2) == 1 && col2 == whitePawnCol)
							{
								board[row1][col1] = " ";
								board[row1][whitePawnCol] = " ";
								board[row2][col2] = piece;
							}
							else
							{
								return false;
							}
						}
						else
						{
							return false;
						}
					}
					else if (col2 == col1)
					{
						if (board[row2][col2].equals(" "))
						{
							board[row1][col1] = " ";
							board[row2][col2] = piece;
						}
						else
						{
							return false;
						}
					}
					else
					{
						return false;
					}
				}
				else if (row2 == row1 + 2 && col2 == col1 && row1 == 1)
				{
					if (board[row2 - 1][col2].equals(" ") && board[row2][col2].equals(" "))
					{
						board[row1][col1] = " ";
						board[row2][col2] = piece;
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
			}
			else if (piece.equals("n"))
			{
				if (Math.abs(row2 - row1) == 2 && Math.abs(col2 - col1) == 1)
				{
					if (!Character.isLowerCase(board[row2][col2].charAt(0)))
					{
						board[row1][col1] = " ";
						board[row2][col2] = piece;
					}
					else
					{
						return false;
					}
				}
				else if (Math.abs(row2 - row1) == 1 && Math.abs(col2 - col1) == 2)
				{
					if (!Character.isLowerCase(board[row2][col2].charAt(0)))
					{
						board[row1][col1] = " ";
						board[row2][col2] = piece;
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
			}
			else if (piece.equals("b"))
			{
				if (row2 > row1)
				{
					if (col2 > col1)
					{
						r = row1 + 1;
						c = col1 + 1;
						while (r < ROWS && c < COLUMNS && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r++;
							c++;
						}
					}
					else if (col2 < col1)
					{
						r = row1 + 1;
						c = col1 - 1;
						while (r < ROWS && c >= 0 && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r++;
							c--;
						}
					}
				}
				else if (row2 < row1)
				{
					if (col2 > col1)
					{
						r = row1 - 1;
						c = col1 + 1;
						while (r >= 0 && c < COLUMNS && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r--;
							c++;
						}
					}
					else if (col2 < col1)
					{
						r = row1 - 1;
						c = col1 - 1;
						while (r >= 0 && c >= 0 && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r--;
							c--;
						}
					}
				}
				if (!foundSquare)
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
			}
			else if (piece.equals("r"))
			{
				if (row2 == row1)
				{
					if (col2 > col1)
					{
						for (int col = col1 + 1; col < COLUMNS && !hitPiece && !foundSquare; col++)
						{
							if (board[row2][col].equals(" "))
							{
								if (col == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[row2][col].charAt(0)))
								{
									if (col == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
					else if (col2 < col1)
					{
						for (int col = col1 - 1; col >= 0 && !hitPiece && !foundSquare; col--)
						{
							if (board[row2][col].equals(" "))
							{
								if (col == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[row2][col].charAt(0)))
								{
									if (col == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
				}
				else if (col2 == col1)
				{
					if (row2 > row1)
					{
						for (int row = row1 + 1; row < ROWS && !hitPiece && !foundSquare; row++)
						{
							if (board[row][col2].equals(" "))
							{
								if (row == row2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[row][col2].charAt(0)))
								{
									if (row == row2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
					else if (row2 < row1)
					{
						for (int row = row1 - 1; row >= 0 && !hitPiece && !foundSquare; row--)
						{
							if (board[row][col2].equals(" "))
							{
								if (row == row2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[row][col2].charAt(0)))
								{
									if (row == row2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
				}
				if (!foundSquare)
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
			}
			else if (piece.equals("q"))
			{
				if (row2 > row1)
				{
					if (col2 > col1)
					{
						r = row1 + 1;
						c = col1 + 1;
						while (r < ROWS && c < COLUMNS && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r++;
							c++;
						}
					}
					else if (col2 < col1)
					{
						r = row1 + 1;
						c = col1 - 1;
						while (r < ROWS && c >= 0 && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r++;
							c--;
						}
					}
				}
				else if (row2 < row1)
				{
					if (col2 > col1)
					{
						r = row1 - 1;
						c = col1 + 1;
						while (r >= 0 && c < COLUMNS && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r--;
							c++;
						}
					}
					else if (col2 < col1)
					{
						r = row1 - 1;
						c = col1 - 1;
						while (r >= 0 && c >= 0 && !hitPiece && !foundSquare)
						{
							if (board[r][c].equals(" "))
							{
								if (r == row2 && c == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[r][c].charAt(0)))
								{
									if (r == row2 && c == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
							r--;
							c--;
						}
					}
				}
				if (row2 == row1)
				{
					if (col2 > col1)
					{
						for (int col = col1 + 1; col < COLUMNS && !hitPiece && !foundSquare; col++)
						{
							if (board[row2][col].equals(" "))
							{
								if (col == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[row2][col].charAt(0)))
								{
									if (col == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
					else if (col2 < col1)
					{
						for (int col = col1 - 1; col >= 0 && !hitPiece && !foundSquare; col--)
						{
							if (board[row2][col].equals(" "))
							{
								if (col == col2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[row2][col].charAt(0)))
								{
									if (col == col2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
				}
				else if (col2 == col1)
				{
					if (row2 > row1)
					{
						for (int row = row1 + 1; row < ROWS && !hitPiece && !foundSquare; row++)
						{
							if (board[row][col2].equals(" "))
							{
								if (row == row2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[row][col2].charAt(0)))
								{
									if (row == row2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
					else if (row2 < row1)
					{
						for (int row = row1 - 1; row >= 0 && !hitPiece && !foundSquare; row--)
						{
							if (board[row][col2].equals(" "))
							{
								if (row == row2)
								{
									foundSquare = true;
									board[row1][col1] = " ";
									board[row2][col2] = piece;
								}
							}
							else
							{
								hitPiece = true;
								if (Character.isUpperCase(board[row][col2].charAt(0)))
								{
									if (row == row2)
									{
										foundSquare = true;
										board[row1][col1] = " ";
										board[row2][col2] = piece;
									}
								}
							}
						}
					}
				}
				if (!foundSquare)
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
			}
			else if (piece.equals("k"))
			{
				if (Math.abs(row2 - row1) <= 1 && Math.abs(col2 - col1) <= 1)
				{
					if (!attackAt(row2, col2) && !Character.isLowerCase(board[row2][col2].charAt(0)))
					{
						board[row1][col1] = " ";
						board[row2][col2] = piece;
					}
					else
					{
						return false;
					}
				}
				else if (!blackKingHasMoved && !h8RookHasMoved && col2 == col1 + 2 && row1 == row2 && !kingIsInCheck() && !attackAt(0, 5) && board[0][5].equals(" ") && !attackAt(0, 6) && board[0][6].equals(" ") && !attackAt(row2, col2) && board[row2][col2].equals(" "))
				{
					board[row1][col1] = " ";
					board[row2][col2] = piece;
					String rook = board[0][7];
					board[0][7] = " ";
					board[0][5] = rook;
				}
				else if (!blackKingHasMoved && !a8RookHasMoved && col2 == col1 - 2 && row1 == row2 && !kingIsInCheck() && board[0][1].equals(" ") && !attackAt(0, 2) && board[0][2].equals(" ") && !attackAt(0, 3) && board[0][3].equals(" ") && !attackAt(row2, col2) && board[row2][col2].equals(" "))
				{
					board[row1][col1] = " ";
					board[row2][col2] = piece;
					String rook = board[0][0];
					board[0][0] = " ";
					board[0][3] = rook;
				}
				else
				{
					return false;
				}
				if (kingIsInCheck())
				{
					board = copy;
					return false;
				}
			}
			else
			{
				return false;
			}
			if (kingIsInCheck())
			{
				board = copy;
				return false;
			}
		}
		board = copy;
		return true;
	}
	
	/**
	 * Gets the king row, of the white king if it is white's move, of the black
	 * king otherwise.
	 * @return the king row.
	 */
	public int getKingRow()
	{
		int kingRow = 0;
		if (whitesMove)
		{
			for (int r = 0; r < ROWS; r++)
			{
				for (int c = 0; c < COLUMNS; c++)
				{
					if (board[r][c] == "K")
					{
						kingRow = r;
					}
				}
			}
		}
		else
		{
			for (int r = 0; r < ROWS; r++)
			{
				for (int c = 0; c < COLUMNS; c++)
				{
					if (board[r][c] == "k")
					{
						kingRow = r;
					}
				}
			}
		}
		return kingRow;
	}
	
	/**
	 * Gets the king column, of the white king if it is white's move, of the black
	 * king otherwise.
	 * @return the king column.
	 */
	public int getKingColumn()
	{
		int kingColumn = 0;
		if (whitesMove)
		{
			for (int r = 0; r < ROWS; r++)
			{
				for (int c = 0; c < COLUMNS; c++)
				{
					if (board[r][c] == "K")
					{
						kingColumn = c;
					}
				}
			}
		}
		else
		{
			for (int r = 0; r < ROWS; r++)
			{
				for (int c = 0; c < COLUMNS; c++)
				{
					if (board[r][c] == "k")
					{
						kingColumn = c;
					}
				}
			}
		}
		return kingColumn;
	}
	
	/**
	 * Tests whether the current position on the board is checkmate.
	 * @return true if checkmate, false otherwise
	 */
	public boolean checkmate()
	{
		boolean checkmate = true;
		for (int r = 0; r < ROWS; r++)
		{
			for (int c = 0; c < COLUMNS; c++)
			{
				if (hasLegalMoves(r, c))
				{
					checkmate = false;
				}
			}
		}
		if (checkmate)
		{
			if (!kingIsInCheck())
			{
				return false;
			}
		}
		return checkmate;
	}
	
	/**
	 * Tests whether the current position on the board is stalemate.
	 * @return true if stalemate, false otherwise
	 */
	public boolean stalemate()
	{
		boolean stalemate = true;
		for (int r = 0; r < ROWS; r++)
		{
			for (int c = 0; c < COLUMNS; c++)
			{
				if (hasLegalMoves(r, c))
				{
					stalemate = false;
				}
			}
		}
		if (stalemate)
		{
			if (kingIsInCheck())
			{
				return false;
			}
		}
		return stalemate;
	}
	
	/**
	 * Tests whether a piece at board[row1][col1] has any legal moves.
	 * @param row1 the row of the piece to test
	 * @param col1 the col of the piece to test
	 * @return
	 */
	public boolean hasLegalMoves(int row1, int col1)
	{
		boolean hasLegalMv = false;
		for (int r = 0; r < ROWS && !hasLegalMv; r++)
		{
			for (int c = 0; c < COLUMNS && !hasLegalMv; c++)
			{
				if (testMove(row1, col1, r, c))
				{
					hasLegalMv = true;
				}
			}
		}
		return hasLegalMv;
	}
	
	/**
	 * Tests whether a king is in check.
	 * Tests for white's king if it is white's move, tests for black's king
	 * otherwise.
	 * @return
	 */
	public boolean kingIsInCheck()
	{
		int kingRow = getKingRow();
		int kingColumn = getKingColumn();
		return attackAt(kingRow, kingColumn);
	}
	
	/**
	 * Determines whether there is an attack at board[row][col].
	 * @param row the row of the square to test
	 * @param col the column of the square to test
	 * @return true if there is an attack, false otherwise
	 */
	public boolean attackAt(int row, int col)
	{
		if (horizontalAttackAt(row, col) || verticalAttackAt(row, col) || diagonalAttackAt(row, col) || knightAttackAt(row, col))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Determines whether there is an attack at board[row][col] from the
	 * right or left.
	 * @param row the row of the square to test
	 * @param col the column of the square to test
	 * @return true if there is an attack from right or left, false otherwise
	 */
	public boolean horizontalAttackAt(int row, int col)
	{
		boolean hitPiece = false;
		for (int c = col + 1; c < COLUMNS && !hitPiece; c++)
		{
			if (!board[row][c].equals(" "))
			{
				hitPiece = true;
				if (whitesMove)
				{
					if (c == col + 1)
					{
						if (board[row][c].equals("k"))
						{
							return true;
						}
					}
					if (board[row][c].equals("r") || board[row][c].equals("q"))
					{
						return true;
					}
				}
				else
				{
					if (c == col + 1)
					{
						if (board[row][c].equals("K"))
						{
							return true;
						}
					}
					if (board[row][c].equals("R") || board[row][c].equals("Q"))
					{
						return true;
					}
				}
			}
		}
		hitPiece = false;
		for (int c = col - 1; c >= 0 && !hitPiece; c--)
		{
			if (!board[row][c].equals(" "))
			{
				hitPiece = true;
				if (whitesMove)
				{
					if (c == col - 1)
					{
						if (board[row][c].equals("k"))
						{
							return true;
						}
					}
					if (board[row][c].equals("r") || board[row][c].equals("q"))
					{
						return true;
					}
				}
				else
				{
					if (c == col - 1)
					{
						if (board[row][c].equals("K"))
						{
							return true;
						}
					}
					if (board[row][c].equals("R") || board[row][c].equals("Q"))
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Determines whether there is an attack at board[row][col] from above
	 * or below.
	 * @param row the row of the square to test
	 * @param col the column of the square to test
	 * @return true if there is an attack from above or below, false otherwise
	 */
	public boolean verticalAttackAt(int row, int col)
	{
		boolean hitPiece = false;
		for (int r = row + 1; r < ROWS && !hitPiece; r++)
		{
			if (!board[r][col].equals(" "))
			{
				hitPiece = true;
				if (whitesMove)
				{
					if (r == row + 1)
					{
						if (board[r][col].equals("k"))
						{
							return true;
						}
					}
					if (board[r][col].equals("r") || board[r][col].equals("q"))
					{
						return true;
					}
				}
				else
				{
					if (r == row + 1)
					{
						if (board[r][col].equals("K"))
						{
							return true;
						}
					}
					if (board[r][col].equals("R") || board[r][col].equals("Q"))
					{
						return true;
					}
				}
			}
		}
		hitPiece = false;
		for (int r = row - 1; r >= 0 && !hitPiece; r--)
		{
			if (!board[r][col].equals(" "))
			{
				hitPiece = true;
				if (whitesMove)
				{
					if (r == row - 1)
					{
						if (board[r][col].equals("k"))
						{
							return true;
						}
					}
					if (board[r][col].equals("r") || board[r][col].equals("q"))
					{
						return true;
					}
				}
				else
				{
					if (r == row - 1)
					{
						if (board[r][col].equals("K"))
						{
							return true;
						}
					}
					if (board[r][col].equals("R") || board[r][col].equals("Q"))
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Determines whether there is an attack at board[row][col] from the diagonals.
	 * @param row the row of the square to test
	 * @param col the column of the square to test
	 * @return true if there is an attack from the diagonals, false otherwise
	 */
	public boolean diagonalAttackAt(int row, int col)
	{
		int r = row - 1;
		int c = col - 1;
		boolean hitPiece = false;
		while (r >= 0 && c >= 0 && !hitPiece)
		{
			if (!board[r][c].equals(" "))
			{
				hitPiece = true;
				if (whitesMove)
				{
					if (c == col - 1)
					{
						if (board[r][c].equals("p") || board[r][c].equals("k"))
						{
							return true;
						}
					}
					if (board[r][c].equals("b") || board[r][c].equals("q"))
					{
						return true;
					}
				}
				else
				{
					if (c == col - 1)
					{
						if (board[r][c].equals("K"))
						{
							return true;
						}
					}
					if (board[r][c].equals("B") || board[r][c].equals("Q"))
					{
						return true;
					}
				}
			}
			r--;
			c--;
		}
		hitPiece = false;
		r = row - 1;
		c = col + 1;
		while (r >= 0 && c < COLUMNS && !hitPiece)
		{
			if (!board[r][c].equals(" "))
			{
				hitPiece = true;
				if (whitesMove)
				{
					if (c == col + 1)
					{
						if (board[r][c].equals("p") || board[r][c].equals("k"))
						{
							return true;
						}
					}
					if (board[r][c].equals("b") || board[r][c].equals("q"))
					{
						return true;
					}
				}
				else
				{
					if (c == col + 1)
					{
						if (board[r][c].equals("K"))
						{
							return true;
						}
					}
					if (board[r][c].equals("B") || board[r][c].equals("Q"))
					{
						return true;
					}
				}
			}
			r--;
			c++;
		}
		hitPiece = false;
		r = row + 1;
		c = col - 1;
		while (r < ROWS && c >= 0 && !hitPiece)
		{
			if (!board[r][c].equals(" "))
			{
				hitPiece = true;
				if (whitesMove)
				{
					if (c == col - 1)
					{
						if (board[r][c].equals("k"))
						{
							return true;
						}
					}
					if (board[r][c].equals("b") || board[r][c].equals("q"))
					{
						return true;
					}
				}
				else
				{
					if (c == col - 1)
					{
						if (board[r][c].equals("P") || board[r][c].equals("K"))
						{
							return true;
						}
					}
					if (board[r][c].equals("B") || board[r][c].equals("Q"))
					{
						return true;
					}
				}
			}
			r++;
			c--;
		}
		hitPiece = false;
		r = row + 1;
		c = col + 1;
		while (r < ROWS && c < COLUMNS && !hitPiece)
		{
			if (!board[r][c].equals(" "))
			{
				hitPiece = true;
				if (whitesMove)
				{
					if (c == col + 1)
					{
						if (board[r][c].equals("k"))
						{
							return true;
						}
					}
					if (board[r][c].equals("b") || board[r][c].equals("q"))
					{
						return true;
					}
				}
				else
				{
					if (c == col + 1)
					{
						if (board[r][c].equals("P") || board[r][c].equals("K"))
						{
							return true;
						}
					}
					if (board[r][c].equals("B") || board[r][c].equals("Q"))
					{
						return true;
					}
				}
			}
			r++;
			c++;
		}
		return false;
	}
	
	/**
	 * Determines whether there is an attack at board[row][col] from a knight.
	 * @param row the row of the square to test
	 * @param col the column of the square to test
	 * @return true if there is an attack from a knight, false otherwise
	 */
	public boolean knightAttackAt(int row, int col)
	{
		if (row - 2 >= 0 && row - 2 < ROWS)
		{
			if (whitesMove)
			{
				if (col + 1 >= 0 && col + 1 < COLUMNS)
				{
					if (board[row - 2][col + 1].equals("n"))
					{
						return true;
					}
				}
				if (col - 1 >= 0 && col - 1 < COLUMNS)
				{
					if (board[row - 2][col - 1].equals("n"))
					{
						return true;
					}
				}
			}
			else
			{
				if (col + 1 >= 0 && col + 1 < COLUMNS)
				{
					if (board[row - 2][col + 1].equals("N"))
					{
						return true;
					}
				}
				if (col - 1 >= 0 && col - 1 < COLUMNS)
				{
					if (board[row - 2][col - 1].equals("N"))
					{
						return true;
					}
				}
			}
		}
		if (row + 2 >= 0 && row + 2 < ROWS)
		{
			if (whitesMove)
			{
				if (col + 1 >= 0 && col + 1 < COLUMNS)
				{
					if (board[row + 2][col + 1].equals("n"))
					{
						return true;
					}
				}
				if (col - 1 >= 0 && col - 1 < COLUMNS)
				{
					if (board[row + 2][col - 1].equals("n"))
					{
						return true;
					}
				}
			}
			else
			{
				if (col + 1 >= 0 && col + 1 < COLUMNS)
				{
					if (board[row + 2][col + 1].equals("N"))
					{
						return true;
					}
				}
				if (col - 1 >= 0 && col - 1 < COLUMNS)
				{
					if (board[row + 2][col - 1].equals("N"))
					{
						return true;
					}
				}
			}
		}
		if (col - 2 >= 0 && col - 2 < COLUMNS)
		{
			if (whitesMove)
			{
				if (row + 1 >= 0 && row + 1 < ROWS)
				{
					if (board[row + 1][col - 2].equals("n"))
					{
						return true;
					}
				}
				if (row - 1 >= 0 && row - 1 < ROWS)
				{
					if (board[row - 1][col - 2].equals("n"))
					{
						return true;
					}
				}
			}
			else
			{
				if (row + 1 >= 0 && row + 1 < ROWS)
				{
					if (board[row + 1][col - 2].equals("N"))
					{
						return true;
					}
				}
				if (row - 1 >= 0 && row - 1 < ROWS)
				{
					if (board[row - 1][col - 2].equals("N"))
					{
						return true;
					}
				}
			}
		}
		if (col + 2 >= 0 && col + 2 < COLUMNS)
		{
			if (whitesMove)
			{
				if (row + 1 >= 0 && row + 1 < ROWS)
				{
					if (board[row + 1][col + 2].equals("n"))
					{
						return true;
					}
				}
				if (row - 1 >= 0 && row - 1 < ROWS)
				{
					if (board[row - 1][col + 2].equals("n"))
					{
						return true;
					}
				}
			}
			else
			{
				if (row + 1 >= 0 && row + 1 < ROWS)
				{
					if (board[row + 1][col + 2].equals("N"))
					{
						return true;
					}
				}
				if (row - 1 >= 0 && row - 1 < ROWS)
				{
					if (board[row - 1][col + 2].equals("N"))
					{
						return true;
					}
				}
			}
		}
		return false;
	}
}
