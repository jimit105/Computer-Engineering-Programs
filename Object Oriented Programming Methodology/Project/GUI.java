//Pizza Restaurant Ordering Simulation

/* @author
 * Jimit Dholakia
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

class GUI2 extends JFrame 
{
	
	private JRadioButton res, par;	
	private ButtonGroup group;
	private JLabel logo_name, delivery_type, date_time, table_no, name, address, contact, toppings_label, quantity_label;
	private ImageIcon logo;
	private JTextField table_no_tf, name_tf, address_tf, contact_tf;
	private JPanel input_panel, delivery_panel, toppings_panel, toppings2_panel, quantity_panel, initial_panel, buttons_panel;
	private JPanel top1_panel, top2_panel;
	private JCheckBox top_onion, top_mushroom, top_broccoli, top_corn, top_capsicum, top_cheese;
	private JComboBox quantity_box;
	String date;
	public float rate = 80;		//base rate is Rs.80
//	private JCheckBox[] toppings_box;
/*	final double[] toppings_price = {
		10, 10, 10, 15, 15, 20
	};*/
	
	private JLabel quantity_op_label, quantity_op, rate_label, rate_op_label;
	private JButton print, clear, calculate;
	private ImageIcon print_icon, clear_icon;
	private JLabel table_no_op, name_op, address_op, contact_op;
	String table_no_str, name_str, address_str, contact_str;
	private JLabel table_no2, name2, address2, contact2;
	private JLabel date_time2;
	private JLabel logo_name2;
	
	
	public GUI2() 
	{
		super("Pizza Palace");
		setLayout(new FlowLayout(FlowLayout.CENTER, 30, 15));
		logo = new ImageIcon("pizza.png");			
		logo_name = new JLabel("Pizza Palace", logo, 0);
		initial_panel = new JPanel();
		initial_panel.setLayout(new GridLayout(2, 1));		
		
		JOptionPane.showMessageDialog(new JFrame(), "Welcome to Pizza Palace!", "Pizza Palace", JOptionPane.PLAIN_MESSAGE, logo);
		
		//Logo Icon and Name
		logo = new ImageIcon("pizza.png");			
		logo_name = new JLabel("Pizza Palace", logo, 0);		
		initial_panel.add(logo_name);
		
		//Date and Time
		date = new SimpleDateFormat("EEEE yyyy-MM-dd   hh:mm:ss a zzz").format(new Date());
		date_time = new JLabel(date);
		initial_panel.add(date_time);					
			
		add(initial_panel);	
	}
	
	
	public void Input()
	{		
		input_panel = new JPanel();
		input_panel.setLayout(new GridLayout(5, 2, 5, 5));	
					
		delivery_panel = new JPanel();
		delivery_panel.setLayout(new GridLayout(1, 3));			
		
		//Delivery Type
		delivery_type = new JLabel("Delivery Type:");
	//	delivery_panel.add(delivery_type);		
		res = new JRadioButton("in-Restaurant");
		res.setActionCommand("res");
		par = new JRadioButton("Parcel");
		par.setActionCommand("par");
		
				
		group = new ButtonGroup();
		group.add(res);
		group.add(par);
		delivery_panel.add(res);
		delivery_panel.add(par);
		
	//	add(delivery_panel);
		
		input_panel.add(delivery_type);					
		input_panel.add(delivery_panel);		
		
		//Table Number
		table_no = new JLabel("Table Number");		
		table_no_tf = new JTextField("", 5);
		input_panel.add(table_no);
		input_panel.add(table_no_tf);						
		
		//Parcel Details
		name = new JLabel("Name");
		address = new JLabel("Address");
		contact = new JLabel("Contact Number");
		name_tf = new JTextField("", 10);
		address_tf = new JTextField("", 20);
		contact_tf = new JTextField("", 10);
		input_panel.add(name);
		input_panel.add(name_tf);					
		input_panel.add(address);
		input_panel.add(address_tf);
		input_panel.add(contact);
		input_panel.add(contact_tf);
				
		add(input_panel);
		
		// Hide Extra Labels & TextFields depending on RadioButton Selected
		/*
		res.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent arg0)
			{
				if(res.isSelected())
				{
					name.setVisible(false);
					address.setVisible(false);
					contact.setVisible(false);
					name_tf.setVisible(false);
					address_tf.setVisible(false);
					contact_tf.setVisible(false);		
				}
			}
		});
		
		par.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent arg0)
			{
				if(par.isSelected())
				{
					table_no.setVisible(false);
					table_no_tf.setVisible(false);
				}
			}
		}); */				
		
		
		// Disable Extra Labels & TextFields depending on RadioButton Selected
		res.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent arg0)
			{
				if(res.isSelected())
				{
					name.setEnabled(false);
					address.setEnabled(false);
					contact.setEnabled(false); 
					name_tf.setEditable(false);
					address_tf.setEditable(false);
					contact_tf.setEditable(false);	
					name_tf.setEnabled(false);
					address_tf.setEnabled(false);
					contact_tf.setEnabled(false);
					table_no.setEnabled(true);
					table_no_tf.setEnabled(true);					
					table_no_tf.setEditable(true);		
				}
			}
		});
		
		par.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent arg0)
			{
				if(par.isSelected())
				{
					table_no.setEnabled(false);
					table_no_tf.setEnabled(false);					
					table_no_tf.setEditable(false);
					name.setEnabled(true);
					address.setEnabled(true);
					contact.setEnabled(true); 
					name_tf.setEditable(true);
					address_tf.setEditable(true);
					contact_tf.setEditable(true);	
					name_tf.setEnabled(true);
					address_tf.setEnabled(true);
					contact_tf.setEnabled(true);				
				}
			}
		});								
	
	}
	
	public void Toppings()
	{
		top1_panel = new JPanel();
		top1_panel.setLayout(new GridLayout(1, 3));
		
		top2_panel = new JPanel();
		top2_panel.setLayout(new GridLayout(1, 3));
		
		toppings_panel = new JPanel();
		toppings_panel.setLayout(new GridLayout(2, 1));
		
		toppings2_panel = new JPanel();
		toppings2_panel.setLayout(new GridLayout(2, 1));
		
		toppings_label = new JLabel("Toppings:");	
		
	/*	top_onion = new JCheckBox("Onion");   
		top_mushroom = new JCheckBox("Mushroom");
		top_broccoli = new JCheckBox("Broccoli");
		top_corn = new JCheckBox("Corn");
		top_capsicum = new JCheckBox("Capsicum");
		top_cheese = new JCheckBox("Cheese");			
				
		toppings_panel.add(top_onion);	
		toppings_panel.add(top_mushroom);	
		toppings_panel.add(top_broccoli);	
		toppings_panel.add(top_corn);
		toppings_panel.add(top_capsicum);
		toppings_panel.add(top_cheese);		*/
		
		top_onion = new JCheckBox("Onion", false);
		top_mushroom = new JCheckBox("Mushroom", false);
		top_broccoli = new JCheckBox("Broccoli", false);
		top_corn = new JCheckBox("Corn", false);
		top_capsicum = new JCheckBox("Capsicum", false);
		top_cheese = new JCheckBox("Cheese", false);
		
		
	/*	ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected)
					rate = rate + 15;
			}
		};
		
		
		
		top_onion.addActionListener(actionListener);
		top_mushroom.addActionListener(actionListener);
		top_broccoli.addActionListener(actionListener);
		top_corn.addActionListener(actionListener);
		top_capsicum.addActionListener(actionListener);
		top_cheese.addActionListener(actionListener);
		*/
		
		ItemListener itemListener = new ItemListener()
		{
			public void itemStateChanged(ItemEvent itemEvent)
			{
				AbstractButton abstractButton = (AbstractButton) itemEvent.getSource();
				int state = itemEvent.getStateChange();
				if(state == ItemEvent.SELECTED)
				{
					rate = rate + 15;
				}
			}
		};
			
		top_onion.addItemListener(itemListener);
		top_mushroom.addItemListener(itemListener);
		top_broccoli.addItemListener(itemListener);
		top_corn.addItemListener(itemListener);
		top_capsicum.addItemListener(itemListener);
		top_cheese.addItemListener(itemListener);	
		
		
	//	top_onion = new JCheckBox("Onion", false);
		top1_panel.add(top_onion);
	//	top_onion.addActionListener(this);
			
	//	top_mushroom = new JCheckBox("Mushroom", false);
		top1_panel.add(top_mushroom);
	//	top_mushroom.addActionListener(this);
		
	//	top_broccoli = new JCheckBox("Broccoli", false);
		top1_panel.add(top_broccoli);
	//	top_broccoli.addActionListener(this);
			
	//	top_corn = new JCheckBox("Corn", false);
		top2_panel.add(top_corn);
	//	top_corn.addActionListener(this);
		
	//	top_capsicum = new JCheckBox("Capsicum", false);
		top2_panel.add(top_capsicum);
	//	top_capsicum.addActionListener(this);
		
	//	top_cheese = new JCheckBox("Cheese", false);
		top2_panel.add(top_cheese);		
	//	top_cheese.addActionListener(this);		
	
		toppings_panel.add(top1_panel);
		toppings_panel.add(top2_panel);
					
		toppings2_panel.add(toppings_label);
		toppings2_panel.add(toppings_panel);
		add(toppings2_panel);
		
	/*	toppings_box = new JCheckBox[] {
			top_onion, top_mushroom, top_broccoli, top_corn, top_capsicum, top_cheese
		};	
			
		*/
	}
	
	public void Quantity() 
	{
		quantity_label = new JLabel("Quantity: ");
		quantity_op_label = new JLabel("Quantity: ");
		quantity_op = new JLabel();
		quantity_panel = new JPanel();
		quantity_panel.setLayout(new GridLayout(2, 2));
		String[] quantity = {"1", "2", "3", "4", "5"};
		
		JComboBox<String>quantity_box = new JComboBox<String>();
		for(int i = 0; i < quantity.length; i++)		
			quantity_box.addItem(quantity[i]);
		
		quantity_box.setSelectedIndex(0);
						
		quantity_panel.add(quantity_label);
		quantity_panel.add(quantity_box);
		
		
		quantity_box.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				quantity_op.setText((String)((JComboBox)e.getSource()).getSelectedItem());
			}	
		});
		
	//	quantity_panel.add(quantity_op_label);
	//	quantity_panel.add(quantity_op);
		add(quantity_panel);
	} 
	
	
/*	public void Cost()
	{
		if(top_broccoli.isSelected())
			rate = rate + 10;
		if(top_capsicum.isSelected())
			rate = rate + 15;
		if(top_corn.isSelected())
			rate = rate + 15;
		if(top_cheese.isSelected())
			rate = rate + 20;
		if(top_mushroom.isSelected())
			rate = rate + 10;
		if(top_onion.isSelected())
			rate = rate +10;
	} */
	

	
	public void Output()
	{	
		print_icon = new ImageIcon("print.png");
		clear_icon = new ImageIcon("clear.png");
		
		buttons_panel = new JPanel();
		buttons_panel.setLayout(new GridLayout(1, 2, 50, 10));
					
		table_no2 = new JLabel("Table No.: ");
		name2 = new JLabel("Name: ");
		address2 = new JLabel("Address: ");
		contact2= new JLabel("Contact Number: ");
		
/*		for(int i = 0; i < toppings_box.length; i++)
		{
			if(toppings_box[i].isSelected())
			{
				rate += toppings_price[i];
			}
		}*/
		
/*		top_broccoli.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				if(e.getStateChange() == ItemEvent.SELECTED)
					rate = rate + 10;
			}
		});	*/				
				
		String rate_str;
		rate_str = Float.toString(rate);
		rate_label = new JLabel("Rate: ");
		rate_op_label = new JLabel(rate_str);	
		
		
		print = new JButton("Print");
		print.setRolloverIcon(print_icon);
		print.setRolloverEnabled(true);
		clear = new JButton("Clear");
	
	//	print.setPreferredSize(new Dimension(70, 30));
	
		buttons_panel.add(print);
		buttons_panel.add(clear);		
			
		add(buttons_panel);
				
	/*	calculate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(top_broccoli.isSelected())
					rate = rate + 10;
				if(top_capsicum.isSelected())
					rate = rate + 15;
				if(top_corn.isSelected())
					rate = rate + 15;
				if(top_cheese.isSelected())
					rate = rate + 20;
				if(top_mushroom.isSelected())
					rate = rate + 10;
				if(top_onion.isSelected())
					rate = rate +10;
			}
		});	*/	
				
		clear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				table_no_tf.setText("");
				name_tf.setText("");
				address_tf.setText("");
				contact_tf.setText("");
				group.clearSelection();
				name.setEnabled(true);
				address.setEnabled(true);
				contact.setEnabled(true); 
					
				name_tf.setEditable(true);
				address_tf.setEditable(true);
				contact_tf.setEditable(true);	
				name_tf.setEnabled(true);
				address_tf.setEnabled(true);
				contact_tf.setEnabled(true);
				table_no.setEnabled(true);
				table_no_tf.setEnabled(true);					
				table_no_tf.setEditable(true);
				
				top_broccoli.setSelected(false);
				top_capsicum.setSelected(false);
				top_cheese.setSelected(false);
				top_corn.setSelected(false);
				top_mushroom.setSelected(false);
				top_onion.setSelected(false);
				
					
			}
		});
		
		print.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
				String rate_str;
				rate_str = Float.toString(rate);
				rate_label = new JLabel("Rate: ");
				rate_op_label = new JLabel(rate_str);
							
				JFrame output = new JFrame();
				output.setLayout(new GridLayout(8, 2));
				
				logo_name2 = new JLabel("Pizza Palace", logo, 0);		
				output.add(logo_name2);				
				date = new SimpleDateFormat("E yyyy-MM-dd HH:mm:ss").format(new Date());							
				date_time2 = new JLabel(date);
				output.add(date_time2);										
				
				table_no_str = table_no_tf.getText();
				name_str = name_tf.getText();
				address_str = address_tf.getText();
				contact_str = contact_tf.getText();
				
				table_no_op = new JLabel(table_no_str);
				name_op = new JLabel(name_str);
				address_op = new JLabel(address_str);
				contact_op = new JLabel(contact_str);
				
				output.add(table_no2);
				output.add(table_no_op);
				output.add(name2);
				output.add(name_op);
				output.add(address2);
				output.add(address_op);
				output.add(contact2);
				output.add(contact_op);	
				
				output.add(rate_label);
				output.add(rate_op_label);
				output.add(quantity_op_label);				
				output.add(quantity_op);
				output.pack();
				output.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				output.setLocationRelativeTo(null);
			//	output.setSize(100, 100);
				output.setVisible(true);
				
				JOptionPane.showMessageDialog(null, "Your Order Has Been Placed!");
				
			}
		});
		
	}
			
}


class GUI
{
	public static void main(String[] args) 
	{
		GUI2 gui_obj = new GUI2();	
		gui_obj.Input();		
		gui_obj.Toppings();
		gui_obj.Quantity();			
		gui_obj.Output();	
				
		gui_obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui_obj.setLocationByPlatform(true);
		gui_obj.setSize(575,600);
		gui_obj.setVisible(true);
		
	}
}