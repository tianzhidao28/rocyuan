package com.rocyuan.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



/**
 *
 * 

                                      (@@) (  ) (@)  ( )  @@    ()    @     O     @     O      @                        
                                 (   )                                                                                  
                             (@@@@)                                                                                    
                          (    )                                                                                        

                        (@@@)                                                                                        
                       ====        	[  www.rocyuan.com]                                               
                   _D _|  |_______/        \__I_I_____===__|_________|                                                  
                    |(_)---  |   H\________/ |   |        =|___ ___|      _________________                             
                    /     |  |   H  |  |     |   |         ||_| |_||     _|                \_____A                      
                   |      |  |   H  |__--------------------| [___] |   =|                        |                      
                   | ________|___H__/__|_____/[][]~\_______|       |   -|                        |                      
                   |/ |   |-----------I_____I [][] []  D   |=======|____|________________________|_                     
                 __/ =| o |=-~~\  /~~\  /~~\  /~~\ ____Y___________|__|__________________________|_                     
                  |/-=|___|=   O=====O=====O=====O|_____/~\___/          |_D__D__D_|  |_D__D__D_|                       
                   \_/      \__/  \__/  \__/  \__/      \_/               \_/   \_/    \_/   \_/                        

 * @author rocyuan
 * @date:2014-9-17
 * @desc:
 * @project:  序列化类(  )
 */

public class SerializeUtils {
	

	/**
	 * 序列化处理
	 * @param obj
	 * @return
	 */
	public static byte[] serializable(Object obj) {
		if (obj == null) {
			return null;
		}
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * 反序列化处理
	 * @param bytes
	 * @return
	 */
	public static Object unserialize(byte[] bytes) {
		if (bytes == null) {
			return null;
		}
		ByteArrayInputStream bais = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * 
	 * @Description:  序列化到文件
	 *  @param obj
	 *  @param filePath    
	 *  @return void   
	 *  @throws
	 */
	public static void serializable (Object obj , String filePath ) {
		
		try {
			File f = new File( filePath ) ;
			if (! f.exists() ) {
				f.getParentFile().mkdirs();
				f.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			oos.flush();
			oos.close();		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	public static Object unserialize ( String filePath ) {
		
		try {
			FileInputStream fis = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fis);
			return ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	

	

}
