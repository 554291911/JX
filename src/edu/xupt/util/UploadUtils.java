package edu.xupt.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.sql.Date;

import org.apache.struts2.ServletActionContext;

public class UploadUtils {

	/** 上传照片*/
	public  String photoUpload(File photo, String photoFileName) throws Exception{
		String imgPath = "upload/";
		String path = ServletActionContext.getServletContext().getRealPath("/");
        if(photo != null) {
             InputStream is = new FileInputStream(photo);   
             File folder = new File(path + "upload");
             if(!folder.exists())folder.mkdirs();
             File destFile = new File(path+imgPath, photoFileName);
             OutputStream os = new FileOutputStream(destFile);
             byte[] buffer = new byte[400];
             int length = 0;
             while ((length = is.read(buffer)) > 0) {
                 os.write(buffer, 0, length);
             }
             is.close();
            os.close();
        }
        System.out.println("~~~~~~~~~~~~~~上传成功！");  
        return imgPath + photoFileName;
	}
	
	/**  上传文件*/
	public  String wordUpload(File word, String wordFileName) throws Exception{
		String wordPath = "word/";
		String path = ServletActionContext.getServletContext().getRealPath("/");
		if(word != null && word.length() != 0) {
             InputStream is = new FileInputStream(word);   
             File folder = new File(path + "word");
             if(!folder.exists())folder.mkdirs();
             File destFile = new File(path+wordPath, wordFileName);
             OutputStream os = new FileOutputStream(destFile);
             byte[] buffer = new byte[400];
             int length = 0;
             while ((length = is.read(buffer)) > 0) {
                 os.write(buffer, 0, length);
             }
             is.close();
            os.close();
        }else{
        	 File folder = new File(path + "word");
             if(!folder.exists())folder.mkdirs();
             File destFile = new File(path+wordPath, wordFileName);
             destFile.createNewFile();
        }
		System.out.println("~~~~~~~~~~~~~~上传成功！");  
		return wordFileName;
	}
	
	public Date getNowDate(){
		java.util.Date nDate = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sDate = sdf.format(nDate);
        java.sql.Date now = java.sql.Date.valueOf(sDate);
		return now;
	}
}
