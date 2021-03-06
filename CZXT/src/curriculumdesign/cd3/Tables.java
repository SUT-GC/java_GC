package curriculumdesign.cd3;

import java.util.Vector;

public class Tables {
	private Vector <AllocationUnit> distribution;
	private Vector <FreeTable> free;
	private int STARTID;
	private int FREESIZE;
	private int COUNT ;
	public Tables(int FREESIZE){
		distribution = new Vector<AllocationUnit>();
		free = new Vector<FreeTable>();
		STARTID = 0;
		COUNT = 0;
		this.FREESIZE = FREESIZE;
		FreeTable ft = new FreeTable();
		ft.setFREESIZE(FREESIZE);
		ft.setSTARTADD(0);
		free.add(ft);
	}
	private void checkFree(){
		for(int i = 0; i < free.size(); i++){
			if(free.get(i).getFREESIZE() == 0){
				free.remove(i);
			}
		}
		for(int i = 0; i < free.size(); i++){
			for(int j = 0; j < free.size(); j++){
				if((free.get(i).getSTARTADD()+free.get(i).getFREESIZE())==free.get(j).getSTARTADD()){
					free.get(i).setFREESIZE(free.get(i).getFREESIZE()+free.get(j).getFREESIZE());
					free.remove(j);
				}
			}
		}
		for(int i = 0; i < free.size(); i++){
			for(int j = 0; j < free.size(); j++){
				if(free.get(i).getSTARTADD()==(free.get(j).getSTARTADD()+free.get(j).getFREESIZE())){
					free.get(i).setSTARTADD(free.get(j).getSTARTADD());
					free.get(i).setFREESIZE(free.get(i).getFREESIZE()+free.get(j).getFREESIZE());
					free.remove(j);
				}
			}
		}
	}
	public void distributionJobFF(Job job){
		int count = 0;
		for(int i = 0; i < free.size(); i++){
			if(free.get(i).getFREESIZE() >= job.getSize()){
				count++;
				STARTID = free.get(i).getSTARTADD();
				AllocationUnit au1 = new AllocationUnit();
				au1.setJOBNAME(job.getName());
				au1.setJOBSIZE(job.getSize());
				au1.setSTARTADD(STARTID);
				au1.setISFREE(false);
				STARTID+=job.getSize();
				distribution.add(au1);
				FreeTable ft1 = new FreeTable();
				ft1.setSTARTADD(au1.getSTARTADD()+au1.getJOBSIZE());
				ft1.setFREESIZE(free.get(i).getFREESIZE()-job.getSize());
				free.remove(i);
				free.add(ft1);
				break;
			}
		}
		if(count == 0){
			System.out.println("内存不足以分配......");
		}
	}
	public void distributionJobNF(Job job){
		int count = 0;
		int c = 0;
		for(int i = COUNT; c <= free.size(); i++){
			c++;
			i = i % free.size();
			if(free.get(i).getFREESIZE() >= job.getSize()){
				count++;
				STARTID = free.get(i).getSTARTADD();
				AllocationUnit au1 = new AllocationUnit();
				au1.setJOBNAME(job.getName());
				au1.setJOBSIZE(job.getSize());
				au1.setSTARTADD(STARTID);
				au1.setISFREE(false);
				STARTID+=job.getSize();
				distribution.add(au1);
				FreeTable ft1 = new FreeTable();
				ft1.setSTARTADD(au1.getSTARTADD()+au1.getJOBSIZE());
				ft1.setFREESIZE(free.get(i).getFREESIZE()-job.getSize());
				free.remove(i);
				free.add(ft1);
				COUNT = i;
				break;
			}
		}
		if(count == 0){
			System.out.println("内存不足以分配......");
		}
	}
	public void distributionJobBF(Job job){
		int minmomery = 65;
		int mini = 0;
		for(int i = 0; i < free.size(); i++){
			if(free.get(i).getFREESIZE() >= job.getSize() && free.get(i).getFREESIZE() <= minmomery){
				minmomery = free.get(i).getFREESIZE();
				mini = i;
			}
		}
		if(minmomery == 65){
			System.out.println("内存不足以分配......");
			return;
		}
		STARTID = free.get(mini).getSTARTADD();
		AllocationUnit au1 = new AllocationUnit();
		au1.setJOBNAME(job.getName());
		au1.setJOBSIZE(job.getSize());
		au1.setSTARTADD(STARTID);
		au1.setISFREE(false);
		STARTID+=job.getSize();
		distribution.add(au1);
		FreeTable ft1 = new FreeTable();
		ft1.setSTARTADD(au1.getSTARTADD()+au1.getJOBSIZE());
		ft1.setFREESIZE(free.get(mini).getFREESIZE()-job.getSize());
		free.remove(mini);
		free.add(ft1);
	}
	public void recoveryMemory(String name){
		checkFree();
		for(int i = 0; i < distribution.size(); i++){
			if(distribution.get(i).getJOBNAME().equals(name)){
				FreeTable ft1 = new FreeTable();
				AllocationUnit au1 = distribution.get(i);
				ft1.setSTARTADD(au1.getSTARTADD());
				ft1.setFREESIZE(au1.getJOBSIZE());
				distribution.remove(i);
				free.add(ft1);
			}
		}
	}
	public void showDistribution(){
		System.out.println("------------------------------分配分区表 ------------------------------ ");
		for(int i = 0; i < distribution.size(); i++){
			if(distribution.get(i).isISFREE()){
				System.out.println("------------------------------------空表目 ");
			}else{
				System.out.println(distribution.get(i));
			}
		}
		System.out.println("---------------------------------------------------------------------------- ");
	}
	public void showFree(){
		checkFree();
		System.out.println("------------------------------空闲分区表------------------------------ ");
		for(int i = 0; i < free.size(); i++){
			System.out.println(free.get(i));
		}
		System.out.println("---------------------------------------------------------------------------- ");
	}
}
