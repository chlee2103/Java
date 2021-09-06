package singletonAccount;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import bt210521.Ex01.AccountDtoCho;





public class Fileclass {
	
	private File file;

	public Fileclass(String filname) {
		file = new File("d:\\tmp\\" + filname + ".txt");
		
		createFile();
		fileLoad();
	}
	
	public void createFile() {
		try {
			if(file.createNewFile()) {
				System.out.println("파일 생성 성공!");
			}else {
				System.out.println("파일 생성 실패");
			}			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	public void fileLoad() {	
		
		Singletonclass si = Singletonclass.getInstence();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
						
			String str;
			while((str = br.readLine()) != null) {
				
				String data[] = str.split(",");
				String datas[] = data[1].split(" ");
				int money = Integer.parseInt(datas[4]);
				String use = datas[3].substring(3);
				if(datas.length == 6) {
					si.map.put(data[0], new AccountDtoCho(datas[1], datas[2], use, money, datas[5]));
				}else {
					si.map.put(data[0], new AccountDtoCho(datas[1], datas[2], use, money, ""));
				}
			}
			br.close();			
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}				
	}
	
	public void fileSave() {
		Singletonclass si = Singletonclass.getInstence();
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			Iterator<String> itkey = si.map.keySet().iterator();
			while(itkey.hasNext()) {
				String key = itkey.next();
				AccountDtoCho val = si.map.get(key);
				pw.println(key+", "+val);
			}
			pw.close();
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		System.out.println("파일에 저장되었습니다");
	}
}
