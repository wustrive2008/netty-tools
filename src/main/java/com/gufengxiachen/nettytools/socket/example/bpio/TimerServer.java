package com.gufengxiachen.nettytools.socket.example.bpio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.gufengxiachen.nettytools.socket.example.bio.TimeServerHandler;

public class TimerServer {
	public static void main(String[] args) throws IOException {
		int port = 8080;
		if (args != null && args.length > 0){
			try{
				port = Integer.valueOf(args[0]);
			}catch(NumberFormatException e){
				e.printStackTrace();
			}
		}
		
		ServerSocket server = null;
		TimerServerHandlerExecutePool singleExecutor = new TimerServerHandlerExecutePool(
				50,10000);
		try{
			server = new ServerSocket(port);
			System.out.println("the TimeServer is start in port:"+port);
			Socket socket = null;
			while(true){
				socket = server.accept();
				singleExecutor.execute(new TimeServerHandler(socket));
			}
		}finally{
			if (server != null){
				System.out.println("the TimeServer close");
				server.close();
				server = null;
			}
		}
	}
}
