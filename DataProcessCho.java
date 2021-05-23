package bt210521.Ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.TreeMap;

public class DataProcessCho {
	private File file;
		
	public DataProcessCho(String filename) {
		file = new File("d:\\tmp\\"+filename+".txt");
	}
	
	public void createFile() {
		try {
			if(file.createNewFile()) {
				System.out.println("파일 생성 완료");
			}else {
				System.out.println("파일 생성 실패");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String[] fileLoad() {
		String datas[] = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			// data의 총수를 구한다
			int count = 0;
			String str = "";
			
			// null이 아니면 str을 읽는다 
			while((str = br.readLine()) != null) {
					count++;
			}				
			br.close();
			
			// 배열의 크기 count
			datas = new String[count];
			// data취합
			br = new BufferedReader(new FileReader(file));
			int w = 0;
			while((str = br.readLine()) != null) {
				datas[w] = str;
				w++;
			}
			
			br.close();		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		} catch (IOException e) {
				// TODO Auto-generated catch block
		}
		
		return datas;
	}

	public void fileSave(TreeMap<String, AccountDtoCho> datas) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			Iterator<String> itkey = datas.keySet().iterator();
			while(itkey.hasNext()) {
				String key = itkey.next();
				AccountDtoCho val = datas.get(key);
				pw.println(key+", "+val);
			}
			pw.close();
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		System.out.println("파일에 저장되었습니다");
	}

	
	
}
