import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class AddressBookFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameTFld;
	private JTextField emailTFld;
	private JTextField phoneTFld;
	private JScrollPane scrollPane;
	AddressBookEntry abe = new AddressBookEntry();
	AddressBookIO abio = new AddressBookIO();
	SwingValidator sv = new SwingValidator();
	JTextArea addressbook = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressBookFrame frame = new AddressBookFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddressBookFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Name:");
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		
		nameTFld = new JTextField();
		nameTFld.setColumns(10);
		
		emailTFld = new JTextField();
		emailTFld.setColumns(10);
		
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				abe = new AddressBookEntry();
				if (sv.isPresent(nameTFld, "Name"))
					abe.setName(nameTFld.getText());
				if (sv.isPresent(emailTFld, "Email"))
					abe.setEmailAddress(emailTFld.getText());
				if (sv.isPresent(phoneTFld, "Phone"))
					abe.setPhoneNumber(phoneTFld.getText());
				abio.saveEntry(abe);
				sv.showPositiveMessage(null, "Data saved!");
				nameTFld.setText("");
				emailTFld.setText("");
				phoneTFld.setText("");
			}
		});
		
		JButton exitBtn = new JButton("Exit");
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Phone:");
		
		phoneTFld = new JTextField();
		phoneTFld.setColumns(10);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nameTFld.setText("");
				emailTFld.setText("");
				phoneTFld.setText("");
			}
		});
		
		JButton showListBtn = new JButton("Show List");
		showListBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addressbook.setText(abio.getEntriesString());
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(43)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_2))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(emailTFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(nameTFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(phoneTFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(clearBtn)
									.addGap(18)
									.addComponent(addBtn)
									.addGap(18)
									.addComponent(exitBtn))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addComponent(showListBtn)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(12)))))
					.addGap(45))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(nameTFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(28)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(emailTFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1))
									.addGap(25)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(phoneTFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2)))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(23)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(addBtn)
						.addComponent(exitBtn)
						.addComponent(clearBtn))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(showListBtn)
					.addGap(24))
		));
		
		scrollPane_1.setViewportView(addressbook);
		panel.setLayout(gl_panel);
	}
}
