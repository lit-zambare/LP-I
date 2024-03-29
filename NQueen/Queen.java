import java.util.Scanner;

public class Queen {
	int N;
	void setN(int n)
	{
		this.N=n;
	}
	void printSolution(int board[][])
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(" "+board[i][j]+" ");
			}
			System.out.println();
		}
	}
	boolean isSafe(int board[][],int row,int col)
	{
		for(int i=0;i<=col;i++)
		{
			if(board[row][i]==1)
				return false;
		}
		
		for(int i=row,j=col;i>=0 && j>=0;i--,j--)
		{
			if(board[i][j]==1)
				return false;
		}
		
		for(int i=row,j=col;i<N && j>=0;i++,j--)
		{
			if(board[i][j]==1)
				return false;
		}
		return true;
	}
	
	boolean solveNQUtil(int board[][],int col)
	{
		if(col>=N)
			return true;
		
		for(int i=0;i<N;i++)
		{
			if(isSafe(board,i,col))
			{
				board[i][col]=1;
				if(solveNQUtil(board,col+1))
				{
					return true;
				}
				board[i][col]=0;
			}
		}
		return false;
	}
	
	boolean solve(int n)
	{
		int board[][]=new int[n][n];
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				board[i][j]=0;
			}
		}
		
		if(solveNQUtil(board,0)==false)
		{
			System.out.println("This problem cannot be solved");
		}
		printSolution(board);	
		return true;
	}
	public static void main(String args[])
	{
		Queen q=new Queen();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of N");
		int n=sc.nextInt();
		q.setN(n);
		q.solve(n);
		sc.close();
	}
}
