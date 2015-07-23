package com.gufengxiachen.nettytools.socket.example.aio;

public class TimerServer {
	public static void main(String[] args) {
		int port = 8080;
		if (args != null && args.length > 0){
			try{
				port = Integer.valueOf(args[0]);
			}catch(NumberFormatException e){
				e.printStackTrace();
			}
		}
		AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
		new Thread(timeServer,"AIO-AsyncTimeServerHandler-001").start();
	}
}
