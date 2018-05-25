package org.ysh.java.core.test;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;


public class QueueTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(new File("F:/QCP_20171101_001.txt")), Charset.forName("UTF-8")));
		String str = "";
		while((str = br.readLine())!=null){
			String[] records = str.split(",");
			System.out.println(records[2] + " " + records[3] + " " + records[4] + " " + records[5]);
		}
		br.close();*/
		
		/*RandomAccessFile raf = new RandomAccessFile(new File("F:/QCP_20171101_001.txt"), "r");
		String line = "";
		while((line=raf.readLine())!=null){
			String[] records = line.split(",");
			
			System.out.println(records[2]+" " + new String(records[3].getBytes("UTF-8"),"gbk") + " " + records[4] + " " + records[5]);
		}
		raf.close();*/
		
		Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
		InetAddress ip = null;
		while (networkInterfaces.hasMoreElements())
		{
			NetworkInterface netInterface = networkInterfaces.nextElement();
			System.out.println(netInterface.getName());
			Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
			while (addresses.hasMoreElements())
			{
				ip = addresses.nextElement();
				if (ip != null && ip instanceof Inet4Address)
				{
					System.out.println("本机的IP = " + ip.getHostAddress());
				} 
			}
		}
	}

}
