package Image_Sharing;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Client {
	
	public static void main(String[] args) {
		try {
			byte[] imageData = Files.readAllBytes(Paths.get("image.jpeg"));
			
			Socket socket = new Socket("localhost", 7172);
			
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write(imageData);
			outputStream.flush();
			
			outputStream.close();
			socket.close();
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
			
		}
	}

}
