package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws Exception {
		// 建立 Socket Server
		ServerSocket serverSocket = new ServerSocket(5555);
		System.out.println("port: " + serverSocket.getLocalPort());
		// 等待 Client 連入
		System.out.println("waiting...");
		Socket clientSocket = serverSocket.accept(); // 接收到 client 連入資訊
		System.out.println("success!");
		
		// 建立 Client-Server 的 I/O 通訊
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		// 接收 client 端來的資料
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			// 將 client 端傳來的資料印出
			System.out.println("client: " + inputLine);
		}
		
		// 關閉 I/O
		out.close();
		in.close();
		
		// 關閉連線
		clientSocket.close();
		serverSocket.close();
		System.out.println("closed");
	}
	
}