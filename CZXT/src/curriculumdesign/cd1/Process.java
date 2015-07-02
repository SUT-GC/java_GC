package curriculumdesign.cd1;

import java.util.Vector;

public class Process {
	private Vector<PCB> pcbs = new Vector<PCB>();

	public Process() {
		pcbs.clear();
	}

	public void createProcess(PCB pcb) {
		pcbs.add(pcb);
	}

	public Vector<PCB> getPcbs() {
		return pcbs;
	}

}
