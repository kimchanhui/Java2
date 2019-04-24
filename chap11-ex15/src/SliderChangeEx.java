import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderChangeEx extends JFrame{
	private JLabel colorLabel;
	private JSlider [] sl = new JSlider [3]; // 3���� �����̴� �迭 ����
	
	public SliderChangeEx() {
	setTitle("�����̴��� ChangeEvent ����");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container c = getContentPane();
	c.setLayout(new FlowLayout());
	
	colorLabel = new JLabel("		SLIDER EXAMPLE		");
	
	// �����̴��� 3�� �����ϰ� ����� �����Ѵ�.
	for(int i=0; i<sl.length; i++) {
		//0~255 ������ ���� ������ �� �ִ� �����̴� ����. �ʱ갪�� 128
		sl[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
		sl[i].setPaintLabels(true);
		sl[i].setPaintTicks(true);
		sl[i].setPaintTrack(true);
		sl[i].setMajorTickSpacing(50);
		sl[i].setMinorTickSpacing(10);
		
		// �����̴��� Change ������ ���
		sl[i].addChangeListener(new MyChangeListener());
		c.add(sl[i]); // �����̴��� ����Ʈ�ҿ� ����
	}
	
	sl[0].setForeground(Color.RED); // s[0] �����̴��� RED �� ����
	sl[1].setForeground(Color.GREEN); // ""
	sl[2].setForeground(Color.BLUE); // ""
	
	// �����̴��� 3�� �����ϰ� ����� �����Ѵ�
	int r = sl[0].getValue(); // ù ��° �����̴��κ��� R ���� �� ���
	int g = sl[1].getValue(); // �� ��°    ""
	int b = sl[2].getValue(); // �� ��°    ""
	colorLabel.setOpaque(true); // ������ ��µǵ��� �������� ����
	colorLabel.setBackground(new Color(r, g, b)); // r,g,b ������ ���ο� �� ����
	
	c.add(colorLabel);
	setSize(300,230);
	setVisible(true);
	
	}
	
	// Change ������ ����
	class MyChangeListener implements ChangeListener{
		public void stateChanged(ChangeEvent e) { // �����̴��� ���� ������ �� ȣ��
			//3���� �����̴��κ��� ���� ��� colorLabel�� ���� ����
			int r = sl[0].getValue(); // R ���� �� ���
			int g = sl[1].getValue(); // G ���� �� ���
			int b = sl[2].getValue(); // B ���� �� ���
			colorLabel.setBackground(new Color(r, g, b)); // r,g,b ������ ���ο� �� ����
			
		}
	}
	public static void main(String[] args) {
		new SliderChangeEx();
	}

}




















