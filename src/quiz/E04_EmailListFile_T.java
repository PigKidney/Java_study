package quiz;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E04_EmailListFile_T {

	
	public static void main(String[] args) {
		
		try {
			FileOutputStream out = new FileOutputStream("myfiles/email.txt");
			Matcher matcher = Pattern.compile("(.+@.+)").matcher(D10_ReporterList.emails);
			while(matcher.find()) {
				System.out.println(matcher.group(1));
				out.write(matcher.group(1).getBytes());
				
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
