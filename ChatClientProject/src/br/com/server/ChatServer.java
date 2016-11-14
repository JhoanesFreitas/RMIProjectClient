package br.com.server;

import java.rmi.Remote;

public interface ChatServer extends Remote{
	
	public boolean conectar(ChatClient client, String nickName);
	public void desconectar(ChatClient client, String nickName);
	public void falar(String nickName, String msg);
	public String[] naSessao();
}
