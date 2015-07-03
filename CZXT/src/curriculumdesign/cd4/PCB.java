package curriculumdesign.cd4;

public class PCB {
	private int pid;

	public String toString() {
		return "PCB [pid=" + pid + ", timeneed=" + timeneed + ", priority="
				+ priority + "]";
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	private int timeneed;
	private int priority;

	public int getTimeneed() {
		return timeneed;
	}

	public void setTimeneed(int timeneed) {
		this.timeneed = timeneed;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
