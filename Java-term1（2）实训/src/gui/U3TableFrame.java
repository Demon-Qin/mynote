package gui;

import java.util.List;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import entity.Book;


public class U3TableFrame extends JFrame{
	public U3TableFrame(List<Book> list) {
	  	  Vector<Vector<Object>> vectordate = new Vector<>();
			for (Book book : list) {
				Vector<Object> objs = new Vector<>();
				objs.add(book.getId());
				objs.add(book.getName());
				objs.add(book.getAuthor()); 
				objs.add(new Double(book.getPrice())); 
				objs.add(new Integer(book.getNum()));
				
				
				vectordate.add(objs);
			}
			String[] labels = {"书本编号", "书名", "作者", "价格", "数量" };
			Vector<String> columNames = new Vector<>();
			for (String label : labels) {
				columNames.add(label);
			}

			JTable table = new JTable(vectordate, columNames);

			JScrollPane scrollPane = new JScrollPane(table);
			this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

			JPanel panel = new JPanel();

			panel.setLayout(null);
			panel.setBorder(new TitledBorder(null, "总面板", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			this.getContentPane().add(panel);
			panel.add(scrollPane);
			scrollPane.setBounds(15, 15, 300, 200);
			scrollPane.setBorder(new TitledBorder(null, "书本信息界面", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			this.setSize(500, 400);
			this.setLocationRelativeTo(null);
			this.setLocation(380, 150);
			this.setVisible(true);
		}

		private String getMark() {
			// TODO Auto-generated method stub
			return null;
		}

	}
