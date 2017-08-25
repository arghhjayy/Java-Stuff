/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arghhjayy
 */

public class BinaryTreeNode
{
	public BinaryTreeNode left;
	public int data;
	public BinaryTreeNode right;

	BinaryTreeNode() {}
	
	BinaryTreeNode(int data)
	{
		this.data = data;
	}
	
	public void addLeft(int data)
	{
		this.left = new BinaryTreeNode(data);
	}
	
	public void addRight(int data)
	{
		this.right = new BinaryTreeNode(data);
	}
}