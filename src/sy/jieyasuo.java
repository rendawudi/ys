
import java.io.BufferedInputStream;  
import java.io.BufferedOutputStream;  
import java.io.File;  
import java.io.FileOutputStream;  
import java.util.Enumeration;  
import java.util.zip.ZipEntry;  
import java.util.zip.ZipFile;  

public class jieyasuo {
	static final int BUFFER = 2048;  
	  
    public static void main(String argv[]) {  
        try {  
            String fileName = "G:\\springmvc\\mybatis-3.3.0.zip";  
            String filePath = "G:\\springmvc\\";  
            ZipFile zipFile = new ZipFile(fileName);  
            Enumeration emu = zipFile.entries();  
            int i = 0;  
            while (emu.hasMoreElements()) {  
                ZipEntry entry = (ZipEntry) emu.nextElement();  
                // ���Ŀ¼��Ϊһ��file����һ�Σ�����ֻ����Ŀ¼�Ϳ��ԣ�֮�µ��ļ����ᱻ��������  
                if (entry.isDirectory()) {  
                    new File(filePath + entry.getName()).mkdirs();  
                    continue;  
                }  
                BufferedInputStream bis = new BufferedInputStream(zipFile  
                        .getInputStream(entry));  
                File file = new File(filePath + entry.getName());  
                // ���������ԭ����zipfile��ȡ�ļ��������ȡ�ģ������ɿ����ȶ�ȡһ���ļ�  
                // ������ļ����ڵ�Ŀ¼��û�г��ֹ�������Ҫ����Ŀ¼����  
                File parent = file.getParentFile();  
                if (parent != null && (!parent.exists())) {  
                    parent.mkdirs();  
                }  
                FileOutputStream fos = new FileOutputStream(file);  
                BufferedOutputStream bos = new BufferedOutputStream(fos, BUFFER);  
                int count;  
                byte data[] = new byte[BUFFER];  
                while ((count = bis.read(data, 0, BUFFER)) != -1) {  
                    bos.write(data, 0, count);  
                }  
                bos.flush();  
                bos.close();  
                bis.close();  
            }  
            zipFile.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}
