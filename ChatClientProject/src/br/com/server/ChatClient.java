package br.com.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatClient extends Remote{

	public void disse(String nickName, String msg) throws RemoteException;
	public void evento(String msg) throws RemoteException;
}
