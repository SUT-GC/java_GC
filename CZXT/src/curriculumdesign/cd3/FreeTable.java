package curriculumdesign.cd3;

public class FreeTable {
	private int STARTADD;
	private int FREESIZE;
	public int getSTARTADD() {
		return STARTADD;
	}
	public void setSTARTADD(int sTARTADD) {
		this.STARTADD = sTARTADD;
	}
	public int getFREESIZE() {
		return FREESIZE;
	}
	public void setFREESIZE(int fREESIZE) {
		FREESIZE = fREESIZE;
	}
	@Override
	public String toString() {
		return " [起始地址=" + STARTADD + ", 终止地址="+(STARTADD+FREESIZE-1)+", 空闲大小=" + FREESIZE
				+ "]";
	}
	
}
