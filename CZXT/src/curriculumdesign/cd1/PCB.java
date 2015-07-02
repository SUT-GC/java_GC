package curriculumdesign.cd1;

public class PCB {
	private int pid;
	private int ppid;
	private int pow;
	public PCB(int pid, int ppid, int pow){
		this.pid = pid;
		this.ppid = ppid;
		this.pow = pow;
	}
	public PCB(){
		
	}
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getPpid() {
		return ppid;
	}

	public void setPpid(int ppid) {
		this.ppid = ppid;
	}

	public int getPow() {
		return pow;
	}

	public void setPow(int pow) {
		this.pow = pow;
	}

}
