package Image_Sharing;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(7172);
			
			while(true) {
				Socket socket = serverSocket.accept();
				InputStream inputStream = socket.getInputStream();
				
				ByteArrayOutputStream buffer = new ByteArrayOutputStream();
				
				int nRead;
				byte[] data = new byte[1024];
				while((nRead = inputStream.read(data, 0, data.length))!= -1) {
					buffer.write(data, 0, nRead);
				}
				buffer.flush();
				byte[] imageData = buffer.toByteArray();
				
				FileOutputStream outputStream = new FileOutputStream("recivedImage.jpeg");
				outputStream.write(imageData);
				outputStream.close();
				
				inputStream.close();
				socket.close();
				serverSocket.close();
				
 				
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
			
		}
		
	}

}