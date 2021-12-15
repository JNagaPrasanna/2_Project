import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class RailFence extends Frame
{
	Label l1,l2,l3,l4,l5;
	TextField t1,t2,t3,t4;
	Button b1,b2;
	RailFence()
	{
		setTitle("RailFence");
		setSize(600,600);
		setVisible(true);
		setLayout(null);
		//Exit Code
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
		});
		l1 = new Label("RAILFENCE");
		l1.setFont(new Font("Dialog", Font.PLAIN, 25));
		l1.setAlignment(Label.CENTER);
		l1.setBounds(81,39 , 393, 44);
		l2 = new Label("Enter Message ");
		l2.setFont(new Font("Dialog", Font.PLAIN, 15));
		l2.setAlignment(Label.CENTER);
		l2.setBounds(28,104 , 132, 30);
		l3 = new Label("Depth");
		l3.setFont(new Font("Dialog", Font.PLAIN, 15));
		l3.setAlignment(Label.CENTER);
		l3.setBounds(16,152 , 154, 40);
		l4 = new Label("Encrypted Text ");
		l4.setFont(new Font("Dialog", Font.PLAIN, 15));
		l4.setAlignment(Label.CENTER);
		l4.setBounds(16,213 , 132, 30);
		l5 = new Label("Decrypted Text");
		l5.setFont(new Font("Dialog", Font.PLAIN, 15));
		l5.setAlignment(Label.CENTER);
		l5.setBounds(10,272 , 132, 30);
		t1 = new TextField();
		t1.setSize(242, 30);
		t1.setLocation(176, 104);
		t2 = new TextField();
		t2.setSize(242, 30);
		t2.setLocation(176, 151);
		t3 = new TextField();
		t3.setSize(242, 30);
		t4 = new TextField();
		t4.setSize(242, 30);
		t4.setLocation(176, 213);
		t3.setLocation(176, 272);
		b1 = new Button("Encryption");
		b1.setFont(new Font("Dialog", Font.PLAIN, 15));
		b1.setSize(96, 30);
		b1.setLocation(114, 353);
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				
				int d=Integer.parseInt(t2.getText());
				String plaintext=t1.getText();
				int b=plaintext.length();
				int c=b/d;
				char mat[][]=new char[d][c];
				  int k=0;
				  
				  String ciphertext="";
				  
				  for(int i=0;i< c;i++)
				  {
				   for(int j=0;j< d;j++)
				   {
				    if(k!=b)
				     mat[j][i]=plaintext.charAt(k++);
				    else
				     mat[j][i]='X';
				   }
				  }
				  for(int i=0;i< d;i++)
				  {
				   for(int j=0;j< c;j++)
				   {
				    ciphertext+=mat[i][j];
				   }
				  }
				 t4.setText(ciphertext);
				
			}
		});
		b2 = new Button("Decryption");
		b2.setFont(new Font("Dialog", Font.PLAIN, 15));
		b2.setSize(121, 30);
		b2.setLocation(263, 353);
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				String r=t2.getText();
				int d=Integer.parseInt(t2.getText());
				String ciphertext=t1.getText();
				int b=ciphertext.length();
				int c=b/d;
				char mat[][]=new char[d][c];
				  int k=0;
				  String plainText="";
				  
				  
				  for(int i=0;i< d;i++)
				  {
				   for(int j=0;j< c;j++)
				   {
				    mat[i][j]=ciphertext.charAt(k++);
				   }
				  }
				  for(int i=0;i< c;i++)
				  {
				   for(int j=0;j< d;j++)
				   {
				    plainText+=mat[j][i];
				   }
				  } 
					 t3.setText(ciphertext);
			}
		});

		add(l1);add(l2);add(l3);add(l4);add(l5);
		add(t1);add(t2);add(t3);add(t4);
		add(b1);add(b2);
	}
	
	public static void main(String[] args) 
	{
		new RailFence();
	}
}
