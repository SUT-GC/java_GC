import java.util.concurrent.ThreadLocalRandom;

public class GoBangAI {
	private int BOARD_SIZE;
	private int X;
	private int Y;
	private int BLACK_X;
	private int BLACK_Y;
	private boolean WHITE_WIN = false;
	private boolean BLACK_WIN = false;
	private ThreadLocalRandom random = ThreadLocalRandom.current();

	public void AI(int[][] board, int board_szie) {
		this.BOARD_SIZE = board_szie;
		X = random.nextInt(0, BOARD_SIZE-1);
		Y = random.nextInt(0, BOARD_SIZE-1);
		System.out.println(X+"     "+Y);
		while (board[X][Y] != 0) {
			X = random.nextInt(0, BOARD_SIZE-1);
			Y = random.nextInt(0, BOARD_SIZE-1);
		}
		board[X][Y] = 1;
		// System.out.println(X + " " + Y);
	}
	public void WhiteWinOrNotWin(int[][] board){
		int count = 0;
		int tempx = X;
		int tempy = Y;
		System.out.println(X+"  "+Y);
		while(tempx>=0 && tempy >=0 && board[tempx][tempy] == 1 ){
			tempx -= 1;
			tempy -= 1;
			count++;
		}
		if(count >= 5){
			WHITE_WIN = true;
			return;
		}else{
			tempx = X+1;
			tempy = Y+1;
			while(tempx<BOARD_SIZE && tempy <BOARD_SIZE && board[tempx][tempy] == 1){
				tempx += 1;
				tempy += 1;
				count++;
			}
		}
		if(count >= 5){
			WHITE_WIN = true;
			return;
		}else{
			count =0;
			tempx = X;
			tempy = Y;
			while( tempx>=0 && tempy >=0 && board[tempx][tempy] == 1){
				tempx -= 1;
				count++;
			}
			if(count >= 5){
				WHITE_WIN = true;
				return;
			}else{
				tempx = X+1;
				while(tempx<BOARD_SIZE && tempy >=0 && board[tempx][tempy] == 1){
					tempx += 1;
					count++;
				}
			}
			if(count >= 5){
				WHITE_WIN = true;
				return;
			}else{
				count = 0;
				tempx = X;
				tempy = Y;
				while(tempx>=0 && tempy >=0 && board[tempx][tempy] == 1){
					tempy -= 1;
					count++;
				}
				if(count >= 5){
					WHITE_WIN = true;
					return;
				}else{
					tempy = Y+1;
					while(tempx>=0 && tempy <= BOARD_SIZE && board[tempx][tempy] == 1){
						tempy += 1;
						count++;
					}
				}
				if(count >= 5){
					WHITE_WIN = true;
					return;
				}else{
					count = 0;
					tempx = X;
					tempy = Y;
					while( tempx<BOARD_SIZE && tempy >=0 && board[tempx][tempy] == 1){
						tempx += 1;
						tempy -= 1;
						count++;
					}
					if(count >= 5){
						WHITE_WIN = true;
						return;
					}else{
						tempx = X-1;
						tempy = Y+1;
						while(tempx>=0 && tempy < BOARD_SIZE && board[tempx][tempy] == 1){
							tempx -= 1;
							tempy += 1;
							count++;
						}
					}
					if(count >= 5){
						WHITE_WIN = true;
						return;
					}
				}
			}
		}
	}
	public void blackWinOrNotWin(int[][] board){
		int count = 0;
		int tempx = BLACK_X;
		int tempy = BLACK_Y;
		while( tempx>=0 && tempy >=0 && board[tempx][tempy] == -1){
			tempx -= 1;
			tempy -= 1;
			count++;
		}
		if(count >= 5){
			BLACK_WIN = true;
			return;
		}else{
			tempx = BLACK_X+1;
			tempy = BLACK_Y+1;
			while(tempx< BOARD_SIZE && tempy < BOARD_SIZE && board[tempx][tempy] == -1){
				tempx += 1;
				tempy += 1;
				count++;
			}
		}
		if(count >= 5){
			BLACK_WIN = true;
			return;
		}else{
			count =0;
			tempx = BLACK_X;
			tempy = BLACK_Y;
			while(   tempx>=0 && tempy >=0 && board[tempx][tempy] == -1){
				tempx -= 1;
				count++;
			}
			if(count >= 5){
				BLACK_WIN = true;
				return;
			}else{
				tempx = BLACK_X+1;
				while(tempx<BOARD_SIZE && tempy >=0 && board[tempx][tempy] == -1){
					tempx += 1;
					count++;
				}
			}
			if(count >= 5){
				BLACK_WIN = true;
				return;
			}else{
				count = 0;
				tempx = BLACK_X;
				tempy = BLACK_Y;
				while( tempx>=0 && tempy >=0 && board[tempx][tempy] == -1){
					tempy -= 1;
					count++;
				}
				if(count >= 5){
					BLACK_WIN = true;
					return;
				}else{
					tempy = BLACK_Y+1;
					while(tempx>=0 && tempy <BOARD_SIZE && board[tempx][tempy] == -1){
						tempy += 1;
						count++;
					}
				}
				if(count >= 5){
					BLACK_WIN = true;
					return;
				}else{
					count = 0;
					tempx = BLACK_X;
					tempy = BLACK_Y;
					while(tempx<BOARD_SIZE && tempy >=0 && board[tempx][tempy] == -1){
						tempx += 1;
						tempy -= 1;
						count++;
					}
					if(count >= 5){
						BLACK_WIN = true;
						return;
					}else{
						tempx = BLACK_X-1;
						tempy = BLACK_Y+1;
						while(tempx>=0 && tempy <BOARD_SIZE && board[tempx][tempy] == -1){
							tempx -= 1;
							tempy += 1;
							count++;
						}
					}
					if(count >= 5){
						BLACK_WIN = true;
						return;
					}
				}
			}
		}
	}
	public void setWHITE_WIN(boolean wHITE_WIN) {
		WHITE_WIN = wHITE_WIN;
	}
	public void setBLACK_WIN(boolean bLACK_WIN) {
		BLACK_WIN = bLACK_WIN;
	}
	public void setBOARD_SIZE(int bOARD_SIZE) {
		BOARD_SIZE = bOARD_SIZE;
	}

	public boolean isWHITE_WIN() {
		return WHITE_WIN;
	}

	public boolean isBLACK_WIN() {
		return BLACK_WIN;
	}

	public void setBLACK_X(int bLACK_X) {
		BLACK_X = bLACK_X;
	}

	public void setBLACK_Y(int bLACK_Y) {
		BLACK_Y = bLACK_Y;
	}
}
