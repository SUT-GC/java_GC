package curriculumdesign.cd3;

public class AllocationUnit {
	private String JOBNAME;
	private int STARTADD;
	private int JOBSIZE;
	private boolean ISFREE;
	public String getJOBNAME() {
		return JOBNAME;
	}
	public String toString() {
		return "[作业名称=" + JOBNAME + ", 起始地址=" + STARTADD
				+ ", 终止地址"+(STARTADD+JOBSIZE-1)+", 作业大小=" + JOBSIZE + "]";
	}
	public void setJOBNAME(String jOBNAME) {
		JOBNAME = jOBNAME;
	}
	public int getSTARTADD() {
		return STARTADD;
	}
	public void setSTARTADD(int sTARTADD) {
		STARTADD = sTARTADD;
	}
	public int getJOBSIZE() {
		return JOBSIZE;
	}
	public void setJOBSIZE(int jOBSIZE) {
		JOBSIZE = jOBSIZE;
	}
	public boolean isISFREE() {
		return ISFREE;
	}
	public void setISFREE(boolean iSFREE) {
		ISFREE = iSFREE;
	}
	
}
