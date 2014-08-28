/**
libICMath aims to be a powerful numerical calculation library, for more info see http://code.google.com/p/libicmath/
Copyright (C) IamMecone.com Development group

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.

For more info check out the code available freely at http://code.google.com/p/libicmath/
Or check out our website at IamMeCone.com
 */

package com.ic.libICMath;

public class ICLinkedList
{
	public static class Node
	{
		public Node next = null;
		public Node prev = null;
		public ICMathToken data;
		
		public String toString()
		{
			return data.toString();
		}
	}

	public Node headNode = null;
	public Node tailNode = null;
	public Node tempNode = null;
	public int size;
	
	public ICLinkedList(ICLinkedList copy)
	{
		//this.size=copy.size;
		Node tempNode2=copy.headNode;
		if(tempNode2!=null)
		{
			insertAtTail(tempNode2.data.clone());
		}
		while(tempNode2.next!=null)
		{
			tempNode2=tempNode2.next;
			insertAtTail(tempNode2.data.clone());
		}
	}
	
	public ICLinkedList()
	{
		
	}
	
	public void insertAtHead(ICMathToken data)
	{
		if (size == 0)
		{
			headNode = new Node();
			headNode.data = data;
			tailNode = headNode;
		}
		else
		{
			tempNode = headNode;
			headNode = new Node();
			headNode.data = data;
			headNode.next = tempNode;
			headNode.next.prev=headNode;
		}
		size++;
	}

	public void insertAtTail(ICMathToken data)
	{
		if (size == 0)
		{
			headNode = new Node();
			headNode.data = data;
			tailNode = headNode;
		}
		else
		{
			tempNode = tailNode;
			tailNode = new Node();
			tailNode.data = data;
			tailNode.prev = tempNode;
			tempNode.next=tailNode;
			tailNode.prev.next=tailNode;
		}
		size++;
	}

	public void add(ICMathToken data)
	{
		insertAtTail(data);
	}

	public ICMathToken get(int i)
	{
		if(i>=0 && i<size)
		{
			tempNode=headNode;
			for(int j=0;j<i;j++)
			{
				tempNode=tempNode.next;
			}
		}
		return tempNode.data;
	}
	public void remove(int i)
	{}
	public void clear()
	{
		headNode=null;
		tailNode=null;
		size=0;
	}
	public void set(int i,ICMathToken data)
	{
		
	}
	public void remove(Node del)
	{
		if (size > 1)
		{
			if (del.prev == null)
			{
				del.next.prev = null;
				headNode = del.next;
				size--;
			}
			else if (del.next == null)
			{
				del.prev.next = null;
				tailNode = del.prev;
				size--;
			}
			else
			{
				del.prev.next = del.next;
				del.next.prev = del.prev;
				size--;
			}
		}
		else if (size == 1)
		{
			headNode = null;
			tailNode = null;
			size--;
		}
	}
	public String toString()
	{
		String out="";
		tempNode=headNode;
		while(tempNode!=null)
		{
			out+=" "+tempNode.data.toString();
			tempNode=tempNode.next;
		}
		return out;
	}
}
