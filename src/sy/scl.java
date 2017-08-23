package sy;

import java.io.File;



public class scl {
	public static void main(String argv[]) {
	
	String htwj=".txt";
	String wjj=".files";
	String realPath="E:\\BaiduNetdiskDownload\\";
	String wz="安装说明";
		File file1=new File(realPath+wz+htwj);
		File file2=new File(realPath+wz);
		if (file1.exists()) {
			file1.delete();
		}
		
			deleteDir(file2);
		
		}
	  public static boolean deleteDir(File someFile) {  
	        if (!someFile.exists()) {  
	            System.out.println("[deleteDir]File " + someFile.getAbsolutePath()  
	                    + " does not exist.");  
	            return false;  
	        }  
	        if (someFile.isDirectory()) {// is a folder  
	            File[] files = someFile.listFiles();  
	            for (File subFile : files) {  
	                boolean isSuccess = deleteDir(subFile);  
	                if (!isSuccess) {  
	                    return isSuccess;  
	                }  
	            }  
	        } else {// is a regular file  
	            boolean isSuccess = someFile.delete();  
	            if (!isSuccess) {  
	                return isSuccess;  
	            }  
	        }  
	        if (someFile.isDirectory()) {  
	            return someFile.delete();  
	        } else {  
	            return true;  
	        }  
	    } 
}
