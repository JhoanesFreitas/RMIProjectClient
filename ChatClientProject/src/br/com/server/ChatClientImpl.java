package br.com.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatClientImpl extends UnicastRemoteObject implements ChatClient {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ChatServer servidor;
	private String nickName;

	protected ChatClientImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void disse(String nickName, String msg) throws RemoteException {

		evento(nickName + ": " + msg);
		evento(this.nickName + ": ");
	}

	public void evento(String msg) throws RemoteException {
		System.out.println(msg);
	}

	public String getNickName() throws RemoteException {
		return nickName;
	}

	public void setNickName(String nickName) throws RemoteException {
		this.nickName = nickName;
	}

	public ChatServer getServidor() throws RemoteException {
		return servidor;
	}

	public void setServidor(ChatServer servidor) throws RemoteException {
		this.servidor = servidor;
	}

}
