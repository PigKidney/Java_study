package quiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class E07_Copy2 {

	// 폴더 이름을 전달하면 해당 폴더 이름에 2를 붙인 새 폴더안에
	// 모든 내용을 복사하는 메서드를 만들어보세요

	// 폴더 위치에서 폴더 명을 선택하게? 폴더 위치를 직접 선택
	public static void copyFile(String src, String folderName) {
		File srcDir = new File(src);
		FilenameFilter nameFilter = new FilenameFilter() {
			@Override
			public boolean accept(File f, String name) {
				return name.startsWith(folderName);
			}
		};

		String[] fileName = srcDir.list(nameFilter);
		int i = fileName.length + 1;
		String copyFolder = folderName + i;
		new File(copyFolder).mkdirs();

//		File startDir = new File("./" + folderName);
////		copyFolder(folderName);
//
//		for (File file : startDir.listFiles()) {
//			String startFileName = file.getName();
//			if (file.isDirectory()) {
//				new File(copyFolder, startFileName).mkdirs(); // 복사한 폴더에 디렉트폴더를 만든다
//				copyFile(file.getPath(),startFileName);
//				continue;
//			} else {
//				File dstFile = new File(copyFolder, startFileName);
//				FileInputStream in = null;
//				FileOutputStream out = null;
//
//				try {
//					in = new FileInputStream(file);
//					out = new FileOutputStream(dstFile);
//
//					out.write(in.readAllBytes());
//
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				} finally {
//					try {
//						if (in != null) {
//							in.close();
//						}
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//					try {
//						if (out != null) {
//							out.close();
//						}
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//			
//		}
	}

// ----------------------------------------------------------------------------------------------------------------
	
	public static void copyDirectory(File srcDir, File dstDir) {
		if(!dstDir.exists()) {
			dstDir.mkdirs();
		}
		
		for (File srcFile : srcDir.listFiles()) {
			if (srcFile.isDirectory()) {
				copyDirectory(srcFile, new File(dstDir, srcFile.getName()));
			} else {
				copyFile(srcFile, new File(dstDir, srcFile.getName()));
			}
		}
	}
	
	
	public static void copyDirectory(String path) {
		copyDirectory(new File(path), new File(path + 2));
	}

	
	public static void copyFile(File srcFile, File dstFile) {
		
		// try문의 ()안에서 선언한 객체는 try문의 범위를 벗어나면
		// 자동으로 close() 메서드를 호출한다 (AutoClose)
		try (
				FileInputStream in = new FileInputStream(srcFile); 
				FileOutputStream out = new FileOutputStream(dstFile);
		) {
			out.write(in.readAllBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public static void main(String[] args) {
//		copyFile("C:/JavaFullStack_YGM/JavaStudy/", "myfiles");
		copyDirectory("myfiles");
	}
}
