package Terminal.Simulation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TermianlBackstage {
	private String LS = "ls";
	private String CD = "cd";
	private String CLEAR = "clear";
	private String NEWFILE = "newfile";
	private String DELFILE = "delfile";
	private String CPFILE = "cpfile";
	private String LSALL = "ls all";
	private String CAT = "cat";
	private String HELP = "help";
	private String DefualtPath = ".";
	private String[] commands;
	private String result = null;

	public void startWork() {
		System.out.println(commands.length);
		if (commands.length == 1 && commands[0].equals(LS)) {
			lsCommandStart();
		} else if (commands.length == 2 && commands[0].equals(CD)) {
			cdCommandStart();
		} else if (commands.length == 1 && commands[0].equals(CLEAR)) {
			clearCommandStart();
		} else if (commands.length == 2 && commands[0].equals(NEWFILE)) {
			newfileCommandStart();
		} else if (commands.length == 2 && commands[0].equals(DELFILE)) {
			delfileCommandStart();
		} else if (commands.length == 3 && commands[0].equals("cpfile")) {
			cpfileCommandStart();
		}else if(commands.length == 2 && commands[0].equals("ls") && commands[1].equals("all")){
			lsallCommandStart();
		}else if(commands.length == 2 && commands[0].equals("cat")){
			catCommandStart();
		}else if(commands.length == 1 && commands[0].equals("help")){
			helpCommands();
		}else {
			result = "您输入的命令有误 , 请重新输入";
		}
	}
	private void helpCommands() {
		result = "";
		File file = new File("help.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			int count = 0;
			byte[] bytes = new byte[1024];
			while((count = fis.read(bytes))> 0 ){
				result += new String(bytes,0,count);
			}
		} catch (IOException e) {
			result = "help文档路径不正确....";
		}
	}
	private void catCommandStart() {
		File file = new File(DefualtPath+"/"+commands[1]);
		result = "";
		try {
			FileInputStream fis = new FileInputStream(file);
			int count = 0;
			byte[] bytes = new byte[1024];
			while((count = fis.read(bytes))> 0 ){
				result += new String(bytes,0,count);
			}
			
		} catch (IOException e) {
			result = "请输入正确的文件路径....";
		}
		
	}
	private void bfsFile(File file){
		String[] files = file.list();
		for(String filename: files){
			File nowFile = new File(file.getAbsolutePath()+"/"+filename);
			if(nowFile.isDirectory()){
				bfsFile(nowFile);
			}else{
				result += file.getAbsolutePath()+"/"+filename+"\n";
			}
		}
	}
	private void lsallCommandStart() {
		File file = new File(DefualtPath);
		bfsFile(file);
	}

	private void cpfileCommandStart() {
		File srcFile = new File(DefualtPath + "/" + commands[1]);
		File tarFile = new File(commands[2]);
		FileInputStream fis;
		FileOutputStream fos;
		byte[] bytes = new byte[1024];
		int count = 0;
		try {
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(tarFile);
			while ((count = fis.read(bytes)) > 0) {
				fos.write(bytes, 0, count);
			}
			result = "文件拷贝成功  !!!! ";
		} catch (IOException e) {
			result = "文件路径错误  !!!! ";
		}
	}

	private void delfileCommandStart() {
		try {
			File file = new File(DefualtPath + "/" + commands[1]);
			file.delete();
			result = "删除文件 " + DefualtPath + "/" + commands[1] + " 成功 !!!";
		} catch (Exception e) {
			result = "请输入正确的文件名,刪除失败......";
		}
	}

	public void newfileCommandStart() {
		File file = new File(DefualtPath + "/" + commands[1]);
		try {
			file.createNewFile();
		} catch (IOException e) {
			result = "请输入正确的文件路径,创建失败......";
		}
		result = "新建文件 " + DefualtPath + "/" + commands[1] + " 成功 !!!";
	}

	public void clearCommandStart() {
		result = CLEAR;
	}

	public void cdCommandStart() {
		try {
			if (commands[1].equals("../")) {
				System.out.println(commands[1]);
				File file = new File(DefualtPath);
				DefualtPath = file.getParentFile().getAbsolutePath() + "/";
				System.out.println(DefualtPath);
				result = "返回上级目录成功 !! ";
			} else {
				DefualtPath = commands[1];
				File file = new File(DefualtPath);
				result = "进入文件 : " + file.getAbsolutePath() + "  成功 !!!! ";
			}
		} catch (Exception e) {
			result = "进入目录失败,请检查目录格式是否正确 !! ";
		}
	}

	public void lsCommandStart() {
		File file = new File(DefualtPath);
		String[] files = file.list();
		for (String filename : files) {
			result += file.getAbsolutePath() + "/" + filename + "\n";
		}
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setCommands(String[] commands) {
		this.commands = commands;
	}
}
